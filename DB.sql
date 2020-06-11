create table if not exists mall.es_member
(
	id int auto_increment comment '会员id'
		primary key,
	user_name varchar(30) null comment '用户名',
	member_name varchar(255) null comment '会员名',
	store_id int null comment '所属门店',
	password varchar(255) null comment '密码',
	email varchar(50) null comment '电子邮箱',
	sex tinyint(1) null comment '性别 1男0女',
	mobile varchar(20) null comment '手机号',
	birthday date null comment '出生日',
	createTime datetime null comment '注册日期',
	constraint es_member_user_name_uindex
		unique (user_name)
)
charset=utf8;
INSERT INTO mall.es_member (id, user_name, member_name, store_id, password, email, sex, mobile, birthday, createTime) VALUES (1, 'fujian', '符剑', 1, '$2a$10$8gJvzqTwm6f7ughjHJR1R.W9Nc3xvEO1KfQsmDp93lsRi7bUcxnyi', '111', 2, '18397511021', '2018-12-13', '2018-12-13 14:27:38');
INSERT INTO mall.es_member (id, user_name, member_name, store_id, password, email, sex, mobile, birthday, createTime) VALUES (5, 'hecheng', '贺成', 1, '$2a$10$jnOhz1ygruQr/RC2pSstGury5prxzNIXwv0HJVSt1D6AjqkEitG7.', null, 1, '18397511021', null, null);
INSERT INTO mall.es_member (id, user_name, member_name, store_id, password, email, sex, mobile, birthday, createTime) VALUES (9, 'futiejun', '符铁军', 1, '$2a$10$55NtlJkpAFeNKpQP0/MWuupCo/abIF7pzAUdcQaufOMPxISOZ5Qba', null, 1, '18397511521', null, null);
INSERT INTO mall.es_member (id, user_name, member_name, store_id, password, email, sex, mobile, birthday, createTime) VALUES (10, 'fubo', '符博', 1, '$2a$10$JxZZEUVqMwfCdkQVo4KhsusAFC8jBpzQ9bH5EjZgqw9thYr4sR/he', null, 1, '18397544512', null, null);

create table if not exists mall.es_member_role
(
	id int auto_increment comment '主键'
		primary key,
	member_id int null comment '会员id',
	role_id int null comment '角色id'
)
charset=utf8;

INSERT INTO mall.es_member_role (id, member_id, role_id) VALUES (1, 1, 1);
INSERT INTO mall.es_member_role (id, member_id, role_id) VALUES (2, 1, 2);

create table if not exists mall.es_permission
(
	id int auto_increment comment '权限id'
		primary key,
	permission_name varchar(255) null comment '资源名称',
	url varchar(64) null comment '路径',
	method varchar(10) null comment '方法类型',
	zuul_prefix varchar(30) null comment '网关前缀',
	service_prefix varchar(30) null comment '服务前缀',
	uri varchar(100) null comment '请求路径',
	createTime datetime null comment '创建日期',
	updateTime datetime null comment '更新日期',
	ranks int null comment '排序',
	parent_id int null comment '上级编码'
)
charset=utf8;
INSERT INTO mall.es_permission (id, permission_name, url, method, zuul_prefix, service_prefix, uri, createTime, updateTime, ranks, parent_id) VALUES (1, '系统管理', '/setting', 'GET', '/api', '/auth', 'exit', '2018-12-14 09:45:35', '2018-12-14 09:45:37', 1, 0);
INSERT INTO mall.es_permission (id, permission_name, url, method, zuul_prefix, service_prefix, uri, createTime, updateTime, ranks, parent_id) VALUES (2, '用户管理', '/sysUser', 'GET', '/api', '/auth', 'member', '2018-12-17 13:23:25', '2018-12-17 13:23:27', 1, 1);
INSERT INTO mall.es_permission (id, permission_name, url, method, zuul_prefix, service_prefix, uri, createTime, updateTime, ranks, parent_id) VALUES (3, '角色管理', '/sysRole', 'GET', '/api', '/member', 'hello', '2018-12-17 13:23:25', '2018-12-17 13:23:25', 2, 1);
INSERT INTO mall.es_permission (id, permission_name, url, method, zuul_prefix, service_prefix, uri, createTime, updateTime, ranks, parent_id) VALUES (4, '资源管理', '/sysPermission', 'GET', '/api', '/member', 'current', '2018-12-17 13:23:25', '2018-12-17 13:23:25', 3, 1);


create table if not exists mall.es_role
(
	id int auto_increment comment '角色id'
		primary key,
	role_name varchar(50) null comment '角色名称',
	valid tinyint(1) null comment '是否有效 1是 0否',
	createTime datetime null comment '创建日期',
	updateTime datetime null comment '更新日期'
)
charset=utf8;
INSERT INTO mall.es_role (id, role_name, valid, createTime, updateTime) VALUES (1, 'ROLE_ADMIN', 1, '2018-12-14 09:46:01', '2018-12-14 09:46:03');
INSERT INTO mall.es_role (id, role_name, valid, createTime, updateTime) VALUES (2, 'ROLE_USER', 1, '2018-12-14 09:46:16', '2018-12-14 09:46:18');

create table if not exists mall.es_role_permission
(
	id int auto_increment comment '主键'
		primary key,
	role_id int null comment '角色id',
	permission_id int null comment '权限id'
)
charset=utf8;
INSERT INTO mall.es_role_permission (id, role_id, permission_id) VALUES (1, 1, 1);
INSERT INTO mall.es_role_permission (id, role_id, permission_id) VALUES (2, 1, 2);
INSERT INTO mall.es_role_permission (id, role_id, permission_id) VALUES (4, 1, 3);
INSERT INTO mall.es_role_permission (id, role_id, permission_id) VALUES (5, 1, 4);
INSERT INTO mall.es_role_permission (id, role_id, permission_id) VALUES (6, 2, 1);
INSERT INTO mall.es_role_permission (id, role_id, permission_id) VALUES (7, 2, 2);

create table if not exists mall.mall_store
(
	id int auto_increment comment '门店编码'
		primary key,
	store_name varchar(255) null comment '门店名称',
	parent_id int null comment '上级门店',
	create_date date null comment '注册日期',
	address varchar(255) null comment '门店地址',
	phone varchar(11) null comment '门店联系电话',
	store_user varchar(255) null comment '门店负责人',
	valid smallint null comment '门店状态：1正常0已禁用'
)
comment '门店信息' charset=utf8;

