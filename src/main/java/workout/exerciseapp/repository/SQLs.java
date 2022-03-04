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
			//"select * from exercises where exercise_name like ? or equipment like ? or body_part like ? or exercise_target like ?";
			//"select * from exercises where exercise_name like '%?%' or equipment like '%?%' or body_part like '%?%' or exercise_target like '%?%'";
	public static final String SQL_ADD_EXERCISE = 
			"insert into exercises (body_part, equipment, gif_url, exercise_name, exercise_target) VALUES (?, ?, ?, ?, ?)";

/* 	public static final String SQL_GET_USER_BY_USERNAME =
			"select count(*) user_count from user where username = ?";

	public static final String SQL_ADD_NEW_TASK = 
			"insert into task(username, task_name, priority, due_date) values (?, ?, ?, ?)"; */
}
