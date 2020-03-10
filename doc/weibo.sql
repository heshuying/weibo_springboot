/*
Navicat MySQL Data Transfer

Source Server         : study_local
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : weibo

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-12-23 23:23:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_id_follower` int(11) DEFAULT NULL COMMENT '被关注用户id',
  `follow_time` datetime DEFAULT NULL COMMENT '关注时间',
  `remark_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='关注表'


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `portrait_url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像地址',
  `phone_num` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号码',
  `sex` tinyint(1) DEFAULT '0' COMMENT '性别：0 男，1 女',
  `true_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '真实姓名',
  `idcard` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号码',
  `birthday` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '出生日期',
  `regist_time` datetime DEFAULT NULL COMMENT '注册时间',
  `login_times` int(11) DEFAULT '0' COMMENT '登录次数',
  `last_login` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上次登录时间',
  `mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `account_status` tinyint(1) DEFAULT '0' COMMENT '账号状态：0 正常 1 禁用',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '个人介绍',
  `follow_count` int(11) DEFAULT '0' COMMENT '关注人数',
  `follower_count` int(11) DEFAULT '0' COMMENT '关注自己的人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='微博注册用户表'


-- ----------------------------
-- Table structure for weibo
-- ----------------------------
DROP TABLE IF EXISTS `weibo`;
CREATE TABLE `weibo` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '关联user表id',
  `content` varchar(500) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '微博文字内容',
  `publish_time` int(10) DEFAULT NULL COMMENT '发布时间',
  `comment_count` int(11) DEFAULT '0' COMMENT '评论次数',
  `like_count` int(11) DEFAULT '0' COMMENT '点赞次数',
  `share_count` int(11) DEFAULT '0' COMMENT '转发次数',
  `read_count` int(11) DEFAULT '0' COMMENT '阅读次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='微博主表';

-- ----------------------------
-- Table structure for weibo_comment
-- ----------------------------
DROP TABLE IF EXISTS `weibo_comment`;
CREATE TABLE `weibo_comment` (
  `id` int(11) NOT NULL,
  `weibo_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '评论人id',
  `content` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评论内容',
  `comment_time` int(10) DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='微博评论表';

-- ----------------------------
-- Table structure for weibo_like
-- ----------------------------
DROP TABLE IF EXISTS `weibo_like`;
CREATE TABLE `weibo_like` (
  `id` int(11) NOT NULL,
  `weibo_id` int(11) NOT NULL COMMENT '微博表id',
  `user_id` int(11) NOT NULL COMMENT '点赞的用户id',
  `like_time` int(10) DEFAULT NULL COMMENT '点赞时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='微博点赞表';
