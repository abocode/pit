package cn.source.flowable.mapper;

import java.util.List;
import cn.source.flowable.domain.WfForm;

/**
 * 流程单信息Mapper接口
 * 
 * @author Andy
 * @date 2022-11-01
 */
public interface WfFormMapper 
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
     * 删除流程单信息
     * 
     * @param formId 流程单信息主键
     * @return 结果
     */
    public int deleteWfFormByFormId(Long formId);

    /**
     * 批量删除流程单信息
     * 
     * @param formIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWfFormByFormIds(Long[] formIds);
}
