
CREATE TABLE IF NOT EXISTS `r_story` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL COMMENT '故事表名字',
    `story_voice_path` varchar(500) DEFAULT NULL COMMENT '故事音频地址',
    `story_vedio_path` varchar(500) DEFAULT NULL COMMENT '故事视频地址',
    `deleted` tinyint(2) unsigned DEFAULT 0 COMMENT '删除标志，0:未删除；1:已删除',
    `version` int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `r_question_answer` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `content` varchar(512) DEFAULT NULL COMMENT '问题内容',
    `voice_path` varchar(512) DEFAULT NULL COMMENT '消息版本',
    `video_path` varchar(512) DEFAULT NULL COMMENT '事件唯一标识,需要保证全局唯一',
    `deleted` tinyint(2) unsigned DEFAULT 0 COMMENT '删除标志，0:未删除；1:已删除',
    `version` int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `r_music` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL COMMENT '故事表名字',
    `story_voice_path` varchar(500) DEFAULT NULL COMMENT '故事音频地址',
    `story_vedio_path` varchar(500) DEFAULT NULL COMMENT '故事视频地址',
    `deleted` tinyint(2) unsigned DEFAULT 0 COMMENT '删除标志，0:未删除；1:已删除',
    `version` int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `r_keyword` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `keyword_content` varchar(100) DEFAULT NULL COMMENT '关键字内容',
    `keyword_re_index` text DEFAULT NULL COMMENT '关键字对应实体的倒排索引',
    `keyword_type` int(11) DEFAULT NULL COMMENT '关键字类型。0：问题；1：歌；2：故事',
    `deleted` tinyint(2) unsigned DEFAULT 0 COMMENT '删除标志，0:未删除；1:已删除',
    `version` int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `r_user` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `machine_code` text DEFAULT NULL COMMENT '登录机器ID',
    `deleted` tinyint(2) unsigned DEFAULT 0 COMMENT '删除标志，0:未删除；1:已删除',
    `version` int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `r_en_word` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `en_content` varchar(200) DEFAULT NULL COMMENT '单词内容',
    `en_ch_content` text DEFAULT NULL COMMENT '单词内容',
    `en_en_content` text DEFAULT NULL COMMENT '单词内容',
    `img_path` varchar(500) DEFAULT NULL COMMENT '单词内容',
    `voice_path` varchar(500) DEFAULT NULL COMMENT '单词内容',
    `deleted` tinyint(2) unsigned DEFAULT 0 COMMENT '删除标志，0:未删除；1:已删除',
    `version` int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `r_en_video_voice` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(500) DEFAULT NULL COMMENT '音乐名',
    `src_path` varchar(500) DEFAULT NULL COMMENT '音乐存储地址',
    `src_type` int(11) DEFAULT NULL COMMENT '类型；0：音频；1：视频',
    `r_type` int(11) DEFAULT NULL COMMENT '类型；0：问题；1：歌；2：故事',
    `deleted` tinyint(2) unsigned DEFAULT 0 COMMENT '删除标志，0:未删除；1:已删除',
    `version` int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `r_topic` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `content` varchar(500) DEFAULT NULL COMMENT '主题内容',
    `deleted` tinyint(2) unsigned DEFAULT 0 COMMENT '删除标志，0:未删除；1:已删除',
    `version` int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `r_topic_word` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `topic_id` int(11) DEFAULT NULL COMMENT '主题ID',
    `word_id` int(11) DEFAULT NULL COMMENT '单词ID',
    `deleted` tinyint(2) unsigned DEFAULT 0 COMMENT '删除标志，0:未删除；1:已删除',
    `version` int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;







