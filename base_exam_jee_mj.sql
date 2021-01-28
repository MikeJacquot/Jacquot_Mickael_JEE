-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 28 Janvier 2021 à 16:58
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `base_exam_jee_mj`
--

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_link` varchar(250) DEFAULT NULL,
  `lastname` varchar(250) DEFAULT NULL,
  `firstname` varchar(250) DEFAULT NULL,
  `date_entree` date DEFAULT NULL,
  `numero_tel` varchar(250) DEFAULT NULL,
  `role` enum('admin','user') DEFAULT NULL,
  `login` varchar(250) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `image_link`, `lastname`, `firstname`, `date_entree`, `numero_tel`, `role`, `login`, `password`) VALUES
(1, 'https://scontent-mrs2-2.xx.fbcdn.net/v/t1.0-9/13406982_10154206039859705_3857331767581710154_n.jpg?_nc_cat=106&ccb=2&_nc_sid=174925&_nc_ohc=i0uMPxBunbEAX_jMVdc&_nc_ht=scontent-mrs2-2.xx&oh=1f8eb6eceeb8b7acbff32ae8f965f4f1&oe=603A34D1', 'Jacquot', 'mickael', '2021-01-21', '0612121212', 'admin', 'admin', 'admin'),
(8, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(9, 'https://th.bing.com/th/id/R376d3884b2bc20e6ac3f2acce4ed8ab7?rik=9nhc04WX8ek3pA&riu=http%3a%2f%2ftotoofficial.com%2fwp-content%2fuploads%2f2019%2f02%2ftoto-dvd-web.jpg&ehk=gOreJ7SrcwwHm%2fM4TUhzcv0BRYYNg7PtNJKl4N174LQ%3d&risl=&pid=ImgRaw', 'toto', 'toto', '2001-01-01', '020202002', 'user', 'toto', 'toto');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
