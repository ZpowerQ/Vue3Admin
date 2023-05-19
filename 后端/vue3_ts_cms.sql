/*
 Navicat Premium Data Transfer

 Source Server         : liangweitang
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : vue3_ts_cms

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 19/05/2023 09:55:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `updatetime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '研发部门', '1', '2022-11-09 18:48:05', '2022-11-09 18:48:15');
INSERT INTO `department` VALUES (2, '市场部门', '1', '2022-11-09 18:48:05', '2022-11-09 18:48:15');
INSERT INTO `department` VALUES (3, '测试部门', '1', '2022-11-09 18:48:05', '2022-11-09 18:48:15');
INSERT INTO `department` VALUES (4, '财务部门', '1', '2022-11-09 18:48:05', '2022-11-09 18:48:15');
INSERT INTO `department` VALUES (5, '运维部门', '1', '2022-11-09 18:48:05', '2022-11-09 18:48:15');

-- ----------------------------
-- Table structure for first_menu
-- ----------------------------
DROP TABLE IF EXISTS `first_menu`;
CREATE TABLE `first_menu`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `index` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `state` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of first_menu
-- ----------------------------
INSERT INTO `first_menu` VALUES (1, '系统总览', 'HelpFilled', '1', '2022-10-24 12:27:11', 1);
INSERT INTO `first_menu` VALUES (2, '系统管理', 'Setting', '2', '2022-10-24 12:27:15', 1);
INSERT INTO `first_menu` VALUES (3, '商品中心', 'Shop', '3', '2022-10-24 12:27:18', 1);
INSERT INTO `first_menu` VALUES (4, '系统监控', 'Monitor', '4', '2022-10-24 12:27:22', 1);

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `originalprice` decimal(10, 2) NULL DEFAULT NULL,
  `currentprice` decimal(10, 2) NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stock` int(0) NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `updatetime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES (1, '笔记本电脑', 7889.00, 7500.00, 'http://localhost:8080/good/1.png', '1', 100, '2022-10-27 18:45:53', '2022-11-02 11:40:29');
INSERT INTO `good` VALUES (2, 'iphone14', 7888.00, 7588.00, 'http://localhost:8080/good/2.png', '1', 100, '2022-10-27 18:45:53', '2022-10-28 18:46:01');
INSERT INTO `good` VALUES (3, '荣耀手机', 4588.00, 4258.00, 'http://localhost:8080/good/3.png', '1', 100, '2022-10-27 18:45:53', '2022-10-28 18:46:01');
INSERT INTO `good` VALUES (4, '相机', 2558.00, 2100.00, 'http://localhost:8080/good/4.png', '1', 100, '2022-10-28 18:45:53', '2022-10-28 18:46:01');
INSERT INTO `good` VALUES (5, '耳机', 200.00, 178.00, 'http://localhost:8080/good/5.png', '1', 100, '2022-10-28 18:45:53', '2022-10-28 18:46:01');
INSERT INTO `good` VALUES (6, '充电器', 45.00, 38.00, 'http://localhost:8080/good/6.png', '1', 100, '2022-10-28 18:45:53', '2022-10-28 18:46:01');
INSERT INTO `good` VALUES (7, '台灯', 35.00, 30.00, 'http://localhost:8080/good/7.png', '1', 100, '2022-10-28 18:45:53', '2022-10-28 18:46:01');
INSERT INTO `good` VALUES (8, 'i5处理器', 1588.00, 1388.00, 'http://localhost:8080/good/8.png', '1', 100, '2022-10-28 18:45:53', '2022-10-28 18:46:01');
INSERT INTO `good` VALUES (9, '小米手机', 2598.00, 2400.00, 'http://localhost:8080/good/9.png', '1', 100, '2022-10-29 18:45:53', '2022-10-28 18:46:01');
INSERT INTO `good` VALUES (10, 'iQOO', 2489.00, 2398.00, 'http://localhost:8080/good/10.png', '1', 100, '2022-10-29 18:45:53', '2022-10-28 18:46:01');
INSERT INTO `good` VALUES (11, '华为手机', 2099.00, 1799.00, 'http://localhost:8080/good/11.png', '1', 100, '2022-10-29 18:45:53', '2022-10-28 18:46:01');

-- ----------------------------
-- Table structure for good_category
-- ----------------------------
DROP TABLE IF EXISTS `good_category`;
CREATE TABLE `good_category`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good_category
-- ----------------------------
INSERT INTO `good_category` VALUES (1, '电脑', 'http://loclhost:8080/good_category/1.jpg');
INSERT INTO `good_category` VALUES (2, '音响', 'http://loclhost:8080/good_category/2.jpg');
INSERT INTO `good_category` VALUES (3, '手机', 'http://loclhost:8080/good_category/3.jpg');
INSERT INTO `good_category` VALUES (4, '耳机', 'http://loclhost:8080/good_category/4.jpg');
INSERT INTO `good_category` VALUES (5, '平板', 'http://loclhost:8080/good_category/5.jpg');
INSERT INTO `good_category` VALUES (6, '键盘', 'http://loclhost:8080/good_category/6.jpg');
INSERT INTO `good_category` VALUES (7, '鼠标', 'http://loclhost:8080/good_category/7.jpg');
INSERT INTO `good_category` VALUES (8, '充电线', 'http://loclhost:8080/good_category/8.jpg');
INSERT INTO `good_category` VALUES (9, '台灯', 'http://loclhost:8080/good_category/9.jpg');
INSERT INTO `good_category` VALUES (10, '显卡', 'http://loclhost:8080/good_category/10.jpg');
INSERT INTO `good_category` VALUES (11, 'U盘', 'http://loclhost:8080/good_category/11.jpg');
INSERT INTO `good_category` VALUES (12, '显示器', 'http://loclhost:8080/good_category/12.jpg');

-- ----------------------------
-- Table structure for good_cell_count
-- ----------------------------
DROP TABLE IF EXISTS `good_cell_count`;
CREATE TABLE `good_cell_count`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(0) NULL DEFAULT NULL,
  `money` float(255, 0) NULL DEFAULT NULL,
  `like` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good_cell_count
-- ----------------------------
INSERT INTO `good_cell_count` VALUES (1, '上衣', 450, 150000, 4100);
INSERT INTO `good_cell_count` VALUES (2, '裤子', 500, 179000, 5100);
INSERT INTO `good_cell_count` VALUES (3, '鞋子', 521, 102000, 6550);
INSERT INTO `good_cell_count` VALUES (4, '厨具', 786, 312000, 7263);
INSERT INTO `good_cell_count` VALUES (5, '家具', 810, 157000, 7851);
INSERT INTO `good_cell_count` VALUES (6, '女装', 921, 213000, 8789);
INSERT INTO `good_cell_count` VALUES (7, '日常用品', 1020, 365000, 10011);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `updatetime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '所有权限', '2022-10-26 12:37:16', '2022-10-26 12:37:31');
INSERT INTO `role` VALUES (2, '人事', '人员管理', '2022-10-26 12:37:16', '2022-10-26 12:37:31');
INSERT INTO `role` VALUES (3, '商品运营', '商品管理', '2022-10-26 12:37:16', '2022-10-26 12:37:31');
INSERT INTO `role` VALUES (4, '总裁办', '系统管理', '2022-10-26 12:37:16', '2022-10-26 12:37:31');

-- ----------------------------
-- Table structure for second_menu
-- ----------------------------
DROP TABLE IF EXISTS `second_menu`;
CREATE TABLE `second_menu`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parentmenu` int(0) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `index` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of second_menu
-- ----------------------------
INSERT INTO `second_menu` VALUES (1, '核心技术', 1, '/main/overview/technology', '1-1', 'Key', '2022-10-25 12:00:00', '1');
INSERT INTO `second_menu` VALUES (2, '商品统计', 1, '/main/overview/goodscount', '1-2', 'PieChart', '2022-10-25 12:00:00', '1');
INSERT INTO `second_menu` VALUES (3, '用户管理', 2, '/main/management/user', '2-1', 'UserFilled', '2022-10-25 12:00:00', '1');
INSERT INTO `second_menu` VALUES (4, '部门管理', 2, '/main/management/department', '2-2', 'Compass', '2022-10-25 12:00:00', '1');
INSERT INTO `second_menu` VALUES (5, '角色管理', 2, '/main/management/role', '2-3', 'Avatar', '2022-10-25 12:00:00', '1');
INSERT INTO `second_menu` VALUES (6, '菜单管理', 2, '/main/management/menus', '2-4', 'Menu', '2022-10-25 12:00:00', '1');
INSERT INTO `second_menu` VALUES (7, '商品类别', 3, '/main/goodscenter/category', '3-1', 'ShoppingBag', '2022-10-25 12:00:00', '1');
INSERT INTO `second_menu` VALUES (8, '商品信息', 3, '/main/goodscenter/info', '3-2', 'Goods', '2022-10-25 12:00:00', '1');
INSERT INTO `second_menu` VALUES (9, '服务监控', 4, '/main/monitor/online', '4-1', 'Service', '2022-10-25 12:00:00', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enable` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '13212345678', 1);
INSERT INTO `user` VALUES (2, 'power', 'power', '13512345678', 1);

-- ----------------------------
-- Table structure for user_menu
-- ----------------------------
DROP TABLE IF EXISTS `user_menu`;
CREATE TABLE `user_menu`  (
  `id` int(0) NOT NULL,
  `userId` int(0) NULL DEFAULT NULL,
  `firstMenuId` int(0) NULL DEFAULT NULL,
  `secondMenuId` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_menu
-- ----------------------------
INSERT INTO `user_menu` VALUES (1, 1, 1, 1);
INSERT INTO `user_menu` VALUES (2, 1, 1, 2);
INSERT INTO `user_menu` VALUES (3, 1, 2, 3);
INSERT INTO `user_menu` VALUES (4, 1, 2, 4);
INSERT INTO `user_menu` VALUES (5, 1, 2, 5);
INSERT INTO `user_menu` VALUES (6, 1, 2, 6);
INSERT INTO `user_menu` VALUES (7, 1, 3, 7);
INSERT INTO `user_menu` VALUES (8, 1, 3, 8);
INSERT INTO `user_menu` VALUES (9, 1, 4, 9);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usericon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `updatetime` datetime(0) NULL DEFAULT NULL,
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `online` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, 'admin', 'admin', '超级管理员', '13212345678', 'http://localhost:8080/avatar/1.jpg', '2022-10-26 16:41:41', '2022-10-27 16:51:12', '1', 0);
INSERT INTO `userinfo` VALUES (2, 'power', 'power', '人事', '13512345678', 'http://localhost:8080/avatar/default.png', '2022-10-26 16:41:41', '2022-10-27 16:51:12', '1', 0);
INSERT INTO `userinfo` VALUES (3, 'David Martin', '123456', '人事', '18944981684', 'http://localhost:8080/avatar/default.png', '2022-10-26 16:41:41', '2022-10-31 05:01:27', '1', 0);
INSERT INTO `userinfo` VALUES (4, 'Deborah Thompson', '123456', '人事', '13556513634', 'http://localhost:8080/avatar/default.png', '2022-10-27 16:41:41', '2022-10-27 16:51:12', '1', 0);
INSERT INTO `userinfo` VALUES (5, 'Deborah Davis', '123456', '人事', '13258053240', 'http://localhost:8080/avatar/default.png', '2022-10-27 16:41:41', '2022-10-27 16:51:12', '1', 0);
INSERT INTO `userinfo` VALUES (6, 'Donald Hernandez', '123456', '商品运营', '13518596311', 'http://localhost:8080/avatar/default.png', '2022-10-27 16:41:41', '2022-10-27 16:51:12', '1', 0);
INSERT INTO `userinfo` VALUES (7, 'Steven Williams', '123456', '商品运营', '18981060828', 'http://localhost:8080/avatar/default.png', '2022-10-27 16:41:41', '2022-10-27 16:51:12', '1', 0);
INSERT INTO `userinfo` VALUES (8, 'Karen Brown', '123456', '商品运营', '13547568618', 'http://localhost:8080/avatar/default.png', '2022-10-27 16:41:41', '2022-10-27 16:51:12', '1', 0);
INSERT INTO `userinfo` VALUES (9, 'Jeffrey Davis', '123456', '总裁办', '13548987184', 'http://localhost:8080/avatar/default.png', '2022-10-27 16:41:41', '2022-10-27 16:51:12', '1', 0);
INSERT INTO `userinfo` VALUES (10, 'Patricia Garcia', '123456', '总裁办', '13585624720', 'http://localhost:8080/avatar/default.png', '2022-10-28 16:41:41', '2022-10-28 16:51:12', '1', 0);
INSERT INTO `userinfo` VALUES (11, 'Elizabeth Jones', '123456', '总裁办', '13269761266', 'http://localhost:8080/avatar/default.png', '2022-10-28 16:41:41', '2022-10-28 16:51:12', '0', 0);
INSERT INTO `userinfo` VALUES (12, 'Elizabeth Jones', '123456', '总裁办', '13269761266', 'http://localhost:8080/avatar/default.png', '2022-10-28 16:41:41', '2022-10-28 16:51:12', '1', 0);
INSERT INTO `userinfo` VALUES (13, '123123', '1231231', '人事', '231231231', 'http://localhost:8080/avatar/default.png', '2022-10-31 05:27:55', '2022-10-31 05:27:55', '1', 0);

SET FOREIGN_KEY_CHECKS = 1;
