package workout.exerciseapp.repository;

public interface SQLs {
	public static final String SQL_GET_ALL_EXERCISES = 
			"select * from excercises";

	public static final String SQL_GET_ALL_EXERCISES_BY_LIMIT_OFFSET = 
			"select * from exercises limit ? offset ?";

	public static final String SQL_GET_EXERCISE_BY_ID = 
			"select * from exercises where eid = ? ";

/* 	public static final String SQL_GET_USER_BY_USERNAME =
			"select count(*) user_count from user where username = ?";

	public static final String SQL_ADD_NEW_TASK = 
			"insert into task(username, task_name, priority, due_date) values (?, ?, ?, ?)"; */
}
