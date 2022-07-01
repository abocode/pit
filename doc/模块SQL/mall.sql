/*
Navicat MySQL Data Transfer

Source Server         : 47.243.114.191-dev
Source Server Version : 50737
Source Host           : 47.243.114.191:3306
Source Database       : source-vue

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-07-01 20:59:51
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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COMMENT='收货地址';

-- ----------------------------
-- Records of mall_address
-- ----------------------------
INSERT INTO `mall_address` VALUES ('56', '1', '张三', '18720989281', '浙江省杭州市', '0', '0', null, null, '2022-06-19 15:21:49', 'admin', '2022-06-25 10:32:44', '默认地址');

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
-- Records of mall_advert
-- ----------------------------
INSERT INTO `mall_advert` VALUES ('51', '1', '美妆中部广告', '{id:1}', '/profile/upload/2022/05/03/97f15df7-215e-4428-b4a2-af6c3e118860.png', '1', '0', null, '2022-05-03 09:39:19', null, '2022-05-03 19:40:17', null);
INSERT INTO `mall_advert` VALUES ('52', '0', '美妆专场', '{id:2}', '/profile/upload/2022/05/03/eb6b4b8b-1fa1-45c4-aca8-bec82fe3a2dd.jpg', '2', '0', null, '2022-05-03 09:39:37', null, '2022-05-03 19:40:57', null);
INSERT INTO `mall_advert` VALUES ('53', '0', '美妆分类', '{id:3}', '/profile/upload/2022/05/03/bfa310b1-f555-4575-b638-55251456ddf5.jpg', '3', '0', null, '2022-05-03 09:39:50', null, '2022-05-03 19:41:04', null);
INSERT INTO `mall_advert` VALUES ('54', '0', '狗粮分类', '{id:4}', '/profile/upload/2022/05/03/047f0ab9-177a-42c4-ab19-080a5e3ac6b4.jpg', '4', '0', null, '2022-05-03 09:40:05', null, '2022-05-03 19:41:10', null);
INSERT INTO `mall_advert` VALUES ('55', '2', '热门推荐', '{hotStatus:0}', '/profile/upload/2022/05/03/3834f244-c14f-4db1-9a87-ee664463e900.png', '5', '0', null, '2022-05-03 10:50:44', null, '2022-05-03 19:41:49', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8mb4 COMMENT='分类管理';

-- ----------------------------
-- Records of mall_classify
-- ----------------------------
INSERT INTO `mall_classify` VALUES ('116', '0', '', '宠物用品', '/profile/upload/2022/05/02/b8312427-8de8-46c2-a315-481374fe5b2b.jpg', '1', '0', '', '2022-05-02 21:54:36', '', null, null);
INSERT INTO `mall_classify` VALUES ('117', '116', '', '海洋之星猫/狗粮', '/profile/upload/2022/05/02/b2a2f21c-7212-480e-aae6-696aa1716a2a.jpg', '1', '0', '', '2022-05-02 21:56:05', '', '2022-05-03 09:24:43', null);
INSERT INTO `mall_classify` VALUES ('118', '0', '', '个护彩妆', '/profile/upload/2022/05/03/e6096a82-c8ff-46e5-b3df-345f3361ca85.jpg', '2', '0', '', '2022-05-03 09:29:04', '', null, null);
INSERT INTO `mall_classify` VALUES ('119', '0', '', '母婴童装', '/profile/upload/2022/05/03/4e66b699-d513-42ff-9dcf-af23bc60e856.jpg', '3', '0', '', '2022-05-03 09:29:29', '', null, null);
INSERT INTO `mall_classify` VALUES ('120', '0', '', '家居家纺', '/profile/upload/2022/05/03/9bc5c1e1-144a-451c-89e5-10c1aca374a5.jpg', '4', '0', '', '2022-05-03 09:29:42', '', null, null);
INSERT INTO `mall_classify` VALUES ('121', '118', '', '口红', '/profile/upload/2022/05/03/3ea7a7ff-c4a4-411f-b7c6-769438a1559c.jpg', '1', '0', '', '2022-05-03 09:30:51', '', '2022-05-03 09:30:57', null);
INSERT INTO `mall_classify` VALUES ('122', '119', '', '妈咪包/背婴带', '/profile/upload/2022/05/03/2870e281-3c4e-46cf-bea5-c4b72a31aed0.jpg', '1', '0', '', '2022-05-03 09:31:23', '', null, null);
INSERT INTO `mall_classify` VALUES ('123', '120', '', '沙发垫套', '/profile/upload/2022/05/03/8a226307-fbfc-4545-9bf4-a438798e8fd3.jpg', '1', '0', '', '2022-05-03 09:31:38', '', null, null);
INSERT INTO `mall_classify` VALUES ('124', '118', '', '女士香水', '/profile/upload/2022/05/12/9670f8e6-e3f1-405d-85c6-7a3415e3b716.jpg', '2', '0', '', '2022-05-12 19:00:46', '', null, null);
INSERT INTO `mall_classify` VALUES ('125', '118', '', '隔离霜', '/profile/upload/2022/05/12/e67739cf-ec26-415f-9e72-47718ee7343b.jpg', '3', '0', '', '2022-05-12 19:01:30', '', null, null);

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
-- Records of mall_goods
-- ----------------------------
INSERT INTO `mall_goods` VALUES ('52', '海洋之星猫/狗粮', '海洋之星 深海鱼幼犬 小颗粒', null, '150.00', '180.00', '10', '/profile/upload/2022/05/02/bae52365-fbb1-495c-9b6d-6c49db7fe368.jpg', '/profile/upload/2022/05/02/9629bc51-fad6-4295-94e4-83a80ee336d3.jpg,/profile/upload/2022/05/03/b6555264-8813-4b4a-b05e-d0f729b3c77e.jpg,/profile/upload/2022/05/03/af8d802e-1e3a-4eea-810a-10578518b6f0.jpg', '<p><img src=\"\"><img src=\"\"><img src=\"\"><img src=\"\"><img src=\"\"><img src=\"\"><img src=\"\"><img src=\"\"><img src=\"\"><img src=\"https://vkceyugu.cdn.bspapp.com/VKCEYUGU-mix-mall-admin/ffb3e3dc-79aa-45d9-a0b3-d10189a906ce.jpg\" height=\"1051\" width=\"750\"></p><p><img src=\"https://vkceyugu.cdn.bspapp.com/VKCEYUGU-mix-mall-admin/d3998f5c-2f03-4da2-9cf1-87ebb3b53d95.jpg\" height=\"569\" width=\"750\"></p><p><img src=\"https://vkceyugu.cdn.bspapp.com/VKCEYUGU-mix-mall-admin/5212c55e-8092-4c4a-876d-da2aa1914575.jpg\"></p><p><img src=\"https://vkceyugu.cdn.bspapp.com/VKCEYUGU-mix-mall-admin/42c6b6a0-3eee-4616-8660-b0d1ae1a1212.jpg\" height=\"907\" width=\"750\"></p><p><img src=\"https://vkceyugu.cdn.bspapp.com/VKCEYUGU-mix-mall-admin/c91627d6-68d3-4e5d-8a02-af321e6ab4e5.jpg\" height=\"1255\" width=\"750\"></p><p><img src=\"https://vkceyugu.cdn.bspapp.com/VKCEYUGU-mix-mall-admin/4351eb7f-7f1a-435a-8cdf-28d4b19aacd2.jpg\" height=\"889\" width=\"790\"></p><p><img src=\"https://vkceyugu.cdn.bspapp.com/VKCEYUGU-mix-mall-admin/87a8bb72-7c5a-476b-a928-ad1715ef81f7.jpg\" height=\"1116\" width=\"790\"></p><p><img src=\"https://vkceyugu.cdn.bspapp.com/VKCEYUGU-mix-mall-admin/0cab6906-069b-482a-ab9c-e8d71807d76c.jpg\" height=\"712\" width=\"790\"></p><p>&nbsp;</p>', '0', '0', '0', '0', 'mall', '2022-05-02 21:58:36', 'admin', '2022-05-12 18:54:08', null);
INSERT INTO `mall_goods` VALUES ('53', '海洋之星猫/狗粮', '海洋之星 臻越进口 三文鱼狗粮', '', '765.00', '788.00', '9824', '/profile/upload/2022/05/12/1dee2a26-c9f2-4bcd-8a90-c5906d8e07c5.jpg', '/profile/upload/2022/05/12/e2e99d12-245c-4201-9431-b939a9e32739.jpg', '<p><img src=\"https://img.alicdn.com/imgextra/i2/785880482/O1CN01e0wqyo1FQnPWOYJM7_!!785880482.jpg\" height=\"246\" width=\"790\"></p><p><img src=\"https://img.alicdn.com/imgextra/i4/785880482/O1CN01DQKx7m1FQnPY9oZxU_!!785880482.jpg\"></p><p><img src=\"https://img.alicdn.com/imgextra/i2/785880482/O1CN01VdQLTz1FQnPVTMrqk_!!785880482.jpg\" height=\"828\" width=\"790\"></p><p><img src=\"https://img.alicdn.com/imgextra/i4/785880482/O1CN01ZUOBRN1FQnPV65bUI_!!785880482.jpg\" height=\"786\" width=\"790\"></p><p><img src=\"https://img.alicdn.com/imgextra/i3/785880482/O1CN01Ag0Inq1FQnPXdawBJ_!!785880482.jpg\" height=\"915\" width=\"790\"></p><p><img src=\"https://img.alicdn.com/imgextra/i1/785880482/O1CN01n0MXGp1FQnPSwaeZY_!!785880482.jpg\" height=\"803\" width=\"790\"></p><p><img src=\"https://img.alicdn.com/imgextra/i3/785880482/O1CN015oggBb1FQnPXdZvoC_!!785880482.jpg\" height=\"1013\" width=\"790\"></p><p><img src=\"https://img.alicdn.com/imgextra/i2/785880482/O1CN012rjdpI1FQnPV64GKp_!!785880482.jpg\" height=\"775\" width=\"790\"></p><p><img src=\"https://img.alicdn.com/imgextra/i4/785880482/O1CN01ODdJ3d1FQnPUxrETo_!!785880482.jpg\" height=\"774\" width=\"790\"></p><p><img src=\"https://img.alicdn.com/imgextra/i4/785880482/O1CN01p2uQfa1FQnPThevHt_!!785880482.jpg\" height=\"1012\" width=\"790\"></p><p><img src=\"https://img.alicdn.com/imgextra/i2/785880482/O1CN01im8LHr1FQnPWObSnM_!!785880482.jpg\" height=\"577\" width=\"790\"></p><p><img src=\"https://img.alicdn.com/imgextra/i3/785880482/O1CN01ApTRcC1FQnPWEsKGW_!!785880482.jpg\" height=\"1035\" width=\"790\"></p><p><img src=\"https://img.alicdn.com/imgextra/i1/785880482/O1CN01FERp5N1FQnPWtEdYc_!!785880482.jpg\" height=\"1152\" width=\"790\"></p>', '0', '0', '0', '0', 'admin', '2022-05-12 18:54:04', null, null, null);
INSERT INTO `mall_goods` VALUES ('54', '口红', '阿玛尼（ARMANI）', null, '305.00', '339.00', '3999', '/profile/upload/2022/05/12/caa48b22-fc33-4370-b171-8ff0b52257e6.jpg', '/profile/upload/2022/05/12/8cc1e3c6-117d-4d7f-bb8c-5c14713606c0.jpg,/profile/upload/2022/05/12/02f13996-ab5b-40cd-ad0b-007f2b3db2bd.jpg,/profile/upload/2022/05/12/7dd4478b-77e8-4b70-9020-d7f786c55171.jpg', '<p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595600850659597265.jpg\" height=\"637\" width=\"750\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595600862432659312.jpg\" height=\"701\" width=\"750\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595600907544238604.jpg\" height=\"837\" width=\"750\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595600874394982080.jpg\" height=\"1052\" width=\"1125\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595600920132981518.jpg\" height=\"1206\" width=\"1125\"></p>', '0', '0', '0', '0', 'admin', '2022-05-12 18:56:26', null, null, null);
INSERT INTO `mall_goods` VALUES ('55', '口红', '卡姿兰口红小粉管盈彩唇膏唇釉学生小样', null, '54.00', '99.00', '4995', '/profile/upload/2022/05/12/d8c7efb2-b122-4291-97bd-8c25ef331389.jpg', '/profile/upload/2022/05/12/49047332-07fe-4722-b383-0100416ef389.jpg,/profile/upload/2022/05/12/14671422-9140-46f6-9f4a-b2f424d39097.jpg', '<p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595601858032370088.jpg\" height=\"1273\" width=\"790\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595601877626487072.jpg\" height=\"962\" width=\"790\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595601893908785580.jpg\" height=\"805\" width=\"790\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595601905345938189.jpg\" height=\"1072\" width=\"790\"></p>', '0', '0', '0', '0', 'admin', '2022-05-12 18:57:48', null, null, null);
INSERT INTO `mall_goods` VALUES ('56', '口红', '卡姿兰 （Carslan） 雾感丝滑唇釉', null, '79.00', '89.00', '2210', '/profile/upload/2022/05/12/ec382f81-2a26-4713-a877-060d1e1dc898.jpg', '/profile/upload/2022/05/12/9cc46013-4e81-4456-9e7b-76c1ef385800.jpg', '<p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595601858032370088.jpg\" height=\"1273\" width=\"790\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595601877626487072.jpg\" height=\"962\" width=\"790\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595601893908785580.jpg\" height=\"805\" width=\"790\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595601905345938189.jpg\" height=\"1072\" width=\"790\"></p>', '0', '0', '0', '0', 'admin', '2022-05-12 18:59:15', null, null, null);
INSERT INTO `mall_goods` VALUES ('57', '女士香水', '法颂浪漫梦境精美女士香水留香持久淡香', null, '89.00', '299.00', '989', '/profile/upload/2022/05/12/b3f0d9cb-9d30-4530-95d8-185dc5c82d5e.jpg', '/profile/upload/2022/05/12/149a670b-02e6-4398-b494-668ecc9b9966.jpg', '<p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595658199400635167.jpg\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595658205716053419.jpg\"></p>', '0', '0', '0', '0', 'admin', '2022-05-12 19:02:54', null, null, null);
INSERT INTO `mall_goods` VALUES ('58', '隔离霜', '资生堂 Za白色新焕真皙美白隔离霜', null, '1.80', '0.00', '1962', '/profile/upload/2022/05/12/b3b30c0f-df48-4417-81ef-cdb7ce985483.jpg', '/profile/upload/2022/05/12/ba26b5bb-7ffc-414c-ba56-6f4358db2e93.jpg,/profile/upload/2022/05/12/4072697f-be88-4a68-ad3a-14698799c612.jpg', '<p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595658512669721213.jpg\" height=\"1000\" width=\"750\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595658522920550306.jpg\" height=\"1071\" width=\"750\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595658534383425508.jpg\"></p>', '0', '0', '0', '0', 'admin', '2022-05-12 19:04:05', null, null, null);
INSERT INTO `mall_goods` VALUES ('59', '隔离霜', 'MR.WISH 心愿先生 多效修颜隔离霜', null, '0.01', '68.00', '890', '/profile/upload/2022/05/12/dd4b58ff-25e9-4434-8b45-6af8ab911468.jpg', '/profile/upload/2022/05/12/e16a2ecf-8743-47e9-b157-931e8c448c02.jpg', '<p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595658739458599036.jpg\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595658730372852130.jpg\" height=\"969\" width=\"790\"></p><p><img src=\"https://7478-tx-cloud-mix-mall-d6944c-1302673523.tcb.qcloud.la/1595658747670893241.jpg\" height=\"969\" width=\"790\"></p>', '0', '0', '0', '0', 'admin', '2022-05-12 19:05:13', null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COMMENT='商品规格';

-- ----------------------------
-- Records of mall_goods_spec
-- ----------------------------

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
-- Records of mall_navigate
-- ----------------------------
INSERT INTO `mall_navigate` VALUES ('51', '大牌精选', '1', '/profile/upload/2022/05/03/a414e808-6959-4119-a0b4-0ac58d38670e.png', '1', '0', null, '2022-05-03 09:42:50', null, null, null);
INSERT INTO `mall_navigate` VALUES ('52', '母婴童装', '2', '/profile/upload/2022/05/03/e20e5a78-2a37-41b7-b885-2fbfe97f4d38.png', '2', '0', null, '2022-05-03 09:43:03', null, null, null);
INSERT INTO `mall_navigate` VALUES ('53', '个护美妆', '3', '/profile/upload/2022/05/03/fdb9fa47-1e83-4b71-8d8a-2eaa1995b9d7.png', '3', '0', null, '2022-05-03 09:43:17', null, null, null);
INSERT INTO `mall_navigate` VALUES ('54', '家居家纺', '4', '/profile/upload/2022/05/03/cc10ef8d-8f6d-4bd8-8bd9-74ec7662712b.png', '4', '0', null, '2022-05-03 09:43:31', null, null, null);
INSERT INTO `mall_navigate` VALUES ('55', '潮品推荐', '5', '/profile/upload/2022/05/03/77719fb6-61e6-4c8d-97fa-fbc86f2f253c.png', '5', '0', null, '2022-05-03 09:43:47', null, null, null);
INSERT INTO `mall_navigate` VALUES ('56', '宠物用品', '6', '/profile/upload/2022/05/03/83b6cc50-490e-4e69-b7e2-6ae42c0a15a1.png', '6', '0', null, '2022-05-03 09:43:59', null, null, null);
INSERT INTO `mall_navigate` VALUES ('57', '超市百货', '7', '/profile/upload/2022/05/03/4ecdfc00-23e7-4c80-9fa6-9af81e281ac3.png', '7', '0', null, '2022-05-03 09:44:11', null, null, null);
INSERT INTO `mall_navigate` VALUES ('58', '园艺工坊', '8', '/profile/upload/2022/05/03/e033fc48-712c-433c-959d-dc0c2d53c2cd.png', '8', '0', null, '2022-05-03 09:44:22', null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COMMENT='订单信息';

-- ----------------------------
-- Records of mall_order
-- ----------------------------
INSERT INTO `mall_order` VALUES ('56', '20220619160641950000', '2022-06-19 16:06:42', '10.00', '1', '2022-06-19 16:06:42', '1', '1', '1', '0', '1', null, null, null, null, '2022-06-19 16:06:42', null, null, null);
INSERT INTO `mall_order` VALUES ('57', '20220619160822875001', '2022-06-19 16:08:23', '1.00', '1', '2022-06-19 16:06:44', '1', '3', '1', '0', '1', null, null, null, null, '2022-06-19 16:08:23', null, '2022-06-19 16:17:22', null);
