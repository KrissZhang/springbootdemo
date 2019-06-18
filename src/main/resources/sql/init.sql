/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50561
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50561
 File Encoding         : 65001

 Date: 18/06/2019 17:36:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `modelname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                             `permission` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '首页', 'see');
INSERT INTO `permission` VALUES (2, '首页', 'update');
INSERT INTO `permission` VALUES (3, '评论页', 'delete');
INSERT INTO `permission` VALUES (4, '评论页', 'add');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
                       `id` int(11) NOT NULL AUTO_INCREMENT,
                       `rolename` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                       `roledesc` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin', '管理员');
INSERT INTO `role` VALUES (2, 'user', '普通用户');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `rid` int(11) NOT NULL,
                                  `pid` int(11) NOT NULL,
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1, 1);
INSERT INTO `role_permission` VALUES (2, 1, 2);
INSERT INTO `role_permission` VALUES (3, 1, 3);
INSERT INTO `role_permission` VALUES (5, 2, 1);
INSERT INTO `role_permission` VALUES (6, 2, 2);

-- ----------------------------
-- Table structure for t_test
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
CREATE TABLE `t_test`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                         `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_test
-- ----------------------------
INSERT INTO `t_test` VALUES (1, '1', '1');
INSERT INTO `t_test` VALUES (2, '2', '2');
INSERT INTO `t_test` VALUES (3, '张三', '99');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                       `id` int(11) NOT NULL AUTO_INCREMENT,
                       `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                       `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', 'c93aafcc7c7f4fc21cb951c46434c1da');
INSERT INTO `user` VALUES (2, 'lisi', '123');
INSERT INTO `user` VALUES (3, 'wangwu', '123');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `uid` int(11) NOT NULL,
                            `rid` int(11) NOT NULL,
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
