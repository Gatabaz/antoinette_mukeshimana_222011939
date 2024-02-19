-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 10:46 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `antoinette_gatabazi_mukeshimana_222011939`
--

-- --------------------------------------------------------

--
-- Table structure for table `actor`
--

CREATE TABLE `actor` (
  `actor_id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `language` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `actor`
--

INSERT INTO `actor` (`actor_id`, `first_name`, `last_name`, `email`, `phone`, `language`) VALUES
(1, 'jack', 'emi', 'emi@gmaial.com', '0788888883', 'English'),
(2, 'veve', 'isimbi', 'veve@gmail.com', '0724379488', 'french'),
(5, 'keza', 'bella', 'kezabella@gmail.com', '0786758334', 'ENGLISH'),
(20, 'ANTOINETTE', 'GATABAZI MUKESHIMANA', 'gatabaziantoinette983@gmail.com', '0786758334', 'english');

-- --------------------------------------------------------

--
-- Table structure for table `contract`
--

CREATE TABLE `contract` (
  `contact_id` int(10) NOT NULL,
  `contact_text` varchar(220) NOT NULL,
  `actor_name` varchar(220) NOT NULL,
  `investor_name` varchar(220) NOT NULL,
  `project_name` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contract`
--

INSERT INTO `contract` (`contact_id`, `contact_text`, `actor_name`, `investor_name`, `project_name`) VALUES
(1, 'mynames gatabazi', 'mine', 'head manager', 'bamenya'),
(2, 'heroine', 'you', 'db', 'rent');

-- --------------------------------------------------------

--
-- Table structure for table `filmmaker`
--

CREATE TABLE `filmmaker` (
  `filmmaker_id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `nationality` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `filmmaker`
--

INSERT INTO `filmmaker` (`filmmaker_id`, `first_name`, `last_name`, `email`, `phone`, `nationality`) VALUES
(1, 'antog', 'muke', 'muke@gmail.com', '0789654321', 'Rwanda'),
(7, 'shema', 'christian', 'shema@gmail.com', '073457012', 'Rwanda'),
(10, 'uwera', 'anne', 'ann@gmail.com', '1234567889', 'frence'),
(11, 'pere', 'mere', 'mere@gmail.com', '0788888884', 'RWanfdan');

-- --------------------------------------------------------

--
-- Table structure for table `investment`
--

CREATE TABLE `investment` (
  `invest_id` int(10) NOT NULL,
  `investment_amount` int(220) NOT NULL,
  `investor_name` varchar(220) NOT NULL,
  `project_name` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `investment`
--

INSERT INTO `investment` (`invest_id`, `investment_amount`, `investor_name`, `project_name`) VALUES
(1, 10000000, 'VEVE', 'PAPASAVA'),
(2, 3000000, 'GATABAZI', 'THIS LIFE');

-- --------------------------------------------------------

--
-- Table structure for table `investors`
--

CREATE TABLE `investors` (
  `investor_id` int(11) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `nationality` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `investors`
--

INSERT INTO `investors` (`investor_id`, `first_name`, `last_name`, `email`, `phone`, `nationality`) VALUES
(1, 'uwera', 'anick', 'anick@gmail.com', '0789654321', 'kenyan'),
(2, 'mere', 'pere', 'pere@gmail.com', '0785888340', 'Rwandan');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `project_id` int(10) NOT NULL,
  `title` varchar(220) NOT NULL,
  `release_date` date NOT NULL,
  `project_budget` int(220) NOT NULL,
  `filmmaker_name` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`project_id`, `title`, `release_date`, `project_budget`, `filmmaker_name`) VALUES
(1, 'the hero', '2024-12-28', 40000, 'innocent'),
(2, 'bameny', '2024-01-11', 100000, 'Antoj'),
(3, 'bameny', '2024-01-12', 100000, 'Antoj'),
(5, 'papasava', '2024-12-29', 2000000, 'GATABAZI');

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `id` int(10) NOT NULL,
  `first_name` varchar(220) NOT NULL,
  `last_name` varchar(220) NOT NULL,
  `user_name` varchar(220) NOT NULL,
  `password` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`id`, `first_name`, `last_name`, `user_name`, `password`) VALUES
(1, 'qwerty', 'asdfg', 'mere', '1234567'),
(2, 'ANTOINETTE', 'GATABAZI MUKESHIMANA', 'GATABAZI', 'GATABAZI07'),
(3, 'QUEEN', 'INEZA', 'GATABAZI', 'INEZA06'),
(4, 'NIYO', 'EMMY', 'EMMA', '3103@Deb'),
(5, '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `actor`
--
ALTER TABLE `actor`
  ADD PRIMARY KEY (`actor_id`);

--
-- Indexes for table `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`contact_id`);

--
-- Indexes for table `filmmaker`
--
ALTER TABLE `filmmaker`
  ADD PRIMARY KEY (`filmmaker_id`);

--
-- Indexes for table `investment`
--
ALTER TABLE `investment`
  ADD PRIMARY KEY (`invest_id`);

--
-- Indexes for table `investors`
--
ALTER TABLE `investors`
  ADD PRIMARY KEY (`investor_id`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`project_id`);

--
-- Indexes for table `signup`
--
ALTER TABLE `signup`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `actor`
--
ALTER TABLE `actor`
  MODIFY `actor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `contract`
--
ALTER TABLE `contract`
  MODIFY `contact_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `filmmaker`
--
ALTER TABLE `filmmaker`
  MODIFY `filmmaker_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `investment`
--
ALTER TABLE `investment`
  MODIFY `invest_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `investors`
--
ALTER TABLE `investors`
  MODIFY `investor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `project_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `signup`
--
ALTER TABLE `signup`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
