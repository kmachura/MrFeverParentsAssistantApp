-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: mrfever
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `children`
--

DROP TABLE IF EXISTS `children`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `children` (
  `name` varchar(20) NOT NULL,
  `dateofbirth` varchar(20) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`name`,`dateofbirth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `children`
--

LOCK TABLES `children` WRITE;
/*!40000 ALTER TABLE `children` DISABLE KEYS */;
INSERT INTO `children` VALUES ('Joseph','12.01.2019.','boy'),('Justine','03.02.2016.','girl'),('Thomas','05.01.2013.','boy');
/*!40000 ALTER TABLE `children` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `givenmedicines`
--

DROP TABLE IF EXISTS `givenmedicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `givenmedicines` (
  `dateofgiving` varchar(20) NOT NULL,
  `timeofgiving` varchar(20) NOT NULL,
  `typeofmedicine` varchar(50) DEFAULT NULL,
  `formofmedicine` varchar(20) DEFAULT NULL,
  `doseofmedicine` varchar(20) DEFAULT NULL,
  `towhom` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dateofgiving`,`timeofgiving`),
  KEY `typeofmedicine` (`typeofmedicine`),
  KEY `fk_childname` (`towhom`),
  CONSTRAINT `fk_childname` FOREIGN KEY (`towhom`) REFERENCES `children` (`name`) ON DELETE CASCADE,
  CONSTRAINT `fk_medicine` FOREIGN KEY (`typeofmedicine`) REFERENCES `medicineslist` (`nameofmedicine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `givenmedicines`
--

LOCK TABLES `givenmedicines` WRITE;
/*!40000 ALTER TABLE `givenmedicines` DISABLE KEYS */;
INSERT INTO `givenmedicines` VALUES ('01.05.2018.','19:30','paracetamol','syrup','12,00 ml','Thomas'),('02.05.2018.','02:15','ibuprofenum','syrup','3,75 ml','Thomas'),('02.05.2018.','21:45','paracetamol','syrup','7,50 ml','Justine'),('03.05.2018.','16:00','ibuprofenum','syrup','2,50 ml','Justine'),('27.04.2019.','21:30','ibuprofenum','syrup','1,25 ml','Joseph');
/*!40000 ALTER TABLE `givenmedicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicinesdetail`
--

DROP TABLE IF EXISTS `medicinesdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medicinesdetail` (
  `thismedicine` varchar(50) DEFAULT NULL,
  `formofmedicine` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `thismedicine` (`thismedicine`),
  CONSTRAINT `medicinesdetail_ibfk_1` FOREIGN KEY (`thismedicine`) REFERENCES `medicineslist` (`nameofmedicine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicinesdetail`
--

LOCK TABLES `medicinesdetail` WRITE;
/*!40000 ALTER TABLE `medicinesdetail` DISABLE KEYS */;
INSERT INTO `medicinesdetail` VALUES ('paracetamol','syrup','raspberry flavour',1),('ibuprofenum','syrup','orange flavour, strenght type: forte',2),('mix of paracetamol & ibuprofenum','syrup','strawberry flavour',3),('paracetamol','suppositories','125mg',4);
/*!40000 ALTER TABLE `medicinesdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicineslist`
--

DROP TABLE IF EXISTS `medicineslist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medicineslist` (
  `nameofmedicine` varchar(50) NOT NULL,
  PRIMARY KEY (`nameofmedicine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicineslist`
--

LOCK TABLES `medicineslist` WRITE;
/*!40000 ALTER TABLE `medicineslist` DISABLE KEYS */;
INSERT INTO `medicineslist` VALUES ('aspirin'),('ibuprofenum'),('mix of paracetamol & ibuprofenum'),('paracetamol');
/*!40000 ALTER TABLE `medicineslist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temperature`
--

DROP TABLE IF EXISTS `temperature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `temperature` (
  `dateofmeasurement` varchar(20) NOT NULL,
  `timeofmeasurement` varchar(20) NOT NULL,
  `placeofmeasurement` varchar(20) DEFAULT NULL,
  `leveloftemperature` double(4,2) DEFAULT NULL,
  `whose` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dateofmeasurement`,`timeofmeasurement`),
  KEY `fk_whosetemperature` (`whose`),
  CONSTRAINT `fk_whosetemperature` FOREIGN KEY (`whose`) REFERENCES `children` (`name`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temperature`
--

LOCK TABLES `temperature` WRITE;
/*!40000 ALTER TABLE `temperature` DISABLE KEYS */;
INSERT INTO `temperature` VALUES ('01.05.2018.','19:27','ear',38.50,'Thomas'),('02.05.2018.','21:43','ear',38.80,'Justine'),('02.05.2019.','02:11','forehead',38.70,'Thomas'),('03.05.2018.','15:57','forehead',38.90,'Justine'),('12.05.2018.','12:30','armpit',38.50,'Justine'),('23.05.2018.','19:30','ear',38.50,'Joseph'),('28.04.2019.','10:00','ear',38.50,'Joseph');
/*!40000 ALTER TABLE `temperature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mrfever'
--

--
-- Dumping routines for database 'mrfever'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-28 17:43:56
