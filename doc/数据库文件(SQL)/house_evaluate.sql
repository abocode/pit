/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : source-vue

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 16/04/2023 18:57:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for house_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `house_evaluate`;
CREATE TABLE `house_evaluate`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `house_id` bigint(0) NOT NULL COMMENT '房屋id',
  `eval_user_id` bigint(0) NOT NULL COMMENT '评价人id',
  `eval_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评价人',
  `evaluate` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评价',
  `state` int(0) NOT NULL COMMENT '状态 1显示 2删除',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_by` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remark` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '房源评价' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of house_evaluate
-- ----------------------------
INSERT INTO `house_evaluate` VALUES (1, 229, 12, NULL, '121412', 2, '2023-04-14 16:31:34', NULL, NULL, NULL, NULL);
INSERT INTO `house_evaluate` VALUES (2, 229, 1, 'admin', '2222222222222222222222', 1, '2023-04-14 16:43:56', NULL, NULL, NULL, NULL);
INSERT INTO `house_evaluate` VALUES (3, 216, 1, 'admin', '手机端测试', 1, '2023-04-14 16:43:56', NULL, NULL, NULL, NULL);
INSERT INTO `house_evaluate` VALUES (4, 216, 1, 'admin', '测试微信小程序的评价', 1, '2023-04-14 16:43:56', NULL, NULL, NULL, NULL);
INSERT INTO `house_evaluate` VALUES (5, 216, 10, '18720989281', '1231414', 1, '2023-04-16 18:25:49', NULL, NULL, NULL, NULL);
INSERT INTO `house_evaluate` VALUES (6, 216, 10, '18720989281', '测试小程序端提交', 1, '2023-04-16 18:26:45', NULL, NULL, NULL, NULL);


INSERT INTO `sys_menu` VALUES (1281, '房源评价', 1150, 1, 'evaluate', 'house/evaluate/index', NULL, 1, 0, 'C', '0', '0', 'system:evaluate:list', '#', 'admin', '2023-04-14 16:19:03', '', NULL, '房源评价菜单');
INSERT INTO `sys_menu` VALUES (1282, '房源评价查询', 1281, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'system:evaluate:query', '#', 'admin', '2023-04-14 16:19:03', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1283, '房源评价新增', 1281, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'system:evaluate:add', '#', 'admin', '2023-04-14 16:19:03', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1284, '房源评价修改', 1281, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'system:evaluate:edit', '#', 'admin', '2023-04-14 16:19:03', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1285, '房源评价删除', 1281, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'system:evaluate:remove', '#', 'admin', '2023-04-14 16:19:03', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1286, '房源评价导出', 1281, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'system:evaluate:export', '#', 'admin', '2023-04-14 16:19:03', '', NULL, '');


SET FOREIGN_KEY_CHECKS = 1;
