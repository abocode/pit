/*
Navicat MySQL Data Transfer

Source Server         : 47.243.114.191-dev
Source Server Version : 50737
Source Host           : 47.243.114.191:3306
Source Database       : source-vue

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-07-30 12:11:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_address
-- ----------------------------
DROP TABLE IF EXISTS `mall_address`;
CREATE TABLE `mall_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(50) NOT NULL COMMENT '收货人',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `address` varchar(50) NOT NULL COMMENT '地址',
  `is_default` char(1) NOT NULL COMMENT '默认地址',
  `normal_disable` char(1) NOT NULL DEFAULT '' COMMENT '是否启用',
  `sort_no` int(4) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COMMENT='收货地址';

-- ----------------------------
-- Table structure for mall_advert
-- ----------------------------
DROP TABLE IF EXISTS `mall_advert`;
CREATE TABLE `mall_advert` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `advert_type` int(1) NOT NULL COMMENT '广告类别',
  `advert_name` varchar(50) NOT NULL COMMENT '广告名称',
  `advert_address` varchar(50) NOT NULL COMMENT '链接地址',
  `advert_url` varchar(200) NOT NULL COMMENT '广告图片',
  `sort_no` int(4) NOT NULL COMMENT '排序',
  `normal_disable` char(1) NOT NULL COMMENT '是否启用',
  `create_by` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COMMENT='广告管理';

-- ----------------------------
-- Table structure for mall_classify
-- ----------------------------
DROP TABLE IF EXISTS `mall_classify`;
CREATE TABLE `mall_classify` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父id',
  `ancestors` varchar(50) NOT NULL DEFAULT '' COMMENT '祖级列表',
  `classify_name` varchar(30) NOT NULL DEFAULT '' COMMENT '分类名称',
  `classify_url` varchar(200) NOT NULL COMMENT '分类图片',
  `sort_no` int(4) DEFAULT '0' COMMENT '排序',
  `normal_disable` char(1) DEFAULT '0' COMMENT '是否启用',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8mb4 COMMENT='分类管理';

-- ----------------------------
-- Table structure for mall_goods
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods`;
CREATE TABLE `mall_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_classify` varchar(50) NOT NULL COMMENT '商品分类',
  `goods_name` varchar(50) NOT NULL COMMENT '商品名称',
  `goods_feature` varchar(50) DEFAULT NULL COMMENT '特色',
  `new_price` decimal(9,2) NOT NULL COMMENT '销售价',
  `old_price` decimal(9,2) DEFAULT NULL COMMENT '划线价',
  `goods_stock` int(9) NOT NULL COMMENT '库存',
  `goods_face_url` varchar(200) NOT NULL COMMENT '主图',
  `goods_item_url` varchar(2000) NOT NULL COMMENT '轮播图',
  `article_content` mediumtext CHARACTER SET utf8 NOT NULL COMMENT '图文详情',
  `sort_no` int(4) DEFAULT '0' COMMENT '排序',
  `status` char(1) DEFAULT NULL COMMENT '是否上架',
  `hot_Status` char(1) DEFAULT NULL COMMENT '是否热点',
  `goods_view` int(9) DEFAULT '0',
  `create_by` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COMMENT='商品管理';

-- ----------------------------
-- Table structure for mall_goods_spec
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_spec`;
CREATE TABLE `mall_goods_spec` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父id',
  `spec_name` varchar(50) NOT NULL COMMENT '规格名称',
  `spec_url` varchar(200) NOT NULL COMMENT '规格图片',
  `spec_price` decimal(9,2) NOT NULL COMMENT '销售价',
  `spec_stock` int(9) NOT NULL COMMENT '库存',
  `sort_no` int(4) DEFAULT '0' COMMENT '排序',
  `normal_disable` char(1) NOT NULL COMMENT '是否启用',
  `create_by` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品规格';

-- ----------------------------
-- Table structure for mall_navigate
-- ----------------------------
DROP TABLE IF EXISTS `mall_navigate`;
CREATE TABLE `mall_navigate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `navigate_name` varchar(50) NOT NULL COMMENT '导航名称',
  `navigate_address` varchar(50) NOT NULL COMMENT '链接地址',
  `navigate_url` varchar(200) NOT NULL COMMENT '导航图标',
  `sort_no` int(4) NOT NULL COMMENT '排序',
  `normal_disable` char(1) NOT NULL COMMENT '是否启用',
  `create_by` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COMMENT='导航管理';

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_code` varchar(20) NOT NULL COMMENT '订单号',
  `order_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `pay_amount` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '支付金额',
  `pay_method` char(1) DEFAULT NULL COMMENT '支付方式',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `pay_status` char(1) NOT NULL COMMENT '支持状态',
  `dis_amount` decimal(20,0) NOT NULL DEFAULT '0' COMMENT '优惠金额',
  `order_status` char(1) DEFAULT NULL COMMENT '订单状态',
  `sort_no` int(4) NOT NULL COMMENT '排序',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `receiver` varchar(20) DEFAULT NULL COMMENT '收货人',
  `receiver_Phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `receiver_Address` varchar(50) DEFAULT NULL COMMENT '收货地址',
  `create_by` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COMMENT='订单信息';
