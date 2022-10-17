USE GameMoving;
DROP TABLE IF EXISTS `utente`;
CREATE TABLE `utente` (
  `CodFiscale` char(16) NOT NULL,
  `Cognome` varchar(45) DEFAULT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  `Email` varchar(45) NOT NULL,
  `Password` varchar(257) DEFAULT NULL,
  `IsAdmin` int DEFAULT '0',
  PRIMARY KEY (`CodFiscale`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `utente` WRITE;
INSERT INTO `utente` VALUES ('BFFGLG71E14G337A','Buffon','Gianluigi','bufgianlu@tiscali.it','pane',0),('BNCNTN80A01F952K','Bianchi','Antonio','biantonio22@outlook.it','latte',0),('CCCDVD01P28H703H','Coccorullo','David','davidcoccorullo7@outlook.it','pizza',1),('CHLGRG85M14G702M','Chiellini','Giorgio','chiello@libero.it','limoni',0),('LVZPCH96H12F839R','Lavezzi','Pocho','elpocholavezzi@hotmail.ar','zanzare',0),('TNOLCU60D18L781W','Toni','Luca','lucatoni9@alice.it','sole',0),('TTTFNC75P29H501M','Totti','Francesco','fratotti10@gmail.com','luna',0),('VRRMRC84E17C773K','Verratti','Marco','vermar2@gmail.com','lavezzi',0);
UNLOCK TABLES;
