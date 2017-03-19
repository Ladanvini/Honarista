drop table shares if exists;
drop table orders if exists;
drop table exchanges if exists;
drop table customers if exists;
drop table symbols if exists;

create table shares (
    shid integer not null,
    uid varchar(20) not null,
    symbol varchar(50) not null,
    quantity integer not null,
    primary key (shid)
);

create table orders (
    oid integer not null,
    status integer not null,
    symbol varchar(50) not null,
    price varchar(20) not null,
    uid varchar(20) not null,
    type varchar(20) not null,
    operation varchar(20) not null,
    remainingQuantity integer not null,
    initQuantity integer not null,
    submitDate bigint not null,
    primary key (oid)
);

create table exchanges (
    eid integer not null,
    sellPrice varchar(20) not null,
    buyPrice varchar(20) not null,
    symbol varchar(50) not null,
    type varchar(20) not null,
    sellerId varchar(20) not null,
    buyerId varchar(20) not null,
    quantity integer not null,
    sellRef integer not null,
    buyRef integer not null,
    exchangeDate bigint not null,
    primary key (eid)
);

create table customers (
    cid integer not null,
    uid varchar(20) not null,
    name varchar(50) not null,
    family varchar(50) not null,
    credit integer not null,
    primary key (cid)
);

create table symbols (
    sid integer not null,
    symbol varchar(50) not null,
    primary key (sid)
);

insert into customers values ('0', '1', 'admin', 'adminian', '0');