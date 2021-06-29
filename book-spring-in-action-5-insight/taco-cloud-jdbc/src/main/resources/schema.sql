-- 保存配料信息
create table if not exists Ingredient (
  id varchar(4) not null,
  name varchar(25) not null,
  type varchar(10) not null
);
-- 保存taco设计相关的信息
create table if not exists Taco (
  id identity,
  name varchar(50) not null,
  createdAt timestamp not null
);
-- Taco中的每行数据都对应一行或多行，将taco和与之相关的配料映射在一起
create table if not exists Taco_Ingredients (
  taco bigint not null,
  ingredient varchar(4) not null
);

alter table Taco_Ingredients
    add foreign key (taco) references Taco(id);
alter table Taco_Ingredients
    add foreign key (ingredient) references Ingredient(id);
-- 保存必要的订单细节
create table if not exists Taco_Order (
	id identity,
	deliveryName varchar(50) not null,
	deliveryStreet varchar(50) not null,
	deliveryCity varchar(50) not null,
	deliveryState varchar(10) not null,
	deliveryZip varchar(10) not null,
	ccNumber varchar(16) not null,
	ccExpiration varchar(5) not null,
	ccCVV varchar(3) not null,
    placedAt timestamp not null
);
-- Taco_Order中的每行数据都对应一行或多行，将订单和与之相关的taco映射在一起
create table if not exists Taco_Order_Tacos (
	tacoOrder bigint not null,
	taco bigint not null
);

alter table Taco_Order_Tacos
    add foreign key (tacoOrder) references Taco_Order(id);
alter table Taco_Order_Tacos
    add foreign key (taco) references Taco(id);

create table if not exists Users (
    username varchar(20) not null,
    password varchar(70) not null,
    enabled   boolean not null
);

create table if not exists AUTHORITIES (
    username varchar(20) not null,
    authority varchar(20) not null
);

alter table AUTHORITIES
    add foreign key (username) references Users(username);