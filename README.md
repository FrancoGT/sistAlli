# sistAlli
Crud Basico en Spring Boot
Necesita un archivo SQL para la Base de datos.
Ejecute los comandos en MySQL: 

CREATE DATABASE IF NOT EXISTS `db_ejemplo` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_ejemplo`;

CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `persona` (`id`, `name`, `telefono`) VALUES
	(1, 'Gricel la loca', '345345345'),
	(2, 'Gonzalo Segundo Rosero', '656456456');
