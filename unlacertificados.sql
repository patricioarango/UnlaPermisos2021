/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.1.34-MariaDB : Database - UnlaPermisos
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`UnlaPermisos` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `UnlaPermisos`;

/*Table structure for table `lugar` */

DROP TABLE IF EXISTS `lugar`;

CREATE TABLE `lugar` (
  `id_lugar` int(11) NOT NULL AUTO_INCREMENT,
  `codigopostal` varchar(255) DEFAULT NULL,
  `lugar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_lugar`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `lugar` */

insert  into `lugar`(`id_lugar`,`codigopostal`,`lugar`) values (1,'1876','lugar 1'),(2,'1999','lugar 2'),(3,'1548','lugar 3');

/*Table structure for table `permiso` */

DROP TABLE IF EXISTS `permiso`;

CREATE TABLE `permiso` (
  `id_permiso` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `desde` int(11) NOT NULL,
  `hasta` int(11) NOT NULL,
  `persona_id` int(11) NOT NULL,
  PRIMARY KEY (`id_permiso`),
  KEY `FKr7cotsotn36aefd9se2r9hqep` (`desde`),
  KEY `FK5qph98p5ayavfy8pmylekojf1` (`hasta`),
  KEY `FKj4da0kh0pimrahd4nllr0xnwo` (`persona_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `permiso` */

/*Table structure for table `permisodiario` */

DROP TABLE IF EXISTS `permisodiario`;

CREATE TABLE `permisodiario` (
  `motivo` varchar(255) DEFAULT NULL,
  `id_permiso` int(11) NOT NULL,
  PRIMARY KEY (`id_permiso`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `permisodiario` */

/*Table structure for table `permisoperiodo` */

DROP TABLE IF EXISTS `permisoperiodo`;

CREATE TABLE `permisoperiodo` (
  `cantdias` int(11) DEFAULT NULL,
  `vacaciones` bit(1) DEFAULT NULL,
  `id_permiso` int(11) NOT NULL,
  `id_rodado` int(11) NOT NULL,
  PRIMARY KEY (`id_permiso`),
  KEY `FKg1g6ag1pjbrbuq799ynyynss6` (`id_rodado`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `permisoperiodo` */

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `apellido_persona` varchar(255) NOT NULL,
  `dni_persona` bigint(20) NOT NULL,
  `nombre_persona` varchar(255) NOT NULL,
  PRIMARY KEY (`id_persona`),
  UNIQUE KEY `UK_9bruwp5j5764ipjumbkgvf027` (`dni_persona`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `persona` */

insert  into `persona`(`id_persona`,`apellido_persona`,`dni_persona`,`nombre_persona`) values (1,'user1',29119499,'usuario'),(2,'dos',26732003,'usuario');

/*Table structure for table `rodado` */

DROP TABLE IF EXISTS `rodado`;

CREATE TABLE `rodado` (
  `id_rodado` int(11) NOT NULL AUTO_INCREMENT,
  `dominio` varchar(255) NOT NULL,
  `vehiculo` varchar(255) NOT NULL,
  PRIMARY KEY (`id_rodado`),
  UNIQUE KEY `UK_13m3g5b74jl938lil3rvxy9w3` (`dominio`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `rodado` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(50) NOT NULL,
  `createdat` datetime DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `nro_documento` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tipo_documento` varchar(255) DEFAULT NULL,
  `updatedat` datetime DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `id_rol` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  KEY `FK7dauoa8bubikbn7vh34b4dx3o` (`id_rol`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`apellido`,`createdat`,`email`,`enabled`,`nombre`,`nro_documento`,`password`,`tipo_documento`,`updatedat`,`username`,`id_rol`) values (4,'auditor','2021-06-06 23:42:09','unla23@unla.com','','Auditor','2011923423','$2a$10$/uTY/65SEf.l55NIVXwKuevLvzIBph3oLPu8768m5Os6BT/SCiRl.','DNI','2021-06-06 23:42:09','auditor',2),(5,'Arango','2021-06-06 23:38:25','pato.sg2@gmail.com','','Patricio','29119499','$2a$10$u9YluwmwzdmZhRP0hL0VXOE8mw..h188cj9kuuz2rJTD3/JIXvxaK','DNI','2021-06-06 23:38:25','admin',1);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdat` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `role` varchar(100) NOT NULL,
  `updatedat` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`createdat`,`enabled`,`role`,`updatedat`) values (1,'2021-05-19 12:31:00','','ADMINISTRADOR','2021-05-19 12:31:00'),(2,'2021-05-19 12:31:00','','AUDITOR','2021-05-19 12:31:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
