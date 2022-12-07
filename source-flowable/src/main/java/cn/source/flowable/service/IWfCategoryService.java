package cn.source.flowable.service;

import java.util.List;
import cn.source.flowable.domain.WfCategory;

/**
 * 流程分类Service接口
 * 
 * @author 詹Sir
 * @date 2022-10-31
 */
public interface IWfCategoryService 
{
    /**
     * 查询流程分类
     * 
     * @param categoryId 流程分类主键
     * @return 流程分类
     */
    public WfCategory selectWfCategoryByCategoryId(Long categoryId);

    /**
     * 查询流程分类列表
     * 
     * @param wfCategory 流程分类
     * @return 流程分类集合
     */
    public List<WfCategory> selectWfCategoryList(WfCategory wfCategory);

    /**
     * 新增流程分类
     * 
     * @param wfCategory 流程分类
     * @return 结果
     */
    public int insertWfCategory(WfCategory wfCategory);

    /**
     * 修改流程分类
     * 
     * @param wfCategory 流程分类
     * @return 结果
     */
    public int updateWfCategory(WfCategory wfCategory);

    /**
     * 批量删除流程分类
     * 
     * @param categoryIds 需要删除的流程分类主键集合
     * @return 结果
     */
    public int deleteWfCategoryByCategoryIds(Long[] categoryIds);

    /**
     * 删除流程分类信息
     * 
     * @param categoryId 流程分类主键
     * @return 结果
     */
    public int deleteWfCategoryByCategoryId(Long categoryId);

    /**
     * 校验编码是否唯一
     * @param code 编码
     * @return 结果
     */
    public String checkCategoryCodeUnique(String code);
}
