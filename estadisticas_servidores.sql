-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-03-2023 a las 23:00:33
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `estadisticas_servidores`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadisticas`
--

CREATE TABLE `estadisticas` (
  `id` bigint(20) NOT NULL,
  `actualizado` datetime DEFAULT NULL,
  `creado` datetime DEFAULT NULL,
  `disco_disponible` double NOT NULL,
  `disco_total` double NOT NULL,
  `disco_uso` double NOT NULL,
  `id_servidor` int(11) NOT NULL,
  `memoria_disponible` double NOT NULL,
  `memoria_total` double NOT NULL,
  `memoria_uso` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estadisticas`
--

INSERT INTO `estadisticas` (`id`, `actualizado`, `creado`, `disco_disponible`, `disco_total`, `disco_uso`, `id_servidor`, `memoria_disponible`, `memoria_total`, `memoria_uso`) VALUES
(34, '2023-03-14 10:24:38', '2023-03-14 10:24:38', 25, 29, 3, 5, 13, 24, 24),
(36, '2023-03-15 09:17:06', '2023-03-15 09:17:06', 32, 38, 5, 4, 10, 22, 22),
(37, '2023-03-15 09:17:06', '2023-03-15 09:17:06', 25, 29, 3, 5, 15, 25, 25),
(39, '2023-03-15 09:17:14', '2023-03-15 09:17:14', 32, 38, 5, 4, 11, 22, 22),
(40, '2023-03-15 09:17:14', '2023-03-15 09:17:14', 25, 29, 3, 5, 16, 25, 25),
(41, '2023-03-15 11:07:43', '2023-03-15 11:07:43', 30, 38, 8, 1, 11, 22, 22),
(42, '2023-03-15 11:07:43', '2023-03-15 11:07:43', 32, 38, 5, 4, 13, 22, 22),
(43, '2023-03-15 11:07:43', '2023-03-15 11:07:43', 25, 29, 3, 5, 18, 25, 25),
(45, '2022-03-14 00:00:00', '2022-03-14 00:00:00', 30, 38, 8, 1, 1, 15, 22),
(47, '2023-03-16 14:31:12', '2023-03-16 14:31:12', 32, 38, 5, 4, 12, 22, 22),
(48, '2023-03-16 14:31:12', '2023-03-16 14:31:12', 25, 29, 3, 5, 14, 25, 25),
(49, '2023-03-16 14:31:14', '2023-03-16 14:31:14', 30, 38, 8, 1, 15, 22, 22),
(50, '2023-03-16 14:31:14', '2023-03-16 14:31:14', 32, 38, 5, 4, 12, 22, 22),
(51, '2023-03-16 14:31:14', '2023-03-16 14:31:14', 25, 29, 3, 5, 14, 25, 25),
(52, NULL, '2023-01-12 00:00:00', 30, 28, 8, 1, 15, 22, 22),
(53, NULL, '2022-02-12 00:00:00', 30, 28, 8, 1, 15, 22, 22),
(54, NULL, '2022-06-01 00:00:00', 30, 28, 2, 1, 15, 22, 22),
(55, NULL, '2023-03-01 00:00:00', 20, 38, 18, 1, 11, 22, 22),
(56, NULL, '2023-03-02 00:00:00', 20, 38, 18, 1, 11, 22, 22),
(57, NULL, '2023-03-03 00:00:00', 20, 38, 18, 1, 11, 22, 22),
(58, NULL, '2023-03-04 00:00:00', 20, 38, 18, 1, 11, 22, 22),
(59, NULL, '2023-03-05 00:00:00', 20, 38, 18, 1, 11, 22, 22),
(60, NULL, '2023-03-06 00:00:00', 20, 38, 18, 1, 11, 22, 22),
(61, NULL, '2023-03-07 00:00:00', 20, 38, 18, 1, 11, 22, 22),
(62, NULL, '2023-03-08 00:00:00', 20, 38, 18, 1, 11, 22, 22),
(63, NULL, '2023-03-09 00:00:00', 20, 38, 18, 1, 11, 22, 22),
(64, NULL, '2023-03-10 00:00:00', 20, 38, 18, 1, 11, 22, 22),
(65, NULL, '2023-03-11 00:00:00', 20, 38, 18, 1, 11, 22, 22),
(66, NULL, '2023-03-12 00:00:00', 20, 38, 18, 1, 11, 22, 22),
(67, NULL, '2023-03-13 00:00:00', 20, 38, 18, 1, 11, 22, 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servidores`
--

CREATE TABLE `servidores` (
  `id` bigint(20) NOT NULL,
  `actualizado` datetime DEFAULT NULL,
  `creado` datetime DEFAULT NULL,
  `ip_local` varchar(255) DEFAULT NULL,
  `ip_publica` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servidores`
--

INSERT INTO `servidores` (`id`, `actualizado`, `creado`, `ip_local`, `ip_publica`, `nombre`) VALUES
(1, '2023-03-14 10:04:57', '2023-03-12 22:05:18', '10.0.0.27', '168.138.233.89', 'server 1'),
(4, '2023-03-14 10:12:05', '2023-03-14 10:12:05', '10.0.0.155', '152.67.51.191', 'server 2'),
(5, '2023-03-14 10:24:18', '2023-03-14 10:24:18', '10.0.0.4', '20.243.176.56', 'server 3 azure');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estadisticas`
--
ALTER TABLE `estadisticas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `servidores`
--
ALTER TABLE `servidores`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estadisticas`
--
ALTER TABLE `estadisticas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT de la tabla `servidores`
--
ALTER TABLE `servidores`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
