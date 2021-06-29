-- 问题之三 JdbcSQLException: Sequence "HIBERNATE_SEQUENCE" not found
CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;

create table if not exists Ingredient
(
    id   varchar(4)  not null,
    name varchar(25) not null,
    type varchar(10) not null
);

-- 问题之四 Column "CREATED_AT" not found 直接修改字段名
-- 原因: Spring / Hibernate 自动将java的驼峰命名的熟悉名转换成用下划线分隔的形式
create table if not exists Taco
(
    id         identity,
    name       varchar(50) not null,
    created_at timestamp   not null
);

create table if not exists Taco_Ingredients
(
    taco_id        bigint     not null,
    ingredients_id varchar(4) not null
);

alter table Taco_Ingredients
    add foreign key (taco_id) references Taco (id);
alter table Taco_Ingredients
    add foreign key (ingredients_id) references Ingredient (id);

-- 问题之五 Value too long for column "DELIVERY_STATE VARCHAR(2)" 增加长度即可
create table if not exists Taco_Order
(
    id              identity,
    user_id         tinyint  not null ,
    delivery_name   varchar(50) not null,
    delivery_street varchar(50) not null,
    delivery_city   varchar(50) not null,
    delivery_state  varchar(10)  not null,
    delivery_zip    varchar(10) not null,
    cc_number       varchar(16) not null,
    cc_expiration   varchar(5)  not null,
    ccCVV           varchar(3)  not null,
    created_at       timestamp   not null
);

create table if not exists Taco_Order_Tacos
(
    order_id bigint not null,
    tacos_id  bigint not null
);

alter table Taco_Order_Tacos
    add foreign key (order_id) references Taco_Order (id);
alter table Taco_Order_Tacos
    add foreign key (tacos_id) references Taco (id);

create table if not exists User (
    id identity,
    username varchar(10) not null ,
    password varchar(70) not null ,
    fullname varchar(10) not null ,
    street varchar(10) not null ,
    city varchar(10) not null ,
    state varchar(10) not null ,
    zip varchar(10) not null ,
    phone_number varchar(10) not null
);

alter table Taco_Order
    add foreign key (user_id) references User (id);
