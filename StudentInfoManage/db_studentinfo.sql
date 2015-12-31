/*
Navicat MySQL Data Transfer

Source Server         : locahost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : db_studentinfo

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-04-20 01:19:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_grade
-- ----------------------------
DROP TABLE IF EXISTS `t_grade`;
CREATE TABLE `t_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gradeName` varchar(20) DEFAULT NULL,
  `gradeDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grade
-- ----------------------------
INSERT INTO `t_grade` VALUES ('1', '12网工', '12级网络工程');
INSERT INTO `t_grade` VALUES ('2', '13计科', '13级计算机科学与技术');
INSERT INTO `t_grade` VALUES ('3', '13计科', '12级计算机科学与技术');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `stuId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNo` varchar(20) DEFAULT NULL,
  `stuName` varchar(10) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gradeId` int(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `stuDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`stuId`),
  KEY `FK_t_student` (`gradeId`),
  CONSTRAINT `FK_t_student` FOREIGN KEY (`gradeId`) REFERENCES `t_grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2', '20124042001', '张一', '男', '1994-06-08', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('3', '20124042002', '张二', '男', '1994-02-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('4', '20124042003', '张三', '男', '1994-03-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('9', '20124042004', '张四', '男', '1994-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('10', '20124042005', '张五', '男', '1994-09-05', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('11', '20124042006', '张六', '男', '1994-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('12', '20124042007', '张七', '男', '1994-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('13', '20124042008', '张八', '男', '1994-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('14', '20124042009', '张九', '男', '1994-06-07', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('16', '20124042010', '张十', '男', '1994-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('17', '20124042011', '刘斌', '男', '1994-11-03', '1', '31321@qq.com', 'Good');
INSERT INTO `t_student` VALUES ('18', '20124042012', '王小美', '女', '1995-11-03', '1', '3112121@qq.com', 'Good Girls');
INSERT INTO `t_student` VALUES ('19', '20134045012', '王二', '男', '1995-11-03', '2', '3112121@qq.com', 'Good Girls');
INSERT INTO `t_student` VALUES ('20', '20124042004', '王小晓', '女', '1995-11-03', '1', '3112121@qq.com', 'Good Girls');
INSERT INTO `t_student` VALUES ('21', '20134045009', '王飞', '女', '1995-11-03', '2', '3112121@qq.com', 'Good Girls');
INSERT INTO `t_student` VALUES ('27', '20124042007', '张三', '男', '2013-05-14', '1', '321@11.com', 'Good');
INSERT INTO `t_student` VALUES ('28', '20124042009', '曹小小', '女', '2013-05-30', '1', '111321@11.com', '312111\r\n112232');
INSERT INTO `t_student` VALUES ('34', '20134045009', '王靶档', '女', '2013-05-01', '2', 'wanba@12222.com', 'Good Girls');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'java1234', '123456');
INSERT INTO `t_user` VALUES ('2', 'yew1eb', '123456');
