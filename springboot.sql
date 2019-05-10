/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2019-05-10 13:07:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_meun
-- ----------------------------
DROP TABLE IF EXISTS `sys_meun`;
CREATE TABLE `sys_meun` (
  `meun_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父级_id',
  `url` varchar(255) NOT NULL COMMENT '菜单地址',
  `type` varchar(255) DEFAULT NULL COMMENT '类型 0：目录；1：菜单',
  `meun_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `meun_status` varchar(255) DEFAULT '1' COMMENT '菜单状态(1：启用;2:禁用)',
  PRIMARY KEY (`meun_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_meun
-- ----------------------------
INSERT INTO `sys_meun` VALUES ('1', null, 'sys/meun/cost', null, '成本管理', '1');
INSERT INTO `sys_meun` VALUES ('2', null, 'sys/meun/project', null, '项目管理', '1');
INSERT INTO `sys_meun` VALUES ('3', null, 'sys/meun/review', null, '审核管理', '1');
INSERT INTO `sys_meun` VALUES ('4', null, 'sys/meun/comprehensive', null, '综合管理', '1');
INSERT INTO `sys_meun` VALUES ('5', '1', 'sys/meun/cost/cost', null, '成本预算', '1');
INSERT INTO `sys_meun` VALUES ('6', '2', 'sys/meun/project/project', null, '项目监护', '1');
INSERT INTO `sys_meun` VALUES ('7', '2', 'sys/meun/project/customer', null, '产品线', '1');
INSERT INTO `sys_meun` VALUES ('8', '2', 'sys/meun/project/reimburse', null, '报销监护', '1');
INSERT INTO `sys_meun` VALUES ('9', '3', 'sys/meun/comprehensive/require', null, '需求维护', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id：唯一标识',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `e_mail` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) NOT NULL COMMENT '手机号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `id_card` varchar(255) DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', null, '123', 'admin', null);
