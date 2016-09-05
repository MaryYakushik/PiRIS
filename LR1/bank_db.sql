-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bank_db
-- ------------------------------------------------------
-- Server version	5.5.23

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `surname` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `patronymic` varchar(45) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `pasportId` int(11) NOT NULL,
  `placeOfBirth` text NOT NULL,
  `placeOfResidence` int(11) NOT NULL,
  `address` varchar(100) NOT NULL,
  `homePhone` varchar(7) DEFAULT NULL,
  `mobilePhone` varchar(10) DEFAULT NULL,
  `e-mail` varchar(45) DEFAULT NULL,
  `maritalStatus` int(11) NOT NULL,
  `nationality` int(11) NOT NULL,
  `disability` int(11) NOT NULL,
  `pensioner` tinyint(1) NOT NULL,
  `monthlyIncome` decimal(10,0) DEFAULT NULL,
  `miitary` tinyint(1) NOT NULL,
  PRIMARY KEY (`pasportId`,`surname`,`name`),
  KEY `fk_Client_Town1_idx` (`placeOfResidence`),
  KEY `fk_Client_MaritalStatus1_idx` (`maritalStatus`),
  KEY `fk_Client_Nationality1_idx` (`nationality`),
  KEY `fk_Client_Disability1_idx` (`disability`),
  CONSTRAINT `fk_Client_Pasport1` FOREIGN KEY (`pasportId`) REFERENCES `pasport` (`idPasport`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Client_Disability1` FOREIGN KEY (`disability`) REFERENCES `disability` (`idDisability`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Client_MaritalStatus1` FOREIGN KEY (`maritalStatus`) REFERENCES `maritalstatus` (`idMaritalStatus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Client_Nationality1` FOREIGN KEY (`nationality`) REFERENCES `nationality` (`idNationality`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Client_Town1` FOREIGN KEY (`placeOfResidence`) REFERENCES `town` (`idTown`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('Yakushik','Mary','Yurievna','1996-03-27',0,1,'Lida',1,'Dzerzhinski','641319','445606656','mary.yakushik@gmail.com',1,1,3,1,4000,1),('ghfdj','jhbjh','jbbj','2006-11-12',0,2,'Lida',1,'nkj','979789','676868','jkbkb',1,1,3,1,400,1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `bank_db`.`Client_BEFORE_INSERT` BEFORE INSERT ON `Client` FOR EACH ROW
BEGIN
	SET @CountOfSimilarRoads = (
    SELECT COUNT(*) FROM Client WHERE
		pasportId = NEW.pasportId
    );
    
    if( @CountOfSimilarRoads != 0) THEN
		SIGNAL SQLSTATE '45000' SET
		MESSAGE_TEXT = 'Невозможно добавить пользователей с одинаковыми паспортными данными.', 
		MYSQL_ERRNO = 1001;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `bank_db`.`Client_BEFORE_UPDATE` BEFORE UPDATE ON `Client` FOR EACH ROW
BEGIN
	SET @CountOfSimilarRoads = (
    SELECT COUNT(*) FROM Client WHERE
		pasportId = NEW.pasportId
    );
    
    if( @CountOfSimilarRoads != 0) THEN
		SIGNAL SQLSTATE '45000' SET
		MESSAGE_TEXT = 'Невозможно добавить пользователей с одинаковыми паспортными данными.', 
		MYSQL_ERRNO = 1001;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `disability`
--

DROP TABLE IF EXISTS `disability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disability` (
  `idDisability` int(11) NOT NULL AUTO_INCREMENT,
  `group` varchar(45) NOT NULL,
  PRIMARY KEY (`idDisability`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disability`
--

LOCK TABLES `disability` WRITE;
/*!40000 ALTER TABLE `disability` DISABLE KEYS */;
INSERT INTO `disability` VALUES (1,'0'),(2,'1'),(3,'2'),(4,'3');
/*!40000 ALTER TABLE `disability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maritalstatus`
--

DROP TABLE IF EXISTS `maritalstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maritalstatus` (
  `idMaritalStatus` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`idMaritalStatus`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maritalstatus`
--

LOCK TABLES `maritalstatus` WRITE;
/*!40000 ALTER TABLE `maritalstatus` DISABLE KEYS */;
INSERT INTO `maritalstatus` VALUES (1,'holost'),(2,'in mariage');
/*!40000 ALTER TABLE `maritalstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nationality`
--

DROP TABLE IF EXISTS `nationality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nationality` (
  `idNationality` int(11) NOT NULL AUTO_INCREMENT,
  `nationality` varchar(45) NOT NULL,
  PRIMARY KEY (`idNationality`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nationality`
--

LOCK TABLES `nationality` WRITE;
/*!40000 ALTER TABLE `nationality` DISABLE KEYS */;
INSERT INTO `nationality` VALUES (1,'RB'),(2,'NAN'),(3,'UR');
/*!40000 ALTER TABLE `nationality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasport`
--

DROP TABLE IF EXISTS `pasport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pasport` (
  `idPasport` int(11) NOT NULL AUTO_INCREMENT,
  `series` varchar(2) NOT NULL,
  `number` varchar(7) NOT NULL,
  `organization` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `identNumber` varchar(12) NOT NULL,
  PRIMARY KEY (`idPasport`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasport`
--

LOCK TABLES `pasport` WRITE;
/*!40000 ALTER TABLE `pasport` DISABLE KEYS */;
INSERT INTO `pasport` VALUES (1,'KH','2142071','Lida','2012-04-06','123456789'),(2,'Kh','234234','kI','2016-10-10','3456E5453');
/*!40000 ALTER TABLE `pasport` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `bank_db`.`Pasport_BEFORE_INSERT` BEFORE INSERT ON `Pasport` FOR EACH ROW
BEGIN
	SET @CountOFSimilarRows := (SELECT COUNT(*) FROM Pasport WHERE
		series = NEW.series
        AND `number` = NEW.`number`
        AND identNumber = New.identNumber);
	
    if( @CountOfSimilarRows != 0) THEN
		SIGNAL SQLSTATE '45000' SET
		MESSAGE_TEXT = 'Невозможно добавить паспорта с одинаковыми данными.', 
		MYSQL_ERRNO = 1001;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `bank_db`.`Pasport_BEFORE_UPDATE` BEFORE UPDATE ON `Pasport` FOR EACH ROW
BEGIN
	SET @CountOFSimilarRows := (SELECT COUNT(*) FROM Pasport WHERE
		series = New.series
        AND `number` = New.`number`
		AND identNumber = New.identNumber);
	
    if( @CountOfSimilarRows != 0) THEN
		SIGNAL SQLSTATE '45000' SET
		MESSAGE_TEXT = 'Невозможно добавить паспорта с одинаковыми данными.', 
		MYSQL_ERRNO = 1001;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `bank_db`.`Pasport_BEFORE_DELETE` BEFORE DELETE ON `Pasport` FOR EACH ROW
BEGIN
	SET @CountOFSimilarRows := (SELECT COUNT(*) FROM Client WHERE
		pasportId = OLD.idPasport);
	
    if( @CountOfSimilarRows != 0) THEN
		SIGNAL SQLSTATE '45000' SET
		MESSAGE_TEXT = 'Невозможно удалить паспорт, т.к. он привязан к пользователю.', 
		MYSQL_ERRNO = 1001;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `town`
--

DROP TABLE IF EXISTS `town`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `town` (
  `idTown` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`idTown`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `town`
--

LOCK TABLES `town` WRITE;
/*!40000 ALTER TABLE `town` DISABLE KEYS */;
INSERT INTO `town` VALUES (1,'Lida'),(2,'Minsk'),(3,'Grodno');
/*!40000 ALTER TABLE `town` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bank_db'
--

--
-- Dumping routines for database 'bank_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-04 14:42:16
