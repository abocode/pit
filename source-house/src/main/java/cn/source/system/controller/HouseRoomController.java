package cn.source.system.controller;

import cn.source.common.annotation.Log;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.domain.entity.SysUser;
import cn.source.common.core.page.TableDataInfo;
import cn.source.common.enums.BusinessType;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.system.domain.HouseRoom;
import cn.source.system.enums.HouseStatus;
import cn.source.system.service.IHouseRoomService;
import cn.source.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 房源详情Controller
 *
 * @author ruoyi
 * @date 2022-03-27
 */
@RestController
@RequestMapping("/system/houseRoom")
public class HouseRoomController extends BaseController
{
    @Autowired
    private IHouseRoomService houseRoomService;
    @Autowired
    private ISysUserService userService;

    /**
     * 查询房源详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:list')")
    @GetMapping("/list")
    public TableDataInfo list(HouseRoom houseRoom)
    {
        startPage();
        List<HouseRoom> list = houseRoomService.selectHouseRoomList(houseRoom);
        return getDataTable(list);
    }

    /**
     * 导出房源详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:export')")
    @Log(title = "房源详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HouseRoom houseRoom)
    {
        List<HouseRoom> list = houseRoomService.selectHouseRoomList(houseRoom);
        ExcelUtil<HouseRoom> util = new ExcelUtil<HouseRoom>(HouseRoom.class);
        util.exportExcel(response, list, "房源详情数据");
    }

    /**
     * 获取房源详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(houseRoomService.selectHouseRoomById(id));
    }

    /**
     * 新增房源详情
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:add')")
    @Log(title = "房源详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HouseRoom houseRoom)
    {
        return toAjax(houseRoomService.insertHouseRoom(houseRoom));
    }

    /**
     * 修改房源详情
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:edit')")
    @Log(title = "房源详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HouseRoom houseRoom)
    {
        return toAjax(houseRoomService.updateHouseRoom(houseRoom));
    }

    /**
     * 删除房源详情
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:remove')")
    @Log(title = "房源详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(houseRoomService.deleteHouseRoomByIds(ids));
    }

    /**
     * 审核
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:more')")
    @Log(title = "房源详情", businessType = BusinessType.UPDATE)
    @PutMapping("handleAudit/{ids}")
    public AjaxResult handleAudit(@PathVariable Long[] ids)
    {
        return toAjax(houseRoomService.updateHouseRoomByIds(ids, HouseStatus.SALEING.getCode()));
    }

    /**
     * 出租
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:more')")
    @Log(title = "房源详情", businessType = BusinessType.UPDATE)
    @PutMapping("handlePush/{ids}")
    public AjaxResult handlePush(@PathVariable Long[] ids)
    {
        return toAjax(houseRoomService.updateHouseRoomByIds(ids,HouseStatus.SALEED.getCode()));
    }

    /**
     * 下架
     */
    @PreAuthorize("@ss.hasPermi('system:houseRoom:more')")
    @Log(title = "房源详情", businessType = BusinessType.UPDATE)
    @PutMapping("handleClose/{ids}")
    public AjaxResult handleClose(@PathVariable Long[] ids)
    {
        return toAjax(houseRoomService.updateHouseRoomByIds(ids,HouseStatus.CLOSE.getCode()));
    }

    /**
     * 查询用户列表
     */
    @GetMapping("/userList")
    public TableDataInfo userList(SysUser user)
    {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 批量选择用户授权
     */
    @Log(title = "房源详情", businessType = BusinessType.GRANT)
    @PutMapping("/authUser/{ids}")
    public AjaxResult authUser(@PathVariable Long[] ids,Long userId)
    {
        return toAjax(houseRoomService.updateHouseAgent(ids,userId));
    }
}
