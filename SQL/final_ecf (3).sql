-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 01 Mars 2017 à 13:26
-- Version du serveur :  5.7.17-0ubuntu0.16.04.1
-- Version de PHP :  7.0.15-0ubuntu0.16.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `final_ecf`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `commissionnerIntervention` (IN `ch_id` INT, IN `begin_date` DATETIME, IN `end_date` DATETIME)  BEGIN
SELECT 
    user_name,
    user_surname, 
    committee_name 
FROM user INNER JOIN commissionner 
ON commissionner.commissionner_uid = user.id 
INNER JOIN committee 
ON commissionner.committee_id = committee.committee_id 
INNER JOIN regate
ON commissionner.commissionner_regate_id = regate.re_id
INNER JOIN challenge
ON regate.re_challenge_id = ch_id
WHERE challenge.ch_date_departure > begin_date 
AND challenge.ch_date_arrived < end_date;
END$$

--
-- Fonctions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `new_regate_code` (`INPUT` INT(11)) RETURNS INT(11) BEGIN
DECLARE new_code INT;
SELECT (@row:=@row + 1 + ch_id + MONTH(ch_date_departure)) 
INTO new_code 
FROM regate 
INNER JOIN challenge 
ON INPUT = challenge.ch_id, 
(SELECT @row:=0) t;
RETURN new_code;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `titi` () RETURNS INT(11) BEGIN DECLARE i INT; RETURN i; END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `boat`
--

CREATE TABLE `boat` (
  `user_boat_id` int(11) NOT NULL,
  `boat_user_id` int(11) NOT NULL,
  `user_boat_class` int(11) NOT NULL,
  `user_boat_type_id` int(11) NOT NULL,
  `user_boat_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `boat`
--

INSERT INTO `boat` (`user_boat_id`, `boat_user_id`, `user_boat_class`, `user_boat_type_id`, `user_boat_name`) VALUES
(3, 1, 15, 1, 'le toto\r\n'),
(4, 2, 17, 2, 'Bateau de test'),
(5, 2, 15, 1, 'test'),
(10, 2, 17, 1, 'ddd'),
(11, 2, 17, 1, 'ddd'),
(12, 2, 14, 1, 'le toto'),
(13, 2, 18, 1, 'dddd'),
(14, 2, 19, 1, 'ddddddddee'),
(15, 2, 19, 1, 'abc');

-- --------------------------------------------------------

--
-- Structure de la table `boat_type`
--

CREATE TABLE `boat_type` (
  `boat_type_id` int(11) NOT NULL,
  `boat_type_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `boat_type`
--

INSERT INTO `boat_type` (`boat_type_id`, `boat_type_name`) VALUES
(1, 'Voilier'),
(2, 'Aviron'),
(3, 'Motonautisme');

-- --------------------------------------------------------

--
-- Structure de la table `challenge`
--

CREATE TABLE `challenge` (
  `ch_id` int(11) NOT NULL,
  `ch_type_id` int(11) NOT NULL,
  `ch_name` varchar(120) NOT NULL,
  `ch_date_arrived` datetime NOT NULL,
  `ch_date_departure` datetime NOT NULL,
  `ch_nbmax_participant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `challenge`
--

INSERT INTO `challenge` (`ch_id`, `ch_type_id`, `ch_name`, `ch_date_arrived`, `ch_date_departure`, `ch_nbmax_participant`) VALUES
(9, 1, 'Challenge de test Ete', '2017-02-24 00:00:00', '2017-02-25 00:00:00', 120),
(10, 2, 'Challenge de test Hiver', '2017-02-24 00:00:00', '2017-02-25 00:00:00', 160);

-- --------------------------------------------------------

--
-- Structure de la table `challenge_type`
--

CREATE TABLE `challenge_type` (
  `id` int(11) NOT NULL,
  `name` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `challenge_type`
--

INSERT INTO `challenge_type` (`id`, `name`) VALUES
(1, 'Ete'),
(2, 'Hiver');

-- --------------------------------------------------------

--
-- Structure de la table `class`
--

CREATE TABLE `class` (
  `class_id` int(11) NOT NULL,
  `class_serie_id` int(11) NOT NULL,
  `class_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `class`
--

INSERT INTO `class` (`class_id`, `class_serie_id`, `class_name`) VALUES
(13, 2, 'Corsaire'),
(14, 2, 'Surprise'),
(15, 2, '8 metres'),
(16, 2, 'Maraudeur'),
(17, 2, 'Figaro'),
(18, 3, 'Flying Fifteen'),
(19, 3, 'Soling'),
(20, 3, 'Star'),
(21, 3, 'Tempest'),
(22, 3, 'Yngling'),
(23, 3, '5.5');

-- --------------------------------------------------------

--
-- Structure de la table `commissionner`
--

CREATE TABLE `commissionner` (
  `commissionner_id` int(11) NOT NULL,
  `commissionner_uid` int(11) NOT NULL,
  `committee_id` int(11) NOT NULL,
  `committee_federation_id` int(11) NOT NULL,
  `commissionner_regate_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `committee`
--

CREATE TABLE `committee` (
  `committee_id` int(11) NOT NULL,
  `committee_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `committee`
--

INSERT INTO `committee` (`committee_id`, `committee_name`) VALUES
(1, 'comité d’organisation'),
(2, 'comité de course'),
(3, 'comité de réclamation');

-- --------------------------------------------------------

--
-- Structure de la table `crew`
--

CREATE TABLE `crew` (
  `crew_id` int(11) NOT NULL,
  `crew_uid` int(11) NOT NULL,
  `crew_boat_id` int(11) NOT NULL,
  `crew_regate_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `federation`
--

CREATE TABLE `federation` (
  `federation_id` int(11) NOT NULL,
  `federation_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `federation`
--

INSERT INTO `federation` (`federation_id`, `federation_name`) VALUES
(2, 'Fédération Française de voile'),
(3, 'Fédération Bretonne de voile');

-- --------------------------------------------------------

--
-- Structure de la table `licencie`
--

CREATE TABLE `licencie` (
  `licencie_id` int(11) NOT NULL,
  `licencie_uid` int(11) NOT NULL,
  `licencie_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participates`
--

CREATE TABLE `participates` (
  `par_id` int(11) NOT NULL,
  `par_crew_id` int(11) NOT NULL,
  `par_regate_id` int(11) NOT NULL,
  `par_position` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déclencheurs `participates`
--
DELIMITER $$
CREATE TRIGGER `checkinsert_position` BEFORE INSERT ON `participates` FOR EACH ROW BEGIN
		DECLARE nb_place CONDITION FOR SQLSTATE '45001';
        SELECT ch_nbmax_participant FROM challenge
        INNER JOIN regate
        WHERE regate.re_id = new.par_regate_id
		INTO @max_participant;
		if (new.par_position > @max_participant) 
        then
		SIGNAL nb_place
		SET MESSAGE_TEXT = 'La place du participant est supérieur au nombre total de participant !', 
        MYSQL_ERRNO = 9002;
		end if;
	END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `checkupdate_position` BEFORE UPDATE ON `participates` FOR EACH ROW BEGIN
		DECLARE nb_place CONDITION FOR SQLSTATE '45001';
        SELECT ch_nbmax_participant FROM challenge
        INNER JOIN regate
        WHERE regate.re_id = new.par_regate_id
		INTO @max_participant;
		if (new.par_position > @max_participant) 
        then
		SIGNAL nb_place
		SET MESSAGE_TEXT = 'La place du participant est supérieur au nombre total de participant !', 
        MYSQL_ERRNO = 9002;
		end if;
	END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `regate`
--

CREATE TABLE `regate` (
  `re_id` int(11) NOT NULL,
  `re_type_id` int(11) DEFAULT NULL,
  `re_challenge_id` int(11) NOT NULL,
  `re_date_arrived` datetime NOT NULL,
  `re_date_departure` datetime NOT NULL,
  `re_size` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `regate`
--

INSERT INTO `regate` (`re_id`, `re_type_id`, `re_challenge_id`, `re_date_arrived`, `re_date_departure`, `re_size`) VALUES
(28, 1, 9, '2017-02-24 00:00:00', '2017-02-25 00:00:00', 10);

--
-- Déclencheurs `regate`
--
DELIMITER $$
CREATE TRIGGER `check_finish_challenge` BEFORE DELETE ON `regate` FOR EACH ROW BEGIN
		DECLARE error_type CONDITION FOR SQLSTATE '45001';
        SELECT ch_id FROM challenge
        WHERE challenge.ch_id = old.re_challenge_id
		INTO @chall_in_progress;
		if (@chall_in_progress) 
        then
		SIGNAL error_type
		SET MESSAGE_TEXT = 'Le challenge est toujours en cours !', 
        MYSQL_ERRNO = 9002;
		end if;
	END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `check_insert_date` BEFORE INSERT ON `regate` FOR EACH ROW BEGIN
		DECLARE existing_date CONDITION FOR SQLSTATE '45001';
        SELECT ch_date_departure FROM challenge
        WHERE challenge.ch_id = new.re_challenge_id
        into @date_departure; 
        SELECT ch_date_arrived FROM challenge 
        WHERE challenge.ch_id = new.re_challenge_id
        into @date_arrived;
		if (new.re_date_departure != @date_departure || new.re_date_arrived != @date_arrived) then
		SIGNAL existing_date
		SET MESSAGE_TEXT = 'Vos dates ne correspondent pas !', 
        MYSQL_ERRNO = 9002;
		end if;
	END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `regate_type`
--

CREATE TABLE `regate_type` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `regate_type`
--

INSERT INTO `regate_type` (`type_id`, `type_name`) VALUES
(1, 'Solitaire'),
(2, 'Double'),
(3, 'Equipage');

-- --------------------------------------------------------

--
-- Structure de la table `result`
--

CREATE TABLE `result` (
  `result_id` int(11) NOT NULL,
  `result_boat_id` int(11) DEFAULT NULL,
  `result_commissioner_id` int(11) DEFAULT NULL,
  `result_challenge_id` int(11) NOT NULL,
  `result_total` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `serie`
--

CREATE TABLE `serie` (
  `serie_id` int(11) NOT NULL,
  `serie_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `serie`
--

INSERT INTO `serie` (`serie_id`, `serie_name`) VALUES
(2, 'Habitables'),
(3, 'Quillards de sport');

-- --------------------------------------------------------

--
-- Structure de la table `start_printing_list`
--

CREATE TABLE `start_printing_list` (
  `start_id` int(11) NOT NULL,
  `user_role_id` int(11) NOT NULL,
  `user_boat_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `printing_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `status`
--

CREATE TABLE `status` (
  `status_id` int(11) NOT NULL,
  `status_actual` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `status`
--

INSERT INTO `status` (`status_id`, `status_actual`) VALUES
(1, 'Présent'),
(2, 'Absent'),
(3, 'Retardataire');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `user_name` varchar(80) NOT NULL,
  `user_surname` varchar(80) NOT NULL,
  `user_phone` int(11) NOT NULL,
  `user_email` varchar(80) NOT NULL,
  `age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `user_name`, `user_surname`, `user_phone`, `user_email`, `age`) VALUES
(1, 'Jean', 'Jacques', 123456789, 'jj@lpdel.com', 0),
(2, 'Patrick', 'toto', 123456789, 'poldep@ldepld.com', 0),
(3, 'Jean', 'Michel', 123456789, 'ldpeld@ldeld.com', 92);

-- --------------------------------------------------------

--
-- Structure de la table `user_club`
--

CREATE TABLE `user_club` (
  `user_club_id` int(11) NOT NULL,
  `user_club_uid` int(11) NOT NULL,
  `user_club_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user_club`
--

INSERT INTO `user_club` (`user_club_id`, `user_club_uid`, `user_club_name`) VALUES
(1, 1, 'Club de test');

-- --------------------------------------------------------

--
-- Structure de la table `user_role`
--

CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL,
  `user_role_uid` int(11) NOT NULL,
  `user_role_name` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `boat`
--
ALTER TABLE `boat`
  ADD PRIMARY KEY (`user_boat_id`),
  ADD KEY `boat_user_id` (`boat_user_id`),
  ADD KEY `boat_user_id_2` (`boat_user_id`),
  ADD KEY `possesses_id` (`user_boat_class`),
  ADD KEY `boat_type_id` (`user_boat_type_id`);

--
-- Index pour la table `boat_type`
--
ALTER TABLE `boat_type`
  ADD PRIMARY KEY (`boat_type_id`);

--
-- Index pour la table `challenge`
--
ALTER TABLE `challenge`
  ADD PRIMARY KEY (`ch_id`),
  ADD KEY `challenge_id` (`ch_id`),
  ADD KEY `ch_type_id` (`ch_type_id`);

--
-- Index pour la table `challenge_type`
--
ALTER TABLE `challenge_type`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`class_id`),
  ADD KEY `class_serie_id` (`class_serie_id`);

--
-- Index pour la table `commissionner`
--
ALTER TABLE `commissionner`
  ADD PRIMARY KEY (`commissionner_id`),
  ADD KEY `committee_id` (`committee_id`),
  ADD KEY `commissionner_user_id` (`commissionner_uid`),
  ADD KEY `committee_federation_id` (`committee_federation_id`),
  ADD KEY `commissionner_regate_id` (`commissionner_regate_id`);

--
-- Index pour la table `committee`
--
ALTER TABLE `committee`
  ADD PRIMARY KEY (`committee_id`);

--
-- Index pour la table `crew`
--
ALTER TABLE `crew`
  ADD PRIMARY KEY (`crew_id`),
  ADD KEY `crew_uid` (`crew_uid`),
  ADD KEY `crew_boat_id` (`crew_boat_id`),
  ADD KEY `crew_regate_id` (`crew_regate_id`);

--
-- Index pour la table `federation`
--
ALTER TABLE `federation`
  ADD PRIMARY KEY (`federation_id`);

--
-- Index pour la table `licencie`
--
ALTER TABLE `licencie`
  ADD PRIMARY KEY (`licencie_id`),
  ADD KEY `licencie_user_id` (`licencie_uid`);

--
-- Index pour la table `participates`
--
ALTER TABLE `participates`
  ADD PRIMARY KEY (`par_id`),
  ADD KEY `par_crew_id` (`par_crew_id`),
  ADD KEY `par_regate_id` (`par_regate_id`);

--
-- Index pour la table `regate`
--
ALTER TABLE `regate`
  ADD PRIMARY KEY (`re_id`),
  ADD KEY `regate_type_id` (`re_type_id`),
  ADD KEY `re_challenge_id` (`re_challenge_id`);

--
-- Index pour la table `regate_type`
--
ALTER TABLE `regate_type`
  ADD PRIMARY KEY (`type_id`);

--
-- Index pour la table `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`result_id`),
  ADD KEY `regate_id` (`result_challenge_id`),
  ADD KEY `result_commissioner_id` (`result_commissioner_id`),
  ADD KEY `result_club_id` (`result_boat_id`);

--
-- Index pour la table `serie`
--
ALTER TABLE `serie`
  ADD PRIMARY KEY (`serie_id`);

--
-- Index pour la table `start_printing_list`
--
ALTER TABLE `start_printing_list`
  ADD PRIMARY KEY (`start_id`),
  ADD KEY `user_role_id` (`user_role_id`),
  ADD KEY `user_boat_id` (`user_boat_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `status_id_2` (`status_id`);

--
-- Index pour la table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`status_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_club`
--
ALTER TABLE `user_club`
  ADD PRIMARY KEY (`user_club_id`),
  ADD KEY `user_id` (`user_club_uid`);

--
-- Index pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_role_id`),
  ADD KEY `user_id` (`user_role_uid`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `boat`
--
ALTER TABLE `boat`
  MODIFY `user_boat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `boat_type`
--
ALTER TABLE `boat_type`
  MODIFY `boat_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `challenge`
--
ALTER TABLE `challenge`
  MODIFY `ch_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `challenge_type`
--
ALTER TABLE `challenge_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `class`
--
ALTER TABLE `class`
  MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT pour la table `commissionner`
--
ALTER TABLE `commissionner`
  MODIFY `commissionner_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `committee`
--
ALTER TABLE `committee`
  MODIFY `committee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `crew`
--
ALTER TABLE `crew`
  MODIFY `crew_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `federation`
--
ALTER TABLE `federation`
  MODIFY `federation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `licencie`
--
ALTER TABLE `licencie`
  MODIFY `licencie_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `participates`
--
ALTER TABLE `participates`
  MODIFY `par_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `regate`
--
ALTER TABLE `regate`
  MODIFY `re_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT pour la table `regate_type`
--
ALTER TABLE `regate_type`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `result`
--
ALTER TABLE `result`
  MODIFY `result_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `serie`
--
ALTER TABLE `serie`
  MODIFY `serie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `start_printing_list`
--
ALTER TABLE `start_printing_list`
  MODIFY `start_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `status`
--
ALTER TABLE `status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `user_club`
--
ALTER TABLE `user_club`
  MODIFY `user_club_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `user_role_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `boat`
--
ALTER TABLE `boat`
  ADD CONSTRAINT `boat_ibfk_3` FOREIGN KEY (`user_boat_type_id`) REFERENCES `boat_type` (`boat_type_id`),
  ADD CONSTRAINT `boat_ibfk_4` FOREIGN KEY (`user_boat_class`) REFERENCES `class` (`class_id`),
  ADD CONSTRAINT `boat_ibfk_5` FOREIGN KEY (`boat_user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `challenge`
--
ALTER TABLE `challenge`
  ADD CONSTRAINT `challenge_ibfk_1` FOREIGN KEY (`ch_type_id`) REFERENCES `challenge_type` (`id`);

--
-- Contraintes pour la table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`class_serie_id`) REFERENCES `serie` (`serie_id`);

--
-- Contraintes pour la table `commissionner`
--
ALTER TABLE `commissionner`
  ADD CONSTRAINT `commissionner_ibfk_1` FOREIGN KEY (`committee_id`) REFERENCES `committee` (`committee_id`),
  ADD CONSTRAINT `commissionner_ibfk_2` FOREIGN KEY (`commissionner_uid`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `commissionner_ibfk_3` FOREIGN KEY (`committee_federation_id`) REFERENCES `federation` (`federation_id`),
  ADD CONSTRAINT `commissionner_ibfk_4` FOREIGN KEY (`commissionner_regate_id`) REFERENCES `regate` (`re_id`);

--
-- Contraintes pour la table `crew`
--
ALTER TABLE `crew`
  ADD CONSTRAINT `crew_ibfk_1` FOREIGN KEY (`crew_uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `crew_ibfk_2` FOREIGN KEY (`crew_boat_id`) REFERENCES `boat` (`user_boat_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `crew_ibfk_3` FOREIGN KEY (`crew_regate_id`) REFERENCES `regate` (`re_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `licencie`
--
ALTER TABLE `licencie`
  ADD CONSTRAINT `licencie_ibfk_1` FOREIGN KEY (`licencie_uid`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `participates`
--
ALTER TABLE `participates`
  ADD CONSTRAINT `participates_ibfk_1` FOREIGN KEY (`par_crew_id`) REFERENCES `crew` (`crew_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `participates_ibfk_2` FOREIGN KEY (`par_regate_id`) REFERENCES `regate` (`re_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `regate`
--
ALTER TABLE `regate`
  ADD CONSTRAINT `regate_ibfk_1` FOREIGN KEY (`re_type_id`) REFERENCES `regate_type` (`type_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `regate_ibfk_4` FOREIGN KEY (`re_challenge_id`) REFERENCES `challenge` (`ch_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `result`
--
ALTER TABLE `result`
  ADD CONSTRAINT `result_ibfk_1` FOREIGN KEY (`result_boat_id`) REFERENCES `boat` (`user_boat_id`),
  ADD CONSTRAINT `result_ibfk_2` FOREIGN KEY (`result_commissioner_id`) REFERENCES `commissionner` (`commissionner_id`),
  ADD CONSTRAINT `result_ibfk_3` FOREIGN KEY (`result_challenge_id`) REFERENCES `challenge` (`ch_id`);

--
-- Contraintes pour la table `user_club`
--
ALTER TABLE `user_club`
  ADD CONSTRAINT `user_club_ibfk_1` FOREIGN KEY (`user_club_uid`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_role_uid`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
