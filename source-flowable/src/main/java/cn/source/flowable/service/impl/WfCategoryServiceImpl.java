package cn.source.flowable.service.impl;

import java.util.List;

import cn.source.common.constant.UserConstants;
import cn.source.common.utils.DateUtils;
import cn.source.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.source.flowable.mapper.WfCategoryMapper;
import cn.source.flowable.domain.WfCategory;
import cn.source.flowable.service.IWfCategoryService;

/**
 * 流程分类Service业务层处理
 * 
 * @author Andy
 * @date 2022-10-31
 */
@Service
public class WfCategoryServiceImpl implements IWfCategoryService 
{
    @Autowired
    private WfCategoryMapper wfCategoryMapper;

    /**
     * 查询流程分类
     * 
     * @param categoryId 流程分类主键
     * @return 流程分类
     */
    @Override
    public WfCategory selectWfCategoryByCategoryId(Long categoryId)
    {
        return wfCategoryMapper.selectWfCategoryByCategoryId(categoryId);
    }

    /**
     * 查询流程分类列表
     * 
     * @param wfCategory 流程分类
     * @return 流程分类
     */
    @Override
    public List<WfCategory> selectWfCategoryList(WfCategory wfCategory)
    {
        return wfCategoryMapper.selectWfCategoryList(wfCategory);
    }

    /**
     * 新增流程分类
     * 
     * @param wfCategory 流程分类
     * @return 结果
     */
    @Override
    public int insertWfCategory(WfCategory wfCategory)
    {
        wfCategory.setCreateTime(DateUtils.getNowDate());
        return wfCategoryMapper.insertWfCategory(wfCategory);
    }

    /**
     * 修改流程分类
     * 
     * @param wfCategory 流程分类
     * @return 结果
     */
    @Override
    public int updateWfCategory(WfCategory wfCategory)
    {
        wfCategory.setUpdateTime(DateUtils.getNowDate());
        return wfCategoryMapper.updateWfCategory(wfCategory);
    }

    /**
     * 批量删除流程分类
     * 
     * @param categoryIds 需要删除的流程分类主键
     * @return 结果
     */
    @Override
    public int deleteWfCategoryByCategoryIds(Long[] categoryIds)
    {
        return wfCategoryMapper.deleteWfCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除流程分类信息
     * 
     * @param categoryId 流程分类主键
     * @return 结果
     */
    @Override
    public int deleteWfCategoryByCategoryId(Long categoryId)
    {
        return wfCategoryMapper.deleteWfCategoryByCategoryId(categoryId);
    }

    /**
     * 校验编码是否唯一
     * @param code 编码
     * @return 结果
     */
    @Override
    public String checkCategoryCodeUnique(String code) {
        WfCategory wfCategory = wfCategoryMapper.checkCategoryCodeUnique(code);
        if (StringUtils.isNotNull(wfCategory)) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
}
