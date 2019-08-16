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

-- 导出  表 picture_auth.authority_url 结构
CREATE TABLE IF NOT EXISTS `authority_url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_id` int(11) NOT NULL COMMENT '角色ID',
  `url_id` int(11) NOT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色可访问资源url';

-- 正在导出表  picture_auth.authority_url 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `authority_url` DISABLE KEYS */;
INSERT INTO `authority_url` (`id`, `authority_id`, `url_id`) VALUES
	(1, 2, 1);
/*!40000 ALTER TABLE `authority_url` ENABLE KEYS */;

-- 导出  表 picture_auth.system_url 结构
CREATE TABLE IF NOT EXISTS `system_url` (
  `id` int(11) NOT NULL,
  `url` varchar(50) NOT NULL COMMENT 'URL地址',
  `describe` varchar(50) DEFAULT NULL COMMENT '描述',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1:禁用 0:启用',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建用户',
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '修改用户',
  `update_time` timestamp NOT NULL COMMENT '修改时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源URL';

-- 正在导出表  picture_auth.system_url 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `system_url` DISABLE KEYS */;
INSERT INTO `system_url` (`id`, `url`, `describe`, `status`, `create_user`, `create_time`, `update_user`, `update_time`, `version`) VALUES
	(1, '/auth/get', '测试用', 0, 'SYSTEM', '2019-08-16 17:54:18', 'SYSTEM', '2019-08-16 17:54:26', 0);
/*!40000 ALTER TABLE `system_url` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
