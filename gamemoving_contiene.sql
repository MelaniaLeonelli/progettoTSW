USE GameMoving;
DROP TABLE IF EXISTS `contiene`;
CREATE TABLE `contiene` (
  `CodProdotto` varchar(8) DEFAULT NULL,
  `quantita` int DEFAULT NULL,
  `ImportoTotale` decimal(10,2) DEFAULT NULL,
  `CodFiscale` char(16) DEFAULT NULL,
  KEY `CF` (`CodFiscale`),
  CONSTRAINT `CF` FOREIGN KEY (`CodFiscale`) REFERENCES `utente` (`CodFiscale`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `contiene` WRITE;
UNLOCK TABLES;
