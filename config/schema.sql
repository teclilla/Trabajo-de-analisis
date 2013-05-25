-- Database: inmoapp_development
--


CREATE DATABASE inmoapp_development 

DROP TABLE IF EXISTS users;
CREATE TABLE users(
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  email VARCHAR(60),
  first_name VARCHAR(56),
  last_name VARCHAR(56)
);

-- for an owner only need to keep his name , an email and a number-id to
-- reference the owner
drop table if exists owners;
create table owners (
  id int(11) not null auto_increment,
  first_name varchar(56)
  last_name varchar(56)
  email varchar(60) unique
  constraint owners_pk primary key (id)
);     

--
drop table if exists real_estates_agencies;
create table real_estates_agencies(
  id int(11) not null auto_increment,
  name varchar(56),
  city varchar(56) unique,
  street varchar(56) default null,
  street_number int(8) default null,
  email varchar(56) default null,
  neighboorhood varchar(56) default null,
  constraint real_estates_agency_pk primary key (id)

);

drop table if exists buildings;
create table buildings(
  id int(11) not null auto_increment;
  type ENUM('land', 'farm', 'house', 'garage'),
  city varchar(56) unique,
  neighboorhood varchar(56) default null
  street varchar(56) default null,
  street_number int(8) default null,
  owner_id int (20),
  description varchar(250),
  price float(10),
  operation ENUM ('venta', 'alquiler'),
  constraint buildings_pk primary key (id)
);

-- (building, owner) table
drop table if exists building_owner; 
create table building_owner(
  id int(11) not null auto_increment,
  owner_id int (11),
  building_id int (11),
  constrair building_owner_pk primary key (id)
);
