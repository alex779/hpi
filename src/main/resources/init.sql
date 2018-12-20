CREATE TABLE IF NOT EXISTS `mydb`.`Road` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Location1` INT NOT NULL,
  `Location2` INT NOT NULL,
  `City_id` INT NOT NULL,
  `City_id1` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Road_City_idx` (`City_id` ASC),
  INDEX `fk_Road_City1_idx` (`City_id1` ASC),
  CONSTRAINT `fk_Road_City`
    FOREIGN KEY (`City_id`)
    REFERENCES `mydb`.`City` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Road_City1`
    FOREIGN KEY (`City_id1`)
    REFERENCES `mydb`.`City` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB