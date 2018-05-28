-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 29 Mai 2018 à 00:30
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `incidentv1`
--

-- --------------------------------------------------------

--
-- Structure de la table `categoriedelai`
--

CREATE TABLE IF NOT EXISTS `categoriedelai` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NBRHEURE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `categoriedelai`
--

INSERT INTO `categoriedelai` (`ID`, `DESCRIPTION`, `NBRHEURE`) VALUES
(154, 'résoudre avant 8 heures', 8),
(155, 'résoudre avant 24 heures', 24),
(156, 'résoudre avant 48 heures', 48);

-- --------------------------------------------------------

--
-- Structure de la table `categorieequipement`
--

CREATE TABLE IF NOT EXISTS `categorieequipement` (
  `ID` bigint(20) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `categorieequipement`
--

INSERT INTO `categorieequipement` (`ID`, `LIBELLE`) VALUES
(108, 'Matériel de réseau informatique'),
(109, 'Matériel de sécurité informatique ');

-- --------------------------------------------------------

--
-- Structure de la table `degreurgence`
--

CREATE TABLE IF NOT EXISTS `degreurgence` (
  `ID` bigint(20) NOT NULL,
  `DEGRE` int(11) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `degreurgence`
--

INSERT INTO `degreurgence` (`ID`, `DEGRE`, `DESCRIPTION`) VALUES
(151, 1, 'haute'),
(152, 2, 'moyenne'),
(153, 3, 'basse');

-- --------------------------------------------------------

--
-- Structure de la table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `ID` varchar(255) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `TEL` varchar(255) DEFAULT NULL,
  `ENTITEADMINISTRATIVE_ID` bigint(20) DEFAULT NULL,
  `LOGIN` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `BLOCKED` int(1) NOT NULL,
  `NBRCNX` int(1) NOT NULL,
  `MDPCHANGED` smallint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EMPLOYEE_ENTITEADMINISTRATIVE_ID` (`ENTITEADMINISTRATIVE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `employee`
--

INSERT INTO `employee` (`ID`, `EMAIL`, `NOM`, `PRENOM`, `TEL`, `ENTITEADMINISTRATIVE_ID`, `LOGIN`, `PASSWORD`, `BLOCKED`, `NBRCNX`, `MDPCHANGED`) VALUES
('AE165 118', 'zidani@ocp.ma', 'ZIDANI ', 'MAYSSAE ', '06 56 62 08 44', NULL, 'ZIDANI ', 'ZIDANI ', 0, 0, 0),
('AE165018', 'maimoun@ocp.ma', 'MAIMOUNI ', 'AIMANE', '06 87 63 02 39', NULL, 'MAIMOUNI ', 'MAIMOUNI ', 0, 0, 0),
('AI177184', 'hmamed@ocp.ma', 'HMAMED ', 'HABIBA', '06 68 02 02 31', NULL, 'HMAMED ', 'HMAMED ', 0, 0, 0),
('CH012114', 'fennane@ocp.ma', 'FENNANE ', 'OUSSAMA', '06 78 60 08 77', NULL, 'FENNANE ', 'FENNANE ', 0, 0, 0),
('CH077788', 'idman@ocp.ma', 'IDMANE ', 'MOHAMED', '06 76 55 54 44', NULL, 'IDMANE ', 'IDMANE ', 0, 0, 0),
('CH154747', 'bakari@ocp.ma', 'BAKRI ', 'SOUKAINA', '06 89 92 08 66', NULL, 'BAKRI ', 'BAKRI ', 0, 0, 0),
('CH154788', 'azize@ocp.ma', 'AZIZE ', 'AZIZE ACHRAF ', '06 98 65 08 77', NULL, 'AZIZE ', 'AZIZE ', 0, 0, 0),
('CH174888', 'aqil@ocp.ma', 'ÂQIL ', 'ASMAE', '06 76 90 05 90', NULL, 'ÂQIL ', 'ÂQIL ', 0, 0, 0),
('DE164234', 'tyah@ocp.ma', 'TYAH ', 'MOHAMED', '06 63 00 19 76', NULL, 'TYAH ', 'TYAH ', 0, 0, 0),
('EE106147', 'mouhoub@ocp.ma', 'MOUHOUB  ', 'REDALLAH', '06 73 16 08 77', NULL, 'MOUHOUB  ', 'MOUHOUB  ', 0, 0, 0),
('EE107887', 'krekeb@ocp.ma', 'KERKEB ', 'YASMINA', '06 76 62 60 04', NULL, 'KERKEB ', 'KERKEB ', 0, 0, 0),
('EE109011', 'jebbari@ocp.ma', 'JEBBARI', 'OTHMANE', '06 76 65 08 06', NULL, 'JEBBARI', 'JEBBARI', 0, 0, 0),
('EE160087', 'aitboumalik@ocp.ma', 'AIT BOUMLIK ', 'OTHMANE', '06 78 16 08 77', NULL, 'AIT BOUMLIK ', 'AIT BOUMLIK ', 0, 0, 0),
('EE165487', 'boozaaboun@ocp.ma', 'BOUZAABOUN ', 'ZINEB', '06 37 72 02 39', NULL, 'BOUZAABOUN ', 'BOUZAABOUN ', 0, 0, 0),
('EQ060147', 'boujandar@ocp.ma', 'BOUJANDAR ', 'AICHA', '06 73 51 08 67', NULL, 'BOUJANDAR ', 'BOUJANDAR ', 0, 0, 0),
('GE102147', 'agerouassi@ocp.ma', 'AGEROUASSI ', 'HAYAM', '06 63 80 09 66', NULL, 'AGEROUASSI ', 'AGEROUASSI ', 0, 0, 0),
('HA177069', 'boussif@ocp.ma', 'BOUSSIF ', 'OUSSAMA', '06 73 60 02 55', NULL, 'BOUSSIF ', 'BOUSSIF ', 0, 0, 0),
('HA177159', 'chaquiq@ocp.ma', 'CHAQUIQ ', 'HAMZA', '06 37 72 02 31', NULL, 'CHAQUIQ ', 'CHAQUIQ ', 0, 0, 0),
('HH119750', 'foussoul@ocp.ma', 'FOUSSOUL ', 'AYOUB', '06 78 92 04 77', NULL, 'FOUSSOUL ', 'FOUSSOUL ', 0, 0, 0),
('HH120650', 'moutchou@ocp.ma', 'MOUTCHOU ', 'ZAKARIAE', '06 37 90 24 31', NULL, 'MOUTCHOU ', 'MOUTCHOU ', 0, 0, 0),
('QP147225', 'zarou@ocp.ma', 'ZAROU ', 'ZAROU AYOUB', '06 78 16 50 88', NULL, 'ZAROU ', 'ZAROU ', 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `entiteadministrative`
--

CREATE TABLE IF NOT EXISTS `entiteadministrative` (
  `ID` bigint(20) NOT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `CHEF_ID` varchar(255) DEFAULT NULL,
  `ENTITEADMINISTRATIVESUPERIEURE_ID` bigint(20) DEFAULT NULL,
  `TYPEENTITEADMINISTRATIVE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `NTITEADMINISTRATIVENTITEADMINISTRATIVESUPERIEUREID` (`ENTITEADMINISTRATIVESUPERIEURE_ID`),
  KEY `ENTITEADMINISTRATIVE_TYPEENTITEADMINISTRATIVE_ID` (`TYPEENTITEADMINISTRATIVE_ID`),
  KEY `FK_ENTITEADMINISTRATIVE_CHEF_ID` (`CHEF_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `entiteadministrative`
--

INSERT INTO `entiteadministrative` (`ID`, `NOM`, `CHEF_ID`, `ENTITEADMINISTRATIVESUPERIEURE_ID`, `TYPEENTITEADMINISTRATIVE_ID`) VALUES
(5, 'Direction marketing', 'CH012114', 8, 1),
(7, 'Direction des exploitations', 'AI177184', 7, 1),
(8, 'Direction des marchés', 'CH174888', 5, 3),
(9, 'Direction d''achats', 'AE165 118', 8, 4);

-- --------------------------------------------------------

--
-- Structure de la table `equipement`
--

CREATE TABLE IF NOT EXISTS `equipement` (
  `ID` varchar(255) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `CATEGORIEEQUIPEMENT_ID` bigint(20) DEFAULT NULL,
  `FOURNISSEUR_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EQUIPEMENT_CATEGORIEEQUIPEMENT_ID` (`CATEGORIEEQUIPEMENT_ID`),
  KEY `FK_EQUIPEMENT_FOURNISSEUR_ID` (`FOURNISSEUR_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `equipement`
--

INSERT INTO `equipement` (`ID`, `LIBELLE`, `CATEGORIEEQUIPEMENT_ID`, `FOURNISSEUR_ID`) VALUES
('sn°4510587', 'carte graphique', 109, 105),
('sn°5412587', 'carte mère', 109, 103),
('sn°5414581', 'clavier', 109, 103),
('sn°5418847', 'logiciel', 108, 107),
('sn°5464887', 'microprocesseur', 109, 102),
('sn°55842150007', 'Disque Dur ', 109, 103),
('sn°6912587', 'PC portable', 109, 107),
('sn°6916007', 'poste de travail', 109, 105);

-- --------------------------------------------------------

--
-- Structure de la table `executionplanpreventif`
--

CREATE TABLE IF NOT EXISTS `executionplanpreventif` (
  `ID` bigint(20) NOT NULL,
  `DATEDEPART` date DEFAULT NULL,
  `DATEFIN` date DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `RESPONSABLE_ID` varchar(255) DEFAULT NULL,
  `PLANPREVENTIF_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EXECUTIONPLANPREVENTIF_RESPONSABLE_ID` (`RESPONSABLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `executionplanpreventif`
--

INSERT INTO `executionplanpreventif` (`ID`, `DATEDEPART`, `DATEFIN`, `DESCRIPTION`, `RESPONSABLE_ID`, `PLANPREVENTIF_ID`) VALUES
(1, '2018-05-17', '2018-05-04', 'flousss', 'AE165 118', 1);

-- --------------------------------------------------------

--
-- Structure de la table `executionplanpreventifitem`
--

CREATE TABLE IF NOT EXISTS `executionplanpreventifitem` (
  `ID` bigint(20) NOT NULL,
  `DATEDEPART` date DEFAULT NULL,
  `DATEFIN` date DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `EQUIPEMENT_ID` varchar(255) DEFAULT NULL,
  `EXECUTIONPLANPREVENTIF_ID` bigint(20) DEFAULT NULL,
  `RESPONSABLE_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `EXECUTIONPLANPREVENTIFITEMEXECUTIONPLANPREVENTIFID` (`EXECUTIONPLANPREVENTIF_ID`),
  KEY `FK_EXECUTIONPLANPREVENTIFITEM_RESPONSABLE_ID` (`RESPONSABLE_ID`),
  KEY `FK_EXECUTIONPLANPREVENTIFITEM_EQUIPEMENT_ID` (`EQUIPEMENT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `executionplanpreventifitem`
--

INSERT INTO `executionplanpreventifitem` (`ID`, `DATEDEPART`, `DATEFIN`, `DESCRIPTION`, `EQUIPEMENT_ID`, `EXECUTIONPLANPREVENTIF_ID`, `RESPONSABLE_ID`) VALUES
(54, '2018-05-16', '2018-05-25', '9siweraaaaghiweraaaaaaa', 'sn°5464887', 1, 'AI177184'),
(53, '2018-05-16', '2018-05-25', 'sghiweraaaaaaa', 'sn°5414581', 1, 'AI177184');

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE IF NOT EXISTS `fournisseur` (
  `ID` bigint(20) NOT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `RC` varchar(255) DEFAULT NULL,
  `SIEGE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `fournisseur`
--

INSERT INTO `fournisseur` (`ID`, `NOM`, `RC`, `SIEGE`) VALUES
(102, 'SISCO', 'N°3000D00150', 'casa'),
(103, 'Network', 'N°3000D00456', 'fes'),
(104, 'PC TECH', 'N°2050E01450', 'casablanca'),
(105, 'DELL', 'N°2050E01450', 'tanger'),
(106, 'E2S', 'N°2050S69450', 'agadir'),
(107, 'TEKOS', 'N°6050t00150', 'casablanca');

-- --------------------------------------------------------

--
-- Structure de la table `incident`
--

CREATE TABLE IF NOT EXISTS `incident` (
  `ID` bigint(20) NOT NULL,
  `DATEINCIDENT` date DEFAULT NULL,
  `DATEVALIDATION` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ETAT` int(11) DEFAULT NULL,
  `EMPLOYEEDECLARANT_ID` varchar(255) DEFAULT NULL,
  `TYPEINCIDENT_ID` bigint(20) DEFAULT NULL,
  `VALIDATEUR_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_INCIDENT_VALIDATEUR_ID` (`VALIDATEUR_ID`),
  KEY `FK_INCIDENT_EMPLOYEEDECLARANT_ID` (`EMPLOYEEDECLARANT_ID`),
  KEY `FK_INCIDENT_TYPEINCIDENT_ID` (`TYPEINCIDENT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `incident`
--

INSERT INTO `incident` (`ID`, `DATEINCIDENT`, `DATEVALIDATION`, `DESCRIPTION`, `ETAT`, `EMPLOYEEDECLARANT_ID`, `TYPEINCIDENT_ID`, `VALIDATEUR_ID`) VALUES
(1, '2018-05-11', NULL, 'ggg', 1, 'AE165 118', 52, NULL),
(2, '2018-06-07', NULL, '', 2, 'AE165018', 53, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `incidentitem`
--

CREATE TABLE IF NOT EXISTS `incidentitem` (
  `ID` bigint(20) NOT NULL,
  `DATETRAITEMENT` datetime DEFAULT NULL,
  `CATEGORIEDELAI_ID` bigint(20) DEFAULT NULL,
  `DEGREURGENCE_ID` bigint(20) DEFAULT NULL,
  `EQUIPEMENT_ID` varchar(255) DEFAULT NULL,
  `INCIDENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_INCIDENTITEM_INCIDENT_ID` (`INCIDENT_ID`),
  KEY `FK_INCIDENTITEM_EQUIPEMENT_ID` (`EQUIPEMENT_ID`),
  KEY `FK_INCIDENTITEM_DEGREURGENCE_ID` (`DEGREURGENCE_ID`),
  KEY `FK_INCIDENTITEM_CATEGORIEDELAI_ID` (`CATEGORIEDELAI_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `incidentitem`
--

INSERT INTO `incidentitem` (`ID`, `DATETRAITEMENT`, `CATEGORIEDELAI_ID`, `DEGREURGENCE_ID`, `EQUIPEMENT_ID`, `INCIDENT_ID`) VALUES
(2, '2018-05-18 00:00:00', 156, 153, 'sn°5414581', 1),
(1, '2018-05-08 00:00:00', 155, 152, 'sn°5418847', 1),
(4, '2018-05-16 00:00:00', 154, 153, 'sn°5414581', 2),
(3, '2018-05-16 00:00:00', 154, 151, 'sn°4510587', 2);

-- --------------------------------------------------------

--
-- Structure de la table `planpreventif`
--

CREATE TABLE IF NOT EXISTS `planpreventif` (
  `ID` bigint(20) NOT NULL,
  `DATEDEPART` date DEFAULT NULL,
  `DATEFIN` date DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `RESPONSABLE_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PLANPREVENTIF_RESPONSABLE_ID` (`RESPONSABLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `planpreventif`
--

INSERT INTO `planpreventif` (`ID`, `DATEDEPART`, `DATEFIN`, `DESCRIPTION`, `RESPONSABLE_ID`) VALUES
(1, '2018-05-10', '2018-05-04', 'nhhh', 'AE165 118');

-- --------------------------------------------------------

--
-- Structure de la table `planpreventifitem`
--

CREATE TABLE IF NOT EXISTS `planpreventifitem` (
  `ID` bigint(20) NOT NULL,
  `DATEDEPART` date DEFAULT NULL,
  `DATEFIN` date DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `CATEGORIEEQUIPEMENT_ID` bigint(20) DEFAULT NULL,
  `PLANPREVENTIF_ID` bigint(20) DEFAULT NULL,
  `RESPONSABLE_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PLANPREVENTIFITEM_RESPONSABLE_ID` (`RESPONSABLE_ID`),
  KEY `FK_PLANPREVENTIFITEM_CATEGORIEEQUIPEMENT_ID` (`CATEGORIEEQUIPEMENT_ID`),
  KEY `FK_PLANPREVENTIFITEM_PLANPREVENTIF_ID` (`PLANPREVENTIF_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `planpreventifitem`
--

INSERT INTO `planpreventifitem` (`ID`, `DATEDEPART`, `DATEFIN`, `DESCRIPTION`, `CATEGORIEEQUIPEMENT_ID`, `PLANPREVENTIF_ID`, `RESPONSABLE_ID`) VALUES
(52, '2019-05-03', '2019-05-23', 'oummmmm', 108, 1, 'CH012114'),
(51, '2018-05-03', '2018-05-23', 'jsjsj', 109, 1, 'AE165 118');

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '100');

-- --------------------------------------------------------

--
-- Structure de la table `technicien`
--

CREATE TABLE IF NOT EXISTS `technicien` (
  `ID` bigint(20) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `TEL` varchar(255) DEFAULT NULL,
  `ENTITEADMINISTRATIVE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TECHNICIEN_ENTITEADMINISTRATIVE_ID` (`ENTITEADMINISTRATIVE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `technicien`
--

INSERT INTO `technicien` (`ID`, `EMAIL`, `NOM`, `PRENOM`, `TEL`, `ENTITEADMINISTRATIVE_ID`) VALUES
(1, 'moro@ocp.ma', 'MORO ', 'KHALID', '06 87 50 03 46', NULL),
(2, 'kritet@opc.ma', 'KRITET ', 'YOUSSEF', '06 68 42 01 55', NULL),
(3, 'tbatou@ocp.ma', 'TBATOU ', 'AYOUB', '06 63 40 26 30', NULL),
(4, 'oublouhou@ocp.ma', 'OUBLOUHOU ', 'HANANE ', '06 67 92 06 88', NULL),
(5, 'wamra@ocp.ma', 'WAMRA ', 'HAYAT', '06 79 21 50 14', NULL),
(6, 'yakoubi@ocp.ma', 'YAKOUBI ', 'MOAD', '06 62 84 12 15', NULL),
(7, 'maachou@ocp.ma', 'MAACHOU ', 'MAROUANE', '06 63 58 92 06', NULL),
(8, 'tanane@ocp.ma', 'TANANE ', 'BADREDDINE', '06 79 64 25 18', NULL),
(9, 'bodor@ocp.ma', 'BODOR ', 'HAMZA', '06 77 62 08 22', NULL),
(10, 'menai@ocp.ma', 'MENAI ', 'NABIL', '06 79 21 05 41', NULL),
(11, 'afa@ocp.ma', 'AFA ', 'ABDELILAH', '06 65 90 20 29', NULL),
(12, 'gharbi@ocp.ma', 'GHARBI ', 'AYMAN', '06 76 12 62 30', NULL),
(13, 'fafe@ocp.ma', 'FAFE ', 'SOUFIANE', '06 78 50 21 45', NULL),
(14, 'alouane@ocp.ma', 'ALOUANE ', 'AHMED TAHA', '06 78 94 06 45', NULL),
(15, 'tabti@ocp.ma', 'TABTI ', 'HAFSAE', '06 65 12 00 00', NULL),
(164132, 'kerroumi@ocp.ma', 'KERROUMI ', 'MOHAMED', '06 87 50 03 46', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `traitementincident`
--

CREATE TABLE IF NOT EXISTS `traitementincident` (
  `ID` bigint(20) NOT NULL,
  `DATETRAITEMENT` date DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ETAT` int(11) DEFAULT NULL,
  `INCIDENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TRAITEMENTINCIDENT_INCIDENT_ID` (`INCIDENT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `traitementincident`
--

INSERT INTO `traitementincident` (`ID`, `DATETRAITEMENT`, `DESCRIPTION`, `ETAT`, `INCIDENT_ID`) VALUES
(1, '2018-05-10', 'lolo', 2, 1),
(2, '2018-07-24', 'mpmp', 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `traitementincidentitem`
--

CREATE TABLE IF NOT EXISTS `traitementincidentitem` (
  `ID` bigint(20) NOT NULL,
  `DATETRAITEMENT` datetime DEFAULT NULL,
  `ETAT` int(11) DEFAULT NULL,
  `EQUIPEMENT_ID` varchar(255) DEFAULT NULL,
  `TECHNICIEN_ID` bigint(20) DEFAULT NULL,
  `TRAITEMENTINCIDENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TRAITEMENTINCIDENTITEM_TRAITEMENTINCIDENT_ID` (`TRAITEMENTINCIDENT_ID`),
  KEY `FK_TRAITEMENTINCIDENTITEM_EQUIPEMENT_ID` (`EQUIPEMENT_ID`),
  KEY `FK_TRAITEMENTINCIDENTITEM_TECHNICIEN_ID` (`TECHNICIEN_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `traitementincidentitem`
--

INSERT INTO `traitementincidentitem` (`ID`, `DATETRAITEMENT`, `ETAT`, `EQUIPEMENT_ID`, `TECHNICIEN_ID`, `TRAITEMENTINCIDENT_ID`) VALUES
(6, '2018-05-22 00:00:00', 2, 'sn°5414581', 3, 1),
(5, '2018-05-23 00:00:00', 2, 'sn°5412587', 2, 1),
(8, '2018-05-24 00:00:00', 1, 'sn°5418847', 4, 2),
(7, '2018-05-16 00:00:00', 1, 'sn°5412587', 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `typeentiteadministrative`
--

CREATE TABLE IF NOT EXISTS `typeentiteadministrative` (
  `ID` bigint(20) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `NIVEAU` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `typeentiteadministrative`
--

INSERT INTO `typeentiteadministrative` (`ID`, `LIBELLE`, `NIVEAU`) VALUES
(1, 'pôle chimie', 1),
(2, 'Direction commerciale', 1),
(3, 'pôle finances et support de gestion', 1),
(4, 'pôle approvisionnement et support logistique', 1);

-- --------------------------------------------------------

--
-- Structure de la table `typeincident`
--

CREATE TABLE IF NOT EXISTS `typeincident` (
  `ID` bigint(20) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `typeincident`
--

INSERT INTO `typeincident` (`ID`, `LIBELLE`) VALUES
(51, 'panne'),
(52, 'degradation'),
(53, 'Perte de données'),
(54, 'Panne d’électricité'),
(55, 'incendie'),
(56, 'explosion');
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
