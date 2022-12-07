package cn.source.flowable.mapper;

import java.util.List;
import cn.source.flowable.domain.WfCategory;

/**
 * 流程分类Mapper接口
 * 
 * @author 詹Sir
 * @date 2022-10-31
 */
public interface WfCategoryMapper
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
     * 删除流程分类
     * 
     * @param categoryId 流程分类主键
     * @return 结果
     */
    public int deleteWfCategoryByCategoryId(Long categoryId);

    /**
     * 批量删除流程分类
     * 
     * @param categoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWfCategoryByCategoryIds(Long[] categoryIds);

    /**
     * 校验编码是否唯一
     * @param code 编码
     * @return 结果
     */
    public WfCategory checkCategoryCodeUnique(String code);
}
