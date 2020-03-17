/*
SQLyog v10.2
MySQL - 8.0.17 : Database - weibo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`weibo` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

/*Table structure for table `follow` */

CREATE TABLE `follow` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_id_follow` int(11) DEFAULT NULL COMMENT '被关注用户id',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态：0 关注 1 已取消',
  `follow_time` datetime DEFAULT NULL COMMENT '关注时间',
  `remark_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='关注表';

/*Data for the table `follow` */

insert  into `follow`(`id`,`user_id`,`user_id_follow`,`status`,`follow_time`,`remark_name`) values (1,1,2,0,'2020-03-10 17:20:56',NULL);
insert  into `follow`(`id`,`user_id`,`user_id_follow`,`status`,`follow_time`,`remark_name`) values (2,1,3,0,'2020-03-10 17:21:00',NULL);
insert  into `follow`(`id`,`user_id`,`user_id_follow`,`status`,`follow_time`,`remark_name`) values (3,1,4,0,'2020-03-14 09:50:38',NULL);

/*Table structure for table `user` */

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `portrait_url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像地址',
  `phone_num` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号码',
  `sex` tinyint(1) DEFAULT '0' COMMENT '性别：0 男，1 女',
  `true_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '真实姓名',
  `idcard` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号码',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `regist_time` datetime DEFAULT NULL COMMENT '注册时间',
  `login_times` int(11) DEFAULT '0' COMMENT '登录次数',
  `last_login` datetime DEFAULT NULL COMMENT '上次登录时间',
  `mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `account_status` tinyint(1) DEFAULT '0' COMMENT '账号状态：0 正常 1 禁用',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '个人介绍',
  `follow_count` int(11) DEFAULT '0' COMMENT '关注人数',
  `fans_count` int(11) DEFAULT '0' COMMENT '粉丝人数',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='微博注册用户表';

/*Data for the table `user` */

insert  into `user`(`id`,`user_name`,`password`,`portrait_url`,`phone_num`,`sex`,`true_name`,`idcard`,`birthday`,`regist_time`,`login_times`,`last_login`,`mail`,`account_status`,`introduction`,`follow_count`,`fans_count`,`update_time`) values (1,'eyesfree','eyesfree',NULL,'15610026960',0,'何树营','370222198804031210','2020-03-08 17:17:50','2020-03-12 17:30:24',0,'2020-03-08 17:17:50','eyesfree@yeah.net',0,'',3,0,NULL);
insert  into `user`(`id`,`user_name`,`password`,`portrait_url`,`phone_num`,`sex`,`true_name`,`idcard`,`birthday`,`regist_time`,`login_times`,`last_login`,`mail`,`account_status`,`introduction`,`follow_count`,`fans_count`,`update_time`) values (2,'laowang','laowang',NULL,NULL,0,'老王',NULL,NULL,'2020-03-14 17:30:29',0,NULL,NULL,0,'',0,1,NULL);
insert  into `user`(`id`,`user_name`,`password`,`portrait_url`,`phone_num`,`sex`,`true_name`,`idcard`,`birthday`,`regist_time`,`login_times`,`last_login`,`mail`,`account_status`,`introduction`,`follow_count`,`fans_count`,`update_time`) values (3,'laozhang','laozhang',NULL,NULL,0,'老张',NULL,NULL,'2020-03-14 17:30:32',0,NULL,NULL,0,'',0,1,NULL);
insert  into `user`(`id`,`user_name`,`password`,`portrait_url`,`phone_num`,`sex`,`true_name`,`idcard`,`birthday`,`regist_time`,`login_times`,`last_login`,`mail`,`account_status`,`introduction`,`follow_count`,`fans_count`,`update_time`) values (4,'laoli','laoli',NULL,NULL,0,'老李',NULL,NULL,'2020-03-12 17:30:34',0,NULL,NULL,0,'',0,1,NULL);

/*Table structure for table `weibo` */

CREATE TABLE `weibo` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '关联user表id',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '微博文字内容',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `comment_count` int(11) DEFAULT '0' COMMENT '评论次数',
  `like_count` int(11) DEFAULT '0' COMMENT '点赞次数',
  `share_count` int(11) DEFAULT '0' COMMENT '转发次数',
  `read_count` int(11) DEFAULT '0' COMMENT '阅读次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='微博主表';

/*Data for the table `weibo` */

insert  into `weibo`(`id`,`user_id`,`content`,`publish_time`,`update_time`,`comment_count`,`like_count`,`share_count`,`read_count`) values (1,1,'发表了第一条微博','2020-03-16 09:41:52','2020-03-17 07:40:58',3,1,0,0);

/*Table structure for table `weibo_comment` */

CREATE TABLE `weibo_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weibo_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '评论人id',
  `content` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评论内容',
  `comment_time` timestamp NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='微博评论表';

/*Data for the table `weibo_comment` */

insert  into `weibo_comment`(`id`,`weibo_id`,`user_id`,`content`,`comment_time`) values (6,1,2,'太精彩了！','2020-03-17 07:25:48');
insert  into `weibo_comment`(`id`,`weibo_id`,`user_id`,`content`,`comment_time`) values (7,1,2,'太精彩了！','2020-03-17 07:39:44');
insert  into `weibo_comment`(`id`,`weibo_id`,`user_id`,`content`,`comment_time`) values (8,1,2,'太精彩了！','2020-03-17 07:40:58');

/*Table structure for table `weibo_like` */

CREATE TABLE `weibo_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weibo_id` int(11) NOT NULL COMMENT '微博表id',
  `user_id` int(11) NOT NULL COMMENT '点赞的用户id',
  `like_time` timestamp NULL DEFAULT NULL COMMENT '点赞时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='微博点赞表';

/*Data for the table `weibo_like` */

insert  into `weibo_like`(`id`,`weibo_id`,`user_id`,`like_time`) values (1,1,2,'2020-03-17 06:01:45');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
