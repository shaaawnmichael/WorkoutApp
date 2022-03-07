package workout.exerciseapp.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import io.jsonwebtoken.lang.Collections;
import workout.exerciseapp.model.Profile;
import static workout.exerciseapp.repository.SQLs.*;

@Repository
public class UserProfileRepository {
    
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

} 
