package cn.source.flowable.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.source.common.constant.UserConstants;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.source.common.annotation.Log;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.enums.BusinessType;
import cn.source.flowable.domain.WfCategory;
import cn.source.flowable.service.IWfCategoryService;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.common.core.page.TableDataInfo;

/**
 * 流程分类Controller
 * 
 * @author Andy
 * @date 2022-10-31
 */
@RestController
@RequestMapping("/flowable/category")
public class WfCategoryController extends BaseController
{
    @Autowired
    private IWfCategoryService wfCategoryService;

    /**
     * 查询流程分类列表
     */
    @PreAuthorize("@ss.hasPermi('flowable:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(WfCategory wfCategory)
    {
        startPage();
        List<WfCategory> list = wfCategoryService.selectWfCategoryList(wfCategory);
        return getDataTable(list);
    }

    /**
     * 导出流程分类列表
     */
    @PreAuthorize("@ss.hasPermi('flowable:category:export')")
    @Log(title = "流程分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WfCategory wfCategory)
    {
        List<WfCategory> list = wfCategoryService.selectWfCategoryList(wfCategory);
        ExcelUtil<WfCategory> util = new ExcelUtil<WfCategory>(WfCategory.class);
        util.exportExcel(response, list, "流程分类数据");
    }

    /**
     * 获取流程分类详细信息
     */
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId)
    {
        return AjaxResult.success(wfCategoryService.selectWfCategoryByCategoryId(categoryId));
    }

    /**
     * 新增流程分类
     */
    @PreAuthorize("@ss.hasPermi('flowable:category:add')")
    @Log(title = "流程分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WfCategory wfCategory)
    {
        if (UserConstants.NOT_UNIQUE.equals(wfCategoryService.checkCategoryCodeUnique(wfCategory.getCode()))) {
            return AjaxResult.error("新增流程分类'" + wfCategory.getCategoryName() + "'失败，流程编码已存在");

        }
        return toAjax(wfCategoryService.insertWfCategory(wfCategory));
    }

    /**
     * 修改流程分类
     */
    @PreAuthorize("@ss.hasPermi('flowable:category:edit')")
    @Log(title = "流程分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WfCategory wfCategory)
    {
        return toAjax(wfCategoryService.updateWfCategory(wfCategory));
    }

    /**
     * 删除流程分类
     */
    @PreAuthorize("@ss.hasPermi('flowable:category:remove')")
    @Log(title = "流程分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Long[] categoryIds)
    {
        return toAjax(wfCategoryService.deleteWfCategoryByCategoryIds(categoryIds));
    }
}
