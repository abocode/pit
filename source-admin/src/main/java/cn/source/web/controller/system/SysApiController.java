package cn.source.web.controller.system;

import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.domain.entity.SysUser;
import cn.source.common.core.page.TableDataInfo;
import cn.source.common.utils.SecurityUtils;
import cn.source.system.domain.SysNotice;
import cn.source.system.service.ISysNoticeService;
import cn.source.system.service.ISysUserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基础服务接口
 *
 * @author 詹Sir
 */
@RequestMapping("/api")
@RestController
public class SysApiController extends BaseController
{

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysNoticeService noticeService;


    /**
     * profile 重置密码
     */
    @PutMapping("/profile/updatePwd")
    public AjaxResult updatePwd(@RequestBody JSONObject json)
    {
        String oldPassword = json.getString("oldPassword");
        String newPassword = json.getString("newPassword");
        Long userId = json.getLong("userId");
        SysUser sysUser = userService.selectUserById(userId);
        String userName = sysUser.getUserName();
        String password = sysUser.getPassword();
        if (!SecurityUtils.matchesPassword(oldPassword, password))
        {
            return AjaxResult.error("修改密码失败，旧密码错误");
        }
        if (SecurityUtils.matchesPassword(newPassword, password))
        {
            return AjaxResult.error("新密码不能与旧密码相同");
        }
        if (userService.resetUserPwd(userName, SecurityUtils.encryptPassword(newPassword)) > 0)
        {
            return AjaxResult.success();
        }
        return AjaxResult.error("修改密码异常，请联系管理员");
    }


    /**
     * @Description: 获取通知列表
     */
    @GetMapping("/notice/findNoticeList")
    public TableDataInfo findNoticeList(SysNotice notice)
    {
        startPage();
        List<SysNotice> list = noticeService.selectNoticeList(notice);
        return getDataTable(list);
    }

    /**
     * 获取文章详细信息
     */
    @GetMapping(value = "/notice/getNotice/{id}")
    public AjaxResult getNotice(@PathVariable("id") Long id)
    {
        return AjaxResult.success(noticeService.selectNoticeById(id));
    }

}
