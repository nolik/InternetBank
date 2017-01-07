-- MySQL dump 10.16  Distrib 10.1.20-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: localhost
-- ------------------------------------------------------
-- Server version	10.1.20-MariaDB

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
-- Table structure for table `Cards`
--

DROP TABLE IF EXISTS `Cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cards` (
  `cardNumber` int(11) NOT NULL,
  `summ` decimal(10,2) NOT NULL,
  `Users_login` varchar(45) NOT NULL,
  `Currencies_currencyName` varchar(3) NOT NULL,
  PRIMARY KEY (`cardNumber`,`Users_login`,`Currencies_currencyName`),
  KEY `fk_Cards_Users1_idx` (`Users_login`),
  KEY `fk_Cards_Currencies1_idx` (`Currencies_currencyName`),
  CONSTRAINT `fk_Cards_Currencies1` FOREIGN KEY (`Currencies_currencyName`) REFERENCES `Currencies` (`currencyName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cards_Users1` FOREIGN KEY (`Users_login`) REFERENCES `Users` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cards`
--

LOCK TABLES `Cards` WRITE;
/*!40000 ALTER TABLE `Cards` DISABLE KEYS */;
INSERT INTO `Cards` VALUES (111,65739.52,'nolik','RUB'),(222,1672.17,'kate','RUB'),(333,10000.00,'user','RUB'),(444,1084.00,'kate','EUR'),(1111,97999.81,'nolik','USD'),(2222,12226.92,'kate','USD'),(3333,29292.00,'user','USD');
/*!40000 ALTER TABLE `Cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Currencies`
--

DROP TABLE IF EXISTS `Currencies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Currencies` (
  `currencyName` varchar(3) NOT NULL,
  `currencyCode` int(3) NOT NULL,
  PRIMARY KEY (`currencyName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Currencies`
--

LOCK TABLES `Currencies` WRITE;
/*!40000 ALTER TABLE `Currencies` DISABLE KEYS */;
INSERT INTO `Currencies` VALUES ('EUR',978),('RUB',643),('USD',840);
/*!40000 ALTER TABLE `Currencies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Transactions`
--

DROP TABLE IF EXISTS `Transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Transactions` (
  `idTransaction` int(11) NOT NULL AUTO_INCREMENT,
  `operation` varchar(45) DEFAULT NULL,
  `summOfOperation` decimal(10,2) NOT NULL,
  `Cards_cardNumber` int(11) NOT NULL,
  `Cards_Users_login` varchar(45) NOT NULL,
  `transactionTime` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`idTransaction`,`Cards_cardNumber`,`Cards_Users_login`),
  KEY `fk_Transactions_Cards1_idx` (`Cards_cardNumber`,`Cards_Users_login`),
  CONSTRAINT `fk_Transactions_Cards1` FOREIGN KEY (`Cards_cardNumber`, `Cards_Users_login`) REFERENCES `Cards` (`cardNumber`, `Users_login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Transactions`
--

LOCK TABLES `Transactions` WRITE;
/*!40000 ALTER TABLE `Transactions` DISABLE KEYS */;
INSERT INTO `Transactions` VALUES (1,'sent money',111.00,222,'kate','2016-11-18 20:14:49.247792'),(2,'sent money',22.00,111,'nolik','2016-11-19 16:54:54.601160'),(3,'sent money',77.00,222,'kate','2016-11-21 22:34:47.657390'),(4,'sent money',30.00,222,'kate','2016-11-21 23:07:59.238229'),(5,'sent money',22.00,222,'kate','2016-11-22 00:45:05.679347'),(6,'sent money',2.00,222,'kate','2016-11-23 22:21:50.583254'),(7,'sent money',11.00,222,'kate','2016-11-25 21:09:10.322746'),(8,'sent money',100.00,444,'kate','2016-11-25 21:32:27.514946'),(9,'sent money',15.00,444,'kate','2016-11-25 21:54:32.445451'),(10,'sent money',1000.00,1111,'nolik','2016-11-27 16:43:12.316418'),(11,'sent money',11.00,111,'nolik','2016-12-08 20:39:05.616788'),(12,'sent money',111.00,111,'nolik','2016-12-14 19:54:32.734119');
/*!40000 ALTER TABLE `Transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`login`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES ('kate','88c76da1363d4578957b74fae6121bff','user','Kate','Rojok'),('nolik','dc233a3fe98e8ce330bb6630325cd25c','user','Nolik','Nooool'),('user','user','user','User','HOOODOOOR');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fio` varchar(300) NOT NULL,
  `birthday` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `content` longblob NOT NULL,
  `page_count` int(11) NOT NULL,
  `isbn` varchar(100) NOT NULL,
  `genre_id` bigint(20) NOT NULL,
  `author_id` bigint(20) NOT NULL,
  `publish_year` int(11) NOT NULL,
  `publisher_id` bigint(20) NOT NULL,
  `image` longblob,
  `descr` varchar(5000) DEFAULT NULL,
  `rating` int(5) DEFAULT '0',
  `vote_count` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `isbn_UNIQUE` (`isbn`),
  KEY `fk_author_idx` (`author_id`),
  KEY `fk_genre_idx` (`genre_id`),
  KEY `fk_publiher_idx` (`publisher_id`),
  CONSTRAINT `fk_author` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_genre` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_publisher` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `parent` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_parent_idx` (`parent`),
  CONSTRAINT `fk_parent` FOREIGN KEY (`parent`) REFERENCES `genre` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publisher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` int(5) DEFAULT '0',
  `book_id` bigint(20) NOT NULL,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_book_id_idx` (`book_id`),
  KEY `fk_user_id_idx` (`username`),
  CONSTRAINT `fk_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-07 23:12:31
