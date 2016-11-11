CREATE DATABASE `bbsluke`;

CREATE TABLE `bbsluke`.`userinfor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(200) NULL,
  `userpws` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
