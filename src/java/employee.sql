-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Lun 28 Mai 2018 à 18:06
-- Version du serveur: 5.5.27-log
-- Version de PHP: 5.4.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `incidentv1`
--

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
  `MDPCHANGED` int(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EMPLOYEE_ENTITEADMINISTRATIVE_ID` (`ENTITEADMINISTRATIVE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `employee`
--

INSERT INTO `employee` (`ID`, `EMAIL`, `NOM`, `PRENOM`, `TEL`, `ENTITEADMINISTRATIVE_ID`, `LOGIN`, `PASSWORD`, `BLOCKED`, `NBRCNX`, `MDPCHANGED`) VALUES
('AE165 118', 'zidani@ocp.ma', 'ZIDANI ', 'MAYSSAE ', '06 56 62 08 44', NULL, 'ibtissam', 'intissam', 0, 0, 0),
('AE165018', 'maimoun@ocp.ma', 'MAIMOUNI ', 'AIMANE', '06 87 63 02 39', NULL, '', '', 0, 0, 0),
('AI177184', 'hmamed@ocp.ma', 'HMAMED ', 'HABIBA', '06 68 02 02 31', NULL, '', '', 0, 0, 0),
('CH012114', 'fennane@ocp.ma', 'FENNANE ', 'OUSSAMA', '06 78 60 08 77', NULL, '', '', 0, 0, 0),
('CH077788', 'idman@ocp.ma', 'IDMANE ', 'MOHAMED', '06 76 55 54 44', NULL, '', '', 0, 0, 0),
('CH154747', 'bakari@ocp.ma', 'BAKRI ', 'SOUKAINA', '06 89 92 08 66', NULL, '', '', 0, 0, 0),
('CH154788', 'azize@ocp.ma', 'AZIZE ', 'AZIZE ACHRAF ', '06 98 65 08 77', NULL, '', '', 0, 0, 0),
('CH174888', 'aqil@ocp.ma', 'ÂQIL ', 'ASMAE', '06 76 90 05 90', NULL, '', '', 0, 0, 0),
('DE164234', 'tyah@ocp.ma', 'TYAH ', 'MOHAMED', '06 63 00 19 76', NULL, '', '', 0, 0, 0),
('EE106147', 'mouhoub@ocp.ma', 'MOUHOUB  ', 'REDALLAH', '06 73 16 08 77', NULL, '', '', 0, 0, 0),
('EE107887', 'krekeb@ocp.ma', 'KERKEB ', 'YASMINA', '06 76 62 60 04', NULL, '', '', 0, 0, 0),
('EE109011', 'jebbari@ocp.ma', 'JEBBARI', 'OTHMANE', '06 76 65 08 06', NULL, '', '', 0, 0, 0),
('EE160087', 'aitboumalik@ocp.ma', 'AIT BOUMLIK ', 'OTHMANE', '06 78 16 08 77', NULL, '', '', 0, 0, 0),
('EE165487', 'boozaaboun@ocp.ma', 'BOUZAABOUN ', 'ZINEB', '06 37 72 02 39', NULL, '', '', 0, 0, 0),
('EQ060147', 'boujandar@ocp.ma', 'BOUJANDAR ', 'AICHA', '06 73 51 08 67', NULL, '', '', 0, 0, 0),
('GE102147', 'agerouassi@ocp.ma', 'AGEROUASSI ', 'HAYAM', '06 63 80 09 66', NULL, '', '', 0, 0, 0),
('HA177069', 'boussif@ocp.ma', 'BOUSSIF ', 'OUSSAMA', '06 73 60 02 55', NULL, '', '', 0, 0, 0),
('HA177159', 'chaquiq@ocp.ma', 'CHAQUIQ ', 'HAMZA', '06 37 72 02 31', NULL, '', '', 0, 0, 0),
('HH119750', 'foussoul@ocp.ma', 'FOUSSOUL ', 'AYOUB', '06 78 92 04 77', NULL, '', '', 0, 0, 0),
('HH120650', 'moutchou@ocp.ma', 'MOUTCHOU ', 'ZAKARIAE', '06 37 90 24 31', NULL, '', '', 0, 0, 0),
('QP147225', 'zarou@ocp.ma', 'ZAROU ', 'ZAROU AYOUB', '06 78 16 50 88', NULL, '', '', 0, 0, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
