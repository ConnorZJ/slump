/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.18-log : Database - slump
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`slump` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `slump`;

/*Table structure for table `bbs_class` */

DROP TABLE IF EXISTS `bbs_class`;

CREATE TABLE `bbs_class` (
  `id` varchar(32) NOT NULL,
  `name` varchar(64) NOT NULL,
  `intro` varchar(500) DEFAULT NULL,
  `rule` varchar(4000) DEFAULT NULL,
  `topic_count` int(11) DEFAULT '0',
  `reply_count` int(11) DEFAULT '0',
  `last_topic_id` varchar(32) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `img_url` varchar(500) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `create_by` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bbs_class` */

insert  into `bbs_class`(`id`,`name`,`intro`,`rule`,`topic_count`,`reply_count`,`last_topic_id`,`url`,`img_url`,`enabled`,`create_time`,`create_by`) values 
('1','综合讨论','java学习者交流',NULL,9,0,NULL,'','/static/clazz/java.jpg','','2019-03-10 19:31:18','god'),
('2','技术分享','java源码或踩坑分享',NULL,1,0,NULL,NULL,'/static/clazz/java.jpg','','2019-03-10 19:32:11','god'),
('3','资源分享','java相关学习资料分享',NULL,0,0,NULL,NULL,'/static/clazz/java.jpg','','2019-03-10 19:33:00','god');

/*Table structure for table `bbs_reply` */

DROP TABLE IF EXISTS `bbs_reply`;

CREATE TABLE `bbs_reply` (
  `id` varchar(32) NOT NULL,
  `topic_id` varchar(32) NOT NULL,
  `body` varchar(800) NOT NULL,
  `username` varchar(32) NOT NULL,
  `last_modified` datetime NOT NULL,
  `create_time` datetime NOT NULL,
  `rank` tinyint(4) NOT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `hava_reply` bit(1) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bbs_reply` */

insert  into `bbs_reply`(`id`,`topic_id`,`body`,`username`,`last_modified`,`create_time`,`rank`,`is_delete`,`hava_reply`,`parent_id`) values 
('06265c8c85e741428a28ad814e77b3fa','aa8079fdf18f4c38bea8394f82f2231c','test3','zhangsan','2019-04-14 17:02:16','2019-04-14 17:02:16',1,'\0',NULL,NULL),
('1','1','123','dog','2019-04-10 18:04:58','2019-04-10 18:04:58',1,'',NULL,NULL),
('121','1','我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行固定宽度的文字自动换行并垂直剧中固定宽度的文字自动换行并垂直剧中我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行固定宽度的文字自动换行并垂直剧中固定宽度的文字自动换行并垂直剧中我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行固定宽度的文字自动换行并垂直剧中固定宽度的文字自动换行并垂直剧中我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行固定宽度的文字自动换行并垂直剧中固定宽度的文字自动换行并垂直剧中我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行固定宽度的文字自动换行并垂直剧中固定宽度的文字自动换行并垂直剧中我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行我是文字随便几行固定宽度的文字自动换行并垂直剧中固定宽度的文字自动换行并垂直剧中','god','2019-03-13 21:36:59','2019-03-13 21:36:59',2,'',NULL,NULL),
('123','1','123123','god3','2019-03-05 19:29:06','2019-03-12 19:29:13',3,'\0',NULL,NULL),
('172522e2f9ec499c92d928bfbf299619','3','123','god4','2019-04-13 20:04:52','2019-04-13 20:04:52',1,'\0',NULL,NULL),
('2','1','123','dog','2019-04-10 18:27:29','2019-04-10 18:27:29',4,'\0',NULL,NULL),
('21efd74201a6485491646c14e7cb2c9d','402ae1a4a8f844c19ad30638096c87b0','testtest','zhangsan','2019-04-14 17:03:55','2019-04-14 17:03:55',1,'\0',NULL,NULL),
('378eddbb43bc4cb3b07624c67e62477d','a908fcad8ec34872a59ab4c17209fd7f','这是一条新的回复内容','zhangsan','2019-05-04 20:40:23','2019-05-04 20:40:23',2,'\0',NULL,NULL),
('3dd4b7fa2e904bd7975f3315ace74241','1','321123','zhangsan','2019-04-13 20:01:15','2019-04-13 20:01:15',11,'\0',NULL,NULL),
('4','1','456','god4','2019-03-06 19:33:17','2019-03-06 19:33:20',5,'\0',NULL,NULL),
('45','1','123','dog','2019-04-10 18:43:43','2019-04-10 18:43:43',6,'\0',NULL,NULL),
('55','1','123','dog','2019-04-10 18:44:05','2019-04-10 18:44:05',7,'\0',NULL,NULL),
('61367092fe9a4b81b019b5b7fd6c09d6','1','321','zhangsan','2019-04-13 20:04:24','2019-04-13 20:04:24',13,'\0',NULL,NULL),
('731f65eb8d8945cc841603648ec33d73','1','123132','zhangsan','2019-04-13 22:40:34','2019-04-13 22:40:34',15,'',NULL,NULL),
('7f9368be9a394dffa72407ad31dcd5ba','1','321','zhangsan','2019-04-10 22:20:06','2019-04-10 22:20:06',8,'\0',NULL,NULL),
('81d33656d287434cab305406fc38cf5a','1','123','zhangsan','2019-04-13 22:38:30','2019-04-13 22:38:30',14,'',NULL,NULL),
('855e1c1155604c82a91f16ed2fda7e8a','208d1682132e4e70866b29b97fcae152','test1','zhangsan','2019-04-14 16:54:51','2019-04-14 16:54:51',1,'\0',NULL,NULL),
('8ad8609fc784497f801d44e523c1c51d','1','456','zhangsan','2019-04-10 22:20:31','2019-04-10 22:20:31',9,'\0',NULL,NULL),
('a201453c7ea44a0da43dc42b9bbb3e97','ff7e4ef703a6487bb1935bc6c3dac96a','测试1 ','zhangsan','2019-04-16 14:28:09','2019-04-16 14:28:09',1,'\0',NULL,NULL),
('ae6b564f564a4abcb92beb2dbddc5cc7','a908fcad8ec34872a59ab4c17209fd7f','新的内容','zhangsan','2019-05-04 20:37:30','2019-05-04 20:37:30',1,'\0',NULL,NULL),
('b9445ab64abb4aa786383bcaaa10156f','efc58e8af3f54d1b8d83659a9e28d4c0','test2','zhangsan','2019-04-14 17:00:47','2019-04-14 17:00:47',1,'\0',NULL,NULL),
('c9e2065cf55944ba8de24a75510e2635','647516ad4c65410f9d761bb52c43cd86','New Body','zhangsan','2019-05-04 20:36:41','2019-05-04 20:36:41',1,'\0',NULL,NULL),
('d2ae8bbd615b411ab4715fd2390dae72','1','123213','zhangsan','2019-04-13 20:01:35','2019-04-13 20:01:35',12,'\0',NULL,NULL),
('eb234ebda4fd49c797e06d7dc3fdb8ea','1','112233','zhangsan','2019-04-13 20:01:02','2019-04-13 20:01:02',10,'\0',NULL,NULL);

/*Table structure for table `bbs_topic` */

DROP TABLE IF EXISTS `bbs_topic`;

CREATE TABLE `bbs_topic` (
  `id` varchar(32) NOT NULL,
  `class_id` varchar(32) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `body` varchar(800) DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `reply_by` varchar(32) DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL,
  `hits` int(11) DEFAULT NULL,
  `reply_count` int(11) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `img_url` varchar(500) DEFAULT NULL,
  `is_close` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bbs_topic` */

insert  into `bbs_topic`(`id`,`class_id`,`title`,`body`,`create_by`,`create_time`,`reply_by`,`reply_time`,`hits`,`reply_count`,`enabled`,`img_url`,`is_close`) values 
('1','1','111','1111','god','2019-03-13 21:36:59','god1','2019-03-13 21:37:14',11,15,'',NULL,'\0'),
('2','2','222','2222','god','2019-03-12 21:37:53','god2','2019-03-12 21:38:00',22,0,'',NULL,'\0'),
('208d1682132e4e70866b29b97fcae152','1','test1','test1','zhangsan','2019-04-14 16:54:51','zhangsan','2019-04-14 16:54:51',0,1,'',NULL,'\0'),
('3','1','333','3333','god','2019-03-14 16:28:28','god1','2019-03-14 16:28:33',33,1,'',NULL,'\0'),
('402ae1a4a8f844c19ad30638096c87b0','1','testtest','testtest','zhangsan','2019-04-14 17:03:55','zhangsan','2019-04-14 17:03:55',0,1,'',NULL,'\0'),
('647516ad4c65410f9d761bb52c43cd86','1','New Post','New Body','zhangsan','2019-05-04 20:36:41','zhangsan','2019-05-04 20:36:41',0,1,'',NULL,'\0'),
('a908fcad8ec34872a59ab4c17209fd7f','1','这是一个新的标题','新的内容','zhangsan','2019-05-04 20:37:30','zhangsan','2019-05-04 20:37:30',0,2,'',NULL,'\0'),
('aa8079fdf18f4c38bea8394f82f2231c','1','test3','test3','zhangsan','2019-04-14 17:02:16','zhangsan','2019-04-14 17:02:16',0,1,'',NULL,'\0'),
('efc58e8af3f54d1b8d83659a9e28d4c0','1','test2','test2','zhangsan','2019-04-14 17:00:47','zhangsan','2019-04-14 17:00:47',0,1,'',NULL,'\0'),
('ff7e4ef703a6487bb1935bc6c3dac96a','1','测试1','测试1 ','zhangsan','2019-04-16 14:28:09','zhangsan','2019-04-16 14:28:09',0,1,'',NULL,'\0');

/*Table structure for table `bbs_user` */

DROP TABLE IF EXISTS `bbs_user`;

CREATE TABLE `bbs_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(64) NOT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  `password` varchar(1000) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `head_url` varchar(100) DEFAULT NULL,
  `introduction` varchar(800) DEFAULT NULL,
  `signature` varchar(800) DEFAULT NULL,
  `topic_count` int(11) DEFAULT '0',
  `reply_count` int(11) DEFAULT '0',
  `best_topic_count` int(11) DEFAULT '0',
  `create_time` datetime NOT NULL,
  `is_mnger` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bbs_user` */

insert  into `bbs_user`(`id`,`username`,`nickname`,`password`,`email`,`head_url`,`introduction`,`signature`,`topic_count`,`reply_count`,`best_topic_count`,`create_time`,`is_mnger`) values 
('1','zhangsan','张三','123123','abc@123.com',NULL,'自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍自我介绍','王五',0,0,0,'2019-04-10 16:12:43','\0'),
('2','god','god','123123','god@123.com',NULL,'godgodgod','god',0,0,0,'2019-04-10 16:12:36','\0'),
('3','god3','god3','123123','god3@qq.com',NULL,'god3god3god3','god3',0,0,0,'2019-04-10 16:13:08','\0'),
('4','god4','god4','123123','god4@qq.com',NULL,'god4god4god4','god4',0,0,0,'2019-04-10 16:13:40','\0'),
('d0faffe3306a4a00b24721aa6bbc6dea','admin',NULL,'admin123','admin@qq.com',NULL,'admin',NULL,0,0,0,'2019-04-16 15:52:20','');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `test` */

insert  into `test`(`id`,`name`) values 
(1,'张三');

/* Trigger structure for table `bbs_reply` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `reply_comment` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `reply_comment` BEFORE INSERT ON `bbs_reply` FOR EACH ROW BEGIN
	DECLARE cou INT(10);
	update `slump`.`bbs_topic` set reply_count = reply_count+1 where id = new.topic_id;
	select count(*) into cou from `slump`.`bbs_reply` where topic_id = new.topic_id;
	set new.rank = cou+1 ;
    END */$$


DELIMITER ;

/* Trigger structure for table `bbs_topic` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `topic_post` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `topic_post` BEFORE INSERT ON `bbs_topic` FOR EACH ROW BEGIN
	UPDATE `slump`.`bbs_class` SET topic_count = topic_count+1 WHERE id = new.class_id;
    END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
