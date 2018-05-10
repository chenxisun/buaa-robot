CREATE TABLE IF NOT EXISTS r_weather (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    `r_date` char(12) DEFAULT NULL COMMENT '日期',
    `r_city` varchar(500) DEFAULT NULL COMMENT '城市',
    `result` text DEFAULT NULL COMMENT '天气结果',
    version int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    deleted int(2) NOT NULL DEFAULT 0 COMMENT '删除标志，默认0，1:删除；0:未删除',
    ctime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


