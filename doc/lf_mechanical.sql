


--CREATE DATABASE `lf_mechanical` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- 创建表product表
CREATE TABLE lf_product(
	seriald VARCHAR(64) PRIMARY KEY,
	product_type_no VARCHAR(64),
	product_type_name VARCHAR(64),
	product_type_img VARCHAR(500),
	product_no VARCHAR(64),
	product_name VARCHAR(64),
	product_img VARCHAR(500),
	req_url VARCHAR(500),
	mark_img VARCHAR(500),
	mark_dec text,
	is_delete VARCHAR(2) DEFAULT 0
)

/*新闻资讯表*/
DROP TABLE IF EXISTS lf_news;
CREATE TABLE lf_news(
	serial_id  VARCHAR(64) PRIMARY KEY,
	news_title text,
	news_content text,
	news_auother VARCHAR(64),
	click_num VARCHAR(10) COMMENT '点击量',
	create_time VARCHAR(64),
	update_time VARCHAR(64),
	is_delete VARCHAR(2) DEFAULT '0' COMMENT '0-有效数据，1-无效数据'
);



DROP TABLE IF EXISTS lf_sysenums;
CREATE TABLE lf_sysenums(
	sys_id VARCHAR(64) PRIMARY KEY,
	sys_no VARCHAR(64),
	sys_key VARCHAR(64),
	sys_value VARCHAR(64),
	sys_desc VARCHAR(2000),
	sys_key1 VARCHAR(64),
	sys_value1 VARCHAR(64),
	sys_desc1 VARCHAR(2000),
	sys_parent_no VARCHAR(64),
	sys_sequ VARCHAR(64),
	create_time VARCHAR(64),
	update_time VARCHAR(64),
	is_delete VARCHAR(2) DEFAULT '0'COMMENT '0-有效数据，1-无效数据'
);