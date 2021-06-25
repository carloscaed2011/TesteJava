-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 25-Jun-2021 às 19:35
-- Versão do servidor: 10.1.35-MariaDB
-- versão do PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testejava`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `pokemon`
--

CREATE TABLE `pokemon` (
  `num` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `pre_evolution` varchar(100) DEFAULT NULL,
  `next_evolution` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pokemon`
--

INSERT INTO `pokemon` (`num`, `name`, `pre_evolution`, `next_evolution`) VALUES
('001', 'Bulbasaur', '', 'Ivysaur Venusaur '),
('002', 'Ivysaur', 'Bulbasaur ', 'Venusaur '),
('003', 'Venusaur', 'Bulbasaur Ivysaur ', ''),
('004', 'Charmander', '', 'Charmeleon Charizard '),
('005', 'Charmeleon', 'Charmander ', 'Charizard '),
('006', 'Charizard', 'Charmander Charmeleon ', ''),
('007', 'Squirtle', '', 'Wartortle Blastoise '),
('008', 'Wartortle', 'Squirtle ', 'Blastoise '),
('009', 'Blastoise', 'Squirtle Wartortle ', ''),
('010', 'Caterpie', '', 'Metapod Butterfree '),
('011', 'Metapod', 'Caterpie ', 'Butterfree '),
('012', 'Butterfree', 'Caterpie Metapod ', ''),
('013', 'Weedle', '', 'Kakuna Beedrill '),
('014', 'Kakuna', 'Weedle ', 'Beedrill '),
('015', 'Beedrill', 'Weedle Kakuna ', ''),
('016', 'Pidgey', '', 'Pidgeotto Pidgeot '),
('017', 'Pidgeotto', 'Pidgey ', 'Pidgeot '),
('018', 'Pidgeot', 'Pidgey Pidgeotto ', ''),
('019', 'Rattata', '', 'Raticate '),
('020', 'Raticate', 'Rattata ', ''),
('021', 'Spearow', '', 'Fearow '),
('022', 'Fearow', 'Spearow ', ''),
('023', 'Ekans', '', 'Arbok '),
('024', 'Arbok', 'Ekans ', ''),
('025', 'Pikachu', '', 'Raichu '),
('026', 'Raichu', 'Pikachu ', ''),
('027', 'Sandshrew', '', 'Sandslash '),
('028', 'Sandslash', 'Sandshrew ', ''),
('029', 'Nidoran â™€ (Female)', '', 'Nidorina Nidoqueen '),
('030', 'Nidorina', 'Nidoran(Female) ', 'Nidoqueen '),
('031', 'Nidoqueen', 'Nidoran(Female) Nidorina ', ''),
('032', 'Nidoran â™‚ (Male)', '', 'Nidorino Nidoking '),
('033', 'Nidorino', 'Nidoran(Male) ', 'Nidoking '),
('034', 'Nidoking', 'Nidoran(Male) Nidorino ', ''),
('035', 'Clefairy', '', 'Clefable '),
('036', 'Clefable', 'Clefairy ', ''),
('037', 'Vulpix', '', 'Ninetales '),
('038', 'Ninetales', 'Vulpix ', ''),
('039', 'Jigglypuff', '', 'Wigglytuff '),
('040', 'Wigglytuff', 'Jigglypuff ', ''),
('041', 'Zubat', '', 'Golbat '),
('042', 'Golbat', 'Zubat ', ''),
('043', 'Oddish', '', 'Gloom Vileplume '),
('044', 'Gloom', 'Oddish ', 'Vileplume '),
('045', 'Vileplume', 'Oddish Gloom ', ''),
('046', 'Paras', '', 'Parasect '),
('047', 'Parasect', 'Paras ', ''),
('048', 'Venonat', '', 'Venomoth '),
('049', 'Venomoth', 'Venonat ', ''),
('050', 'Diglett', '', 'Dugtrio '),
('051', 'Dugtrio', 'Diglett ', ''),
('052', 'Meowth', '', 'Persian '),
('053', 'Persian', 'Meowth ', ''),
('054', 'Psyduck', '', 'Golduck '),
('055', 'Golduck', 'Psyduck ', ''),
('056', 'Mankey', '', 'Primeape '),
('057', 'Primeape', 'Mankey ', ''),
('058', 'Growlithe', '', 'Arcanine '),
('059', 'Arcanine', 'Growlithe ', ''),
('060', 'Poliwag', '', 'Poliwhirl Poliwrath '),
('061', 'Poliwhirl', 'Poliwag ', 'Poliwrath '),
('062', 'Poliwrath', 'Poliwag Poliwhirl ', ''),
('063', 'Abra', '', 'Kadabra Alakazam '),
('064', 'Kadabra', 'Abra ', 'Alakazam '),
('065', 'Alakazam', 'Abra Kadabra ', ''),
('066', 'Machop', '', 'Machoke Machamp '),
('067', 'Machoke', 'Machop ', 'Machamp '),
('068', 'Machamp', 'Machop Machoke ', ''),
('069', 'Bellsprout', '', 'Weepinbell Victreebel '),
('070', 'Weepinbell', 'Bellsprout ', 'Victreebel '),
('071', 'Victreebel', 'Bellsprout Weepinbell ', ''),
('072', 'Tentacool', '', 'Tentacruel '),
('073', 'Tentacruel', 'Tentacool ', ''),
('074', 'Geodude', '', 'Graveler Golem '),
('075', 'Graveler', 'Geodude ', 'Golem '),
('076', 'Golem', 'Geodude Graveler ', ''),
('077', 'Ponyta', '', 'Rapidash '),
('078', 'Rapidash', 'Ponyta ', ''),
('079', 'Slowpoke', '', 'Slowbro '),
('080', 'Slowbro', 'Slowpoke ', ''),
('081', 'Magnemite', '', 'Magneton '),
('082', 'Magneton', 'Magnemite ', ''),
('083', 'Farfetch\'d', '', ''),
('084', 'Doduo', '', 'Dodrio '),
('085', 'Dodrio', 'Doduo ', ''),
('086', 'Seel', '', 'Dewgong '),
('087', 'Dewgong', 'Seel ', ''),
('088', 'Grimer', '', 'Muk '),
('089', 'Muk', 'Grimer ', ''),
('090', 'Shellder', '', 'Cloyster '),
('091', 'Cloyster', 'Shellder ', ''),
('092', 'Gastly', '', 'Haunter Gengar '),
('093', 'Haunter', 'Gastly ', 'Gengar '),
('094', 'Gengar', 'Gastly Haunter ', ''),
('095', 'Onix', '', ''),
('096', 'Drowzee', '', 'Hypno '),
('097', 'Hypno', 'Drowzee ', ''),
('098', 'Krabby', '', 'Kingler '),
('099', 'Kingler', 'Krabby ', ''),
('100', 'Voltorb', '', 'Electrode '),
('101', 'Electrode', 'Voltorb ', ''),
('102', 'Exeggcute', '', 'Exeggutor '),
('103', 'Exeggutor', 'Exeggcute ', ''),
('104', 'Cubone', '', 'Marowak '),
('105', 'Marowak', 'Cubone ', ''),
('106', 'Hitmonlee', '', ''),
('107', 'Hitmonchan', '', ''),
('108', 'Lickitung', '', ''),
('109', 'Koffing', '', 'Weezing '),
('110', 'Weezing', 'Koffing ', ''),
('111', 'Rhyhorn', '', 'Rhydon '),
('112', 'Rhydon', 'Rhyhorn ', ''),
('113', 'Chansey', '', ''),
('114', 'Tangela', '', ''),
('115', 'Kangaskhan', '', ''),
('116', 'Horsea', '', 'Seadra '),
('117', 'Seadra', 'Horsea ', ''),
('118', 'Goldeen', '', 'Seaking '),
('119', 'Seaking', 'Goldeen ', ''),
('120', 'Staryu', '', 'Starmie '),
('121', 'Starmie', 'Staryu ', ''),
('122', 'Mr. Mime', '', ''),
('123', 'Scyther', '', ''),
('124', 'Jynx', '', ''),
('125', 'Electabuzz', '', ''),
('126', 'Magmar', '', ''),
('127', 'Pinsir', '', ''),
('128', 'Tauros', '', ''),
('129', 'Magikarp', '', 'Gyarados '),
('130', 'Gyarados', 'Magikarp ', ''),
('131', 'Lapras', '', ''),
('132', 'Ditto', '', ''),
('133', 'Eevee', '', 'Vaporeon Jolteon Flareon '),
('134', 'Vaporeon', 'Eevee ', ''),
('135', 'Jolteon', 'Eevee ', ''),
('136', 'Flareon', 'Eevee ', ''),
('137', 'Porygon', '', ''),
('138', 'Omanyte', '', 'Omastar '),
('139', 'Omastar', 'Omanyte ', ''),
('140', 'Kabuto', '', 'Kabutops '),
('141', 'Kabutops', 'Kabuto ', ''),
('142', 'Aerodactyl', '', ''),
('143', 'Snorlax', '', ''),
('144', 'Articuno', '', ''),
('145', 'Zapdos', '', ''),
('146', 'Moltres', '', ''),
('147', 'Dratini', '', 'Dragonair Dragonite '),
('148', 'Dragonair', 'Dratini ', 'Dragonite '),
('149', 'Dragonite', 'Dratini Dragonair ', ''),
('150', 'Mewtwo', '', ''),
('151', 'Mew', '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_pokemon`
--

CREATE TABLE `tipo_pokemon` (
  `id` int(11) NOT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `fk_pokemon_num` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tipo_pokemon`
--

INSERT INTO `tipo_pokemon` (`id`, `tipo`, `fk_pokemon_num`) VALUES
(3, 'Grass', '001'),
(4, 'Poison', '001'),
(5, 'Grass', '002'),
(6, 'Poison', '002'),
(7, 'Grass', '003'),
(8, 'Poison', '003'),
(9, 'Fire', '004'),
(10, 'Fire', '005'),
(11, 'Fire', '006'),
(12, 'Flying', '006'),
(13, 'Water', '007'),
(14, 'Water', '008'),
(15, 'Water', '009'),
(16, 'Bug', '010'),
(17, 'Bug', '011'),
(18, 'Bug', '012'),
(19, 'Flying', '012'),
(20, 'Bug', '013'),
(21, 'Poison', '013'),
(22, 'Bug', '014'),
(23, 'Poison', '014'),
(24, 'Bug', '015'),
(25, 'Poison', '015'),
(26, 'Normal', '016'),
(27, 'Flying', '016'),
(28, 'Normal', '017'),
(29, 'Flying', '017'),
(30, 'Normal', '018'),
(31, 'Flying', '018'),
(32, 'Normal', '019'),
(33, 'Normal', '020'),
(34, 'Normal', '021'),
(35, 'Flying', '021'),
(36, 'Normal', '022'),
(37, 'Flying', '022'),
(38, 'Poison', '023'),
(39, 'Poison', '024'),
(40, 'Electric', '025'),
(41, 'Electric', '026'),
(42, 'Ground', '027'),
(43, 'Ground', '028'),
(44, 'Poison', '029'),
(45, 'Poison', '030'),
(46, 'Poison', '031'),
(47, 'Ground', '031'),
(48, 'Poison', '032'),
(49, 'Poison', '033'),
(50, 'Poison', '034'),
(51, 'Ground', '034'),
(52, 'Normal', '035'),
(53, 'Normal', '036'),
(54, 'Fire', '037'),
(55, 'Fire', '038'),
(56, 'Normal', '039'),
(57, 'Normal', '040'),
(58, 'Poison', '041'),
(59, 'Flying', '041'),
(60, 'Poison', '042'),
(61, 'Flying', '042'),
(62, 'Grass', '043'),
(63, 'Poison', '043'),
(64, 'Grass', '044'),
(65, 'Poison', '044'),
(66, 'Grass', '045'),
(67, 'Poison', '045'),
(68, 'Bug', '046'),
(69, 'Grass', '046'),
(70, 'Bug', '047'),
(71, 'Grass', '047'),
(72, 'Bug', '048'),
(73, 'Poison', '048'),
(74, 'Bug', '049'),
(75, 'Poison', '049'),
(76, 'Ground', '050'),
(77, 'Ground', '051'),
(78, 'Normal', '052'),
(79, 'Normal', '053'),
(80, 'Water', '054'),
(81, 'Water', '055'),
(82, 'Fighting', '056'),
(83, 'Fighting', '057'),
(84, 'Fire', '058'),
(85, 'Fire', '059'),
(86, 'Water', '060'),
(87, 'Water', '061'),
(88, 'Water', '062'),
(89, 'Fighting', '062'),
(90, 'Psychic', '063'),
(91, 'Psychic', '064'),
(92, 'Psychic', '065'),
(93, 'Fighting', '066'),
(94, 'Fighting', '067'),
(95, 'Fighting', '068'),
(96, 'Grass', '069'),
(97, 'Poison', '069'),
(98, 'Grass', '070'),
(99, 'Poison', '070'),
(100, 'Grass', '071'),
(101, 'Poison', '071'),
(102, 'Water', '072'),
(103, 'Poison', '072'),
(104, 'Water', '073'),
(105, 'Poison', '073'),
(106, 'Rock', '074'),
(107, 'Ground', '074'),
(108, 'Rock', '075'),
(109, 'Ground', '075'),
(110, 'Rock', '076'),
(111, 'Ground', '076'),
(112, 'Fire', '077'),
(113, 'Fire', '078'),
(114, 'Water', '079'),
(115, 'Psychic', '079'),
(116, 'Water', '080'),
(117, 'Psychic', '080'),
(118, 'Electric', '081'),
(119, 'Electric', '082'),
(120, 'Normal', '083'),
(121, 'Flying', '083'),
(122, 'Normal', '084'),
(123, 'Flying', '084'),
(124, 'Normal', '085'),
(125, 'Flying', '085'),
(126, 'Water', '086'),
(127, 'Water', '087'),
(128, 'Ice', '087'),
(129, 'Poison', '088'),
(130, 'Poison', '089'),
(131, 'Water', '090'),
(132, 'Water', '091'),
(133, 'Ice', '091'),
(134, 'Ghost', '092'),
(135, 'Poison', '092'),
(136, 'Ghost', '093'),
(137, 'Poison', '093'),
(138, 'Ghost', '094'),
(139, 'Poison', '094'),
(140, 'Rock', '095'),
(141, 'Ground', '095'),
(142, 'Psychic', '096'),
(143, 'Psychic', '097'),
(144, 'Water', '098'),
(145, 'Water', '099'),
(146, 'Electric', '100'),
(147, 'Electric', '101'),
(148, 'Grass', '102'),
(149, 'Psychic', '102'),
(150, 'Grass', '103'),
(151, 'Psychic', '103'),
(152, 'Ground', '104'),
(153, 'Ground', '105'),
(154, 'Fighting', '106'),
(155, 'Fighting', '107'),
(156, 'Normal', '108'),
(157, 'Poison', '109'),
(158, 'Poison', '110'),
(159, 'Ground', '111'),
(160, 'Rock', '111'),
(161, 'Ground', '112'),
(162, 'Rock', '112'),
(163, 'Normal', '113'),
(164, 'Grass', '114'),
(165, 'Normal', '115'),
(166, 'Water', '116'),
(167, 'Water', '117'),
(168, 'Water', '118'),
(169, 'Water', '119'),
(170, 'Water', '120'),
(171, 'Water', '121'),
(172, 'Psychic', '121'),
(173, 'Psychic', '122'),
(174, 'Bug', '123'),
(175, 'Flying', '123'),
(176, 'Ice', '124'),
(177, 'Psychic', '124'),
(178, 'Electric', '125'),
(179, 'Fire', '126'),
(180, 'Bug', '127'),
(181, 'Normal', '128'),
(182, 'Water', '129'),
(183, 'Water', '130'),
(184, 'Flying', '130'),
(185, 'Water', '131'),
(186, 'Ice', '131'),
(187, 'Normal', '132'),
(188, 'Normal', '133'),
(189, 'Water', '134'),
(190, 'Electric', '135'),
(191, 'Fire', '136'),
(192, 'Normal', '137'),
(193, 'Rock', '138'),
(194, 'Water', '138'),
(195, 'Rock', '139'),
(196, 'Water', '139'),
(197, 'Rock', '140'),
(198, 'Water', '140'),
(199, 'Rock', '141'),
(200, 'Water', '141'),
(201, 'Rock', '142'),
(202, 'Flying', '142'),
(203, 'Normal', '143'),
(204, 'Ice', '144'),
(205, 'Flying', '144'),
(206, 'Electric', '145'),
(207, 'Flying', '145'),
(208, 'Fire', '146'),
(209, 'Flying', '146'),
(210, 'Dragon', '147'),
(211, 'Dragon', '148'),
(212, 'Dragon', '149'),
(213, 'Flying', '149'),
(214, 'Psychic', '150'),
(215, 'Psychic', '151');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`num`);

--
-- Indexes for table `tipo_pokemon`
--
ALTER TABLE `tipo_pokemon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_tipo_pokemon_2` (`fk_pokemon_num`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tipo_pokemon`
--
ALTER TABLE `tipo_pokemon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=224;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tipo_pokemon`
--
ALTER TABLE `tipo_pokemon`
  ADD CONSTRAINT `FK_tipo_pokemon_2` FOREIGN KEY (`fk_pokemon_num`) REFERENCES `pokemon` (`num`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
