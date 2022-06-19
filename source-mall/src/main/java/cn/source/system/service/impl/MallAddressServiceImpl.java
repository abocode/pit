package cn.source.system.service.impl;

import cn.source.common.annotation.DataScope;
import cn.source.common.utils.DateUtils;
import cn.source.common.utils.SecurityUtils;
import cn.source.system.domain.MallAddress;
import cn.source.system.mapper.MallAddressMapper;
import cn.source.system.service.IMallAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址Service业务层处理
 *
 * @author 詹Sir
 * @date 2022-06-19
 */
@Service
public class MallAddressServiceImpl implements IMallAddressService
{
    @Autowired
    private MallAddressMapper mallAddressMapper;

    /**
     * 查询收货地址
     *
     * @param id 收货地址主键
     * @return 收货地址
     */
    @Override
    public MallAddress selectMallAddressById(Long id)
    {
        return mallAddressMapper.selectMallAddressById(id);
    }

    /**
     * 查询收货地址列表
     *
     * @param mallAddress 收货地址
     * @return 收货地址
     */
    @Override
    @DataScope(userAlias = "mall_address")
    public List<MallAddress> selectMallAddressList(MallAddress mallAddress)
    {
        return mallAddressMapper.selectMallAddressList(mallAddress);
    }

    /**
     * 新增收货地址
     *
     * @param mallAddress 收货地址
     * @return 结果
     */
    @Override
    public int insertMallAddress(MallAddress mallAddress)
    {
        mallAddress.setUserId(SecurityUtils.getUserId());
        mallAddress.setCreateTime(DateUtils.getNowDate());
        return mallAddressMapper.insertMallAddress(mallAddress);
    }

    /**
     * 修改收货地址
     *
     * @param mallAddress 收货地址
     * @return 结果
     */
    @Override
    public int updateMallAddress(MallAddress mallAddress)
    {
        mallAddress.setUpdateTime(DateUtils.getNowDate());
        mallAddress.setUpdateBy(SecurityUtils.getUsername());
        return mallAddressMapper.updateMallAddress(mallAddress);
    }

    /**
     * 批量删除收货地址
     *
     * @param ids 需要删除的收货地址主键
     * @return 结果
     */
    @Override
    public int deleteMallAddressByIds(Long[] ids)
    {
        return mallAddressMapper.deleteMallAddressByIds(ids);
    }

    /**
     * 删除收货地址信息
     *
     * @param id 收货地址主键
     * @return 结果
     */
    @Override
    public int deleteMallAddressById(Long id)
    {
        return mallAddressMapper.deleteMallAddressById(id);
    }
}
