DROP DATABASE IF EXISTS gacha;
CREATE DATABASE gacha
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

CREATE USER 'winter'@'localhost' IDENTIFIED BY 'secret';
GRANT ALL PRIVILEGES ON gacha.* TO 'winter'@'localhost';

DROP TABLE IF EXISTS gacha.restaurants;
CREATE TABLE gacha.restaurants (
  id int(11) NOT NULL AUTO_INCREMENT,
  latitude DOUBLE NOT NULL,
  longitude DOUBLE NOT NULL,
  name VARCHAR(100) NOT NULL,
  score TINYINT(5) DEFAULT '5' COMMENT '1 ~ 100',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 DEFAULT COLLATE utf8_general_ci;