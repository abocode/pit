/*
Navicat MySQL Data Transfer

Source Server         : 47.243.114.191-dev
Source Server Version : 50737
Source Host           : 47.243.114.191:3306
Source Database       : source-vue

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-07-30 12:11:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for house_feature
-- ----------------------------
DROP TABLE IF EXISTS `house_feature`;
CREATE TABLE `house_feature` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_id` bigint(20) NOT NULL,
  `feature` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=463 DEFAULT CHARSET=utf8 COMMENT='房源特色';

-- ----------------------------
-- Table structure for house_heart
-- ----------------------------
DROP TABLE IF EXISTS `house_heart`;
CREATE TABLE `house_heart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=413 DEFAULT CHARSET=utf8 COMMENT='房源特色';

-- ----------------------------
-- Table structure for house_image
-- ----------------------------
DROP TABLE IF EXISTS `house_image`;
CREATE TABLE `house_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_id` bigint(20) DEFAULT NULL,
  `image_name` varchar(50) DEFAULT NULL,
  `image_path` varchar(200) DEFAULT NULL,
  `img_url` varchar(200) DEFAULT NULL,
  `image_size` float(11,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=308 DEFAULT CHARSET=utf8 COMMENT='房源图片';

-- ----------------------------
-- Table structure for house_room
-- ----------------------------
DROP TABLE IF EXISTS `house_room`;
CREATE TABLE `house_room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(1) NOT NULL COMMENT '0整租/1合租',
  `house_num` varchar(2) DEFAULT NULL COMMENT '居室',
  `toilet_num` varchar(2) DEFAULT NULL COMMENT '卫生间',
  `house_area` float(6,2) DEFAULT NULL COMMENT '整套面积',
  `room_type` int(1) DEFAULT NULL COMMENT '1主卧,1次卧',
  `room_code` varchar(10) DEFAULT NULL COMMENT '房间号',
  `room_area` float(6,0) DEFAULT NULL COMMENT '房屋面积',
  `direction` varchar(2) DEFAULT NULL COMMENT '朝向',
  `price` decimal(10,2) DEFAULT NULL COMMENT '租金',
  `floor` varchar(10) DEFAULT NULL COMMENT '楼层',
  `step_type` varchar(10) DEFAULT NULL COMMENT '楼房类型',
  `start_date` datetime DEFAULT NULL COMMENT '起租日期',
  `introduce` varchar(255) DEFAULT NULL COMMENT '房源描述',
  `owner_name` varchar(20) DEFAULT NULL COMMENT '房东姓名',
  `ower_phone` varchar(11) DEFAULT NULL COMMENT '房东电话',
  `village_id` bigint(20) DEFAULT NULL COMMENT '小区id',
  `village_name` varchar(20) DEFAULT NULL COMMENT '小区名称',
  `address` varchar(100) DEFAULT NULL COMMENT '具体地址',
  `house_no` varchar(10) DEFAULT NULL COMMENT '房牌号',
  `pay_type` varchar(10) DEFAULT NULL COMMENT '付款方式',
  `publish_id` bigint(20) DEFAULT NULL COMMENT '发布人id',
  `state` int(1) DEFAULT NULL COMMENT '0：待出租，1：已出租,2:下架',
  `create_time` datetime DEFAULT NULL,
  `create_name` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_name` varchar(20) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `house_Hall` varchar(2) DEFAULT NULL,
  `code` varchar(32) DEFAULT NULL,
  `face_Url` varchar(200) NOT NULL,
  `decoration` varchar(50) DEFAULT NULL,
  `agent_Name` varchar(20) DEFAULT NULL,
  `agent_Phone` varchar(20) DEFAULT NULL,
  `agent_User_Id` bigint(20) DEFAULT NULL,
  `agent_Avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_house` (`publish_id`,`village_id`,`address`,`house_no`,`price`,`ower_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8 COMMENT='房源详情';

-- ----------------------------
-- Table structure for house_user
-- ----------------------------
DROP TABLE IF EXISTS `house_user`;
CREATE TABLE `house_user` (
  `id` bigint(20) NOT NULL,
  `house_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `publish_id` bigint(20) NOT NULL,
  `actual_price` decimal(10,2) NOT NULL,
  `state` int(1) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `remark` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出租信息';

-- ----------------------------
-- Table structure for house_village
-- ----------------------------
DROP TABLE IF EXISTS `house_village`;
CREATE TABLE `house_village` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `province` varchar(10) NOT NULL COMMENT '省',
  `city` varchar(20) NOT NULL COMMENT '市',
  `area` varchar(50) NOT NULL COMMENT '区',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `code` varchar(50) DEFAULT NULL COMMENT '代号',
  `year` int(4) DEFAULT NULL COMMENT '年份',
  `type` varchar(20) DEFAULT NULL COMMENT '建筑类型',
  `green` float(5,2) DEFAULT NULL COMMENT '绿化率',
  `introduce` varchar(200) DEFAULT NULL COMMENT '介绍',
  `way_state` int(1) DEFAULT NULL COMMENT '靠近地铁',
  `way_code` varchar(20) DEFAULT NULL COMMENT '地铁线路',
  `way_space` int(8) DEFAULT NULL COMMENT '地铁距离',
  `lon` decimal(10,6) DEFAULT NULL COMMENT '经度',
  `Lat` decimal(10,6) DEFAULT NULL COMMENT '纬度',
  `state` int(1) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='房源小区';
