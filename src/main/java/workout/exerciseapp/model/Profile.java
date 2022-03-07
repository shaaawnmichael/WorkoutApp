package workout.exerciseapp.model;

import java.io.ByteArrayInputStream;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

public class Profile {

    private Integer profileid;
    private String username;
    private String body_part;
    private String equipment;
    private String gif_url;
    private String exercise_name;
    private String exercise_target;
    private Integer userid;

    public Integer getProfileid() {
        return this.profileid;
    }

    public void setProfileid(Integer profileid) {
        this.profileid = profileid;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBody_part() {
        return this.body_part;
    }

    public void setBody_part(String body_part) {
        this.body_part = body_part;
    }

    public String getEquipment() {
        return this.equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getGif_url() {
        return this.gif_url;
    }

    public void setGif_url(String gif_url) {
        this.gif_url = gif_url;
    }

    public String getExercise_name() {
        return this.exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public String getExercise_target() {
        return this.exercise_target;
    }

    public void setExercise_target(String exercise_target) {
        this.exercise_target = exercise_target;
    }

    public static Profile create(String jsonStr) throws Exception {
		JsonReader reader = Json.createReader(new ByteArrayInputStream(jsonStr.getBytes()));
		return create(reader.readObject());
	}

    public static Profile create(JsonObject o) {
		final Profile ea = new Profile();
		try {
			ea.setProfileid(o.getInt("profileid"));
		} catch (Exception ex) { }
        ea.setBody_part(o.getString("body_part"));
        ea.setEquipment(o.getString("equipment"));
        ea.setGif_url(o.getString("gif_url"));
		ea.setExercise_name(o.getString("exercise_name"));
		ea.setExercise_target(o.getString("exercise_target"));
        ea.setUserid(o.getInt("userid"));

		return ea;
	}

    public Profile populate(SqlRowSet rs, Profile profile) {
		profile.setUsername(rs.getString("username"));
		return profile;
	}

     public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("username", username)
            .build();
    } 
    
} 

