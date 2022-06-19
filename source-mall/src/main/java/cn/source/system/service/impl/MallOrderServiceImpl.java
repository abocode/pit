package cn.source.system.service.impl;

import cn.source.common.annotation.DataScope;
import cn.source.common.utils.DateUtils;
import cn.source.common.utils.SecurityUtils;
import cn.source.common.utils.uuid.CodeUtil;
import cn.source.system.domain.MallOrder;
import cn.source.system.mapper.MallOrderMapper;
import cn.source.system.service.IMallOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单信息Service业务层处理
 *
 * @author 詹Sir
 * @date 2022-06-19
 */
@Service
public class MallOrderServiceImpl implements IMallOrderService
{
    @Autowired
    private MallOrderMapper mallOrderMapper;

    /**
     * 查询订单信息
     *
     * @param id 订单信息主键
     * @return 订单信息
     */
    @Override
    public MallOrder selectMallOrderById(Long id)
    {
        return mallOrderMapper.selectMallOrderById(id);
    }

    /**
     * 查询订单信息列表
     *
     * @param mallOrder 订单信息
     * @return 订单信息
     */
    @Override
    @DataScope(userAlias = "mall_order")
    public List<MallOrder> selectMallOrderList(MallOrder mallOrder)
    {
        return mallOrderMapper.selectMallOrderList(mallOrder);
    }

    /**
     * 新增订单信息
     *
     * @param mallOrder 订单信息
     * @return 结果
     */
    @Override
    public int insertMallOrder(MallOrder mallOrder)
    {
        mallOrder.setUserId(SecurityUtils.getUserId());
        mallOrder.setOrderCode(CodeUtil.getCode());
        mallOrder.setOrderCreateTime(DateUtils.getNowDate());
        mallOrder.setCreateTime(DateUtils.getNowDate());
        mallOrder.setSortNo(0);
        return mallOrderMapper.insertMallOrder(mallOrder);
    }

    /**
     * 修改订单信息
     *
     * @param mallOrder 订单信息
     * @return 结果
     */
    @Override
    public int updateMallOrder(MallOrder mallOrder)
    {
        mallOrder.setUpdateTime(DateUtils.getNowDate());
        return mallOrderMapper.updateMallOrder(mallOrder);
    }

    /**
     * 批量删除订单信息
     *
     * @param ids 需要删除的订单信息主键
     * @return 结果
     */
    @Override
    public int deleteMallOrderByIds(Long[] ids)
    {
        return mallOrderMapper.deleteMallOrderByIds(ids);
    }

    /**
     * 删除订单信息信息
     *
     * @param id 订单信息主键
     * @return 结果
     */
    @Override
    public int deleteMallOrderById(Long id)
    {
        return mallOrderMapper.deleteMallOrderById(id);
    }
}
