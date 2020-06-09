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
	createTime datetime null comment '注册日期'
)
charset=utf8;

create table if not exists mall.es_member_role
(
	id int not null comment '主键'
		primary key,
	member_id int null comment '会员id',
	role_id int null comment '角色id'
)
charset=utf8;

create table if not exists mall.es_permission
(
	id int not null comment '权限id'
		primary key,
	method varchar(10) null comment '方法类型',
	zuul_prefix varchar(30) null comment '网关前缀',
	service_prefix varchar(30) null comment '服务前缀',
	uri varchar(100) null comment '请求路径',
	createTime datetime null comment '创建日期',
	updateTime datetime null comment '更新日期'
)
charset=utf8;

create table if not exists mall.es_role
(
	id int not null comment '角色id'
		primary key,
	role_name varchar(50) null comment '角色名称',
	valid tinyint(1) null comment '是否有效 1是 0否',
	createTime datetime null comment '创建日期',
	updateTime datetime null comment '更新日期'
)
charset=utf8;

create table if not exists mall.es_role_permission
(
	id int not null comment '主键'
		primary key,
	role_id int null comment '角色id',
	permission_id int null comment '权限id'
)
charset=utf8;

create table if not exists mall.mall_store
(
	id int auto_increment comment '门店编码'
		primary key,
	store_name varchar(255) null comment '门店名称',
	parent_id int null comment '上级门店',
	create_date date null comment '注册日期',
	address varchar(255) null comment '门店地址',
	phone int null comment '门店联系电话',
	store_user varchar(255) null comment '门店负责人',
	valid smallint null comment '门店状态：1正常0已禁用'
)
comment '门店信息' charset=utf8;

