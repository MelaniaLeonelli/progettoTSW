USE GameMoving;
DROP TABLE IF EXISTS `infoutente`;

CREATE TABLE `infoutente` (
  `CodFiscale` char(16) NOT NULL,
  `Indirizzo` varchar(45) DEFAULT NULL,
  `Citta` varchar(45) DEFAULT NULL,
  `CAP` varchar(5) DEFAULT NULL,
  `NumTelefono` varchar(12) DEFAULT NULL,
  `Punti` int DEFAULT NULL,
  PRIMARY KEY (`CodFiscale`),
  CONSTRAINT `CodFiscaleCliente` FOREIGN KEY (`CodFiscale`) REFERENCES `utente` (`CodFiscale`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `infoutente` WRITE;
INSERT INTO `infoutente` VALUES ('BFFGLG71E14G337A','Via dei Portieri 21','Parma','51851','',0),('BNCNTN80A01F952K','Via degli Alberelli 2','Novara','51511','',0),('CCCDVD01P28H703H','Via Giovanni Lanzalone 11/bis','Salerno','84126','3294555074',0),('CHLGRG85M14G702M','Via Leonardo Bonucci 14','Pisa','94817','',0),('LVZPCH96H12F839R','Viale Buenos Aires 10','Napoli','18178','',0),('TNOLCU60D18L781W','Via Giovanni Cinque 5','Verona','81617','',0),('TTTFNC75P29H501M','Via della Capitale 10','Roma','10101','',0),('VRRMRC84E17C773K','Via della Costiera','Civitavecchia','81876','3695244316',0);
UNLOCK TABLES;
