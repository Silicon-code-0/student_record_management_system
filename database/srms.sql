CREATE DATABASE  IF NOT EXISTS `student_record_management_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `student_record_management_system`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: student_record_management_system
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `academic_details`
--

DROP TABLE IF EXISTS `academic_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academic_details` (
  `student_id` int DEFAULT NULL,
  `primary_board` varchar(50) DEFAULT NULL,
  `primary_school_name` varchar(100) DEFAULT NULL,
  `primary_city` varchar(50) DEFAULT NULL,
  `primary_year_of_passing` varchar(10) DEFAULT NULL,
  `primary_percentage` varchar(10) DEFAULT NULL,
  `secondary_board` varchar(50) DEFAULT NULL,
  `secondary_college_name` varchar(100) DEFAULT NULL,
  `secondary_city` varchar(50) DEFAULT NULL,
  `secondary_year_of_passing` varchar(10) DEFAULT NULL,
  `secondary_percentage` varchar(10) DEFAULT NULL,
  `graduation_board` varchar(50) DEFAULT NULL,
  `graduation_college_name` varchar(100) DEFAULT NULL,
  `graduation_city` varchar(50) DEFAULT NULL,
  `graduation_year_of_passing` varchar(10) DEFAULT NULL,
  `graduation_percentage` varchar(10) DEFAULT NULL,
  KEY `fk_student` (`student_id`),
  CONSTRAINT `fk_student` FOREIGN KEY (`student_id`) REFERENCES `student_detail_master` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic_details`
--

LOCK TABLES `academic_details` WRITE;
/*!40000 ALTER TABLE `academic_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `academic_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `academic_master`
--

DROP TABLE IF EXISTS `academic_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academic_master` (
  `academic_id` int NOT NULL AUTO_INCREMENT,
  `university_name` varchar(45) NOT NULL,
  `year_of_passing` date NOT NULL,
  `cgpa_percentage` varchar(45) NOT NULL,
  `student_id` int NOT NULL,
  `qualification_name` varchar(45) NOT NULL,
  PRIMARY KEY (`academic_id`),
  KEY `student_id_idx` (`student_id`),
  KEY `qualification_name_idx` (`qualification_name`),
  CONSTRAINT `qualification_name` FOREIGN KEY (`qualification_name`) REFERENCES `qualification_master` (`qualification_name`),
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student_detail_master` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic_master`
--

LOCK TABLES `academic_master` WRITE;
/*!40000 ALTER TABLE `academic_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `academic_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_master`
--

DROP TABLE IF EXISTS `category_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_master` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_master`
--

LOCK TABLES `category_master` WRITE;
/*!40000 ALTER TABLE `category_master` DISABLE KEYS */;
INSERT INTO `category_master` VALUES (1,'General'),(2,'SC'),(3,'ST'),(4,'OBC'),(5,'EWS');
/*!40000 ALTER TABLE `category_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_master`
--

DROP TABLE IF EXISTS `country_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country_master` (
  `country_id` int NOT NULL,
  `country_name` varchar(45) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_master`
--

LOCK TABLES `country_master` WRITE;
/*!40000 ALTER TABLE `country_master` DISABLE KEYS */;
INSERT INTO `country_master` VALUES (1,'US'),(2,'India'),(3,'Germany'),(4,'China');
/*!40000 ALTER TABLE `country_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_master`
--

DROP TABLE IF EXISTS `course_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_master` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(45) NOT NULL,
  `course_duration` date NOT NULL,
  `department_id` int NOT NULL,
  `no_of_semester` int NOT NULL,
  PRIMARY KEY (`course_id`),
  KEY `department_id_idx` (`department_id`),
  CONSTRAINT `department_id` FOREIGN KEY (`department_id`) REFERENCES `department_master` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_master`
--

LOCK TABLES `course_master` WRITE;
/*!40000 ALTER TABLE `course_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `current_program_detail_master`
--

DROP TABLE IF EXISTS `current_program_detail_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `current_program_detail_master` (
  `program_id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `student_id` int NOT NULL,
  `semester_year` int NOT NULL,
  `mode_of_study` varchar(45) NOT NULL,
  PRIMARY KEY (`program_id`),
  KEY `course_id_idx` (`course_id`),
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course_master` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `current_program_detail_master`
--

LOCK TABLES `current_program_detail_master` WRITE;
/*!40000 ALTER TABLE `current_program_detail_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `current_program_detail_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department_master`
--

DROP TABLE IF EXISTS `department_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department_master` (
  `department_id` int NOT NULL AUTO_INCREMENT,
  `department_name` varchar(45) NOT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_master`
--

LOCK TABLES `department_master` WRITE;
/*!40000 ALTER TABLE `department_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `department_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district_master`
--

DROP TABLE IF EXISTS `district_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `district_master` (
  `district_id` int NOT NULL AUTO_INCREMENT,
  `district_name` varchar(45) NOT NULL,
  `state_id` int NOT NULL,
  PRIMARY KEY (`district_id`),
  KEY `fk_state_idx` (`state_id`),
  CONSTRAINT `fk_state` FOREIGN KEY (`state_id`) REFERENCES `state_master` (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district_master`
--

LOCK TABLES `district_master` WRITE;
/*!40000 ALTER TABLE `district_master` DISABLE KEYS */;
INSERT INTO `district_master` VALUES (1,'Akola',14),(2,'Amravati',14),(3,'Ahmednagar',14),(4,'Aurangabad',14),(5,'Bhandara',14),(6,'Buldhana',14),(7,'Chandrapur',14),(8,'Dhule',14),(9,'Gadchiroli',14),(10,'Jalgaon',14),(11,'Jalna',14),(12,'Kolhapur',14),(13,'Latur',14),(14,'Mumbai City',14),(15,'Mumbai Suburban',14),(16,'Nagpur',14),(17,'Nanded',14),(18,'Nashik',14),(19,'Nandurbar',14),(20,'Osmanabad',14),(21,'Parbhani',14),(22,'Pune',14),(23,'Raigad',14),(24,'Ratnagiri',14),(25,'Sangli',14),(26,'Satara',14),(27,'Sindhudurg',14),(28,'Thane',14),(29,'Wardha',14),(30,'Washim',14),(31,'Yavatmal',14),(32,'Solapur',14),(33,'Bokaro',10),(34,'Chatra',10),(35,'Deoghar',10),(36,'Dhanbad',10),(37,'Dumka',10),(38,'East Singhbhum',10),(39,'Garhwa',10),(40,'Giridih',10),(41,'Godda',10),(42,'Gumla',10),(43,'Hazaribagh',10),(44,'Jamtara',10),(45,'Khunti',10),(46,'Koderma',10),(47,'Latehar',10),(48,'Lohardaga',10),(49,'Pakur',10),(50,'Palamu',10),(51,'Ramgarh',10),(52,'Ranchi',10),(53,'Sahibganj',10),(54,'Saraikela Kharsawan',10),(55,'Simdega',10),(56,'West Singhbhum',10),(57,'North Goa',6),(58,'South Goa',6),(59,'Ahmedabad',7),(60,'Amreli',7),(61,'Anand',7),(62,'Aravalli',7),(63,'Banaskantha',7),(64,'Bharuch',7),(65,'Bhavnagar',7),(66,'Botad',7),(67,'Chhota Udepur',7),(68,'Dahod',7),(69,'Dang',7),(70,'Gandhinagar',7),(71,'Gir Somnath',7),(72,'Jamnagar',7),(73,'Junagadh',7),(74,'Kheda',7),(75,'Kutch',7),(76,'Mahisagar',7),(77,'Mehsana',7),(78,'Morbi',7),(79,'Narmada',7),(80,'Navsari',7),(81,'Panchmahal',7),(82,'Patan',7),(83,'Porbandar',7),(84,'Rajkot',7),(85,'Sabarkantha',7),(86,'Surat',7),(87,'Surendranagar',7),(88,'Tapi',7),(89,'Vadodara',7),(90,'Valsad',7),(91,'Agra',26),(92,'Aligarh',26),(93,'Ambedkar Nagar',26),(94,'Amethi',26),(95,'Amroha',26),(96,'Auraiya',26),(97,'Ayodhya',26),(98,'Azamgarh',26),(99,'Baghpat',26),(100,'Bahraich',26),(101,'Ballia',26),(102,'Balrampur',26),(103,'Banda',26),(104,'Barabanki',26),(105,'Bareilly',26),(106,'Basti',26),(107,'Bhadohi',26),(108,'Bijnor',26),(109,'Budaun',26),(110,'Bulandshahr',26),(111,'Chandauli',26),(112,'Chitrakoot',26),(113,'Deoria',26),(114,'Etah',26),(115,'Etawah',26),(116,'Faizabad',26),(117,'Farrukhabad',26),(118,'Fatehpur',26),(119,'Firozabad',26),(120,'Gautam Buddha Nagar',26),(121,'Ghaziabad',26),(122,'Ghazipur',26),(123,'Gonda',26),(124,'Gorakhpur',26),(125,'Hamirpur',26),(126,'Hapur',26),(127,'Hardoi',26),(128,'Hathras',26),(129,'Jalaun',26),(130,'Jaunpur',26),(131,'Jhansi',26),(132,'Kannauj',26),(133,'Kanpur Dehat',26),(134,'Kanpur Nagar',26),(135,'Kasganj',26),(136,'Kaushambi',26),(137,'Kheri',26),(138,'Kushinagar',26),(139,'Lalitpur',26),(140,'Lucknow',26),(141,'Maharajganj',26),(142,'Mahoba',26),(143,'Mainpuri',26),(144,'Mathura',26),(145,'Mau',26),(146,'Meerut',26),(147,'Mirzapur',26),(148,'Moradabad',26),(149,'Muzaffarnagar',26),(150,'Pilibhit',26),(151,'Pratapgarh',26),(152,'Raebareli',26),(153,'Rampur',26),(154,'Saharanpur',26),(155,'Sambhal',26),(156,'Sant Kabir Nagar',26),(157,'Shahjahanpur',26),(158,'Shamli',26),(159,'Shravasti',26),(160,'Siddharthnagar',26),(161,'Sitapur',26),(162,'Sonbhadra',26),(163,'Sultanpur',26),(164,'Unnao',26),(165,'Varanasi',26);
/*!40000 ALTER TABLE `district_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender_master`
--

DROP TABLE IF EXISTS `gender_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender_master` (
  `gender_id` int NOT NULL AUTO_INCREMENT,
  `gender_name` varchar(45) NOT NULL,
  PRIMARY KEY (`gender_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender_master`
--

LOCK TABLES `gender_master` WRITE;
/*!40000 ALTER TABLE `gender_master` DISABLE KEYS */;
INSERT INTO `gender_master` VALUES (1,'male'),(2,'female'),(3,'other');
/*!40000 ALTER TABLE `gender_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guardian_details`
--

DROP TABLE IF EXISTS `guardian_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guardian_details` (
  `guardian_id` int NOT NULL AUTO_INCREMENT,
  `father_name` varchar(45) NOT NULL,
  `mother_name` varchar(45) NOT NULL,
  `father_email` varchar(45) DEFAULT NULL,
  `mother_email` varchar(45) DEFAULT NULL,
  `father_contact` varchar(45) NOT NULL,
  `total_earning` varchar(45) NOT NULL,
  `father_qualification` varchar(45) DEFAULT NULL,
  `father_occupation` varchar(45) NOT NULL,
  `mother_contact` varchar(45) NOT NULL,
  `mother_occupation` varchar(45) NOT NULL,
  `mother_qualification` varchar(45) DEFAULT NULL,
  `student_id` int NOT NULL,
  PRIMARY KEY (`guardian_id`),
  UNIQUE KEY `father_email_UNIQUE` (`father_email`),
  UNIQUE KEY `mother_email_UNIQUE` (`mother_email`),
  KEY `fk_guardian_student` (`student_id`),
  CONSTRAINT `fk_guardian_student` FOREIGN KEY (`student_id`) REFERENCES `student_detail_master` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guardian_details`
--

LOCK TABLES `guardian_details` WRITE;
/*!40000 ALTER TABLE `guardian_details` DISABLE KEYS */;
INSERT INTO `guardian_details` VALUES (1,'Prithvi','sarita','abc@gmail.com','abc@gmail.com','345678765','700000','Graduate','Business','3456765','Homemaker','Graduate',0),(2,'sadafgh','SADFGHJ','asdfsghsad','DSFGHF','dfgdhj','DSFGH','Diploma','Doctor','DFSGDHFJ','Doctor','Diploma',0),(3,'0','xfgcvhbjnkm','drfhgjk','gvhbjnm,','45678l','354678','Diploma','Doctor','45678','Teacher','Diploma',0),(10,'q','q','q','q','q','q','Diploma','Doctor','q','Teacher','Diploma',1012);
/*!40000 ALTER TABLE `guardian_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mode_of_study`
--

DROP TABLE IF EXISTS `mode_of_study`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mode_of_study` (
  `mode_id` int NOT NULL AUTO_INCREMENT,
  `mode_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`mode_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mode_of_study`
--

LOCK TABLES `mode_of_study` WRITE;
/*!40000 ALTER TABLE `mode_of_study` DISABLE KEYS */;
INSERT INTO `mode_of_study` VALUES (1,'Private'),(2,'FullTime'),(3,'Distant');
/*!40000 ALTER TABLE `mode_of_study` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qualification_master`
--

DROP TABLE IF EXISTS `qualification_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qualification_master` (
  `qualification_id` int NOT NULL,
  `qualification_name` varchar(45) NOT NULL,
  PRIMARY KEY (`qualification_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qualification_master`
--

LOCK TABLES `qualification_master` WRITE;
/*!40000 ALTER TABLE `qualification_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `qualification_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `religion_master`
--

DROP TABLE IF EXISTS `religion_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `religion_master` (
  `religion_id` int NOT NULL AUTO_INCREMENT,
  `religion_name` varchar(100) NOT NULL,
  PRIMARY KEY (`religion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `religion_master`
--

LOCK TABLES `religion_master` WRITE;
/*!40000 ALTER TABLE `religion_master` DISABLE KEYS */;
INSERT INTO `religion_master` VALUES (1,'Hinduism'),(2,'Islam'),(3,'Christianity'),(4,'Buddhism'),(5,'Sikhism'),(6,'Jainism'),(7,'Zoroastrianism'),(8,'Judaism'),(9,'Atheism'),(10,'Other');
/*!40000 ALTER TABLE `religion_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_master`
--

DROP TABLE IF EXISTS `state_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state_master` (
  `state_id` int NOT NULL AUTO_INCREMENT,
  `state_name` varchar(45) NOT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_master`
--

LOCK TABLES `state_master` WRITE;
/*!40000 ALTER TABLE `state_master` DISABLE KEYS */;
INSERT INTO `state_master` VALUES (1,'Andhra Pradesh'),(2,'Arunachal Pradesh'),(3,'Assam'),(4,'Bihar'),(5,'Chhattisgarh'),(6,'Goa'),(7,'Gujarat'),(8,'Haryana'),(9,'Himachal Pradesh'),(10,'Jharkhand'),(11,'Karnataka'),(12,'Kerala'),(13,'Madhya Pradesh'),(14,'Maharashtra'),(15,'Manipur'),(16,'Meghalaya'),(17,'Mizoram'),(18,'Nagaland'),(19,'Odisha'),(20,'Punjab'),(21,'Rajasthan'),(22,'Sikkim'),(23,'Tamil Nadu'),(24,'Telangana'),(25,'Tripura'),(26,'Uttar Pradesh'),(27,'Uttarakhand'),(28,'West Bengal'),(29,'Andaman and Nicobar Islands'),(30,'Chandigarh'),(31,'Dadra and Nagar Haveli and Daman and Diu'),(32,'Delhi'),(33,'Jammu and Kashmir'),(34,'Ladakh'),(35,'Lakshadweep'),(36,'Puducherry');
/*!40000 ALTER TABLE `state_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `gender_id` int DEFAULT NULL,
  `data_of_birth` date DEFAULT NULL,
  `country_id` int DEFAULT NULL,
  `religion_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `state_id` int DEFAULT NULL,
  `district_id` int DEFAULT NULL,
  `city` varchar(60) DEFAULT NULL,
  `contact_no` varchar(10) DEFAULT NULL,
  `email_id` varchar(100) DEFAULT NULL,
  `aadhar_no` varchar(17) DEFAULT NULL,
  `abc_id` varchar(20) DEFAULT NULL,
  `birth_place` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_detail_master`
--

DROP TABLE IF EXISTS `student_detail_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_detail_master` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `address` varchar(200) NOT NULL,
  `city` varchar(45) NOT NULL,
  `email_id` varchar(45) NOT NULL,
  `contact_no` varchar(45) NOT NULL,
  `aadhar_no` varchar(50) NOT NULL,
  `blood_group` varchar(6) NOT NULL,
  `gender_id` int NOT NULL,
  `religion_id` int NOT NULL,
  `category_id` int NOT NULL,
  `state_id` int NOT NULL,
  `district_id` int NOT NULL,
  `country_id` int NOT NULL,
  `birth_place` varchar(45) NOT NULL,
  `abc_id` varchar(50) NOT NULL,
  `guardian_id` int DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `gender_id_idx` (`gender_id`),
  KEY `religion_id_idx` (`religion_id`),
  KEY `category_id_idx` (`category_id`),
  KEY `state_id_idx` (`state_id`),
  KEY `district_id_idx` (`district_id`),
  KEY `country_id_idx` (`country_id`),
  KEY `guardian_id_idx` (`guardian_id`),
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `category_master` (`category_id`),
  CONSTRAINT `country_id` FOREIGN KEY (`country_id`) REFERENCES `country_master` (`country_id`),
  CONSTRAINT `district_id` FOREIGN KEY (`district_id`) REFERENCES `district_master` (`district_id`),
  CONSTRAINT `gender_id` FOREIGN KEY (`gender_id`) REFERENCES `gender_master` (`gender_id`),
  CONSTRAINT `religion_id` FOREIGN KEY (`religion_id`) REFERENCES `religion_master` (`religion_id`),
  CONSTRAINT `state_id` FOREIGN KEY (`state_id`) REFERENCES `state_master` (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_detail_master`
--

LOCK TABLES `student_detail_master` WRITE;
/*!40000 ALTER TABLE `student_detail_master` DISABLE KEYS */;
INSERT INTO `student_detail_master` VALUES (1000,'Pallavi','Prithviraj ','gond','2025-08-19','nallasopara east','Nallasopara','Pallavigond@gmail.com','8975473753','231345678','A+',2,1,1,14,28,1,'Azamgarh','12345678',0),(1005,'Pallavi','sdfh','cscv','2015-10-01','vrjyuk','asfgj','asvchvch','345678e3456','456899876565','b',1,1,1,14,18,1,'dsvv','35465873412',0),(1007,'xcvxbn','dfxbcvn','zxcvb','2025-10-07','kladsfghj','dfghjkl','sdfghf','dsfghjk','3456789','',3,2,2,14,22,1,'sadfgbn','2134567',0),(1008,'dfghjk','fcgvhbj','fghjk','2025-10-06','hgjklllj','fhgj','dstfghjk','546789','4567890','a',1,1,1,14,23,1,'fghjk','456789',0),(1009,'dfxgchvb','sdcv','zxcv','2025-10-06','ZXcvbnm','dfghvb','xsdfgh','34567567','3546789','a',1,1,1,14,14,1,'xdfg','3456',NULL),(1010,'pakkab','sdcvbn','sdfg','2025-10-07','sdfghjk','Mumbai','asdfghj','345678','4235678348','a',1,1,1,14,14,1,'cvbn','3456',NULL),(1012,'q','q','q','2025-11-11','q','q','q','q','q','q',2,1,1,14,28,1,'q','q',NULL);
/*!40000 ALTER TABLE `student_detail_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_master`
--

DROP TABLE IF EXISTS `users_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_master` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_role` varchar(45) NOT NULL,
  `username` varchar(100) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `created_at` datetime NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_master`
--

LOCK TABLES `users_master` WRITE;
/*!40000 ALTER TABLE `users_master` DISABLE KEYS */;
INSERT INTO `users_master` VALUES (1,'Admin','Pallavi','1234','2025-10-25 00:00:00','login'),(2,'Faculty','faculty','1234','2025-10-31 00:00:00','login');
/*!40000 ALTER TABLE `users_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-13 22:39:25
