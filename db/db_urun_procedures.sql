-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: db_stok_takip
-- ------------------------------------------------------
-- Server version	8.0.31

--
-- Dumping routines for database 'db_stok_takip'
--
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUrun`(IN urunId INT)
BEGIN
    DELETE FROM urun WHERE id = urunId;
END ;;
DELIMITER ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllUrun`()
BEGIN
    SELECT * FROM db_stok_takip.urun;
END ;;
DELIMITER ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUrun`(IN name_param NVARCHAR(50), IN content_param NVARCHAR(255))
BEGIN
    INSERT INTO urun (name, content) VALUES (name_param, content_param);
END ;;
DELIMITER ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `searchUrun`(IN namePattern NVARCHAR(50), IN contentPattern VARCHAR(255))
BEGIN
    SELECT * FROM urun 
    WHERE urun.name LIKE CONCAT('%', namePattern, '%') 
    OR urun.content LIKE CONCAT('%', contentPattern, '%');
END ;;
DELIMITER ;