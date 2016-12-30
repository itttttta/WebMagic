/*
 Navicat Premium Data Transfer

 Source Server         : wd
 Source Server Type    : MySQL
 Source Server Version : 50632
 Source Host           : localhost
 Source Database       : WuXiaWorld

 Target Server Type    : MySQL
 Target Server Version : 50632
 File Encoding         : utf-8

 Date: 12/30/2016 17:27:06 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `catalogue`
-- ----------------------------
DROP TABLE IF EXISTS `catalogue`;
CREATE TABLE `catalogue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL,
  `origin_url` varchar(255) DEFAULT NULL,
  `catalogue` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `super_title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7960 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `content`
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `catalogue_id` int(11) DEFAULT NULL,
  `content` text,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `catalogue_id` (`catalogue_id`),
  CONSTRAINT `content_ibfk_1` FOREIGN KEY (`catalogue_id`) REFERENCES `catalogue` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
