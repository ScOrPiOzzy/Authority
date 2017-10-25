-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cas_authority
-- ------------------------------------------------------
-- Server version	5.6.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `date_create` datetime NOT NULL COMMENT '本条记录的创建时间',
  `date_supply` datetime NOT NULL COMMENT '供货时间（作为授权证书中的内容）',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '交易类型("0:押标","1:供货")',
  `price` float NOT NULL COMMENT '订单金额(单位：万元)',
  `sid` int(11) NOT NULL COMMENT '销售人员编号',
  `cid` int(11) NOT NULL COMMENT '客户编号',
  `pid` int(11) NOT NULL COMMENT '产品编号（作为授权证书中的内容）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `cidd_idx` (`cid`),
  KEY `pidd_idx` (`pid`),
  KEY `销售人员_idx` (`sid`),
  CONSTRAINT `引用产品ID` FOREIGN KEY (`pid`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `引用客户ID` FOREIGN KEY (`cid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='产品销售记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (2,'2017-10-10 00:00:00','2017-10-15 00:00:00',0,15,1,6,1),(4,'2017-10-17 18:21:00','2017-10-17 00:00:00',1,1.5,1,6,1),(5,'2017-10-18 13:23:50','2017-10-11 00:00:00',1,1.5,1,6,1),(6,'2017-10-18 13:25:12','2017-10-19 00:00:00',0,1.6,1,6,1),(7,'2017-10-18 13:37:59','2017-10-11 00:00:00',1,1.5,1,6,1),(8,'2017-10-18 13:38:46','2017-10-27 00:00:00',1,1.5,1,6,1),(9,'2017-10-18 13:44:30','2017-10-11 00:00:00',1,1.5,1,6,1),(10,'2017-10-18 13:45:02','2017-10-05 00:00:00',1,1.5,1,6,1),(11,'2017-10-18 13:45:55','2017-10-10 00:00:00',10,111,1,6,1),(12,'2017-10-18 13:51:04','2017-10-06 00:00:00',1,1.5,1,6,1),(13,'2017-10-18 13:51:33','2017-10-28 00:00:00',1,1.5,1,6,1),(14,'2017-10-18 14:02:55','2017-10-01 00:00:00',1,1.5,1,6,1),(15,'2017-10-18 14:03:49','2017-10-19 00:00:00',1,1.5,1,6,1),(16,'2017-10-18 14:05:09','2017-10-17 00:00:00',1,1.5,1,6,1),(17,'2017-10-18 14:09:49','2017-10-28 00:00:00',1,1.5,1,6,1),(18,'2017-10-18 14:12:14','2017-10-16 00:00:00',1,1.5,1,6,1),(19,'2017-10-18 14:14:18','2017-10-25 00:00:00',1,1.5,1,6,1),(20,'2017-10-18 14:17:25','2017-10-05 00:00:00',1,1.5,1,6,1),(21,'2017-10-18 14:22:29','2017-10-17 00:00:00',1,1.5,1,6,1),(23,'2017-10-18 14:27:19','2017-10-20 00:00:00',1,1.5,1,6,1),(24,'2017-10-18 14:27:48','2017-10-19 00:00:00',1,1.56667,1,6,1),(25,'2017-10-18 14:30:55','2017-10-01 00:00:00',0,1.51111,1,6,1),(26,'2017-10-19 16:07:17','2017-10-19 00:00:00',1,15,1,5,1),(27,'2017-10-19 16:08:10','2017-10-19 00:00:00',0,15,1,5,1),(28,'2017-10-20 19:09:20','2017-10-27 00:00:00',1,13,1,7,5);
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-20 19:19:51