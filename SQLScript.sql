DROP database IF EXISTS PASSWORDMANAGER;
CREATE database PASSWORDMANAGER;
USE PASSWORDMANAGER;

CREATE table PASSWORDS (
	id			int 		not null auto_increment,
    password	varchar(20) not null,
    timestamp	datetime	not null
);