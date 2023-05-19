-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 04, 2022 at 04:40 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `medicine`
--

-- --------------------------------------------------------

--
-- Table structure for table `custom`
--

CREATE TABLE IF NOT EXISTS `custom` (
  `cID` int(6) NOT NULL AUTO_INCREMENT,
  `Cname` varchar(200) NOT NULL,
  `Caddress` varchar(200) NOT NULL,
  `cEmail` varchar(150) NOT NULL,
  `CpNo` varchar(15) NOT NULL,
  PRIMARY KEY (`cID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `custom`
--

INSERT INTO `custom` (`cID`, `Cname`, `Caddress`, `cEmail`, `CpNo`) VALUES
(1, 'Dimuthu', 'Negombo Road, Uhumeeya', 'dimuthu@gmail.com', '0775206259');

-- --------------------------------------------------------

--
-- Table structure for table `order1`
--

CREATE TABLE IF NOT EXISTS `order1` (
  `oID` int(6) NOT NULL AUTO_INCREMENT,
  `mediName` varchar(200) NOT NULL,
  `cName` varchar(200) NOT NULL,
  `cAge` varchar(10) NOT NULL,
  `cAddress` varchar(200) NOT NULL,
  PRIMARY KEY (`oID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Table structure for table `pay`
--

CREATE TABLE IF NOT EXISTS `pay` (
  `payID` int(6) NOT NULL AUTO_INCREMENT,
  `oID` varchar(10) NOT NULL,
  `price` varchar(20) NOT NULL,
  `pDate` varchar(20) NOT NULL,
  `pMethod` varchar(20) NOT NULL,
  PRIMARY KEY (`payID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- Table structure for table `pharmacy1`
--

CREATE TABLE IF NOT EXISTS `pharmacy1` (
  `pID` int(6) NOT NULL AUTO_INCREMENT,
  `mediName` varchar(150) NOT NULL,
  `mQty` varchar(10) NOT NULL,
  `mDate` varchar(20) NOT NULL,
  `mSupplier` varchar(100) NOT NULL,
  PRIMARY KEY (`pID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
