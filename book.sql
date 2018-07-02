/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-07-02 21:42:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book_info`
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `book_num` varchar(50) NOT NULL DEFAULT '',
  `book_name` varchar(50) NOT NULL,
  `book_writer` varchar(50) NOT NULL,
  `publish_house` varchar(50) NOT NULL,
  `publish_time` varchar(50) NOT NULL,
  `book_sum` varchar(50) NOT NULL,
  PRIMARY KEY (`book_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES ('20180001', '清算', '何柔宛', '华东师范大学出版社', '2018年2月', '3');
INSERT INTO `book_info` VALUES ('20180002', '天才在左疯子在右', '高铭', '武汉大学出版社', '2010年2月', '6');
INSERT INTO `book_info` VALUES ('20180003', '欧 亨利短篇小说选', '欧 亨利', '译林出版社', '2010年12月', '5');
INSERT INTO `book_info` VALUES ('20180004', '数学建模-第四版', '姜启源、谢金星', '高等教育出版社', '2012年12月', '3');
INSERT INTO `book_info` VALUES ('20180005', '数据库系统概论', '王珊、萨师煊', '高等教育出版社', '2017年3月', '3');
INSERT INTO `book_info` VALUES ('20180006', '45', '45', '45', '54', '45');
