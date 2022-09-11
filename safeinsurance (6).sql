-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 09 sep. 2022 à 10:51
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `safeinsurance`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `login` varchar(50) NOT NULL,
  `mdp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`login`, `mdp`) VALUES
('okba', 'amina'),
('okba', 'amina');

-- --------------------------------------------------------

--
-- Structure de la table `assurances`
--

CREATE TABLE `assurances` (
  `id assurance` varchar(50) NOT NULL,
  `cin client` int(11) NOT NULL,
  `immatricule voiture client` varchar(50) NOT NULL,
  `matricule employee` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `montant` float NOT NULL,
  `nom client` varchar(50) DEFAULT NULL,
  `permis client` int(11) NOT NULL,
  `type voiture client` varchar(50) NOT NULL,
  `marque voiture client` varchar(50) NOT NULL,
  `prenom_client` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `bareme`
--

CREATE TABLE `bareme` (
  `id calsse` varchar(50) NOT NULL,
  `immatricule` varchar(50) DEFAULT NULL,
  `cin client` int(11) DEFAULT NULL,
  `date permis client` date NOT NULL,
  `historique client` varchar(250) DEFAULT NULL,
  `montant final` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `cin` int(11) NOT NULL,
  `immatricule` varchar(100) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `Délivré_le` date DEFAULT NULL,
  `mdp` varchar(100) DEFAULT NULL,
  `role` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `Num_Permis` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`cin`, `immatricule`, `nom`, `prenom`, `tel`, `Délivré_le`, `mdp`, `role`, `email`, `Num_Permis`) VALUES
(12345665, '1255Tun145', 'sdssdsd', 'sdsdsdsd', 12345678, '2011-11-11', 'masterrr', 'sssqqsq', 'SDQD@ssdds.tn', 123),
(12345678, '1255Tun145', 'sdssdsd', 'sdsdsdsd', 12345678, '2011-11-11', 'masterrr', 'qsqsqsqqq', 'SDQD@ssdds.tn', 123),
(12345679, '1255Tun145', 'sdssdsd', 'sdsdsdsd', 12345678, '2011-11-11', 'masterrr', 'foulennn', 'SDQD@ssdds.tn', 123);

-- --------------------------------------------------------

--
-- Structure de la table `clientssss`
--

CREATE TABLE `clientssss` (
  `cin` int(11) NOT NULL,
  `immatricule` varchar(50) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `num_permis` int(11) DEFAULT NULL,
  `délivré_le` date DEFAULT NULL,
  `login` varchar(100) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  `fonction` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `constats`
--

CREATE TABLE `constats` (
  `id` varchar(100) NOT NULL,
  `nom_client` varchar(100) DEFAULT NULL,
  `prenom_client` varchar(100) DEFAULT NULL,
  `cin_client` int(11) DEFAULT NULL,
  `nom_conducteur_Vclient` varchar(100) DEFAULT NULL,
  `prenom_conducteur_Vclient` varchar(100) DEFAULT NULL,
  `cin_conducteur_Vclient` int(11) DEFAULT NULL,
  `permis_conducteur_Vclient` int(11) NOT NULL,
  `type_vehicule_client` varchar(100) DEFAULT NULL,
  `marque_vehicule_client` varchar(100) DEFAULT NULL,
  `immaricule_vehicule_client` varchar(50) DEFAULT NULL,
  `nom_conducteur_B` varchar(100) DEFAULT NULL,
  `prenom_conducteur_B` varchar(100) DEFAULT NULL,
  `cin_conducteur_B` int(11) DEFAULT NULL,
  `permis_conducteur_B` int(11) DEFAULT NULL,
  `date_permis_B` date DEFAULT NULL,
  `nom_assuré_B` varchar(100) DEFAULT NULL,
  `prenom_assuré_B` varchar(100) DEFAULT NULL,
  `cin_assuré_B` int(11) DEFAULT NULL,
  `type_vehicule_B` varchar(100) DEFAULT NULL,
  `marque_vehicule_B` varchar(100) DEFAULT NULL,
  `immatricule_vehicule_B` varchar(100) DEFAULT NULL,
  `assureur_vehicule_B` varchar(250) DEFAULT NULL,
  `date_accident` date DEFAULT NULL,
  `lieu_accident` varchar(250) DEFAULT NULL,
  `point_d'impact` varchar(150) DEFAULT NULL,
  `blesses (oui/non)` tinyint(1) NOT NULL,
  `temoins (oui/non)` tinyint(1) NOT NULL,
  `nom_temoin` varchar(150) DEFAULT NULL,
  `prenom_temoin` varchar(150) DEFAULT NULL,
  `cin_temoin` int(11) DEFAULT NULL,
  `tel_temoin` int(11) DEFAULT NULL,
  `nb_voitures_accident` int(11) DEFAULT NULL,
  `pièces_endommagés_client` varchar(250) DEFAULT NULL,
  `descriptif_accident` varchar(250) NOT NULL,
  `copie_rapport` varchar(150) NOT NULL,
  `date_permis_conducteur_Vclient` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `employees`
--

CREATE TABLE `employees` (
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `fonction` varchar(250) DEFAULT NULL,
  `matricule` varchar(100) NOT NULL,
  `cin` int(11) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `login` varchar(100) DEFAULT NULL,
  `mdp` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `employees`
--

INSERT INTO `employees` (`nom`, `prenom`, `fonction`, `matricule`, `cin`, `tel`, `login`, `mdp`) VALUES
('modifier_2', 'modifier_2', 'modifier_2', 'ABO0001', 10000000, 97000001, 'contact@contact.tn', 'dsdds'),
('Seddik', 'Hamza', 'Agent back office', 'ABO0005', 46982346, 12367895, 'contact_1@contact.tn', 'ssddsds'),
('Kouki', 'Mohammed', 'Agent de production', 'AP00001', 410010012, 53478131, 'Kouki_Mohamed', '%kouki%assurance_2022'),
('Talbiiiiiiiiiiiii', 'Jihed', 'Agent de production', 'AP0002', 12345678, 12345678, NULL, NULL),
('zzzza', 'azzza', 'azazaz', 'azzazza', 12345678, 12345678, 'foulen@foulen.com', '123foulen456'),
('zzzza', 'azzza', 'azazaz', 'azzazzab', 12345678, 12345678, 'foulen@foulen.com', '123foulen456'),
('zzzza', 'azzza', 'azazaz', 'azzazzabb', 12345678, 12345678, 'foulen@foulen.com', '123foulen456'),
('Chaar', 'Chaarinos', 'Battal', 'BT0000', 12365478, 14654789, NULL, NULL),
('Ben belgacem', 'Farid', 'Conseiller client', 'CC0001', 12304213, 21654001, 'faridbenbelgacem', '000faridassurance642'),
('ben Youness', 'Aymen', 'Conseiller clientèle', 'CC0002', 12345678, 97456982, NULL, NULL),
('sds', 'sdds', 'dssd', 'ds', 1, 2, NULL, NULL),
('okba', 'Weslati', 'Expert', 'E00002', 23415872, 50123456, 'Okba_Elif', '%ElifePI_assurance_2022'),
('Ben Ali', 'Mohamed', 'expert', 'E0001', 12345678, 97456123, NULL, NULL),
('El aayeb', 'Hajer', 'Expert', 'E00018', 14253698, 47895612, NULL, NULL),
('azz', 'sds', 'zad', 'ett', 5, 35, NULL, NULL),
('dss', 'ds', 'fss', 'f', 256, 35, NULL, NULL),
('ggd', 'fssf', 'qfffs', 'fdfsf', 15, 20, NULL, NULL),
('ggg', 'fsff', 'ffdfd', 'fffd', 1, 2, NULL, NULL),
('ffff', 'gfgf', 'fgfgfg', 'fgfg', 586, 321, NULL, NULL),
('lomd', 'opm', 'hffh', 'fgg', 56, 87, NULL, NULL),
('hfhf', 'gfgfg', 'gfgfg', 'fhff', 12, 35, NULL, NULL),
('jjfj', 'hhfh', 'hfhfh', 'fhffhh', 14, 2, NULL, NULL),
('jhh', 'fhgfg', 'fgffhh', 'fhfhff', 2, 3, NULL, NULL),
('kjdhh', 'hfhf', 'fhhfjfh', 'fhfhfj', 4560, 123, NULL, NULL),
('nfbfb', 'bfbfb', 'nfbfb', 'fnf,', 14, 25, NULL, NULL),
('sqqfs', 'fqfq', 'sdsdsfd', 'fqfd', 2, 5, NULL, NULL),
('qffq', 'sdd', 'fdfsd', 'fsf', 1, 2, NULL, NULL),
('kakawiya', 'belouz', 'hammas', 'g55555', 12354899, 12354988, NULL, NULL),
('kjjkjggh', 'gggfgf', 'hhfgf', 'gfgf', 123, 476, NULL, NULL),
('hhgah', 'hjjh', 'ghh', 'ghg', 2, 5, NULL, NULL),
('mmmmmpppppp', 'iyyy', 'hdgdg', 'hdhhdh', 2, 3, NULL, NULL),
('hhfh', 'hhfg', 'kfhh', 'hffga', 12, 35, NULL, NULL),
('ffghg', 'hfggg', 'fjfkki', 'hfhf', 1235, 253, NULL, NULL),
('jkjkdfhj', 'fjjfhj', 'hhfhf', 'hjfhjfh', 1255, 4454, NULL, NULL),
('weslati', 'Okba', 'Ingénieur', 'Ing001', 8093012, 21212121, 'contact@contact.tn', '123okba567'),
('jddkk', 'jhfhfh', 'kjfjf', 'jffhf', 256, 547, NULL, NULL),
('lldm', 'oruu', 'mmoue', 'jfhfhh', 5, 3, NULL, NULL),
('jkkdfjk', 'hhgfgf', 'jhfjhfd', 'jhfdhjfdh', 15, 24, NULL, NULL),
('hffh', 'gfgf', 'jjfh', 'jhfhf', 14, 25, NULL, NULL),
('hjhhj', 'hjhjhj', 'jhhhj', 'jhjhjh', 25, 30, NULL, NULL),
('orrj', 'gkgg', 'orrp', 'kffmm', 142, 658, NULL, NULL),
('jjfh', 'hhfh', 'hhffh', 'khfh', 2, 5, NULL, NULL),
('jgjg', 'hghh', 'hhh', 'kkk', 1, 2, NULL, NULL),
('KHFG', 'iuryr', 'moo', 'lkfjj', 12, 14, NULL, NULL),
('jgjg', 'jghgh', 'uuu', 'llo', 1, 2, NULL, NULL),
('aaur', 'fgfg', 'éopp', 'lokp', 567, 997, NULL, NULL),
('mariem', 'mar', 'Admin', 'm122', 323456, 3325689, NULL, NULL),
('foulen', 'ben foulen', 'master', 'master0001', 12, 121212, 'contact@contact.tn', '123123123'),
('houda ', 'Boussena', 'Medecin', 'Med0001', 123658687, 13548, NULL, NULL),
('test 1000', 'fhfh', 'ljj', 'mkd', 253, 856, NULL, NULL),
('mmm', 'mmmm', 'mmmm', 'mmmm', 3, 8, NULL, NULL),
('kjjkkj', 'yyry', 'ooo', 'mp', 1, 2, NULL, NULL),
('aaaaaazzzzzzzzz', 'mpl', 'mpm', 'mpll', 1, 2, NULL, NULL),
('kdkd', 'mpp', 'mppp', 'mpppp', 1, 2, NULL, NULL),
('khhggh', 'zzrtt', 'zoiei', 'oufre_', 1456, 86687, NULL, NULL),
('jfh', 'pmp', 'poutu', 'oury', 56, 8, NULL, NULL),
('pp', 'ppp', 'ppp', 'pppp', 1, 2, NULL, NULL),
('sddskmppp', 'ppmlp', 'pppppp', 'pppppp', 1, 2, NULL, NULL),
('sqq', 'sss', 'qqq', 'qqq', 1, 2, NULL, NULL),
('qqqqqqqqqqqqqqqqqqqqqq', 'qqqqqqqqqqqqqqq', 'qqqqqqqqqq', 'qqqqqqqqqqq', 1, 2, NULL, NULL),
('ssQssdsdsddd', 'qqqqqqqqqq', 'qqqqqqqqqqqqq', 'qqqqqqqqqqqqqqqqqq', 1, 2, NULL, NULL),
('aaaaaaaaaaaaaaaassss', 'dddd', 'asqqs', 'qqssq', 1, 2, NULL, NULL),
('ssqq', 'qqsqs', 'qsqs', 'qsqs', 1, 2, NULL, NULL),
('qsqsqsqqsqs', 'qsqsqsqssqsq', 'qsqssqsqsq', 'qsqssqssqq', 1, 2, NULL, NULL),
('qsqsqs', 'qqsssqsqssq', 'qssqsqsqqqq', 'qsssssssssqssqqss', 1, 2, NULL, NULL),
('sdsdssdds', 'sdsdsddsds', 'dssdds', 'sddssd', 1, 2, NULL, NULL),
('sds', 'dsdssdsdds', 'sddsdsds', 'sddssdsd', 1, 2, NULL, NULL),
('khhf', 'jhhfh', 'hffjj', 'sdsd', 125, 478, NULL, NULL),
('dssd', 'sdsd', 'sdsd', 'sdsdsd', 2, 1, NULL, NULL),
('sqssq', 'qsqssq', 'qsqqs', 'sqqqssq', 1, 2, NULL, NULL),
('ssqqs', 'qssqsq', 'sqsqsq', 'sqqssq', 1, 2, NULL, NULL),
('sssse', 'see', 'eese', 'ssese', 1, 2, NULL, NULL),
('sddssddddd', 'dsds', 'sss', 'sss', 1, 2, NULL, NULL),
('jfhgh', 'hhgj', 'pie', 'uryr', 535, 684, NULL, NULL),
('Last', 'Test', 'View', 'V1001', 12365478, 98745612, NULL, NULL),
('zzz', 'zzz', 'zzz', 'zzz', 2, 3, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `formulaires`
--

CREATE TABLE `formulaires` (
  `id formulaire` int(11) NOT NULL,
  `type formulaire` varchar(150) DEFAULT NULL,
  `pièce jointe` varchar(50) DEFAULT NULL,
  `cin client` int(11) DEFAULT NULL,
  `matricule employés` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `rapport`
--

CREATE TABLE `rapport` (
  `id_rapport` varchar(50) NOT NULL,
  `id_constat` varchar(50) NOT NULL,
  `mat_employee` varchar(50) NOT NULL,
  `id_assurance` varchar(50) NOT NULL,
  `pieces_jointes` varchar(250) NOT NULL,
  `date_rapport` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `rapport`
--

INSERT INTO `rapport` (`id_rapport`, `id_constat`, `mat_employee`, `id_assurance`, `pieces_jointes`, `date_rapport`) VALUES
('1', '15h5o9', '123458j', '12548hy', '', '2022-09-01'),
('123dsd', '123sdsd4', 'E008', '123KHHF456', 'sss', '2025-11-11'),
('imed', 'imed2222', 'imed', 'imed', 'imed', '21-07-1997');

-- --------------------------------------------------------

--
-- Structure de la table `véhicules`
--

CREATE TABLE `véhicules` (
  `immatricule` varchar(100) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `marque` varchar(100) DEFAULT NULL,
  `type_carburant` varchar(50) DEFAULT NULL,
  `nb_chevaux_fiscaux` int(11) DEFAULT NULL,
  `date_circulation` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `estimation_rapprochée` int(11) DEFAULT NULL,
  `classe` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `véhicules`
--

INSERT INTO `véhicules` (`immatricule`, `type`, `marque`, `type_carburant`, `nb_chevaux_fiscaux`, `date_circulation`, `age`, `estimation_rapprochée`, `classe`) VALUES
('1255Tun145', 'Berline', 'Renault', 'diesel', 6, '01-01-2012', 6, 25000, 'véhicule'),
('205tun202', 'berline', 'ford fiesta', 'essence', 5, '11-01-2022', 5, 40, 'véhicule ');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `assurances`
--
ALTER TABLE `assurances`
  ADD PRIMARY KEY (`id assurance`),
  ADD KEY `fk_nom_c` (`nom client`),
  ADD KEY `prenom_client` (`prenom_client`),
  ADD KEY `fk_permis_c` (`permis client`),
  ADD KEY `type voiture client` (`type voiture client`),
  ADD KEY `cin_client` (`cin client`),
  ADD KEY `fk_immatr_voiture` (`immatricule voiture client`),
  ADD KEY `matricule_emp` (`matricule employee`),
  ADD KEY `fk_marque_voiture` (`marque voiture client`);

--
-- Index pour la table `bareme`
--
ALTER TABLE `bareme`
  ADD PRIMARY KEY (`id calsse`),
  ADD KEY `fk_imt véhicule` (`immatricule`),
  ADD KEY `fk_cin client` (`cin client`);

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`cin`),
  ADD KEY `fk_immatricule` (`immatricule`);

--
-- Index pour la table `clientssss`
--
ALTER TABLE `clientssss`
  ADD PRIMARY KEY (`cin`);

--
-- Index pour la table `constats`
--
ALTER TABLE `constats`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_nom_client` (`nom_client`),
  ADD KEY `fk_prenom_client` (`prenom_client`),
  ADD KEY `fk_type_voit_client` (`type_vehicule_client`),
  ADD KEY `fk_marque_voit_client` (`marque_vehicule_client`),
  ADD KEY `fk_immat_voit_client` (`immaricule_vehicule_client`),
  ADD KEY `fk_cin_client` (`cin_client`);

--
-- Index pour la table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`matricule`),
  ADD KEY `nom` (`nom`),
  ADD KEY `prenom` (`prenom`);

--
-- Index pour la table `formulaires`
--
ALTER TABLE `formulaires`
  ADD PRIMARY KEY (`id formulaire`),
  ADD KEY `fk_cin clt` (`cin client`),
  ADD KEY `fk_mat emp` (`matricule employés`);

--
-- Index pour la table `rapport`
--
ALTER TABLE `rapport`
  ADD PRIMARY KEY (`id_rapport`);

--
-- Index pour la table `véhicules`
--
ALTER TABLE `véhicules`
  ADD PRIMARY KEY (`immatricule`),
  ADD KEY `type` (`type`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `assurances`
--
ALTER TABLE `assurances`
  ADD CONSTRAINT `cin_client` FOREIGN KEY (`cin client`) REFERENCES `clientssss` (`cin`),
  ADD CONSTRAINT `fk_immatr_voiture` FOREIGN KEY (`immatricule voiture client`) REFERENCES `auten`.`vehicules` (`immatricule`),
  ADD CONSTRAINT `fk_marque_voiture` FOREIGN KEY (`marque voiture client`) REFERENCES `auten`.`vehicules` (`marque`),
  ADD CONSTRAINT `fk_nom_c` FOREIGN KEY (`nom client`) REFERENCES `clientssss` (`nom`),
  ADD CONSTRAINT `fk_permis_c` FOREIGN KEY (`permis client`) REFERENCES `clientssss` (`num permis`),
  ADD CONSTRAINT `fk_prenom_c` FOREIGN KEY (`prenom_client`) REFERENCES `clientssss` (`prenom`),
  ADD CONSTRAINT `fk_type_voiture_client` FOREIGN KEY (`type voiture client`) REFERENCES `auten`.`vehicules` (`type`),
  ADD CONSTRAINT `matricule_emp` FOREIGN KEY (`matricule employee`) REFERENCES `employees` (`matricule`);

--
-- Contraintes pour la table `bareme`
--
ALTER TABLE `bareme`
  ADD CONSTRAINT `fk_cin client` FOREIGN KEY (`cin client`) REFERENCES `clientssss` (`cin`);

--
-- Contraintes pour la table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `fk_immatricule` FOREIGN KEY (`immatricule`) REFERENCES `véhicules` (`immatricule`);

--
-- Contraintes pour la table `constats`
--
ALTER TABLE `constats`
  ADD CONSTRAINT `fk_cin_client` FOREIGN KEY (`cin_client`) REFERENCES `clientssss` (`cin`),
  ADD CONSTRAINT `fk_immat_voit_client` FOREIGN KEY (`immaricule_vehicule_client`) REFERENCES `auten`.`vehicules` (`immatricule`),
  ADD CONSTRAINT `fk_marque_voit_client` FOREIGN KEY (`marque_vehicule_client`) REFERENCES `auten`.`vehicules` (`marque`),
  ADD CONSTRAINT `fk_nom_client` FOREIGN KEY (`nom_client`) REFERENCES `clientssss` (`nom`),
  ADD CONSTRAINT `fk_prenom_client` FOREIGN KEY (`prenom_client`) REFERENCES `clientssss` (`prenom`),
  ADD CONSTRAINT `fk_type_voit_client` FOREIGN KEY (`type_vehicule_client`) REFERENCES `clientssss` (`type véhicule`);

--
-- Contraintes pour la table `formulaires`
--
ALTER TABLE `formulaires`
  ADD CONSTRAINT `fk_cin clt` FOREIGN KEY (`cin client`) REFERENCES `clientssss` (`cin`),
  ADD CONSTRAINT `fk_mat emp` FOREIGN KEY (`matricule employés`) REFERENCES `employees` (`matricule`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
