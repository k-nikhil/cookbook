--
-- Table structure for table `table_receipe`
--

DROP TABLE IF EXISTS `table_receipe`;
CREATE TABLE `table_receipe` (
  `receipe_id` int NOT NULL,
  `creation_timestamp` datetime NOT NULL,
  `veg` tinyint NOT NULL DEFAULT '1',
  `suitable_for` int NOT NULL DEFAULT '2',
  `instructions` longtext NOT NULL,
  PRIMARY KEY (`receipe_id`)
);



DROP TABLE IF EXISTS `table_ingredient`;
CREATE TABLE `table_ingredient` (
  `ingrdient_id` int NOT NULL,
  `receipe_id` int NOT NULL,
  `ingredient` varchar(200) NOT NULL,
  PRIMARY KEY (`ingrdient_id`),
  CONSTRAINT `fk_receipe` FOREIGN KEY (`receipe_id`) REFERENCES `table_receipe` (`receipe_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into table_receipe (receipe_id,creation_timestamp,veg,suitable_for,instructions) values (1, '2008-10-03 22:59:52', 1,1, 'cook for 5 mins');

insert into table_ingredient (ingrdient_id,receipe_id, ingredient) values (1,1, 'onion');