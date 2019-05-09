-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 09 mai 2019 à 11:01
-- Version du serveur :  5.7.23
-- Version de PHP :  7.0.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

drop database if exists autoecole;
create database autoecole;
  use autoecole;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `autoecole`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `archive_voit`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `archive_voit` ()  begin
  declare fini int default 0;
  declare nbreKmVoit, id int;
   declare curv cursor for select numVoit, nbreKmVoit from voiture;
   declare continue handler for not found set fini = 1;
   open curv; 
   fetch curv into id, nbreKmVoit;
   while fini != 1
   do 
   if nbreKmVoit > 500000
   then
    insert into ArchiveVoiture select * from voiture where numVoit = id;
      delete from voiture where numVoit = id;
      end if ;
    fetch curv into id, nbreKmVoit;
end while;
close curv;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `archivevoiture`
--

DROP TABLE IF EXISTS `archivevoiture`;
CREATE TABLE IF NOT EXISTS `archivevoiture` (
  `numVoit` int(6) NOT NULL AUTO_INCREMENT,
  `modeleVoiture` varchar(255) DEFAULT NULL,
  `numImmatriVoit` varchar(15) DEFAULT NULL,
  `dateAchatVoit` date DEFAULT NULL,
  `nbreKmVoit` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`numVoit`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `numCli` int(10) NOT NULL AUTO_INCREMENT,
  `nomCli` varchar(100) DEFAULT NULL,
  `mdpCli` varchar(100) DEFAULT NULL,
  `emailCli` varchar(100) DEFAULT NULL,
  `telCli` varchar(50) DEFAULT NULL,
  `adresseCli` varchar(100) DEFAULT NULL,
  `typeCli` enum('Etudiant','Autre') NOT NULL,
  `nbLecon` varchar(3) DEFAULT NULL,
  `dateNaissanceCli` date DEFAULT NULL,
  `dateInscription` date DEFAULT NULL,
  `reglement_code` tinyint(1) DEFAULT NULL,
  `reglement_permis` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`numCli`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`numCli`, `nomCli`, `mdpCli`, `emailCli`, `telCli`, `adresseCli`, `typeCli`, `nbLecon`, `dateNaissanceCli`, `dateInscription`, `reglement_code`, `reglement_permis`) VALUES
(1, 'Pierre Barrere', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'barrerepierre0705@gmail.com', '0698099845', '20 rue de gentilly, 92120, Montrouge', 'Etudiant', '1', '1999-07-05', '2019-01-08', NULL, NULL),
(11, 'Dennis Ritchie', '51eac6b471a284d3341d8c0c63d0f1a286262a18', 'barrerepierre070599@gmail.com', '0687984565', '11 rue de la tour', 'Etudiant', '1', '1993-06-17', '2018-11-13', 1, NULL),
(12, 'Marc Moreau', 'fc1200c7a7aa52109d762a9f005b149abef01479', 'marc.moreau@yahoo.fr', '0198746541', '15 rue de Paris', 'Autre', '1', '1987-07-18', '2018-12-18', 1, 1),
(13, 'Dennis Debout', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'a@gmail.com', '064987456', '20 rue de paris', 'Etudiant', '1', '1991-05-07', '2019-04-02', NULL, NULL),
(14, '123', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'b@gmail.com', '123', '123', 'Autre', '1', '1990-05-07', '2019-01-11', NULL, NULL),
(15, '123', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'c@gmail.com', '123', '123', 'Autre', '1', '1999-03-12', '2018-12-13', NULL, NULL),
(16, '123', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'd@gmail.com', '123', '123', 'Etudiant', '1', '1985-09-08', '2019-02-13', NULL, NULL),
(17, '123', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'e@gmail.com', '123', '123', 'Autre', '1', '1996-06-05', '2019-04-19', NULL, NULL),
(18, '123', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'f@gmail.com', '123', '123', 'Autre', '1', '1999-05-07', '2019-01-16', NULL, NULL),
(19, '123', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'g@gmail.com', '123', '123', 'Autre', '1', '1999-05-07', '2019-03-21', NULL, NULL),
(20, 'James Gosling', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'ab@gmail.com', '123', '123', 'Autre', '0', '1999-05-07', '2019-02-12', NULL, NULL),
(21, 'Debout', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'abc@gmail.com', '123', '123', 'Autre', '0', '1999-05-07', '2019-04-18', NULL, NULL),
(22, '123', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'bb@gmail.com', '123', '123', 'Autre', '0', '1999-05-07', '2019-04-18', NULL, NULL),
(26, '123', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'abcd@gmail.com', '123', '123', 'Etudiant', '1', '1999-05-07', '2019-04-19', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `code`
--

DROP TABLE IF EXISTS `code`;
CREATE TABLE IF NOT EXISTS `code` (
  `numCode` int(6) NOT NULL AUTO_INCREMENT,
  `contenuExamCode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`numCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `lecon`
--

DROP TABLE IF EXISTS `lecon`;
CREATE TABLE IF NOT EXISTS `lecon` (
  `numLec` int(6) NOT NULL AUTO_INCREMENT,
  `intituleLec` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numLec`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `lecon`
--

INSERT INTO `lecon` (`numLec`, `intituleLec`) VALUES
(1, 'Lecon au code'),
(2, 'Lecon de conduite');

-- --------------------------------------------------------

--
-- Structure de la table `mois`
--

DROP TABLE IF EXISTS `mois`;
CREATE TABLE IF NOT EXISTS `mois` (
  `numMois` int(2) NOT NULL AUTO_INCREMENT,
  `annee` int(4) DEFAULT NULL,
  PRIMARY KEY (`numMois`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `moniteur`
--

DROP TABLE IF EXISTS `moniteur`;
CREATE TABLE IF NOT EXISTS `moniteur` (
  `numMon` int(6) NOT NULL AUTO_INCREMENT,
  `nomMon` varchar(25) DEFAULT NULL,
  `telMon` varchar(50) DEFAULT NULL,
  `mailMon` varchar(100) DEFAULT NULL,
  `mdp` varchar(255) DEFAULT NULL,
  `dateEmbMon` date DEFAULT NULL,
  `dispoMon` int(1) DEFAULT NULL,
  `nbLecon` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`numMon`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `moniteur`
--

INSERT INTO `moniteur` (`numMon`, `nomMon`, `telMon`, `mailMon`, `mdp`, `dateEmbMon`, `dispoMon`, `nbLecon`) VALUES
(1, 'Jacques Dutronc', '06 45 65 45 78', 'a@gmail.com', '123', '2019-11-11', 1, '1'),
(2, 'Denis Dupont', '06 45 65 45 78', 'b@gmail.com', '123', '2019-08-06', 1, '2'),
(3, 'Pierre Bangalter', '06 45 65 45 78', 'c@gmail.com', '123', '2020-10-05', 1, '1'),
(4, 'Marcel Patulacci', '06 45 65 45 78', 'd@gmail.com', '123', '2019-07-12', 1, '1'),
(5, 'Jean-Pierre Avidol', '06 45 65 45 78', 'e@gmail.com', '123', '2019-02-07', 1, '1'),
(6, 'Alexandre Durand', '06 45 65 45 78', 'f@gmail.com', '123', '2019-08-25', 1, '1'),
(7, 'Nicolas Dupieux', '06 45 65 45 78', 'g@gmail.com', '123', '2019-05-21', 1, '1'),
(8, 'Remi Denis', '06 45 65 45 78', 'h@gmail.com', '123', '2019-04-21', 1, '1'),
(9, 'Patrick Frank', '06 45 65 45 78', 'i@gmail.com', '123', '2019-11-18', 1, '1'),
(10, 'Marco Polo', '06 45 65 45 78', 'j@gmail.com', '123', '2019-01-29', 1, '1');

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `nbinscriptions`
-- (Voir ci-dessous la vue réelle)
--
DROP VIEW IF EXISTS `nbinscriptions`;
CREATE TABLE IF NOT EXISTS `nbinscriptions` (
`typeCli` enum('Etudiant','Autre')
,`mois` varchar(67)
,`nbInscriptions` bigint(21)
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `nombrecandidats`
-- (Voir ci-dessous la vue réelle)
--
DROP VIEW IF EXISTS `nombrecandidats`;
CREATE TABLE IF NOT EXISTS `nombrecandidats` (
`Nb` bigint(21)
);

-- --------------------------------------------------------

--
-- Structure de la table `passerc`
--

DROP TABLE IF EXISTS `passerc`;
CREATE TABLE IF NOT EXISTS `passerc` (
  `dateHeureExam` datetime DEFAULT NULL,
  `resultatsCode` varchar(20) DEFAULT NULL,
  `numCode` int(6) NOT NULL,
  `numCli` int(6) NOT NULL,
  PRIMARY KEY (`numCode`,`numCli`),
  KEY `numCli` (`numCli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `passerp`
--

DROP TABLE IF EXISTS `passerp`;
CREATE TABLE IF NOT EXISTS `passerp` (
  `dateHeureExam` datetime DEFAULT NULL,
  `resultatsPermis` varchar(20) NOT NULL,
  `numPermis` int(6) NOT NULL,
  `numCli` int(6) NOT NULL,
  PRIMARY KEY (`numPermis`,`numCli`),
  KEY `numCli` (`numCli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `permis`
--

DROP TABLE IF EXISTS `permis`;
CREATE TABLE IF NOT EXISTS `permis` (
  `numPermis` int(6) NOT NULL AUTO_INCREMENT,
  `adressePermis` varchar(40) DEFAULT NULL,
  `codePostPermis` int(10) DEFAULT NULL,
  `villePermis` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`numPermis`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `permis`
--

INSERT INTO `permis` (`numPermis`, `adressePermis`, `codePostPermis`, `villePermis`) VALUES
(1, '10 rue de la tour', 92120, 'Montrouge');

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

DROP TABLE IF EXISTS `planning`;
CREATE TABLE IF NOT EXISTS `planning` (
  `numHoraire` int(6) NOT NULL AUTO_INCREMENT,
  `dateLec` date DEFAULT NULL,
  `heuredebut` time DEFAULT NULL,
  `heurefin` time DEFAULT NULL,
  `etat` varchar(20) DEFAULT NULL,
  `numMon` int(6) DEFAULT NULL,
  `numLec` int(6) DEFAULT NULL,
  `numVoit` int(6) DEFAULT NULL,
  `numCli` int(6) DEFAULT NULL,
  PRIMARY KEY (`numHoraire`),
  KEY `numCli` (`numCli`),
  KEY `numVoit` (`numVoit`),
  KEY `numMon` (`numMon`),
  KEY `numLec` (`numLec`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `planning`
--

INSERT INTO `planning` (`numHoraire`, `dateLec`, `heuredebut`, `heurefin`, `etat`, `numMon`, `numLec`, `numVoit`, `numCli`) VALUES
(15, '2019-04-29', '10:00:00', '12:00:00', 'En cours', 9, 1, NULL, 14),
(16, '2019-04-29', '10:00:00', '12:00:00', 'En cours', 8, 1, NULL, 15),
(17, '2019-04-29', '10:00:00', '12:00:00', 'En cours', 6, 1, NULL, 16),
(18, '2019-04-29', '10:00:00', '12:00:00', 'En cours', 4, 1, NULL, 17),
(19, '2019-04-29', '10:00:00', '12:00:00', 'En cours', 2, 1, NULL, 18),
(21, '2019-04-29', '10:00:00', '12:00:00', 'En cours', 5, 1, NULL, 19),
(22, '2019-04-29', '10:00:00', '12:00:00', 'En cours', 10, 1, NULL, 13),
(23, '2019-04-29', '10:00:00', '12:00:00', 'En cours', 1, 1, NULL, 11),
(24, '2019-04-29', '10:00:00', '12:00:00', 'En cours', 3, 1, NULL, 1),
(25, '2019-04-29', '10:00:00', '12:00:00', 'En cours', 7, 1, NULL, 12),
(26, '2019-04-28', '15:00:00', '17:00:00', 'En cours', 2, 1, NULL, 26);

--
-- Déclencheurs `planning`
--
DROP TRIGGER IF EXISTS `decre`;
DELIMITER $$
CREATE TRIGGER `decre` AFTER DELETE ON `planning` FOR EACH ROW begin
            update client set nbLecon = nbLecon - 1 where numCli = old.numCli;
            update moniteur set nbLecon = nbLecon - 1 where numMon = old.numMon;
            end
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `incre`;
DELIMITER $$
CREATE TRIGGER `incre` AFTER INSERT ON `planning` FOR EACH ROW begin
      update client set nbLecon = nbLecon + 1 where numCli = new.numCli;
      update moniteur set nbLecon = nbLecon + 1 where numMon = new.numMon;
      end
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `random`;
DELIMITER $$
CREATE TRIGGER `random` BEFORE INSERT ON `planning` FOR EACH ROW BEGIN
  
  IF ( NEW.numMon IS NULL ) THEN
            SELECT COUNT(*) INTO @dispo
    FROM
      moniteur M
        LEFT JOIN planning P
          ON M.numMon = P.numMon
          AND P.dateLec = NEW.dateLec
          AND P.heuredebut = NEW.heuredebut
    WHERE P.numMon IS NULL;
    
    IF @dispo > 0 THEN
                  SET NEW.numMon = (
        SELECT M.numMon
        FROM
          moniteur M
            LEFT JOIN planning P
              ON M.numMon = P.numMon
              AND P.dateLec = NEW.dateLec
              AND P.heuredebut = NEW.heuredebut
        WHERE P.numMon IS NULL
        ORDER BY RAND()
        LIMIT 1
      );
    ELSE
            SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Aucun moniteur disponible sur ce créneau';
    END IF;
  END IF;
  
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `rouler`
--

DROP TABLE IF EXISTS `rouler`;
CREATE TABLE IF NOT EXISTS `rouler` (
  `numMois` int(2) NOT NULL,
  `numVoit` int(6) NOT NULL,
  PRIMARY KEY (`numMois`,`numVoit`),
  KEY `numVoit` (`numVoit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

DROP TABLE IF EXISTS `voiture`;
CREATE TABLE IF NOT EXISTS `voiture` (
  `numVoit` int(6) NOT NULL AUTO_INCREMENT,
  `modeleVoiture` varchar(255) DEFAULT NULL,
  `numImmatriVoit` varchar(15) DEFAULT NULL,
  `dateAchatVoit` date DEFAULT NULL,
  `nbreKmVoit` int(15) DEFAULT NULL,
  PRIMARY KEY (`numVoit`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `voiture`
--

INSERT INTO `voiture` (`numVoit`, `modeleVoiture`, `numImmatriVoit`, `dateAchatVoit`, `nbreKmVoit`) VALUES
(1, 'Citroen C3', '54652', '2012-09-09', 12000),
(2, 'Peugeot 208 Active', '98754687', '2018-04-09', 30000),
(3, 'Renault Clio IV', '8976531', '2010-05-07', 1000);

--
-- Déclencheurs `voiture`
--
DROP TRIGGER IF EXISTS `deleteVoiture`;
DELIMITER $$
CREATE TRIGGER `deleteVoiture` BEFORE UPDATE ON `voiture` FOR EACH ROW begin
   if (nbreKmVoit > 500000)
   then
      delete from voiture where numVoit = new.numVoit;
   end if ;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la vue `nbinscriptions`
--
DROP TABLE IF EXISTS `nbinscriptions`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `nbinscriptions`  AS  select `client`.`typeCli` AS `typeCli`,date_format(`client`.`dateInscription`,'%M %y') AS `mois`,count(0) AS `nbInscriptions` from `client` group by date_format(`client`.`dateInscription`,'%M %y'),`client`.`typeCli` ;

-- --------------------------------------------------------

--
-- Structure de la vue `nombrecandidats`
--
DROP TABLE IF EXISTS `nombrecandidats`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `nombrecandidats`  AS  select count(0) AS `Nb` from `client` ;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `passerc`
--
ALTER TABLE `passerc`
  ADD CONSTRAINT `passerc_ibfk_1` FOREIGN KEY (`numCode`) REFERENCES `code` (`numCode`),
  ADD CONSTRAINT `passerc_ibfk_2` FOREIGN KEY (`numCli`) REFERENCES `client` (`numCli`);

--
-- Contraintes pour la table `passerp`
--
ALTER TABLE `passerp`
  ADD CONSTRAINT `passerp_ibfk_1` FOREIGN KEY (`numPermis`) REFERENCES `permis` (`numPermis`),
  ADD CONSTRAINT `passerp_ibfk_2` FOREIGN KEY (`numCli`) REFERENCES `client` (`numCli`);

--
-- Contraintes pour la table `planning`
--
ALTER TABLE `planning`
  ADD CONSTRAINT `planning_ibfk_1` FOREIGN KEY (`numCli`) REFERENCES `client` (`numCli`),
  ADD CONSTRAINT `planning_ibfk_2` FOREIGN KEY (`numVoit`) REFERENCES `voiture` (`numVoit`),
  ADD CONSTRAINT `planning_ibfk_3` FOREIGN KEY (`numMon`) REFERENCES `moniteur` (`numMon`),
  ADD CONSTRAINT `planning_ibfk_4` FOREIGN KEY (`numLec`) REFERENCES `lecon` (`numLec`);

--
-- Contraintes pour la table `rouler`
--
ALTER TABLE `rouler`
  ADD CONSTRAINT `rouler_ibfk_1` FOREIGN KEY (`numMois`) REFERENCES `mois` (`numMois`),
  ADD CONSTRAINT `rouler_ibfk_2` FOREIGN KEY (`numVoit`) REFERENCES `voiture` (`numVoit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
