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
  `date` varchar(45) NOT NULL COMMENT '供货时间（作为授权证书中的内容）',
  `cid` int(11) NOT NULL COMMENT '客户编号',
  `pid` int(11) NOT NULL COMMENT '产品编号（作为授权证书中的内容）',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '交易类型("0:押标","1:供货")',
  `price` float NOT NULL COMMENT '订单金额(单位：万元)',
  `eid` varchar(45) DEFAULT NULL COMMENT '加密锁',
  `debt` float DEFAULT '0' COMMENT '剩余欠款',
  `sid` varchar(45) DEFAULT NULL COMMENT '销售人员',
  `rcode` varchar(45) DEFAULT NULL COMMENT '一个产品对于一个客户都有一个唯一的注册码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `price_UNIQUE` (`price`),
  UNIQUE KEY `type_UNIQUE` (`type`),
  UNIQUE KEY `pid_UNIQUE` (`pid`),
  UNIQUE KEY `cid_UNIQUE` (`cid`),
  UNIQUE KEY `date_UNIQUE` (`date`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `rcode_UNIQUE` (`rcode`),
  UNIQUE KEY `sid_UNIQUE` (`sid`),
  UNIQUE KEY `debt_UNIQUE` (`debt`),
  KEY `cidd_idx` (`cid`),
  KEY `pidd_idx` (`pid`),
  KEY `应用加密锁序列号_idx` (`eid`),
  KEY `销售人员_idx` (`sid`),
  CONSTRAINT `应用加密锁序列号` FOREIGN KEY (`eid`) REFERENCES `edog` (`serial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `引用产品ID` FOREIGN KEY (`pid`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `引用客户ID` FOREIGN KEY (`cid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `销售人员` FOREIGN KEY (`sid`) REFERENCES `saler` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品销售记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
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

-- Dump completed on 2017-10-13 17:34:48
