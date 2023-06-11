-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jun 2023 pada 05.31
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbtv`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbakun`
--

CREATE TABLE `tbakun` (
  `username` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbakun`
--

INSERT INTO `tbakun` (`username`, `pass`) VALUES
('admin', '123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbdatatv`
--

CREATE TABLE `tbdatatv` (
  `id` int(11) NOT NULL,
  `nama_tv` varchar(255) NOT NULL,
  `warna_tv` varchar(255) NOT NULL,
  `brand_tv` varchar(255) NOT NULL,
  `size_tv` int(11) NOT NULL,
  `tipe_tv` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbdatatv`
--

INSERT INTO `tbdatatv` (`id`, `nama_tv`, `warna_tv`, `brand_tv`, `size_tv`, `tipe_tv`) VALUES
(1, 'AQUOS', 'Biru', 'SHARP', 55, 'LED'),
(2, 'OLED EVO', 'Abu-Abu', 'LG', 60, 'LED'),
(3, 'TCL 4A', 'Hitam', 'TCL', 45, 'LCD');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbakun`
--
ALTER TABLE `tbakun`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `tbdatatv`
--
ALTER TABLE `tbdatatv`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
