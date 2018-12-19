/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100126
 Source Host           : localhost:3306
 Source Schema         : basketball

 Target Server Type    : MySQL
 Target Server Version : 100126
 File Encoding         : 65001

 Date: 19/12/2018 15:46:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `posisi` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `angkatan` int(11) NULL DEFAULT NULL,
  `jk` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `ttl` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES (13, 'Ijah', 'Point', 2016, 'P', 'Blimbing');
INSERT INTO `player` VALUES (14, 'Ngatemi', 'Small', 2016, 'P', 'Mojokerto , 15 des 1997');
INSERT INTO `player` VALUES (15, 'Ngatemi', 'Small', 2016, 'P', 'Mojokerto , 15 des 1997');
INSERT INTO `player` VALUES (16, 'Ngatemi', 'Small', 2016, 'P', 'Mojokerto , 15 des 1997');
INSERT INTO `player` VALUES (17, 'Aisyah', 'ShootingGuard', 2016, 'P', 'Khayangan');
INSERT INTO `player` VALUES (18, 'Naruto', 'Power Forward', 2017, 'L', 'Konoha, 17 Augustus 1998');

-- ----------------------------
-- Table structure for sesilatihan
-- ----------------------------
DROP TABLE IF EXISTS `sesilatihan`;
CREATE TABLE `sesilatihan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hari` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `tanggal` date NULL DEFAULT NULL,
  `jam` time(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `username` varchar(25) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(25) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'adminjuned', '1');

SET FOREIGN_KEY_CHECKS = 1;
