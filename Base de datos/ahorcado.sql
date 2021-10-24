-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 24, 2021 at 11:39 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ahorcado`
--

-- --------------------------------------------------------

--
-- Table structure for table `palabra`
--

CREATE TABLE `palabra` (
  `idPalabra` int(11) NOT NULL,
  `palabra` varchar(15) NOT NULL,
  `dificultad` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `palabra`
--

INSERT INTO `palabra` (`idPalabra`, `palabra`, `dificultad`) VALUES
(1, 'azul', 1),
(2, 'rojo', 1),
(3, 'azul', 1),
(4, 'rojo', 1);

-- --------------------------------------------------------

--
-- Table structure for table `partida`
--

CREATE TABLE `partida` (
  `id` int(11) NOT NULL,
  `tiempoInicio` datetime NOT NULL,
  `tiempoFin` datetime NOT NULL,
  `fallos` int(11) NOT NULL,
  `uid` varchar(25) NOT NULL,
  `idPalabra` int(11) NOT NULL,
  `finPartida` tinyint(1) NOT NULL,
  `puntuacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `partida`
--

INSERT INTO `partida` (`id`, `tiempoInicio`, `tiempoFin`, `fallos`, `uid`, `idPalabra`, `finPartida`, `puntuacion`) VALUES
(1, '2021-10-22 18:52:57', '2021-10-22 18:52:57', 2, 'BucatariuElvis', 1, 1, 50),
(2, '2021-10-22 18:55:49', '2021-10-22 18:55:49', 1, 'ElenaPeris', 4, 1, 25),
(3, '2021-10-23 18:40:34', '2021-10-23 18:40:34', 2, 'BucatariuElvis', 2, 1, 100),
(4, '2021-10-23 20:21:04', '2021-10-23 20:21:04', 3, 'BucatariuElvis', 2, 1, 60),
(5, '2021-10-23 20:21:04', '2021-10-23 20:21:04', 3, 'ElenaPeris', 3, 1, 200),
(6, '2021-10-23 20:21:04', '2021-10-23 20:21:04', 3, 'ElenaPeris', 2, 1, 75),
(7, '2021-10-23 20:21:04', '2021-10-23 20:21:04', 3, 'ElenaPeris', 3, 1, 250);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `palabra`
--
ALTER TABLE `palabra`
  ADD PRIMARY KEY (`idPalabra`);

--
-- Indexes for table `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`id`),
  ADD KEY `rPalabra` (`idPalabra`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `palabra`
--
ALTER TABLE `palabra`
  MODIFY `idPalabra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `partida`
--
ALTER TABLE `partida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `partida`
--
ALTER TABLE `partida`
  ADD CONSTRAINT `rPalabra` FOREIGN KEY (`idPalabra`) REFERENCES `palabra` (`idPalabra`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
