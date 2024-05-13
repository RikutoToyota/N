CREATE TABLE `school` (
	`id` SERIAL,
	`cd` CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学校コード',
	`name` VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学校名',
	PRIMARY KEY (`cd`)
) ENGINE=InnoDB;