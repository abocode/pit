package cn.source.flowable.service;

import java.util.List;
import cn.source.flowable.domain.WfForm;

/**
 * 流程单信息Service接口
 * 
 * @author 詹Sir
 * @date 2022-11-01
 */
public interface IWfFormService 
{
    /**
     * 查询流程单信息
     * 
     * @param formId 流程单信息主键
     * @return 流程单信息
     */
    public WfForm selectWfFormByFormId(Long formId);

    /**
     * 查询流程单信息列表
     * 
     * @param wfForm 流程单信息
     * @return 流程单信息集合
     */
    public List<WfForm> selectWfFormList(WfForm wfForm);

    /**
     * 新增流程单信息
     * 
     * @param wfForm 流程单信息
     * @return 结果
     */
    public int insertWfForm(WfForm wfForm);

    /**
     * 修改流程单信息
     * 
     * @param wfForm 流程单信息
     * @return 结果
     */
    public int updateWfForm(WfForm wfForm);

    /**
     * 批量删除流程单信息
     * 
     * @param formIds 需要删除的流程单信息主键集合
     * @return 结果
     */
    public int deleteWfFormByFormIds(Long[] formIds);

    /**
     * 删除流程单信息信息
     * 
     * @param formId 流程单信息主键
     * @return 结果
     */
    public int deleteWfFormByFormId(Long formId);
}
