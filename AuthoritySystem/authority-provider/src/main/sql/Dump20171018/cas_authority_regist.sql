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
-- Table structure for table `regist`
--

DROP TABLE IF EXISTS `regist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL COMMENT '注册码',
  `node` int(5) NOT NULL COMMENT '节点数',
  `ser_hdd` varchar(45) DEFAULT NULL COMMENT '硬盘序列号',
  `ser_cpu` varchar(45) DEFAULT NULL COMMENT '处理器序列号',
  `date_start` varchar(45) DEFAULT NULL COMMENT '有效期起始日期',
  `date_end` varchar(45) DEFAULT NULL COMMENT '过期日期',
  `record_id` int(11) NOT NULL,
  `used` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `record_regist_idx` (`id`,`record_id`),
  KEY `regist_record_idx` (`record_id`),
  CONSTRAINT `regist_record` FOREIGN KEY (`record_id`) REFERENCES `record` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regist`
--

LOCK TABLES `regist` WRITE;
/*!40000 ALTER TABLE `regist` DISABLE KEYS */;
INSERT INTO `regist` VALUES (1,'1',2,NULL,'1','2016-10-10 00:00:00','2017-10-10 00:00:00',2,1),(4,'2',2,NULL,NULL,'2016-10-10 00:00:00','2017-10-10 00:00:00',2,0),(5,'3',2,NULL,NULL,'2016-10-10 00:00:00','2017-10-10 00:00:00',4,0),(6,'6',5,NULL,NULL,'2016-10-10 00:00:00','2017-10-12 00:00:00',4,0),(7,'7',5,NULL,NULL,'2016-10-10 00:00:00','2017-11-12 00:00:00',2,0),(8,'12345',5,NULL,NULL,'2016-10-10 00:00:00','2017-10-12 00:00:00',4,0),(9,'123',50,NULL,'123','2016-10-10 00:00:00','2017-11-12 00:00:00',4,1),(10,'123456',11,NULL,NULL,'2016-10-10 00:00:00','2017-11-12 00:00:00',4,0),(11,'12345a',5,NULL,NULL,'2016-10-10 00:00:00','2017-11-12 00:00:00',23,0),(12,'12345b',5,'63223ab6-b22f-11e7-af4f-d43d7e34fa1f','BFEBFBFF000306A9','2016-10-10 00:00:00','2017-10-12 00:00:00',5,1);
/*!40000 ALTER TABLE `regist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-18 17:59:50
