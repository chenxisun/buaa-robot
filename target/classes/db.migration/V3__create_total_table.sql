CREATE TABLE IF NOT EXISTS r_story (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL COMMENT '故事名',
    voice_path varchar(500) DEFAULT NULL COMMENT '故事音频地址',
    video_path varchar(500) DEFAULT NULL COMMENT '故事视频地址',
    version int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    deleted int(2) NOT NULL DEFAULT 0 COMMENT '删除标志，默认0，1:删除；0:未删除',
    ctime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS r_question_answer (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    `content` varchar(500) DEFAULT NULL COMMENT '问题内容',
    voice_path varchar(500) DEFAULT NULL COMMENT '问题音频地址',
    video_path varchar(500) DEFAULT NULL COMMENT '问题视频地址',
    version int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    deleted int(2) NOT NULL DEFAULT 0 COMMENT '删除标志，默认0，1:删除；0:未删除',
    ctime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS r_music (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL COMMENT '音乐名',
    voice_path varchar(500) DEFAULT NULL COMMENT '音乐音频地址',
    video_path varchar(500) DEFAULT NULL COMMENT '音乐视频地址',
    version int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    deleted int(2) NOT NULL DEFAULT 0 COMMENT '删除标志，默认0，1:删除；0:未删除',
    ctime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS r_keyword (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    `content` varchar(100) DEFAULT NULL COMMENT '关键字',
    keyword_re_index text DEFAULT NULL COMMENT '关键字对实体的倒排索引',
    keyword_type int(11) DEFAULT 0 COMMENT '关键字类型。0：问题；1：歌；2：故事',
    version int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    deleted int(2) NOT NULL DEFAULT 0 COMMENT '删除标志，默认0，1:删除；0:未删除',
    ctime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS r_user (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    `machine_code` varchar(500) DEFAULT NULL COMMENT '登录机器ID',
    version int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    deleted int(2) NOT NULL DEFAULT 0 COMMENT '删除标志，默认0，1:删除；0:未删除',
    ctime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS r_en_word (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    `en_content` varchar(500) DEFAULT NULL COMMENT '单词内容',
    `en_ch_content` text DEFAULT NULL COMMENT '单词的中文翻译',
    `en_en_content` text DEFAULT NULL COMMENT '单词的英文翻译',
    `img_path` varchar(500) DEFAULT NULL COMMENT '图片地址',
    `voice_path` varchar(500) DEFAULT NULL COMMENT '音频地址',
    version int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    deleted int(2) NOT NULL DEFAULT 0 COMMENT '删除标志，默认0，1:删除；0:未删除',
    ctime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS r_en_video_voice (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(500) DEFAULT NULL COMMENT '音乐名',
    `src_path` varchar(500) DEFAULT NULL COMMENT '音乐音频存储地址',
    `src_type` int(11) DEFAULT 0 COMMENT '类型；0：音频；1：视频',
    `r_type` int(11) DEFAULT 0 COMMENT '类型；0：问题；1：歌；2：故事',
    version int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    deleted int(2) NOT NULL DEFAULT 0 COMMENT '删除标志，默认0，1:删除；0:未删除',
    ctime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS r_topic (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    `content` varchar(500) DEFAULT NULL COMMENT '主题内容',
    version int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    deleted int(2) NOT NULL DEFAULT 0 COMMENT '删除标志，默认0，1:删除；0:未删除',
    ctime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE IF NOT EXISTS r_topic_word (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    topic_id int(11) NOT NULL DEFAULT 0 COMMENT '主题内容ID',
    word_id int(11) NOT NULL DEFAULT 0 COMMENT '单词内容ID',
    version int(11) NOT NULL DEFAULT 1 COMMENT '版本号, 默认为1',
    deleted int(2) NOT NULL DEFAULT 0 COMMENT '删除标志，默认0，1:删除；0:未删除',
    ctime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mtime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

