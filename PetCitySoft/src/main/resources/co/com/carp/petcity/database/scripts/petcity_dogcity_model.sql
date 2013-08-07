CREATE SCHEMA `PetCity_DogCity` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;

CREATE  TABLE `PetCity_DogCity`.`owner` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `documentId` INT NOT NULL ,
  `name` VARCHAR(100) NOT NULL ,
  `email` VARCHAR(150) NULL ,
  `address` VARCHAR(100) NOT NULL ,
  `cellphone` VARCHAR(10) NULL ,
  `phone` VARCHAR(7) NULL ,
  PRIMARY KEY (`identification`) ,
  INDEX `DOCID_NAME` (`documentId` ASC, `name` ASC) );
  
CREATE  TABLE `PetCity_DogCity`.`user` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `documentId` INT NULL ,
  `name` VARCHAR(100) NULL ,
  `email` VARCHAR(150) NOT NULL ,
  `login` VARCHAR(10) NOT NULL ,
  `password` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) ,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) ,
  INDEX `login_password` (`login` ASC, `password` ASC) );
  
CREATE  TABLE `PetCity_DogCity`.`petType` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `class` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) );

CREATE  TABLE `PetCity_DogCity`.`petBreed` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `idPetType` INT NULL ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) ,
  INDEX `FK_petType_petBreed_idx` (`idPetType` ASC) ,
  CONSTRAINT `FK_petType_petBreed`
    FOREIGN KEY (`idPetType` )
    REFERENCES `PetCity_DogCity`.`pettype` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
	
CREATE  TABLE `PetCity_DogCity`.`foodBrand` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  `other` VARCHAR(45) NULL COMMENT 'When a pet is eating a different brand, please fill this field with the food brand\'s name.' ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC));  
  
  CREATE  TABLE `PetCity_DogCity`.`petFood` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `idFoodBrand` INT NOT NULL ,
  `idPetType` INT NOT NULL ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) ,
  INDEX `FK_foodBrand_petFood_idx` (`idFoodBrand` ASC) ,
  INDEX `FK_petType_petFood_idx` (`idPetType` ASC) ,
  CONSTRAINT `FK_foodBrand_petFood`
    FOREIGN KEY (`idFoodBrand` )
    REFERENCES `PetCity_DogCity`.`foodbrand` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_petType_petFood`
    FOREIGN KEY (`idPetType` )
    REFERENCES `PetCity_DogCity`.`pettype` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);

CREATE  TABLE `petcity_dogcity`.`Pet` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `color` VARCHAR(60) NOT NULL ,
  `sex` VARCHAR(6) NOT NULL ,
  `bornDate` DATETIME NOT NULL ,
  `bornPlace` VARCHAR(60) NOT NULL ,
  `reproductionState` VARCHAR(20) NOT NULL ,
  `photo` BLOB NULL ,
  `idPetType` INT NOT NULL ,
  `idPetBreed` INT NOT NULL ,
  `idPetFood` INT NOT NULL ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) ,
  INDEX `Fk_petType_pet_idx` (`idPetType` ASC) ,
  INDEX `Fk_petBreed_pet_idx` (`idPetBreed` ASC) ,
  INDEX `Fk_petFood_pet_idx` (`idPetFood` ASC) ,
  CONSTRAINT `Fk_petType_pet`
    FOREIGN KEY (`idPetType` )
    REFERENCES `petcity_dogcity`.`pettype` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `Fk_petBreed_pet`
    FOREIGN KEY (`idPetBreed` )
    REFERENCES `petcity_dogcity`.`petbreed` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `Fk_petFood_pet`
    FOREIGN KEY (`idPetFood` )
    REFERENCES `petcity_dogcity`.`petfood` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);

CREATE  TABLE `petcity_dogcity`.`clinicHistory` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `openDate` DATETIME NOT NULL ,
  `creatorUser` INT NOT NULL ,
  `idPet` INT NOT NULL ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) ,
  INDEX `Fk_user_clinicHistory_idx` (`creatorUser` ASC) ,
  UNIQUE INDEX `idPet_UNIQUE` (`idPet` ASC) ,
  CONSTRAINT `Fk_user_clinicHistory`
    FOREIGN KEY (`creatorUser` )
    REFERENCES `petcity_dogcity`.`user` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_pet_clinicHistory`
    FOREIGN KEY (`idPet` )
    REFERENCES `petcity_dogcity`.`pet` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);	
    
CREATE  TABLE `petcity_dogcity`.`medicalConsultation` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `consultationDate` DATETIME NOT NULL ,
  `anamnesis` VARCHAR(400) NULL ,
  `illness` VARCHAR(60) NULL ,
  `motive` VARCHAR(200) NOT NULL ,
  `findings` VARCHAR(200) NULL ,
  `diagnosis` VARCHAR(100) NULL ,
  `treatment` VARCHAR(400) NULL ,
  `control` VARCHAR(200) NULL ,
  `idClinicHistory` INT NOT NULL ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) ,
  INDEX `FK_clinicHistory_medicalConsultation_idx` (`idClinicHistory` ASC) ,
  CONSTRAINT `FK_clinicHistory_medicalConsultation`
    FOREIGN KEY (`idClinicHistory` )
    REFERENCES `petcity_dogcity`.`clinichistory` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);

CREATE  TABLE `petcity_dogcity`.`petExam` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `examDate` DATETIME NOT NULL ,
  `examFile` BLOB NULL ,
  `examObservation` VARCHAR(200) NULL ,
  `idMedicalConsultation` INT NOT NULL ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) ,
  INDEX `FK_medicalConsultation_petExam_idx` (`idMedicalConsultation` ASC) ,
  CONSTRAINT `FK_medicalConsultation_petExam`
    FOREIGN KEY (`idMedicalConsultation` )
    REFERENCES `petcity_dogcity`.`medicalconsultation` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
    
ALTER TABLE `petcity_dogcity`.`pet` DROP FOREIGN KEY `Fk_petFood_pet` ;
ALTER TABLE `petcity_dogcity`.`pet` DROP COLUMN `idPetFood` 
, DROP INDEX `Fk_petFood_pet_idx` ;

CREATE  TABLE `petcity_dogcity`.`petVisitInfo` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `weight` FLOAT NOT NULL ,
  `idPetFood` INT NOT NULL ,
  `corporalCondition` VARCHAR(30) NOT NULL ,
  `idMedicalConsultation` INT NOT NULL ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) ,
  INDEX `FK_petFood_petVisitInfo_idx` (`idPetFood` ASC) ,
  INDEX `FK_medicalConsultation_petVisitInfo_idx` (`idMedicalConsultation` ASC) ,
  CONSTRAINT `FK_petFood_petVisitInfo`
    FOREIGN KEY (`idPetFood` )
    REFERENCES `petcity_dogcity`.`petfood` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_medicalConsultation_petVisitInfo`
    FOREIGN KEY (`idMedicalConsultation` )
    REFERENCES `petcity_dogcity`.`medicalconsultation` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
    
CREATE  TABLE `petcity_dogcity`.`petVaccine` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(80) NOT NULL ,
  `applicationDate` DATETIME NOT NULL ,
  `idPet` INT NOT NULL ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) ,
  INDEX `FK_pet_petVaccine_idx` (`idPet` ASC) ,
  CONSTRAINT `FK_pet_petVaccine`
    FOREIGN KEY (`idPet` )
    REFERENCES `petcity_dogcity`.`pet` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
    
CREATE  TABLE `petcity_dogcity`.`petDrenching` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `productName` VARCHAR(60) NOT NULL ,
  `drenchingDate` DATETIME NOT NULL ,
  `idPet` INT NOT NULL ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) ,
  INDEX `FK_pet_petDrenching_idx` (`idPet` ASC) ,
  CONSTRAINT `FK_pet_petDrenching`
    FOREIGN KEY (`idPet` )
    REFERENCES `petcity_dogcity`.`pet` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
    
CREATE  TABLE `petcity_dogcity`.`notification` (
  `identification` INT NOT NULL AUTO_INCREMENT ,
  `message` VARCHAR(400) NOT NULL ,
  `level` TINYINT NOT NULL ,
  `creationDate` DATETIME NOT NULL ,
  `notificationDate` DATETIME NOT NULL ,
  `sendEmail` TINYINT NOT NULL ,
  `idPet` INT NOT NULL ,
  PRIMARY KEY (`identification`) ,
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) ,
  INDEX `FK_pet_notification_idx` (`idPet` ASC) ,
  CONSTRAINT `FK_pet_notification`
    FOREIGN KEY (`idPet` )
    REFERENCES `petcity_dogcity`.`pet` (`identification` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);