DROP DATABASE IF EXISTS GameMoving;
CREATE DATABASE GameMoving;
DROP USER IF EXISTS 'sisi'@'localhost';
CREATE USER'sisi'@'localhost'IDENTIFIED BY'password';
GRANT ALL ON GameMoving.* TO 'sisi'@'localhost';

