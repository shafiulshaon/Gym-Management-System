-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 02, 2017 at 08:25 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `group8f`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE IF NOT EXISTS `accounts` (
  `UserId` int(10) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `Status` varchar(10) NOT NULL,
  `Validity` varchar(10) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`UserId`, `Password`, `Status`, `Validity`) VALUES
(1001, '1234', 'Admin', 'Valid'),
(1003, '1234', 'Member', 'Valid'),
(1002, '1234', 'Instructor', 'Valid');

-- --------------------------------------------------------

--
-- Table structure for table `adminacc`
--

CREATE TABLE IF NOT EXISTS `adminacc` (
  `UserId` int(25) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Gender` varchar(25) NOT NULL,
  `DOB` varchar(25) NOT NULL,
  `Address` varchar(25) NOT NULL,
  `Phone` varchar(100) NOT NULL,
  `Email` varchar(25) NOT NULL,
  `Photo` varchar(100) NOT NULL,
  `JoinDate` varchar(25) NOT NULL,
  `BloodGroup` varchar(25) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminacc`
--

INSERT INTO `adminacc` (`UserId`, `Name`, `Gender`, `DOB`, `Address`, `Phone`, `Email`, `Photo`, `JoinDate`, `BloodGroup`) VALUES
(1001, 'Anik Sadman', 'Male', '24-4-1996', 'Dhaka', '+8801111111111', 'sadmananik1@gmail.com', 'D:/Class/This Semester/Java/GYM Management System/user.png', '30-4-2017', 'B+');

-- --------------------------------------------------------

--
-- Table structure for table `instructoracc`
--

CREATE TABLE IF NOT EXISTS `instructoracc` (
  `UserId` int(25) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Gender` varchar(25) NOT NULL,
  `DOB` varchar(25) NOT NULL,
  `Marital Status` varchar(25) NOT NULL,
  `BloodGroup` varchar(25) NOT NULL,
  `Email` varchar(25) NOT NULL,
  `Phone` varchar(25) NOT NULL,
  `Address` varchar(25) NOT NULL,
  `Photo` varchar(100) NOT NULL,
  `JoinDate` varchar(25) NOT NULL,
  `PaidDate` varchar(25) NOT NULL,
  `GuardianContact` varchar(25) NOT NULL,
  `Batch` varchar(25) NOT NULL,
  `Course` varchar(25) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructoracc`
--

INSERT INTO `instructoracc` (`UserId`, `Name`, `Gender`, `DOB`, `Marital Status`, `BloodGroup`, `Email`, `Phone`, `Address`, `Photo`, `JoinDate`, `PaidDate`, `GuardianContact`, `Batch`, `Course`) VALUES
(1002, 'Shafiul Alam', 'Male', '1-1-1', 'Single', 'B+', 'sadmananik1@gmail.com', '+8801111111111', 'Puran Dhaka', 'D:/Class/This Semester/Java/GYM Management System/user.png', '30-4-2017', '1-1-1', '+8801111111111', 'B1', 'Fat Lose');

-- --------------------------------------------------------

--
-- Table structure for table `memberacc`
--

CREATE TABLE IF NOT EXISTS `memberacc` (
  `UserId` int(25) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Gender` varchar(25) NOT NULL,
  `DOB` varchar(25) NOT NULL,
  `Marital Status` varchar(25) NOT NULL,
  `Height` varchar(25) NOT NULL,
  `Weight` double NOT NULL,
  `BloodGroup` varchar(10) NOT NULL,
  `Email` varchar(25) NOT NULL,
  `Phone` varchar(25) NOT NULL,
  `Address` varchar(25) NOT NULL,
  `Photo` varchar(100) NOT NULL,
  `AdmissionDate` varchar(25) NOT NULL,
  `PaidDate` varchar(25) NOT NULL,
  `GuardianContact` varchar(25) NOT NULL,
  `Course` varchar(25) NOT NULL,
  `Batch` varchar(25) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `memberacc`
--

INSERT INTO `memberacc` (`UserId`, `Name`, `Gender`, `DOB`, `Marital Status`, `Height`, `Weight`, `BloodGroup`, `Email`, `Phone`, `Address`, `Photo`, `AdmissionDate`, `PaidDate`, `GuardianContact`, `Course`, `Batch`) VALUES
(1003, 'Imtiaz Antu', 'Male', '1/1/1900', 'Single ', '1ft0in', 55, 'B+', 'Sadmananik1@gmail.com', '+880', 'Dhaja, Bangladesh', 'D:/Class/This Semester/Java/GYM Management System/user.png', '1/1/2017', '1/1/2017', '+880', 'Build Body ', 'B1');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE IF NOT EXISTS `transaction` (
  `TransactionNo` int(11) NOT NULL,
  `AccountId` int(11) NOT NULL,
  `Status` varchar(25) NOT NULL,
  `ReceiveBill` double NOT NULL,
  `PaySalary` double NOT NULL,
  `Month` int(25) NOT NULL,
  `Year` int(25) NOT NULL,
  `TransactionDate` varchar(25) NOT NULL,
  `AdminId` int(11) NOT NULL,
  PRIMARY KEY (`TransactionNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`TransactionNo`, `AccountId`, `Status`, `ReceiveBill`, `PaySalary`, `Month`, `Year`, `TransactionDate`, `AdminId`) VALUES
(100, 1003, 'Member', 1000, 0, 1, 2017, '1-1-2017', 1001);
