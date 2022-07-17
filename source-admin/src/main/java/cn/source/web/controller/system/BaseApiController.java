package cn.source.web.controller.system;

import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.system.domain.SysNotice;
import cn.source.system.service.ISysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 基础服务接口
 *
 * @author 詹Sir
 */
@RequestMapping("/api")
@RestController
public class BaseApiController extends BaseController
{

    @Autowired
    private ISysNoticeService noticeService;


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
