-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 04-Mar-2019 às 18:20
-- Versão do servidor: 10.1.37-MariaDB
-- versão do PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chavoso`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acoes`
--

CREATE TABLE `acoes` (
  `id_acao` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `acoes`
--

INSERT INTO `acoes` (`id_acao`, `nome`) VALUES
(1, 'Entrega de chave'),
(2, 'Devolução de chave'),
(3, 'Inicio de limpeza'),
(4, 'Termino de limpeza'),
(5, 'Inicio de Manutencao'),
(6, 'Termino de manutencao'),
(7, 'Administrador alterou o estado do lab');

-- --------------------------------------------------------

--
-- Estrutura da tabela `adiministrador`
--

CREATE TABLE `adiministrador` (
  `id_adm` int(11) NOT NULL,
  `id_pessoa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `adiministrador`
--

INSERT INTO `adiministrador` (`id_adm`, `id_pessoa`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `auxiliar_limpeza`
--

CREATE TABLE `auxiliar_limpeza` (
  `id_aux_limpeza` int(11) NOT NULL,
  `id_pessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `auxiliar_limpeza`
--

INSERT INTO `auxiliar_limpeza` (`id_aux_limpeza`, `id_pessoa`) VALUES
(1, 9);

-- --------------------------------------------------------

--
-- Estrutura da tabela `chave`
--

CREATE TABLE `chave` (
  `id_chave` int(11) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `chave`
--

INSERT INTO `chave` (`id_chave`, `numero`) VALUES
(45, 1),
(46, 2),
(47, 3),
(48, 4),
(49, 5),
(50, 6),
(51, 7),
(52, 8),
(53, 9),
(54, 10),
(55, 11),
(56, 12),
(57, 13),
(58, 14),
(59, 15),
(60, 16),
(61, 17),
(62, 18),
(63, 19),
(64, 20),
(65, 21),
(66, 22),
(67, 23),
(68, 24),
(69, 25),
(70, 26),
(71, 27),
(72, 28),
(73, 29),
(74, 30),
(75, 31),
(76, 32),
(77, 33),
(78, 34),
(79, 35),
(80, 36),
(81, 37),
(82, 38),
(83, 39),
(84, 40),
(85, 41),
(86, 42),
(87, 43),
(88, 44);

-- --------------------------------------------------------

--
-- Estrutura da tabela `departamento`
--

CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `sigla` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `departamento`
--

INSERT INTO `departamento` (`id_departamento`, `nome`, `sigla`) VALUES
(1, 'Departamento de computaçao', 'DCOMP'),
(2, 'Departamento de construção civil', 'DCC'),
(3, 'Departamento de Design', 'DDE'),
(4, 'Departamento de Segurança do Trabalho', 'DST'),
(5, 'Departamento de Engenharia Elétrica', 'DEE'),
(6, 'Departamento Acadêmico de Química', 'DAQ'),
(7, 'Departamento de Mecânica', 'DMM');

-- --------------------------------------------------------

--
-- Estrutura da tabela `header`
--

CREATE TABLE `header` (
  `id_header` int(11) NOT NULL,
  `data` varchar(30) DEFAULT NULL,
  `id_acao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `laboratorio`
--

CREATE TABLE `laboratorio` (
  `id_laboratorio` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `id_departamento` int(11) DEFAULT NULL,
  `disponibilidade` varchar(30) CHARACTER SET utf16 COLLATE utf16_bin DEFAULT NULL,
  `numero_chave` int(11) NOT NULL,
  `acao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `laboratorio`
--

INSERT INTO `laboratorio` (`id_laboratorio`, `numero`, `id_departamento`, `disponibilidade`, `numero_chave`, `acao`) VALUES
(45, 26, 1, 'disponivel', 1, 'Chave com o Administrador'),
(46, 27, 1, 'disponivel', 3, 'Chave com o Administrador'),
(47, 23, 1, 'disponivel', 4, 'Chave com o Administrador'),
(48, 24, 1, 'disponivel', 5, 'Chave com o Administrador'),
(49, 25, 1, 'disponivel', 6, 'Chave com o Administrador'),
(50, 1, 2, 'disponivel', 7, 'Chave com o Administrador'),
(52, 2, 2, 'disponivel', 9, 'Chave com o Administrador'),
(53, 3, 2, 'disponivel', 10, 'Chave com o Administrador'),
(54, 4, 3, 'disponivel', 11, 'Chave com o Administrador'),
(55, 8, 3, 'disponivel', 12, 'Chave com o Administrador'),
(56, 10, 3, 'disponivel', 13, 'Chave com o Administrador'),
(57, 1, 4, 'disponivel', 14, 'Chave com o Administrador'),
(58, 2, 4, 'disponivel', 15, 'Chave com o Administrador'),
(59, 1, 5, 'disponivel', 16, 'Chave com o Administrador'),
(60, 2, 5, 'disponivel', 17, 'Chave com o Administrador'),
(61, 3, 5, 'disponivel', 18, 'Chave com o Administrador'),
(62, 4, 5, 'disponivel', 19, 'Chave com o Administrador'),
(63, 5, 5, 'disponivel', 20, 'Chave com o Administrador'),
(64, 6, 5, 'disponivel', 21, 'Chave com o Administrador'),
(65, 7, 5, 'disponivel', 22, 'Chave com o Administrador'),
(66, 1, 6, 'disponivel', 23, 'Chave com o Administrador'),
(67, 2, 6, 'disponivel', 24, 'Chave com o Administrador'),
(68, 3, 6, 'disponivel', 25, 'Chave com o Administrador'),
(69, 4, 6, 'disponivel', 26, 'Chave com o Administrador'),
(73, 1, 7, 'disponivel', 30, 'Chave com o Administrador'),
(74, 2, 7, 'disponivel', 31, 'Chave com o Administrador'),
(75, 3, 7, 'disponivel', 32, 'Chave com o Administrador'),
(76, 4, 7, 'disponivel', 33, 'Chave com o Administrador'),
(77, 5, 7, 'disponivel', 34, 'Chave com o Administrador'),
(78, 6, 7, 'disponivel', 35, 'Chave com o Administrador'),
(79, 7, 7, 'disponivel', 36, 'Chave com o Administrador'),
(80, 8, 7, 'disponivel', 37, 'Chave com o Administrador'),
(81, 9, 7, 'disponivel', 38, 'Chave com o Administrador'),
(82, 10, 7, 'disponivel', 39, 'Chave com o Administrador'),
(83, 11, 7, 'disponivel', 40, 'Chave com o Administrador'),
(84, 12, 7, 'disponivel', 41, 'Chave com o Administrador'),
(85, 5, 6, 'disponivel', 42, 'Chave com o Administrador'),
(86, 6, 6, 'disponivel', 43, 'Chave com o Administrador'),
(87, 7, 6, 'disponivel', 44, 'Chave com o Administrador');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `id_pessoa` int(11) NOT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `senha` varchar(60) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id_pessoa`, `nome`, `senha`, `cpf`) VALUES
(1, 'David Alysson', 'senha1', '12345678911'),
(2, 'Elias Lima', 'senha2', '98765432114'),
(3, 'Samuel Rêgo', 'senha3', '12312312311'),
(4, 'Emanuel Lindoso', 'senha4', '83765123781'),
(5, 'Gabriel Ruivo', 'senha5', '89123798127'),
(6, 'Alexsandro Soares', 'senha6', '36129874517'),
(7, 'Alexsandre Serejo', 'senha7', '21937481267'),
(8, 'Pedro Victor', 'senha8', '23456789011'),
(9, 'Lucas Neto', 'senha9', '76576575345');

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `id_professor` int(11) NOT NULL,
  `id_departamento` int(11) DEFAULT NULL,
  `id_pessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`id_professor`, `id_departamento`, `id_pessoa`) VALUES
(1, 1, 2),
(2, 2, 3),
(3, 3, 4),
(4, 4, 5),
(5, 5, 6),
(6, 6, 7),
(7, 7, 8);

-- --------------------------------------------------------

--
-- Estrutura da tabela `relatorio`
--

CREATE TABLE `relatorio` (
  `id_relatorio` int(11) NOT NULL,
  `id_pessoa_autor` int(11) DEFAULT NULL,
  `id_pessoa_admin` int(11) DEFAULT NULL,
  `verificacao_senha` tinyint(1) DEFAULT NULL,
  `lab_disponibilidade` varchar(30) DEFAULT NULL,
  `id_header` int(11) DEFAULT NULL,
  `numero_chave` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acoes`
--
ALTER TABLE `acoes`
  ADD PRIMARY KEY (`id_acao`);

--
-- Indexes for table `adiministrador`
--
ALTER TABLE `adiministrador`
  ADD PRIMARY KEY (`id_adm`),
  ADD KEY `id_pessoa` (`id_pessoa`);

--
-- Indexes for table `auxiliar_limpeza`
--
ALTER TABLE `auxiliar_limpeza`
  ADD PRIMARY KEY (`id_aux_limpeza`),
  ADD KEY `id_pessoa` (`id_pessoa`);

--
-- Indexes for table `chave`
--
ALTER TABLE `chave`
  ADD PRIMARY KEY (`id_chave`),
  ADD UNIQUE KEY `numero` (`numero`);

--
-- Indexes for table `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id_departamento`),
  ADD UNIQUE KEY `nome` (`nome`),
  ADD UNIQUE KEY `sigla` (`sigla`);

--
-- Indexes for table `header`
--
ALTER TABLE `header`
  ADD PRIMARY KEY (`id_header`),
  ADD KEY `id_acao` (`id_acao`);

--
-- Indexes for table `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`id_laboratorio`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`id_pessoa`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`id_professor`),
  ADD KEY `id_pessoa` (`id_pessoa`),
  ADD KEY `id_departamento` (`id_departamento`);

--
-- Indexes for table `relatorio`
--
ALTER TABLE `relatorio`
  ADD PRIMARY KEY (`id_relatorio`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `acoes`
--
ALTER TABLE `acoes`
  MODIFY `id_acao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `adiministrador`
--
ALTER TABLE `adiministrador`
  MODIFY `id_adm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `auxiliar_limpeza`
--
ALTER TABLE `auxiliar_limpeza`
  MODIFY `id_aux_limpeza` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `chave`
--
ALTER TABLE `chave`
  MODIFY `id_chave` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;

--
-- AUTO_INCREMENT for table `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id_departamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `header`
--
ALTER TABLE `header`
  MODIFY `id_header` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `laboratorio`
--
ALTER TABLE `laboratorio`
  MODIFY `id_laboratorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;

--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `id_pessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `professor`
--
ALTER TABLE `professor`
  MODIFY `id_professor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `relatorio`
--
ALTER TABLE `relatorio`
  MODIFY `id_relatorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `adiministrador`
--
ALTER TABLE `adiministrador`
  ADD CONSTRAINT `adiministrador_ibfk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`);

--
-- Limitadores para a tabela `auxiliar_limpeza`
--
ALTER TABLE `auxiliar_limpeza`
  ADD CONSTRAINT `auxiliar_limpeza_ibfk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`);

--
-- Limitadores para a tabela `header`
--
ALTER TABLE `header`
  ADD CONSTRAINT `header_ibfk_1` FOREIGN KEY (`id_acao`) REFERENCES `acoes` (`id_acao`);

--
-- Limitadores para a tabela `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`),
  ADD CONSTRAINT `professor_ibfk_2` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
