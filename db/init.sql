DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	id BIGINT(20) NOT NULL PRIMARY KEY COMMENT'主键',
	`code` VARCHAR(16) NOT NULL COMMENT'登陆名',
	`name` VARCHAR(16) NOT NULL COMMENT'用户名',
	`password` VARCHAR(32) NOT NULL COMMENT'密码',
	`sign` VARCHAR(256) NOT NULL COMMENT'个性签名',
	`created_time` DATETIME NOT NULL COMMENT'创建日期',
	`updated_time` DATETIME NOT NULL COMMENT'更新日期'
);

CREATE TABLE `file` (
	`id` BIGINT(20) NOT NULL PRIMARY KEY COMMENT'主键',
	`name` VARCHAR(256) NOT NULL COMMENT'文件名',
	`parent_id` BIGINT(20) NOT NULL COMMENT'父级ID',
	`capability` BIGINT(20) NOT NULL COMMENT'能力位',
	`created_time` DATETIME NOT NULL COMMENT'创建日期',
	`updated_time` DATETIME NOT NULL COMMENT'更新日期'
);

ALTER TABLE `file` ADD COLUMN `level` INT(11) NOT NULL DEFAULT 0 COMMENT'深度',
	ADD COLUMN `level_code` VARCHAR(4096) NOT NULL DEFAULT '' COMMENT'深度编码';
ALTER TABLE `file` ADD COLUMN `create_by` BIGINT(20) NOT NULL COMMENT'创建人',
	ADD COLUMN `update_by` BIGINT(20) NOT NULL COMMENT'更新人';

CREATE TABLE `file_ext` (
	`id` BIGINT(20) NOT NULL PRIMARY KEY COMMENT'主键',
	`ext_name` VARCHAR(128) NOT NULL COMMENT'文件扩展名',
	`size` BIGINT(20) NOT NULL COMMENT'文件大小'
);