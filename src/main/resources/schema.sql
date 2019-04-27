CREATE DATABASE IF NOT EXISTS SHOP CHARACTER SET=utf8 COLLATE utf8_general_ci;

USE SHOP;

CREATE TABLE  STORAGE (
                          ID INT AUTO_INCREMENT,
                          NAME VARCHAR(255),
                          PRIMARY KEY(ID)
);

CREATE TABLE  LIST (
                       ID INT AUTO_INCREMENT,
                       NAME VARCHAR(255),
                       ARTICLE INT,
                       PRICE INT,
                       STORAGE_ID INT,
                       PRIMARY KEY(ID),
                       FOREIGN KEY (STORAGE_ID)
                           REFERENCES `STORAGE`(ID) ON DELETE SET NULL);
