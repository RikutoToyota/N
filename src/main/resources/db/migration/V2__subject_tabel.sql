CREATE TABLE `subject` (
	 id SERIAL NOT NULL,
	`school_cd` CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学校コード',
	`cd` CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '科目コード',
	`name` VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '科目名',
	PRIMARY KEY (`school_cd`,`cd`)
);