


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