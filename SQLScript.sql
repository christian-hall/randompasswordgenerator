DROP database IF EXISTS PASSWORDMANAGER;
CREATE database PASSWORDMANAGER;
USE PASSWORDMANAGER;

CREATE table PASSWORDS (
	id			int 		primary key  auto_increment,
    result		varchar(20) not null
);

DROP USER IF EXISTS rpg_user@localhost;
CREATE USER rpg_user@localhost IDENTIFIED BY 'sesame';
GRANT SELECT, INSERT ON PASSWORDMANAGER.* TO rpg_user@localhost;