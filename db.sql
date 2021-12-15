/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.45-community-nt : Database - get_pass
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`get_pass` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `get_pass`;

/*Table structure for table `admins` */

DROP TABLE IF EXISTS `admins`;

CREATE TABLE `admins` (
  `admin_id` int(11) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `gender` varchar(10) default NULL,
  `mobile` varchar(13) default NULL,
  PRIMARY KEY  (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `admins` */

insert  into `admins`(`admin_id`,`name`,`email`,`password`,`gender`,`mobile`) values (1,'admin','admin@gmail.com','12345','male','0987654321');

/*Table structure for table `staffs` */

DROP TABLE IF EXISTS `staffs`;

CREATE TABLE `staffs` (
  `staff_id` int(11) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `gender` varchar(10) default NULL,
  `dob` varchar(13) default NULL,
  `mobile` varchar(13) default NULL,
  `address` varchar(1000) default NULL,
  `department` varchar(100) default NULL,
  `post` varchar(100) default NULL,
  PRIMARY KEY  (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `staffs` */

insert  into `staffs`(`staff_id`,`name`,`email`,`password`,`gender`,`dob`,`mobile`,`address`,`department`,`post`) values (1,'Ram','ram@gmail.com','12345','Male','1990-02-20','0987654321','jabalpur','CSE','HOD'),(2,'sohan','sohan@gamil.com','12345','Male','2017-05-03','0987654321','jabalpur','CSE','Teacher'),(3,'Mohan Kumar','mohan@gamil.com','12345','Male','2017-05-02','0987654321','jabalpur','ME','HOD');

/*Table structure for table `visitors` */

DROP TABLE IF EXISTS `visitors`;

CREATE TABLE `visitors` (
  `visitor_id` int(11) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  `gender` varchar(10) default NULL,
  `mobile` varchar(13) default NULL,
  `address` varchar(1000) default NULL,
  `staff_id` int(11) default NULL,
  `enter_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `out_staff` int(11) default '0',
  `out_staff_time` timestamp NOT NULL default '0000-00-00 00:00:00',
  `final_out` int(11) default '0',
  `final_out_time` timestamp NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`visitor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `visitors` */

insert  into `visitors`(`visitor_id`,`name`,`gender`,`mobile`,`address`,`staff_id`,`enter_time`,`out_staff`,`out_staff_time`,`final_out`,`final_out_time`) values (1,'Visitor','Male','0987654321','jabalpur',1,'2017-05-14 00:23:18',0,'0000-00-00 00:00:00',0,'0000-00-00 00:00:00');

/*Table structure for table `working_staffs` */

DROP TABLE IF EXISTS `working_staffs`;

CREATE TABLE `working_staffs` (
  `working_staff_id` int(11) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `gender` varchar(10) default NULL,
  `dob` varchar(13) default NULL,
  `mobile` varchar(13) default NULL,
  `address` varchar(1000) default NULL,
  PRIMARY KEY  (`working_staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `working_staffs` */

insert  into `working_staffs`(`working_staff_id`,`name`,`email`,`password`,`gender`,`dob`,`mobile`,`address`) values (1,'gita','gita@gmail.com','12345','1990-11-11','0998765432','Female','jabalpur');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
