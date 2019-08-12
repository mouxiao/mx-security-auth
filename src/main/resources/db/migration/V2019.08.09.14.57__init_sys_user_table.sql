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


-- 导出 picture_auth 的数据库结构
CREATE DATABASE IF NOT EXISTS `picture_auth` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `picture_auth`;

-- 导出  表 picture_auth.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
																				`id` int(11) NOT NULL AUTO_INCREMENT,
																				`tenant_code` varchar(255) NOT NULL COMMENT '租户编码',
																				`username` varchar(255) NOT NULL COMMENT '用户名',
																				`password` varchar(255) NOT NULL COMMENT '密码',
																				`status` tinyint(2) NOT NULL COMMENT '用户状态',
																				`account_non_expired` tinyint(1) NOT NULL COMMENT '用户的帐户是否已过期',
																				`account_non_locked` tinyint(1) NOT NULL COMMENT '用户是否已锁定或未锁定',
																				`credentials_non_expired` tinyint(1) NOT NULL COMMENT '用户的凭据(密码)是否已过期',
																				`enabled` tinyint(1) NOT NULL COMMENT '禁用/启用',
																				`create_time` timestamp NOT NULL COMMENT '创建时间',
																				`create_user` varchar(50) DEFAULT NULL COMMENT '创建用户',
																				`update_time` timestamp NULL DEFAULT NULL COMMENT '最后一次修改时间',
																				`update_user` varchar(50) DEFAULT NULL COMMENT '最后修改用户',
																				`version` int(11) NOT NULL COMMENT '版本',
																				PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  picture_auth.sys_user 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `tenant_code`, `username`, `password`, `status`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`, `create_time`, `create_user`, `update_time`, `update_user`, `version`) VALUES
(1, 'SYSTEM', 'admin', 'password', 0, 1, 1, 1, 1, '2019-08-12 03:13:08', 'SYSTEM', '2019-08-12 03:13:08', 'SYSTEM', 0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
