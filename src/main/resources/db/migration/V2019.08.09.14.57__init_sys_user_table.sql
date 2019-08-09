CREATE TABLE `SYS_USER` (
													`id` INT(11) NOT NULL AUTO_INCREMENT,
													`tenant_code` VARCHAR(255) NOT NULL COMMENT '租户编码',
													`username` VARCHAR(255) NOT NULL COMMENT '用户名',
													`password` VARCHAR(255) NOT NULL COMMENT '密码',
													`status` TINYINT(2) NOT NULL COMMENT '用户状态',
													`account_non_expired` TINYINT(1) NOT NULL COMMENT '用户的帐户是否已过期',
													`account_non_locked` TINYINT(1) NOT NULL COMMENT '用户是否已锁定或未锁定',
													`credentials_non_expired` TINYINT(1) NOT NULL COMMENT '用户的凭据(密码)是否已过期',
													`enabled` TINYINT(1) NOT NULL COMMENT '禁用/启用',
													`version` INT(11) NOT NULL COMMENT '版本',
													`create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
													`create_user` VARCHAR(50) NULL DEFAULT NULL COMMENT '创建用户',
													`update_time` TIMESTAMP NULL DEFAULT NULL COMMENT '最后一次修改时间',
													`update_user` VARCHAR(50) NULL DEFAULT NULL COMMENT '最后修改用户',
													PRIMARY KEY (`id`)
)
	COLLATE='utf8_general_ci'
	ENGINE=InnoDB
;
