-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2022 at 05:40 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nongnghiep`
--

-- --------------------------------------------------------

--
-- Table structure for table `nongsan`
--

CREATE TABLE `nongsan` (
  `maNongSan` int(6) NOT NULL,
  `tenNongSan` varchar(255) NOT NULL,
  `donViTinh` varchar(255) NOT NULL,
  `giaTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nongsan`
--

INSERT INTO `nongsan` (`maNongSan`, `tenNongSan`, `donViTinh`, `giaTien`) VALUES
(1, 'Lúa mì (Mới nhập)', 'bao', 120000),
(2, 'Lúa gạo', 'kg', 140000),
(3, 'Lúa nếp', 'kg', 160000),
(4, 'Lúa xanh', 'kg', 180000),
(5, 'Lúa chín', 'kg', 200000),
(6, 'Bắp ngô', 'trái', 5000),
(7, 'Bắp rang bơ', 'hộp', 220000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `nongsan`
--
ALTER TABLE `nongsan`
  ADD PRIMARY KEY (`maNongSan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nongsan`
--
ALTER TABLE `nongsan`
  MODIFY `maNongSan` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
