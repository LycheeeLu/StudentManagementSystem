/*
 Navicat Premium Data Transfer

 Source Server         : mbp-mysql
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : score_management_system

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
                           `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
                           `name` varchar(255) NOT NULL COMMENT 'name',
                           `grade` varchar(50) NOT NULL COMMENT 'grade',
                           `math` double NOT NULL COMMENT 'math',
                           `sport` double NOT NULL COMMENT 'sport',
                           `english` double NOT NULL COMMENT 'english',
                           `java` double NOT NULL COMMENT 'Java',
                           `algorithm` double NOT NULL COMMENT 'algorithm',
                           `policy` double NOT NULL COMMENT 'policy',
                           `average` double NOT NULL COMMENT 'average',
                           `score` double NOT NULL COMMENT 'score',
                           `c_plus_plus` double NOT NULL COMMENT 'C++',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` (`id`, `name`, `grade`, `math`, `sport`, `english`, `java`, `algorithm`, `policy`, `average`, `score`, `c_plus_plus`) VALUES ('101', 'anna', 'CS 1', 88, 90, 87, 98, 89, 70, 88.28571428571429, 618, 96);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;