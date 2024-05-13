CREATE TABLE `schoolNum` (
	`id` SERIAL,
	`schoolCd` CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学校コード',
	`classNum` VARCHAR(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'クラス番号',
	PRIMARY KEY (`schoolCd`,`classNum`)
) ENGINE=InnoDB;