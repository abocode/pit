package cn.source.system.service.impl;

import cn.source.common.core.domain.entity.SysUser;
import cn.source.common.utils.DateUtils;
import cn.source.common.utils.SecurityUtils;
import cn.source.common.utils.StringUtils;
import cn.source.common.utils.uuid.CodeUtil;
import cn.source.system.domain.HouseFeature;
import cn.source.system.domain.HouseImage;
import cn.source.system.domain.HouseRoom;
import cn.source.system.domain.HouseVillage;
import cn.source.system.enums.HouseStatus;
import cn.source.system.mapper.HouseRoomMapper;
import cn.source.system.service.IHouseRoomService;
import cn.source.system.service.IHouseVillageService;
import cn.source.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 房源详情Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-27
 */
@Service
public class HouseRoomServiceImpl implements IHouseRoomService
{

    @Value("${ruoyi.domain}")
    private  String domain;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private IHouseVillageService houseVillageService;

    @Autowired
    private HouseRoomMapper houseRoomMapper;

    /**
     * 查询房源详情
     *
     * @param id 房源详情主键
     * @return 房源详情
     */
    @Override
    public HouseRoom selectHouseRoomById(Long id)
    {
        HouseRoom houseRoom = houseRoomMapper.selectHouseRoomById(id);
        houseRoom.setFeatureList(houseRoomMapper.selectHouseFeature(houseRoom));
        houseRoom.setImageList(houseRoomMapper.selectHouseImage(houseRoom));
        return houseRoom;
    }

    /**
     * 查询房源详情列表
     *
     * @param houseRoom 房源详情
     * @return 房源详情
     */
    @Override
    public List<HouseRoom> selectHouseRoomList(HouseRoom houseRoom)
    {
        return houseRoomMapper.selectHouseRoomList(houseRoom);
    }

    /**
     * 新增房源详情
     *
     * @param houseRoom 房源详情
     * @return 结果
     */
    @Override
    public int insertHouseRoom(HouseRoom houseRoom)
    {
        return insertRoom(houseRoom);
    }

    /**
     * 修改房源详情
     *
     * @param houseRoom 房源详情
     * @return 结果
     */
    @Override
    public int updateHouseRoom(HouseRoom houseRoom)
    {
        houseRoom.setUpdateTime(DateUtils.getNowDate());
        if(StringUtils.isNotNull(houseRoom.getFeatureList()) && houseRoom.getFeatureList().size()>0){
            // 先删除，再插入
            houseRoomMapper.deleteHouseFeatureByHouseId(houseRoom.getId());
            houseRoomMapper.insertHouseFeature(houseRoom);
        }
        if(StringUtils.isNotNull(houseRoom.getImageList()) && houseRoom.getImageList().size()>0){
            // 先删除，再插入
            houseRoomMapper.deleteHouseImageByHouseId(houseRoom.getId());
            houseRoom.setFaceUrl(houseRoom.getImageList().get(0).getImgUrl());
            houseRoomMapper.insertHouseImage(houseRoom);
        }
        return houseRoomMapper.updateHouseRoom(houseRoom);
    }

    /**
     * 设置房源经纪人
     *
     */
    @Override
    public int updateHouseAgent(Long[] ids,Long userId)
    {
        Map<String,Object> houseMap=new HashMap<String,Object>();
        houseMap.put("ids",ids);
        SysUser sysUser = userService.selectUserById(userId);
        houseMap.put("agentUserId",userId);
        houseMap.put("agentName",sysUser.getNickName());
        houseMap.put("agentPhone",sysUser.getPhonenumber());
        return houseRoomMapper.updateHouseAgent(houseMap);
    }

    /**
     * 修改房源详情
     *
     * @param houseRoom 房源详情
     * @return 结果
     */
    @Override
    public int updateHouseRoomByIds(Long[] ids,Integer state)
    {
        Map<String,Object> houseMap=new HashMap<String,Object>();
        houseMap.put("ids",ids);
        houseMap.put("state",state);
        return houseRoomMapper.updateHouseRoomByIds(houseMap);
    }

    /**
     * 批量删除房源详情
     *
     * @param ids 需要删除的房源详情主键
     * @return 结果
     */
    @Override
    public int deleteHouseRoomByIds(Long[] ids)
    {
        for (Long id : ids) {
            houseRoomMapper.deleteHouseFeatureByHouseId(id);
            houseRoomMapper.deleteHouseImageByHouseId(id);
        }
        return houseRoomMapper.deleteHouseRoomByIds(ids);
    }

    /**
     * 删除房源详情信息
     *
     * @param id 房源详情主键
     * @return 结果
     */
    @Override
    public int deleteHouseRoomById(Long id)
    {
        houseRoomMapper.deleteHouseFeatureByHouseId(id);
        houseRoomMapper.deleteHouseImageByHouseId(id);
        return houseRoomMapper.deleteHouseRoomById(id);
    }

    /**
     * API新增房源详情
     *
     * @param houseRoom 房源详情
     * @return 结果
     */
    @Override
    public int apiInsertHouseRoom(HouseRoom houseRoom)
    {
        return insertRoom(houseRoom);
    }

    /**
     * 查询房源相关详情信息
     *
     * @param houseRoom 房源
     * @return 房源详情
     */
    @Override
    public HouseRoom selectDetailHouseRoom(HouseRoom houseRoom) {
        List<HouseImage> houseImages = houseRoomMapper.selectHouseImage(houseRoom);
        List<HouseFeature> houseFeatures = houseRoomMapper.selectHouseFeature(houseRoom);
        houseRoom.setImageList(houseImages);
        houseRoom.setFeatureList(houseFeatures);
        houseRoom.setUser(userService.selectUserById(houseRoom.getPublishId()));
        houseRoom.setVillage(houseVillageService.selectHouseVillageById(houseRoom.getVillageId()));
        return houseRoom;
    }


    /**
    * @Description: 将保存房源的方法统一到此方法中
    * @author: 詹Sir
    */
    public int insertRoom(HouseRoom houseRoom){
        // 待审核
        houseRoom.setState(HouseStatus.AUDIT.getCode());
        houseRoom.setCreateTime(DateUtils.getNowDate());
        if(StringUtils.isNull(houseRoom.getPublishId())){
            houseRoom.setPublishId(SecurityUtils.getUserId());
        }
        if(StringUtils.isNull(houseRoom.getStartDate())){
            houseRoom.setStartDate(new Date());
        }
        if(StringUtils.isEmpty(houseRoom.getVillageName())){
            HouseVillage houseVillage = houseVillageService.selectHouseVillageById(houseRoom.getVillageId());
            houseRoom.setVillageName(houseVillage.getName());
        }
        if(StringUtils.isNull(houseRoom.getVillageId())){
            HouseVillage houseVillage = new HouseVillage();
            houseVillage.setName(houseRoom.getVillageName());
            houseVillage = houseVillageService.selectHouseVillage(houseVillage);
            houseRoom.setVillageId(houseVillage.getId());
        }
        houseRoom.setCode(CodeUtil.getCodeByUUId());
        // 封面图设置默认值
        houseRoom.setFaceUrl("https://sourcebyte.cn/profile/customer/file/loading.png");
        houseRoomMapper.insertHouseRoom(houseRoom);
        if(StringUtils.isNotNull(houseRoom.getFeatureList()) && houseRoom.getFeatureList().size()>0){
            houseRoomMapper.insertHouseFeature(houseRoom);
        }
        if(StringUtils.isNotNull(houseRoom.getImageList()) && houseRoom.getImageList().size()>0){
            houseRoom.setFaceUrl(houseRoom.getImageList().get(0).getImgUrl());
            houseRoomMapper.insertHouseImage(houseRoom);
        }
        return houseRoomMapper.updateHouseRoom(houseRoom);
    }
}
