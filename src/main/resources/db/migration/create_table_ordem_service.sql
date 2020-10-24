CREATE TABLE `ordem_service` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL DEFAULT 0,
  `description` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT 0.00,
  `status` varchar(20) NOT NULL DEFAULT '',
  `date_open` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `date_finished` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table ordem_service add constraint fk_ordem_service_client
foreign key (client_id) references client (id)