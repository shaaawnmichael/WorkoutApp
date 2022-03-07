package workout.exerciseapp.repository;

public interface SQLs {
	public static final String SQL_GET_ALL_EXERCISES = 
			"select * from excercises";

	public static final String SQL_GET_ALL_EXERCISES_BY_LIMIT_OFFSET = 
			"select * from exercises limit ? offset ?";

	public static final String SQL_GET_EXERCISE_BY_ID = 
			"select * from exercises where eid = ? ";
	
	public static final String SQL_SEARCH = 
			"SELECT * FROM exercises WHERE MATCH (exercise_name, equipment, body_part, exercise_target) AGAINST (?)";
			
	public static final String SQL_ADD_EXERCISE = 
			"insert into exercises (body_part, equipment, gif_url, exercise_name, exercise_target) VALUES (?, ?, ?, ?, ?)";

	public static final String SQL_ADD_USERS =
			"insert into users (username, password) values (?, sha1(?))";
	
/*  	public static final String SQL_CREATE_USER_PROFILE =
				  "create table if not exists ? (\n"
				+ "body_part varchar(64) not null,\n"
				+ "equipment varchar(64) not null, \n"
				+ "gif_url varchar(64) not null, \n"
				+ "exercise_name varchar(128) not null, \n"
				+ "exercise_target varchar(64) not null, \n"
				+ "uid int auto_increment not null, \n"
				+ "primary key(uid), \n"
				
				+ "foreign key(uid) \n"
				+ "references users(userid) \n"
				+ "ON DELETE CASCADE \n"
				+ "ON UPDATE RESTRICT\n"
			+ ");";  */

	public static final String SQL_GET_USER_PROFILE =
			"select * from users_profile where username = ?";

	public static final String SQL_GET_ALL_PROFILES =
			"select * from users_profile";

	public static final String SQL_ADD_EXERCISE_TO_PROFILE =
			"INSERT INTO users_profile (username, exercise_name) VALUES (?,?)";

	public static final String SQL_GET_USER_PROFILE_EXERCISES =
			"Select exercise_name from users_profile where username = ?";

	public static final String SQL_ALL_USER_PROFILE_EXERCISES =
			"Select * from users_profile";

/* 	public static final String SQL_CREATE_USER_PROFILE = 
				  "create table if not exists " + username + " (\n"
				+ "body_part varchar(64) not null,\n"
				+ "equipment varchar(64) not null, \n"
				+ "gif_url varchar(64) not null, \n"
				+ "exercise_name varchar(128) not null, \n"
				+ "exercise_target varchar(64) not null, \n"
				+ "uid int auto_increment not null, \n"
				+ "primary key(uid), \n"
				
				+ "foreign key(uid) \n"
				+ "references users(userid) \n"
				+ "ON DELETE CASCADE \n"
				+ "ON UPDATE RESTRICT\n"
			+ ");"; */
	

}
