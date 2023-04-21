/*
Navicat MySQL Data Transfer

Source Server         : 开源字节(腾讯云)
Source Server Version : 50740
Source Host           : 43.139.148.109:3306
Source Database       : source-vue

Target Server Type    : MYSQL
Target Server Version : 50740
File Encoding         : 65001

Date: 2023-04-21 20:08:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `house_evaluate`
-- ----------------------------
DROP TABLE IF EXISTS `house_evaluate`;
CREATE TABLE `house_evaluate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `house_id` bigint(20) NOT NULL COMMENT '房屋id',
  `eval_user_id` bigint(20) NOT NULL COMMENT '评价人id',
  `eval_user` varchar(255) DEFAULT NULL COMMENT '评价人',
  `evaluate` text NOT NULL COMMENT '评价',
  `state` int(1) NOT NULL COMMENT '状态 1显示 2删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='房源评价';

-- ----------------------------
-- Records of house_evaluate
-- ----------------------------
