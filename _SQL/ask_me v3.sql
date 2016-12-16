-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2016 at 04:33 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ask_me`
--
CREATE DATABASE IF NOT EXISTS `ask_me` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ask_me`;

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `answer` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`id`, `question_id`, `answer`) VALUES
(1, 1, 'Absolutely a dog person'),
(2, 3, 'I dont think so?? Maybe because the programmer team is lousy as hell??'),
(3, 5, 'Uhh, maybe ?? I dont really know.'),
(4, 2, 'Not even one T_T');

-- --------------------------------------------------------

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `id` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `following` varchar(32) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `friend`
--

INSERT INTO `friend` (`id`, `username`, `following`, `date`) VALUES
(1, 'meloniaseven', 'system', '2016-11-28 18:30:13'),
(3, 'test', 'meloniaseven', '2016-11-28 18:30:23'),
(4, 'meloniaseven', 'test', '2016-11-28 20:27:33');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `questioner` varchar(32) NOT NULL,
  `answering` varchar(32) NOT NULL,
  `question` text NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `questioner`, `answering`, `question`, `date`) VALUES
(1, 'system', 'meloniaseven', 'Are you a dog person or a cat person?', '2016-11-29 21:07:50'),
(2, 'system', 'meloniaseven', 'How many pets do you own?', '2016-11-29 21:07:51'),
(3, 'test', 'meloniaseven', 'This is a test question. Do you receive it?', '2016-11-29 21:07:52'),
(4, 'meloniaseven', 'test', 'This is a test question from meloniaseven, do you receive it?', '2016-11-29 21:07:53'),
(5, 'meloniaseven', 'test', 'Hey test, this is a test question on 11/29/2016. Do you receive it?', '2016-11-29 21:07:54'),
(6, 'system', 'meloniaseven', 'Have you ever been to a gym?', '2016-11-29 22:07:12'),
(7, 'system', 'meloniaseven', 'If you were a giant mega monster what city would you rampage?', '2016-11-29 22:32:26');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `email`, `name`, `phone`, `birthday`) VALUES
('meloniaseven', 'testtest', 'meloniaseven@gmail.com', 'Melania Laniwati', '081235797777', '1995-02-07 00:00:00'),
('monicalina', 'monica', 'monicalina27@gmail.com', 'Monica Linawati', '085234112277', '1992-08-27 00:00:00'),
('system', 'system', 'system@admin.com', 'system admin', '00000000', '2016-11-27 00:00:00'),
('test', 'test', 'test@test.com', 'test name wow', '123123123', '1995-08-12 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `question_id` (`question_id`);

--
-- Indexes for table `friend`
--
ALTER TABLE `friend`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `friend`
--
ALTER TABLE `friend`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
