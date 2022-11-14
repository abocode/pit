package cn.source.flowable.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import cn.source.flowable.domain.WfForm;
import cn.source.flowable.service.IWfFormService;
import cn.source.common.utils.poi.ExcelUtil;
import cn.source.common.core.page.TableDataInfo;

/**
 * 流程单信息Controller
 * 
 * @author Andy
 * @date 2022-11-01
 */
@RestController
@RequestMapping("/flowable/form")
public class WfFormController extends BaseController
{
    @Autowired
    private IWfFormService wfFormService;

    /**
     * 查询流程单信息列表
     */
    @PreAuthorize("@ss.hasPermi('flowable:form:list')")
    @GetMapping("/list")
    public TableDataInfo list(WfForm wfForm)
    {
        startPage();
        List<WfForm> list = wfFormService.selectWfFormList(wfForm);
        return getDataTable(list);
    }

    /**
     * 导出流程单信息列表
     */
    @PreAuthorize("@ss.hasPermi('flowable:form:export')")
    @Log(title = "流程单信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WfForm wfForm)
    {
        List<WfForm> list = wfFormService.selectWfFormList(wfForm);
        ExcelUtil<WfForm> util = new ExcelUtil<WfForm>(WfForm.class);
        util.exportExcel(response, list, "流程单信息数据");
    }

    /**
     * 获取流程单信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('flowable:form:query')")
    @GetMapping(value = "/{formId}")
    public AjaxResult getInfo(@PathVariable("formId") Long formId)
    {
        return AjaxResult.success(wfFormService.selectWfFormByFormId(formId));
    }

    /**
     * 新增流程单信息
     */
    @PreAuthorize("@ss.hasPermi('flowable:form:add')")
    @Log(title = "流程单信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WfForm wfForm)
    {
        return toAjax(wfFormService.insertWfForm(wfForm));
    }

    /**
     * 修改流程单信息
     */
    @PreAuthorize("@ss.hasPermi('flowable:form:edit')")
    @Log(title = "流程单信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WfForm wfForm)
    {
        return toAjax(wfFormService.updateWfForm(wfForm));
    }

    /**
     * 删除流程单信息
     */
    @PreAuthorize("@ss.hasPermi('flowable:form:remove')")
    @Log(title = "流程单信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{formIds}")
    public AjaxResult remove(@PathVariable Long[] formIds)
    {
        return toAjax(wfFormService.deleteWfFormByFormIds(formIds));
    }
}
