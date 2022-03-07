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
    body_part varchar(64) not null,
    equipment varchar(64) not null,
    gif_url varchar(64) not null,
    exercise_name varchar(128) not null,
    exercise_target varchar(64) not null,
    userid int(8) not null,
    
    foreign key(userid)
    references users(userid)
    ON DELETE RESTRICT
	ON UPDATE RESTRICT
)

-- Display users workouts

select users.userid, username, body_part, equipment, gif_url, exercise_name, exercise_target 
from users 
join users_profile 
on users.userid = users_profile.userid 

