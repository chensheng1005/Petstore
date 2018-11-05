drop database if exists PetstoreDB;
create database PetstoreDB;
use PetstoreDB;
create table `User`(
	user_id int primary key auto_increment,
	user_name varchar(50),
	user_first_name varchar(50),
	user_last_name varchar(50),
	user_email varchar(50),
	user_password varchar(50),
	user_phone varchar(20),
	user_status int
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
insert into `User`(user_name,user_first_name,user_last_name,user_email,user_password,user_phone,user_status) values
('admin','富城','郭','2934293423@qq.com','123456','15093482349',0),
('刘德华','德华','刘','9234213623@qq.com','123456','13393482349',0);
select*from `User`;

select count(*) from `User` where user_name = 'admin' and user_password = '123456';


create table Category( 	# 类型
	category_id int primary key auto_increment,
	category_name varchar(50)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
insert into Category(category_name) values
('狗'),('猫'),('鸟'),('鱼');
select*from Category;

create table Pet(
	pet_id int primary key auto_increment,
	category_id int references Category(category_id),
	pet_name varchar(50),
	pet_price decimal(9,2),
	tag_name varchar(20),
	pet_status enum('可用','待定','已售出'),
	`photo` varchar(255)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

insert into Pet(category_id,pet_name,pet_price,tag_name,pet_status,`photo`) values
(1,'哈士奇',1200,'可爱','可用','1.jpg'),
(1,'茶杯犬',1000,'可爱','可用','2.jpg'),
(1,'藏獒',4000,'可爱','待定','3.jpg'),
(2,'波斯猫',2000,'可爱','可用','4.jpg'),
(3,'金鱼',10,'可爱','已售出','5.jpg');

select*from Pet;

create table `Order`(
	order_id int primary key auto_increment,
	pet_id int references Pet(pet_id),
	user_id int references `User`(user_id),
	order_quantity int,	# 数量
	order_shipDate varchar(100),
	order_status enum('放置','批准','交付'),
	order_complete tinyint(1) default false
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
insert into `Order`(pet_id,user_id,order_quantity,order_shipDate,order_status,order_complete) values
(1,1,1,'2017-10-09','批准',false),
(2,1,1,'2017-10-10','放置',false),
(3,2,1,'2017-11-10','放置',false);
select*from `Order`;

create table Inventories(
	inventories_id int primary key auto_increment,
	inventories_quantity int,
	pet_id int references pet(pet_id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
insert into Inventories(inventories_quantity,pet_id) values
(100,1),(80,2),(90,3),(100,4),(50,5);
select*from Inventories;

update Inventories set inventories_quantity=inventories_quantity+2 where pet_id=1;

create table ApiResponse(
	apiResponse_code int primary key auto_increment,
	apiResponse_type varchar(50),
	apiResponse_message varchar(50)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
insert into ApiResponse(apiResponse_type,apiResponse_message) values
('001','001');



