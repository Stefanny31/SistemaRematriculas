-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: banco_de_dados_centralmatriculas
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cadastro_aluno`
--

DROP TABLE IF EXISTS `cadastro_aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadastro_aluno` (
  `Id` int NOT NULL,
  `Id_Usuario_Responsavel` int DEFAULT NULL,
  `Nome` varchar(100) NOT NULL,
  `Sobrenome` varchar(100) NOT NULL,
  `RG` varchar(100) NOT NULL,
  `CPF` varchar(100) NOT NULL,
  `Naturalidade` varchar(100) NOT NULL,
  `Cor/Raça` varchar(100) NOT NULL,
  `Sexo` varchar(100) NOT NULL,
  `Nome_Mãe` varchar(100) NOT NULL,
  `CPF_Mãe` varchar(100) NOT NULL,
  `Nome_Pai` varchar(100) NOT NULL,
  `CPF_Pai` varchar(100) NOT NULL,
  `Nome_Responsavel_Legal` varchar(100) NOT NULL,
  `CPF_Resposavel_Legal` varchar(100) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Cadastro_Aluno_FK` (`Id_Usuario_Responsavel`),
  CONSTRAINT `Cadastro_Aluno_FK` FOREIGN KEY (`Id_Usuario_Responsavel`) REFERENCES `usuario_responsável` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastro_aluno`
--

LOCK TABLES `cadastro_aluno` WRITE;
/*!40000 ALTER TABLE `cadastro_aluno` DISABLE KEYS */;
/*!40000 ALTER TABLE `cadastro_aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadastro_matricula_rematricula`
--

DROP TABLE IF EXISTS `cadastro_matricula_rematricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadastro_matricula_rematricula` (
  `Id` int NOT NULL,
  `Id_Cadastro_aluno` int NOT NULL,
  `Nome_Estudante` varchar(100) NOT NULL,
  `Data_Nascimento` varchar(100) NOT NULL,
  `Dados_Escolaridade` varchar(100) NOT NULL,
  `Turno` varchar(100) NOT NULL,
  `Dados_Adicionais` varchar(100) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Cadastro_Matricula_Rematricula_FK` (`Id_Cadastro_aluno`),
  CONSTRAINT `Cadastro_Matricula_Rematricula_FK` FOREIGN KEY (`Id_Cadastro_aluno`) REFERENCES `cadastro_aluno` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastro_matricula_rematricula`
--

LOCK TABLES `cadastro_matricula_rematricula` WRITE;
/*!40000 ALTER TABLE `cadastro_matricula_rematricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `cadastro_matricula_rematricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `Id` int NOT NULL,
  `Id_Estado` int DEFAULT NULL,
  `Nome` varchar(100) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `cidade_FK` (`Id_Estado`),
  CONSTRAINT `cidade_FK` FOREIGN KEY (`Id_Estado`) REFERENCES `estado` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereço`
--

DROP TABLE IF EXISTS `endereço`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereço` (
  `Id` int NOT NULL,
  `Id_Cidade` int DEFAULT NULL,
  `CEP` varchar(100) NOT NULL,
  `Nome_Rua` varchar(100) NOT NULL,
  `Numero_Residencia` varchar(100) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `endereço_FK` (`Id_Cidade`),
  CONSTRAINT `endereço_FK` FOREIGN KEY (`Id_Cidade`) REFERENCES `cidade` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereço`
--

LOCK TABLES `endereço` WRITE;
/*!40000 ALTER TABLE `endereço` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereço` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `Id` int NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `UF` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_responsável`
--

DROP TABLE IF EXISTS `usuario_responsável`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_responsável` (
  `Id` int NOT NULL,
  `Id_Endereço` int NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Telefone` varchar(100) NOT NULL,
  `Gênero` varchar(100) NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `Usuario_Responsável_FK` FOREIGN KEY (`Id`) REFERENCES `endereço` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_responsável`
--

LOCK TABLES `usuario_responsável` WRITE;
/*!40000 ALTER TABLE `usuario_responsável` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_responsável` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'banco_de_dados_centralmatriculas'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-08 11:45:46
