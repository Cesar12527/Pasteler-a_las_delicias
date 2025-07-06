-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-07-2025 a las 07:07:30
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pasteleria_las_delicias`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activofijo`
--

CREATE TABLE `activofijo` (
  `idActivoFijo` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `Descripcion` text DEFAULT NULL,
  `fechaAdquisicion` date DEFAULT NULL,
  `valorPrecio` decimal(10,2) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `activofijo`
--

INSERT INTO `activofijo` (`idActivoFijo`, `nombre`, `Descripcion`, `fechaAdquisicion`, `valorPrecio`, `estado`) VALUES
(13, 'Horno', 'Sirve para hornear pan, queque, etc', '2023-11-08', 2635.00, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caja`
--

CREATE TABLE `caja` (
  `idCaja` int(11) NOT NULL,
  `fechaInicio` datetime DEFAULT NULL,
  `fechaCierre` datetime DEFAULT NULL,
  `montoInicial` decimal(10,2) DEFAULT NULL,
  `montoFinal` decimal(10,2) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `caja`
--

INSERT INTO `caja` (`idCaja`, `fechaInicio`, `fechaCierre`, `montoInicial`, `montoFinal`, `estado`, `idEmpleado`) VALUES
(1, '2025-06-01 08:00:00', '2025-06-01 18:00:00', 100.00, 650.00, 'Cerrado', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriaproducto`
--

CREATE TABLE `categoriaproducto` (
  `idCategoria` int(11) NOT NULL,
  `nombreCategoria` varchar(128) NOT NULL,
  `descripcionCategoria` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `categoriaproducto`
--

INSERT INTO `categoriaproducto` (`idCategoria`, `nombreCategoria`, `descripcionCategoria`) VALUES
(1, 'Tortas', 'Tortas de cumpleaños, boda y celebraciones'),
(3, 'Panes', 'Gran variedad de panes como pan integral, semita, etc');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombreCliente` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `documento` varchar(15) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombreCliente`, `apellidos`, `documento`, `telefono`) VALUES
(5, 'Cesar', 'Obb', '65321425', '987654321'),
(6, 'clever', 'loyaga', '1478523689', '9987523325');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL,
  `fechaC` date DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `idProveedor` int(11) DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`idCompra`, `fechaC`, `total`, `idProveedor`, `idEmpleado`) VALUES
(1, '2025-05-31', 180.00, 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecompra`
--

CREATE TABLE `detallecompra` (
  `idDetalleCompra` int(11) NOT NULL,
  `idCompra` int(11) DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precioU` decimal(10,2) DEFAULT NULL,
  `subTotal` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `detallecompra`
--

INSERT INTO `detallecompra` (`idDetalleCompra`, `idCompra`, `idProducto`, `cantidad`, `precioU`, `subTotal`) VALUES
(1, 1, 3, 10, 18.00, 180.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `idDetalleVenta` int(11) NOT NULL,
  `idVenta` int(11) DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `subTotal` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`idDetalleVenta`, `idVenta`, `idProducto`, `cantidad`, `subTotal`) VALUES
(18, 19, 3, 3, 150.00),
(19, 20, 3, 2, 100.00),
(20, 20, 17, 6, 3.00),
(21, 20, 15, 3, 1.50),
(22, 21, 3, 3, 150.00),
(23, 22, 3, 2, 100.00),
(24, 23, 17, 2, 1.00),
(25, 24, 3, 2, 100.00),
(26, 24, 17, 3, 1.50),
(27, 25, 3, 2, 100.00),
(28, 25, 17, 2, 1.00),
(29, 26, 19, 2, 7.00),
(30, 26, 18, 2, 0.60),
(31, 27, 18, 2, 0.60),
(32, 28, 3, 2, 100.00),
(33, 29, 3, 2, 100.00),
(34, 30, 3, 2, 100.00),
(35, 31, 23, 4, 2.00),
(36, 32, 19, 3, 10.50),
(37, 33, 19, 4, 14.00),
(38, 34, 29, 3, 1.50),
(39, 34, 27, 1, 0.60),
(40, 35, 19, 5, 17.50),
(41, 36, 19, 8, 28.00),
(42, 37, 17, 2, 1.00),
(43, 38, 15, 4, 2.00),
(44, 38, 28, 3, 0.90),
(45, 38, 19, 3, 10.50),
(46, 39, 19, 2, 7.00),
(47, 40, 19, 9, 31.50),
(48, 41, 19, 2, 7.00),
(49, 42, 23, 3, 1.50),
(50, 42, 15, 3, 1.50),
(51, 42, 17, 10, 5.00),
(52, 42, 3, 2, 100.00),
(53, 43, 19, 6, 21.00),
(54, 43, 3, 4, 200.00),
(55, 43, 26, 20, 10.00),
(56, 44, 3, 5, 250.00),
(57, 44, 25, 5, 7.50),
(58, 44, 27, 20, 12.00),
(59, 45, 19, 3, 10.50),
(60, 45, 25, 100, 150.00),
(61, 45, 26, 22, 11.00),
(62, 46, 27, 44, 26.40),
(63, 46, 3, 3, 150.00),
(64, 47, 23, 100, 50.00),
(65, 48, 27, 33, 19.80),
(66, 49, 26, 3, 1.50),
(67, 50, 15, 7, 3.50),
(68, 51, 15, 2, 1.00),
(69, 52, 3, 3, 150.00),
(70, 53, 19, 2, 7.00),
(71, 54, 15, 2, 1.00),
(72, 55, 27, 4, 2.40),
(73, 55, 15, 3, 1.50),
(74, 56, 27, 5, 3.00),
(75, 57, 17, 5, 2.50),
(76, 58, 17, 3, 1.50),
(77, 58, 15, 9, 4.50),
(78, 59, 27, 2, 1.20),
(79, 59, 3, 3, 150.00),
(80, 60, 3, 700, 35000.00),
(81, 61, 30, 1, 0.20),
(82, 62, 15, 3, 1.50),
(83, 63, 15, 2, 1.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `nombreEmpleado` varchar(100) NOT NULL,
  `apellidos` varchar(128) NOT NULL,
  `dni` int(8) NOT NULL,
  `telefono` int(9) NOT NULL,
  `correo` varchar(128) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idEmpleado`, `nombreEmpleado`, `apellidos`, `dni`, `telefono`, `correo`, `estado`, `id_usuario`) VALUES
(2, 'Jhosmel Geysen', 'Villa Gomez', 60748934, 948763564, 'Jhosmel1@lasdelicias.com', 'Activo', 1),
(3, 'Milton', 'Huaman Ventura', 30298372, 943873647, 'empleado01@lasdelicias.com', 'Activo', 1),
(6, 'Cesar', 'Obb', 49387467, 957234753, 'Cesar@gmail.com', 'Activo', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodopago`
--

CREATE TABLE `metodopago` (
  `idMetodoPago` int(11) NOT NULL,
  `tipoPago` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `metodopago`
--

INSERT INTO `metodopago` (`idMetodoPago`, `tipoPago`) VALUES
(1, 'Efectivo'),
(2, 'Tarjeta'),
(3, 'Yape');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(100) NOT NULL,
  `precioUnitario` decimal(10,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `unidadMedida` varchar(50) DEFAULT NULL,
  `id_tipo_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `precioUnitario`, `stock`, `unidadMedida`, `id_tipo_categoria`) VALUES
(3, 'torta', 50.00, 59, NULL, 1),
(15, 'torta chocolate', 0.50, 62, NULL, 1),
(17, 'pan integral', 0.50, 67, NULL, 3),
(18, 'cumpado', 0.30, 296, NULL, 3),
(19, 'Torta tres leches', 3.50, 134, NULL, 1),
(23, 'pan Baguette', 0.50, 4, NULL, 3),
(24, 'pan Ciabatta', 1.00, 212, NULL, 3),
(25, 'Pan de molde', 1.50, 1117, NULL, 3),
(26, 'Pan de centeno', 0.50, 77, NULL, 3),
(27, 'Pan pita', 0.60, 13, NULL, 3),
(28, 'Pan de ajo', 0.30, 108, NULL, 3),
(29, 'Pan de hamburguesa', 0.50, 108, NULL, 3),
(30, 'pan popular', 0.20, 128, NULL, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `nombreProveedor` varchar(100) DEFAULT NULL,
  `ruc` varchar(11) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `nombreProveedor`, `ruc`, `telefono`, `direccion`) VALUES
(1, 'Distribuidora Láctea Andina', '20481234567', '951234567', 'Av. Los Lácteos 321'),
(2, 'Panadería Central', '20654321987', '983456789', 'Jr. Panaderos 456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL,
  `nombreRol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nombreRol`) VALUES
(1, 'Administrador'),
(2, 'Cajero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(255) NOT NULL,
  `id_tipo_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `usuario`, `clave`, `id_tipo_rol`) VALUES
(1, 'admin', '$2a$12$7y6wLqZDXCwSWeolJSbhjOTPBA9ESKxtpzSN.dXBEuJJYxJc4T2qe', 1),
(2, 'cajero', '$2a$12$AvLtZ63u5UgMUm2ujVhliu/f37AEezyRyxE.gM2tdsup.tMIzvCEy', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT current_timestamp(),
  `idCliente` int(11) DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL,
  `idMetodoPago` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idVenta`, `total`, `fecha`, `idCliente`, `idEmpleado`, `idMetodoPago`) VALUES
(19, 150.00, '2025-07-02 13:22:39', 5, 2, 1),
(20, 104.50, '2025-07-02 13:37:11', 5, 2, 1),
(21, 150.00, '2025-07-02 15:08:32', 5, 2, 2),
(22, 100.00, '2025-07-02 15:08:52', 6, 6, 2),
(23, 1.00, '2025-07-02 15:10:28', NULL, 6, 2),
(24, 101.50, '2025-07-02 15:12:17', 6, 2, 3),
(25, 101.00, '2025-07-03 18:08:16', 5, 2, 1),
(26, 7.60, '2025-07-03 18:19:45', NULL, 2, 3),
(27, 0.60, '2025-07-04 23:21:22', 5, 3, 1),
(28, 100.00, '2025-07-05 00:23:48', 5, 2, 1),
(29, 100.00, '2025-07-05 01:30:20', NULL, 2, 1),
(30, 100.00, '2025-07-05 01:38:09', NULL, 3, 1),
(31, 2.00, '2025-07-05 01:39:46', NULL, 2, 1),
(32, 10.50, '2025-07-05 04:53:02', 5, 2, 1),
(33, 14.00, '2025-07-05 04:56:54', 6, 6, 1),
(34, 2.10, '2025-07-05 04:58:54', 6, 6, 1),
(35, 17.50, '2025-07-05 05:07:27', 6, 3, 1),
(36, 28.00, '2025-07-05 05:10:48', 6, 6, 2),
(37, 1.00, '2025-07-05 06:46:54', 6, 6, 1),
(38, 13.40, '2025-07-05 06:49:43', 6, 6, 2),
(39, 7.00, '2025-07-05 06:50:55', 6, 6, 1),
(40, 31.50, '2025-07-05 06:53:39', 6, 6, 1),
(41, 7.00, '2025-07-05 06:53:52', 5, 6, 3),
(42, 108.00, '2025-07-05 06:55:17', 6, 6, 3),
(43, 231.00, '2025-07-05 07:01:35', 6, 6, 2),
(44, 269.50, '2025-07-05 07:02:33', 6, 6, 2),
(45, 171.50, '2025-07-05 07:04:01', 6, 6, 2),
(46, 176.40, '2025-07-05 07:04:53', 6, 6, 2),
(47, 50.00, '2025-07-05 07:05:41', NULL, 6, 1),
(48, 19.80, '2025-07-05 07:07:48', NULL, 6, 1),
(49, 1.50, '2025-07-05 07:08:35', 6, 6, 1),
(50, 3.50, '2025-07-05 14:07:35', 6, 6, 1),
(51, 1.00, '2025-07-05 14:13:24', 6, 6, 1),
(52, 150.00, '2025-07-05 14:15:33', 5, 6, 1),
(53, 7.00, '2025-07-05 14:18:20', 6, 6, 1),
(54, 1.00, '2025-07-05 14:22:15', 6, 6, 1),
(55, 3.90, '2025-07-05 23:43:32', 6, 3, 1),
(56, 3.00, '2025-07-06 01:22:19', 5, 3, 1),
(57, 2.50, '2025-07-06 01:30:07', NULL, 6, 1),
(58, 6.00, '2025-07-06 01:30:34', 6, 6, 2),
(59, 151.20, '2025-07-06 01:39:17', 6, 6, 1),
(60, 35000.00, '2025-07-06 02:07:52', NULL, 3, 2),
(61, 0.20, '2025-07-06 02:17:36', 5, 3, 2),
(62, 1.50, '2025-07-06 02:17:58', NULL, 3, 1),
(63, 1.00, '2025-07-06 03:52:58', NULL, 3, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `activofijo`
--
ALTER TABLE `activofijo`
  ADD PRIMARY KEY (`idActivoFijo`);

--
-- Indices de la tabla `caja`
--
ALTER TABLE `caja`
  ADD PRIMARY KEY (`idCaja`),
  ADD KEY `IdEmpleado` (`idEmpleado`);

--
-- Indices de la tabla `categoriaproducto`
--
ALTER TABLE `categoriaproducto`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`idCompra`),
  ADD KEY `IdProveedor` (`idProveedor`),
  ADD KEY `IdEmpleado` (`idEmpleado`);

--
-- Indices de la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  ADD PRIMARY KEY (`idDetalleCompra`),
  ADD KEY `IdCompra` (`idCompra`),
  ADD KEY `IdProducto` (`idProducto`);

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`idDetalleVenta`),
  ADD KEY `IdVenta` (`idVenta`),
  ADD KEY `IdProducto` (`idProducto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idEmpleado`),
  ADD KEY `FK_Usuario` (`id_usuario`);

--
-- Indices de la tabla `metodopago`
--
ALTER TABLE `metodopago`
  ADD PRIMARY KEY (`idMetodoPago`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `FK_idCategoria_Producto` (`id_tipo_categoria`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tipo_rol` (`id_tipo_rol`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `IdCliente` (`idCliente`),
  ADD KEY `IdEmpleado` (`idEmpleado`),
  ADD KEY `IdMetodoPago` (`idMetodoPago`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `activofijo`
--
ALTER TABLE `activofijo`
  MODIFY `idActivoFijo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `caja`
--
ALTER TABLE `caja`
  MODIFY `idCaja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `categoriaproducto`
--
ALTER TABLE `categoriaproducto`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `idCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  MODIFY `idDetalleCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `idDetalleVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `metodopago`
--
ALTER TABLE `metodopago`
  MODIFY `idMetodoPago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `caja`
--
ALTER TABLE `caja`
  ADD CONSTRAINT `caja_ibfk_1` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`);

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`);

--
-- Filtros para la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  ADD CONSTRAINT `detallecompra_ibfk_1` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`),
  ADD CONSTRAINT `detallecompra_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`);

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`),
  ADD CONSTRAINT `detalleventa_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FK_Usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `FK_idCategoria_Producto` FOREIGN KEY (`id_tipo_categoria`) REFERENCES `categoriaproducto` (`idCategoria`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_rol` FOREIGN KEY (`id_tipo_rol`) REFERENCES `rol` (`idRol`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`),
  ADD CONSTRAINT `venta_ibfk_3` FOREIGN KEY (`idMetodoPago`) REFERENCES `metodopago` (`idMetodoPago`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
