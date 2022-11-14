package cn.source.flowable.service.impl;

import java.util.List;
import cn.source.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.source.flowable.mapper.WfFormMapper;
import cn.source.flowable.domain.WfForm;
import cn.source.flowable.service.IWfFormService;

/**
 * 流程单信息Service业务层处理
 * 
 * @author Andy
 * @date 2022-11-01
 */
@Service
public class WfFormServiceImpl implements IWfFormService 
{
    @Autowired
    private WfFormMapper wfFormMapper;

    /**
     * 查询流程单信息
     * 
     * @param formId 流程单信息主键
     * @return 流程单信息
     */
    @Override
    public WfForm selectWfFormByFormId(Long formId)
    {
        return wfFormMapper.selectWfFormByFormId(formId);
    }

    /**
     * 查询流程单信息列表
     * 
     * @param wfForm 流程单信息
     * @return 流程单信息
     */
    @Override
    public List<WfForm> selectWfFormList(WfForm wfForm)
    {
        return wfFormMapper.selectWfFormList(wfForm);
    }

    /**
     * 新增流程单信息
     * 
     * @param wfForm 流程单信息
     * @return 结果
     */
    @Override
    public int insertWfForm(WfForm wfForm)
    {
        wfForm.setCreateTime(DateUtils.getNowDate());
        return wfFormMapper.insertWfForm(wfForm);
    }

    /**
     * 修改流程单信息
     * 
     * @param wfForm 流程单信息
     * @return 结果
     */
    @Override
    public int updateWfForm(WfForm wfForm)
    {
        wfForm.setUpdateTime(DateUtils.getNowDate());
        return wfFormMapper.updateWfForm(wfForm);
    }

    /**
     * 批量删除流程单信息
     * 
     * @param formIds 需要删除的流程单信息主键
     * @return 结果
     */
    @Override
    public int deleteWfFormByFormIds(Long[] formIds)
    {
        return wfFormMapper.deleteWfFormByFormIds(formIds);
    }

    /**
     * 删除流程单信息信息
     * 
     * @param formId 流程单信息主键
     * @return 结果
     */
    @Override
    public int deleteWfFormByFormId(Long formId)
    {
        return wfFormMapper.deleteWfFormByFormId(formId);
    }
}
