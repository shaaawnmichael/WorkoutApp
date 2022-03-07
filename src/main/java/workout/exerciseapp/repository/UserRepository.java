package workout.exerciseapp.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import workout.exerciseapp.model.User;
import static workout.exerciseapp.repository.SQLs.*;

@Repository
public class UserRepository {

	private static final String SQL_SELECT_USER_BY_USERNAME =
		"select * from users where username = ?";

	private static final String SQL_COMPARE_PASSWORDS_BY_USERNAME = 
		"select count(*) as user_count from users where username = ? and password = sha1(?)";

	@Autowired
	private JdbcTemplate template;

	public Optional<User> findUserByName(String username) {
		final SqlRowSet rs = template.queryForRowSet(SQL_SELECT_USER_BY_USERNAME, username);
		if (rs.next())
			return Optional.of(User.populate(rs));
		return Optional.empty();
	}

	public boolean validateUser(String username, String password) {
		final SqlRowSet rs = template.queryForRowSet(SQL_COMPARE_PASSWORDS_BY_USERNAME, username, password);
		if (!rs.next())
			return false;

		return rs.getInt("user_count") > 0;
	}

	public boolean addUser(String username, String password){
		int added = template.update(SQL_ADD_USERS, username, password);

		return added > 0;
	}

/* 	public boolean createUserProfile(String username) {
		int added = template.update("create table if not exists" + username + "(\n"
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
		+ ");" );
		return added > 0;
	} */
/* 	public boolean createUserProfile(String username){
		int added = template.update(SQL_CREATE_USER_PROFILE, username);

		return added > 0;
	} */
}
