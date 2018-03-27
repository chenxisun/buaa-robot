CREATE TABLE IF NOT EXISTS dummy (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    dummy_key varchar(255) NOT NULL COMMENT '键',
    dummy_value varchar(255) NOT NULL COMMENT '值',
    version int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    ctime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;