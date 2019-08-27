-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.13 - MySQL Community Server - GPL
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 picture_auth.client_registration 结构
CREATE TABLE IF NOT EXISTS `client_registration` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `registration_id` varchar(50) NOT NULL COMMENT '注册ID',
  `client_id` varchar(50) DEFAULT NULL COMMENT 'clientID',
  `client_secret` varchar(50) DEFAULT NULL COMMENT 'clientSecret',
  `redirect_uri_template` varchar(50) NOT NULL COMMENT '重定向URI',
  `authorization_uri` varchar(50) NOT NULL COMMENT '授权服务器URI',
  `token_uri` varchar(50) NOT NULL COMMENT '授权令牌端点URI',
  `user_info_uri` varchar(50) NOT NULL COMMENT 'UserInfo端点URI',
  `username_attribute_name` varchar(50) NOT NULL COMMENT 'UserInfo响应中返回的属性的名称',
  `jwk_set_uri` varchar(50) NOT NULL COMMENT '授权服务器检索JSON Web密钥集(JWK)的URI',
  `client_name` varchar(50) DEFAULT NULL COMMENT 'clientName',
  `grant_type` enum('AUTHORIZATION_CODE','IMPLICIT','REFRESH_TOKEN','CLIENT_CREDENTIALS') DEFAULT NULL COMMENT '授权授予类型',
  `authentication_method` enum('BASIC','POST') DEFAULT NULL COMMENT '客户端进行身份验证的方法',
  `status` varchar(50) NOT NULL COMMENT '状态',
  `create_user` varchar(50) NOT NULL COMMENT '创建用户',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(50) NOT NULL COMMENT '修改用户',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `version` int(11) NOT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
