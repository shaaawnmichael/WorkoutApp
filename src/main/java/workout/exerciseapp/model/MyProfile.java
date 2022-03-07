package workout.exerciseapp.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class MyProfile {

    private String username;
    private String exercise_name;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExercise_name() {
        return this.exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }
    
    public static MyProfile populate(SqlRowSet rs) {
        final MyProfile myprofile = new MyProfile();
        myprofile.setUsername(rs.getString("username"));
        myprofile.setExercise_name(rs.getString("exercise_name"));

        return myprofile;
    }
     public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("username", username)
                .add("exercise_name", exercise_name)
                .build();

    } 
}
