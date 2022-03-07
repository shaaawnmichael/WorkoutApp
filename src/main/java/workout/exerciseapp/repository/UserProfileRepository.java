package workout.exerciseapp.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import io.jsonwebtoken.lang.Collections;
import workout.exerciseapp.exerciseappApplication;
import workout.exerciseapp.model.MyProfile;
import workout.exerciseapp.model.Profile;
import workout.exerciseapp.model.ProfileAdd;

import static workout.exerciseapp.repository.SQLs.*;

@Repository
public class UserProfileRepository {

    private final Logger logger = Logger.getLogger(exerciseappApplication.class.getName());
    
    @Autowired
    private JdbcTemplate template;

    public List<Profile> getProfile(){

        final List<Profile> result = new LinkedList<>();

        final SqlRowSet rs = template.queryForRowSet(SQL_GET_ALL_PROFILES); 

        while (rs.next()){
            Profile profile = new Profile(); 

            profile.setProfileid(rs.getInt("profileid"));
            profile.setBody_part(rs.getString("body_part"));
            profile.setEquipment(rs.getString("equipment"));
            profile.setGif_url(rs.getString("gif_url"));
            profile.setExercise_name(rs.getString("exercise_name"));
            profile.setExercise_target(rs.getString("exercise_target"));
            profile.setUserid(rs.getInt("userid"));
            result.add(profile); 
        }
        
        return result;
    }   

    public boolean addExerciseToProfile(String username, String exercise_name) {
		int added = template.update(SQL_ADD_EXERCISE_TO_PROFILE, 
            username, exercise_name);
        return added >0;
	}
    
    public List<MyProfile> getExerciseForProfileByUsername(){
        final List<MyProfile> result = new LinkedList<>();

        final SqlRowSet rs = template.queryForRowSet(SQL_ALL_USER_PROFILE_EXERCISES);
        //logger.info("input>>>" + username);
        
        while (rs.next()) {
            final MyProfile myprofile=MyProfile.populate(rs);
            result.add(myprofile);
        }

        return result;
    }

} 
