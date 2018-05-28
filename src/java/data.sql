-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Lun 28 Mai 2018 à 14:38
-- Version du serveur: 5.5.27-log
-- Version de PHP: 5.4.6

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `incidentv1`
--

--
-- Contenu de la table `categoriedelai`
--

INSERT INTO `categoriedelai` (`ID`, `DESCRIPTION`, `NBRHEURE`) VALUES
(154, 'résoudre avant 8 heures', 8),
(155, 'résoudre avant 24 heures', 24),
(156, 'résoudre avant 48 heures', 48);

--
-- Contenu de la table `categorieequipement`
--

INSERT INTO `categorieequipement` (`ID`, `LIBELLE`) VALUES
(108, 'Matériel de réseau informatique'),
(109, 'Matériel de sécurité informatique ');

--
-- Contenu de la table `degreurgence`
--

INSERT INTO `degreurgence` (`ID`, `DEGRE`, `DESCRIPTION`) VALUES
(151, 1, 'haute'),
(152, 2, 'moyenne'),
(153, 3, 'basse');

--
-- Contenu de la table `employee`
--

INSERT INTO `employee` (`ID`, `EMAIL`, `NOM`, `PRENOM`, `TEL`, `ENTITEADMINISTRATIVE_ID`) VALUES
('AE165 118', 'zidani@ocp.ma', 'ZIDANI ', 'MAYSSAE ', '06 56 62 08 44', NULL),
('AE165018', 'maimoun@ocp.ma', 'MAIMOUNI ', 'AIMANE', '06 87 63 02 39', NULL),
('AI177184', 'hmamed@ocp.ma', 'HMAMED ', 'HABIBA', '06 68 02 02 31', NULL),
('CH012114', 'fennane@ocp.ma', 'FENNANE ', 'OUSSAMA', '06 78 60 08 77', NULL),
('CH077788', 'idman@ocp.ma', 'IDMANE ', 'MOHAMED', '06 76 55 54 44', NULL),
('CH154747', 'bakari@ocp.ma', 'BAKRI ', 'SOUKAINA', '06 89 92 08 66', NULL),
('CH154788', 'azize@ocp.ma', 'AZIZE ', 'AZIZE ACHRAF ', '06 98 65 08 77', NULL),
('CH174888', 'aqil@ocp.ma', 'ÂQIL ', 'ASMAE', '06 76 90 05 90', NULL),
('DE164234', 'tyah@ocp.ma', 'TYAH ', 'MOHAMED', '06 63 00 19 76', NULL),
('EE106147', 'mouhoub@ocp.ma', 'MOUHOUB  ', 'REDALLAH', '06 73 16 08 77', NULL),
('EE107887', 'krekeb@ocp.ma', 'KERKEB ', 'YASMINA', '06 76 62 60 04', NULL),
('EE109011', 'jebbari@ocp.ma', 'JEBBARI', 'OTHMANE', '06 76 65 08 06', NULL),
('EE160087', 'aitboumalik@ocp.ma', 'AIT BOUMLIK ', 'OTHMANE', '06 78 16 08 77', NULL),
('EE165487', 'boozaaboun@ocp.ma', 'BOUZAABOUN ', 'ZINEB', '06 37 72 02 39', NULL),
('EQ060147', 'boujandar@ocp.ma', 'BOUJANDAR ', 'AICHA', '06 73 51 08 67', NULL),
('GE102147', 'agerouassi@ocp.ma', 'AGEROUASSI ', 'HAYAM', '06 63 80 09 66', NULL),
('HA177069', 'boussif@ocp.ma', 'BOUSSIF ', 'OUSSAMA', '06 73 60 02 55', NULL),
('HA177159', 'chaquiq@ocp.ma', 'CHAQUIQ ', 'HAMZA', '06 37 72 02 31', NULL),
('HH119750', 'foussoul@ocp.ma', 'FOUSSOUL ', 'AYOUB', '06 78 92 04 77', NULL),
('HH120650', 'moutchou@ocp.ma', 'MOUTCHOU ', 'ZAKARIAE', '06 37 90 24 31', NULL),
('QP147225', 'zarou@ocp.ma', 'ZAROU ', 'ZAROU AYOUB', '06 78 16 50 88', NULL);

--
-- Contenu de la table `entiteadministrative`
--

INSERT INTO `entiteadministrative` (`ID`, `NOM`, `CHEF_ID`, `ENTITEADMINISTRATIVESUPERIEURE_ID`, `TYPEENTITEADMINISTRATIVE_ID`) VALUES
(5, 'Direction marketing', 'CH012114', 8, 1),
(7, 'Direction des exploitations', 'AI177184', 7, 1),
(8, 'Direction des marchés', 'CH174888', 5, 3),
(9, 'Direction d''achats', 'AE165 118', 8, 4);

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

--
-- Contenu de la table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '200');

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

--
-- Contenu de la table `typeentiteadministrative`
--

INSERT INTO `typeentiteadministrative` (`ID`, `LIBELLE`, `NIVEAU`) VALUES
(1, 'pôle chimie', 1),
(2, 'Direction commerciale', 1),
(3, 'pôle finances et support de gestion', 1),
(4, 'pôle approvisionnement et support logistique', 1);

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
