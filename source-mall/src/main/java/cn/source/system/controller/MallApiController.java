package cn.source.system.controller;

import cn.source.common.constant.HttpStatus;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.page.TableDataInfo;
import cn.source.system.domain.*;
import cn.source.system.service.IMallAdvertService;
import cn.source.system.service.IMallClassifyService;
import cn.source.system.service.IMallGoodsService;
import cn.source.system.service.IMallNavigateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: cms api控制类
 * @author: 詹Sir
 */
@RestController
@RequestMapping("/api/mallApi")
public class MallApiController extends BaseController {

    @Autowired
    private IMallClassifyService mallClassifyService;
    @Autowired
    private IMallGoodsService mallGoodsService;
    @Autowired
    private IMallNavigateService mallNavigateService;
    @Autowired
    private IMallAdvertService mallAdvertService;


    /**
     * @Description: 获取首页初始化数据MallIndex
     */
    @GetMapping("/findMallIndexList")
    public AjaxResult findMallIndexList(MallAdvert mallAdvert, MallNavigate mallNavigate, MallGoods mallGoods)
    {
        MallIndex mllIndex = new MallIndex();
        /**广告*/
        mllIndex.setAdvertList(mallAdvertService.selectMallAdvertList(mallAdvert));
        /**导航*/
        mllIndex.setNavigateList(mallNavigateService.selectMallNavigateList(mallNavigate));
        // 分页
        startPage();
        /**商品*/
        mllIndex.setGoodsList(mallGoodsService.selectMallGoodsList(mallGoods));
        return AjaxResult.success(mllIndex);
    }


    /**
     * @Description: 获取首页初始化数据MallIndex
     */
    @GetMapping("/findGoodsList")
    public TableDataInfo findGoodsList(MallGoods mallGoods)
    {
        // 分页
        startPage();
        /**商品*/
        List<MallGoods>  goodsList = mallGoodsService.selectMallGoodsList(mallGoods);
        return getDataTable(goodsList);
    }

    /**
     * @Description: 获取分类数据
     */
    @GetMapping("/findClassifyList")
    public TableDataInfo findClassifyList(MallClassify mallClassify)
    {
        // 分页
        startPage();
        /**分类*/
        mallClassify.setParentId(0L);
        List<MallClassify>  classifyList = mallClassifyService.selectMallClassifyList(mallClassify);
        for(MallClassify classify:classifyList){
            MallClassify child = new MallClassify();
            child.setParentId(classify.getId());
            classify.setChildren(mallClassifyService.selectMallClassifyList(child));
        }
        return getDataTable(classifyList);
    }


    /**
     * @Description: 获取商品信息by id
     */
    @GetMapping("/findGoodsById")
    public AjaxResult findGoodsById(@RequestParam Long id)
    {
        String msg = "商品查找成功";
        MallGoods mallGoods = mallGoodsService.selectMallGoodsById(id);
        AjaxResult ajaxResult = new AjaxResult(HttpStatus.SUCCESS,msg,mallGoods);
        return ajaxResult;
    }


}
