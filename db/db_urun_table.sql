-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: db_stok_takip
-- ------------------------------------------------------
-- Server version	8.0.31
--
-- Table structure for table `urun`
--

DROP TABLE IF EXISTS `urun`;
CREATE TABLE `urun` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `urun`
--

LOCK TABLES `urun` WRITE;
INSERT INTO `urun` VALUES (1,'test','test'),(2,'TESEF','FERF'),(4,'qwe','eqwe'),(6,'qwe','qwe'),(7,'qwe','qwe'),(8,'Buzdolabı','Vestel buzdolabı');
UNLOCK TABLES;

-- Dump completed on 2024-03-06 12:25:41
