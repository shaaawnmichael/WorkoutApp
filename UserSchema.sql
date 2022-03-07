use exercisedb;

-- create table with users
create table users (
	userid int(8) auto_increment not null,
	username varchar(64) unique not null,
    password varchar(128) not null,

    primary key(userid)
);

-- initialize random users into table for testing
insert into users (username, password) values ('fred', sha1('fred')), ('wilma', sha1('wilma'))

-- create table(user_profile) to store user data
create table users_profile (

    profileid int(8) auto_increment not null primary key,
    username varchar(64) not null,
    exercise_name varchar(128) not null,
    
    foreign key(username)
    references users(username)
    ON DELETE RESTRICT
	ON UPDATE RESTRICT
)



