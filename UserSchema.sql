use exercisedb;

create table users (
	userid int(8) auto_increment not null,
	username varchar(64) not null,
    password varchar(128) not null,

    primary key(userid)
);