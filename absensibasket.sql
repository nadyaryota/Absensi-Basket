/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.156_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : absensibasket

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-01-14 16:33:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for kehadiran
-- ----------------------------
DROP TABLE IF EXISTS `kehadiran`;
CREATE TABLE `kehadiran` (
  `id_kehadiran` int(11) NOT NULL AUTO_INCREMENT,
  `jenis` varchar(10) NOT NULL,
  PRIMARY KEY (`id_kehadiran`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of kehadiran
-- ----------------------------
INSERT INTO `kehadiran` VALUES ('1', 'Hadir');
INSERT INTO `kehadiran` VALUES ('2', 'Tidak');
INSERT INTO `kehadiran` VALUES ('3', 'Izin');
INSERT INTO `kehadiran` VALUES ('4', 'Sakit');
INSERT INTO `kehadiran` VALUES ('5', 'Alpha');

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) DEFAULT NULL,
  `posisi` varchar(255) DEFAULT NULL,
  `angkatan` int(11) DEFAULT NULL,
  `jk` char(1) DEFAULT NULL,
  `ttl` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES ('13', 'Ijah', 'Point', '2016', 'P', 'Blimbing');
INSERT INTO `player` VALUES ('14', 'Ngatemi', 'Small', '2016', 'P', 'Mojokerto , 15 des 1997');
INSERT INTO `player` VALUES ('15', 'Ngatemi', 'Small', '2016', 'P', 'Mojokerto , 15 des 1997');
INSERT INTO `player` VALUES ('16', 'Ngatemi', 'Small', '2016', 'P', 'Mojokerto , 15 des 1997');
INSERT INTO `player` VALUES ('17', 'Aisyah', 'ShootingGuard', '2016', 'P', 'Khayangan');
INSERT INTO `player` VALUES ('18', 'Naruto', 'Power Forward', '2017', 'L', 'Konoha, 17 Augustus 1998');
INSERT INTO `player` VALUES ('19', 'Siti fatimah', 'Point Guard', '2018', 'P', 'malang, 1 Januari 2000');

-- ----------------------------
-- Table structure for riwayat_latihan
-- ----------------------------
DROP TABLE IF EXISTS `riwayat_latihan`;
CREATE TABLE `riwayat_latihan` (
  `id_riwayat` int(11) NOT NULL AUTO_INCREMENT,
  `id_sesi` int(11) NOT NULL,
  `id_player` int(11) NOT NULL,
  `keterangan` varchar(5) NOT NULL,
  `id_kehadiran` int(11) NOT NULL,
  PRIMARY KEY (`id_riwayat`),
  KEY `fk_id` (`id_sesi`),
  KEY `fk_player` (`id_player`),
  KEY `fk_kehadiran` (`id_kehadiran`),
  CONSTRAINT `fk_id` FOREIGN KEY (`id_sesi`) REFERENCES `sesilatihan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_kehadiran` FOREIGN KEY (`id_kehadiran`) REFERENCES `kehadiran` (`id_kehadiran`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_player` FOREIGN KEY (`id_player`) REFERENCES `player` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of riwayat_latihan
-- ----------------------------
INSERT INTO `riwayat_latihan` VALUES ('3', '1', '13', 'sakit', '1');
INSERT INTO `riwayat_latihan` VALUES ('4', '1', '13', 'sakit', '1');
INSERT INTO `riwayat_latihan` VALUES ('5', '1', '13', 'sakit', '1');
INSERT INTO `riwayat_latihan` VALUES ('6', '1', '13', 'sakit', '1');
INSERT INTO `riwayat_latihan` VALUES ('10', '27', '13', 'Sakit', '1');
INSERT INTO `riwayat_latihan` VALUES ('11', '27', '13', 'Sakit', '1');
INSERT INTO `riwayat_latihan` VALUES ('12', '27', '13', 'Sakit', '1');
INSERT INTO `riwayat_latihan` VALUES ('13', '27', '13', 'Sakit', '1');
INSERT INTO `riwayat_latihan` VALUES ('14', '28', '13', 'Sakit', '1');
INSERT INTO `riwayat_latihan` VALUES ('15', '28', '13', 'Sakit', '1');
INSERT INTO `riwayat_latihan` VALUES ('16', '29', '13', 'Sakit', '1');
INSERT INTO `riwayat_latihan` VALUES ('17', '29', '13', 'Sakit', '1');
INSERT INTO `riwayat_latihan` VALUES ('26', '32', '13', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('27', '32', '14', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('28', '32', '15', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('29', '32', '16', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('30', '32', '17', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('31', '32', '18', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('32', '32', '19', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('36', '36', '13', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('37', '36', '14', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('38', '36', '15', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('39', '36', '16', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('40', '36', '17', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('41', '36', '18', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('42', '36', '19', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('43', '37', '13', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('44', '37', '14', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('45', '37', '15', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('46', '37', '16', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('47', '37', '17', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('48', '37', '18', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('49', '37', '19', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('50', '38', '13', 's', '2');
INSERT INTO `riwayat_latihan` VALUES ('51', '38', '14', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('52', '38', '15', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('53', '38', '16', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('54', '38', '17', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('55', '38', '18', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('56', '38', '19', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('57', '39', '13', 'a', '2');
INSERT INTO `riwayat_latihan` VALUES ('58', '39', '14', 'i', '2');
INSERT INTO `riwayat_latihan` VALUES ('59', '39', '15', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('60', '39', '16', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('61', '39', '17', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('62', '39', '18', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('63', '39', '19', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('64', '40', '13', 'A', '2');
INSERT INTO `riwayat_latihan` VALUES ('65', '40', '14', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('66', '40', '15', 'i', '2');
INSERT INTO `riwayat_latihan` VALUES ('67', '40', '16', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('68', '40', '17', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('69', '40', '18', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('70', '40', '19', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('71', '41', '13', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('72', '41', '14', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('73', '41', '15', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('74', '41', '16', 'serib', '1');
INSERT INTO `riwayat_latihan` VALUES ('75', '41', '17', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('76', '41', '18', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('77', '41', '19', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('78', '41', '13', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('79', '41', '14', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('80', '41', '15', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('81', '41', '16', 'serib', '1');
INSERT INTO `riwayat_latihan` VALUES ('82', '41', '17', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('83', '41', '18', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('84', '41', '19', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('85', '41', '13', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('86', '41', '14', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('87', '41', '15', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('88', '41', '16', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('89', '41', '17', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('90', '41', '18', '', '1');
INSERT INTO `riwayat_latihan` VALUES ('91', '41', '19', '', '1');

-- ----------------------------
-- Table structure for sesilatihan
-- ----------------------------
DROP TABLE IF EXISTS `sesilatihan`;
CREATE TABLE `sesilatihan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hari` varchar(50) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `jam` time(6) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sesilatihan
-- ----------------------------
INSERT INTO `sesilatihan` VALUES ('1', 'senin', '2019-01-07', '17:28:00.000000', null);
INSERT INTO `sesilatihan` VALUES ('2', 'Friday', '2019-01-11', '19:28:08.000000', null);
INSERT INTO `sesilatihan` VALUES ('3', 'Friday', '2019-01-11', '19:30:03.000000', null);
INSERT INTO `sesilatihan` VALUES ('4', 'Friday', '2019-01-11', '19:30:05.000000', null);
INSERT INTO `sesilatihan` VALUES ('5', 'Friday', '2019-01-11', '19:31:56.000000', null);
INSERT INTO `sesilatihan` VALUES ('6', 'Friday', '2019-01-11', '19:32:50.000000', 'Tester');
INSERT INTO `sesilatihan` VALUES ('7', 'Friday', '2019-01-11', '19:38:20.000000', null);
INSERT INTO `sesilatihan` VALUES ('8', 'Friday', '2019-01-11', '19:38:20.000000', null);
INSERT INTO `sesilatihan` VALUES ('9', 'Friday', '2019-01-11', '19:38:53.000000', null);
INSERT INTO `sesilatihan` VALUES ('10', 'Friday', '2019-01-11', '19:39:12.000000', null);
INSERT INTO `sesilatihan` VALUES ('11', 'Friday', '2019-01-11', '19:40:32.000000', null);
INSERT INTO `sesilatihan` VALUES ('12', 'Friday', '2019-01-11', '19:41:15.000000', null);
INSERT INTO `sesilatihan` VALUES ('13', 'Friday', '2019-01-11', '19:41:38.000000', null);
INSERT INTO `sesilatihan` VALUES ('24', 'Monday', '2019-01-14', '09:15:51.000000', null);
INSERT INTO `sesilatihan` VALUES ('25', 'Monday', '2019-01-14', '09:16:48.000000', null);
INSERT INTO `sesilatihan` VALUES ('26', 'Monday', '2019-01-14', '09:16:49.000000', null);
INSERT INTO `sesilatihan` VALUES ('27', 'Monday', '2019-01-14', '09:17:23.000000', null);
INSERT INTO `sesilatihan` VALUES ('28', 'Monday', '2019-01-14', '09:18:17.000000', null);
INSERT INTO `sesilatihan` VALUES ('29', 'Monday', '2019-01-14', '09:19:37.000000', null);
INSERT INTO `sesilatihan` VALUES ('30', 'Monday', '2019-01-14', '09:51:33.000000', null);
INSERT INTO `sesilatihan` VALUES ('31', 'Monday', '2019-01-14', '09:52:44.000000', null);
INSERT INTO `sesilatihan` VALUES ('32', 'Monday', '2019-01-14', '09:53:13.000000', null);
INSERT INTO `sesilatihan` VALUES ('33', 'Monday', '2019-01-14', '10:00:27.000000', null);
INSERT INTO `sesilatihan` VALUES ('34', 'Monday', '2019-01-14', '10:03:38.000000', null);
INSERT INTO `sesilatihan` VALUES ('35', 'Monday', '2019-01-14', '10:04:13.000000', null);
INSERT INTO `sesilatihan` VALUES ('36', 'Monday', '2019-01-14', '10:04:52.000000', null);
INSERT INTO `sesilatihan` VALUES ('37', 'Monday', '2019-01-14', '10:05:43.000000', null);
INSERT INTO `sesilatihan` VALUES ('38', 'Monday', '2019-01-14', '10:13:35.000000', null);
INSERT INTO `sesilatihan` VALUES ('39', 'Monday', '2019-01-14', '10:18:14.000000', null);
INSERT INTO `sesilatihan` VALUES ('40', 'Monday', '2019-01-14', '15:11:08.000000', null);
INSERT INTO `sesilatihan` VALUES ('41', 'Monday', '2019-01-14', '16:32:36.000000', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'adminjuned', '1');
