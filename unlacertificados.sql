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

/*Table structure for table `user` */



/*Table structure for table `user_rol` */

/*Data for the table `user_rol` */


/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdat` datetime DEFAULT NULL,
  `role` varchar(100) NOT NULL,
  `updatedat` datetime DEFAULT NULL,
 `enabled` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert  into `user_role`(`id`,`role`,`createdat`,`updatedat`,`enabled`) values (1,'ADMINISTRADOR','2021-05-19 12:31:00','2021-05-19 12:31:00','\0'),(2,'AUDITOR','2021-05-19 12:31:00','2021-05-19 12:31:00','\0');
/*Data for the table `user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `id_rol` bigint(20) NOT NULL,
  `password` longtext NOT NULL,
  `tipo_documento` enum('DNI','CUIT','PASAPORTE') NOT NULL,
  `nro_documento` varchar(45) NOT NULL,
  `createdat` datetime NOT NULL,
  `updatedat` datetime NOT NULL,
  `enabled` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
  ) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`apellido`,`nombre`,`username`,`email`,`id_rol`,`password`,`tipo_documento`,`nro_documento`,`createdat`,`updatedat`,`enabled`) values (3,'arango','patricio','admin','unla@unla.com',1,'$2a$10$Z4arYx02yCWGF9uscf0R3eqpMbhaA6tnkz2Bd2q58CzVV4xhMRMD2','DNI','20119234','2021-05-19 12:31:00','2021-05-19 12:31:00','');

  insert  into `user`(`apellido`,`nombre`,`username`,`email`,`id_rol`,`password`,`tipo_documento`,`nro_documento`,`createdat`,`updatedat`,`enabled`) values ('arango','patricio23','admin23','unla23@unla.com',1,'$2a$10$23','DNI','2011923423','2021-05-19 12:31:00','2021-05-19 12:31:00','');