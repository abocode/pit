package org.jeecgframework.web.system.entity.base;

import org.jeecgframework.core.common.entity.IdEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单权限表
 *
 * @author 张代浩
 */
@Entity
@Table(name = "t_s_function")
public class TSFunction extends IdEntity implements java.io.Serializable {
    private TSFunction TSFunction;//父菜单
    private String functionName;//菜单名称
    private Short functionLevel;//菜单等级
    private String functionUrl;//菜单地址
    private Short functionIframe;//菜单地址打开方式
    private String functionOrder;//菜单排序
    private Short functionType;//菜单类型
    private TSIcon TSIcon = new TSIcon();//菜单图标
    private TSIcon TSIconDesk = new TSIcon();//云桌面菜单图标

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "desk_iconid")
    public TSIcon getTSIconDesk() {
        return TSIconDesk;
    }

    public void setTSIconDesk(TSIcon TSIconDesk) {
        this.TSIconDesk = TSIconDesk;
    }

    private List<TSFunction> TSFunctions = new ArrayList<TSFunction>();

    @ManyToOne(fetch = FetchType.LAZY)
//    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iconid")
    public TSIcon getTSIcon() {
        return TSIcon;
    }

    public void setTSIcon(TSIcon tSIcon) {
        TSIcon = tSIcon;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentfunctionid")
    public TSFunction getTSFunction() {
        return this.TSFunction;
    }

    public void setTSFunction(TSFunction TSFunction) {
        this.TSFunction = TSFunction;
    }

    @Column(name = "functionname", nullable = false, length = 50)
    public String getFunctionName() {
        return this.functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    @Column(name = "functionlevel")
    public Short getFunctionLevel() {
        return this.functionLevel;
    }

    public void setFunctionLevel(Short functionLevel) {
        this.functionLevel = functionLevel;
    }

    @Column(name = "functiontype")
    public Short getFunctionType() {
        return this.functionType;
    }

    public void setFunctionType(Short functionType) {
        this.functionType = functionType;
    }

    @Column(name = "functionurl", length = 100)
    public String getFunctionUrl() {
        return this.functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }

    @Column(name = "functionorder")
    public String getFunctionOrder() {
        return functionOrder;
    }

    public void setFunctionOrder(String functionOrder) {
        this.functionOrder = functionOrder;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSFunction")
    public List<TSFunction> getTSFunctions() {
        return TSFunctions;
    }

    public void setTSFunctions(List<TSFunction> TSFunctions) {
        this.TSFunctions = TSFunctions;
    }

    @Column(name = "functioniframe")
    public Short getFunctionIframe() {
        return functionIframe;
    }

    public void setFunctionIframe(Short functionIframe) {
        this.functionIframe = functionIframe;
    }
}