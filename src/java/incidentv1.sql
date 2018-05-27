-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 27 Mai 2018 à 19:25
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

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

-- --------------------------------------------------------

--
-- Structure de la table `categorieequipement`
--

CREATE TABLE IF NOT EXISTS `categorieequipement` (
  `ID` bigint(20) NOT NULL,
  `LIBELLE` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
  PRIMARY KEY (`ID`),
  KEY `FK_EMPLOYEE_ENTITEADMINISTRATIVE_ID` (`ENTITEADMINISTRATIVE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
  PRIMARY KEY (`ID`),
  KEY `FK_EXECUTIONPLANPREVENTIF_RESPONSABLE_ID` (`RESPONSABLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
('SEQ_GEN', '0');

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

-- --------------------------------------------------------

--
-- Structure de la table `typeincident`
--

CREATE TABLE IF NOT EXISTS `typeincident` (
  `ID` bigint(20) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
