package workout.exerciseapp.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Exercises {

    private Integer id;
    private String bodyPart;
    private String equipment;
    private String gifUrl;
    private String name;
    private String target;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBodyPart() {
        return this.bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getEquipment() {
        return this.equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getGifUrl() {
        return this.gifUrl;
    }

    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Exercises populate(SqlRowSet rs, Exercises exercise) {

		exercise.setId(rs.getInt("eid"));
		exercise.setBodyPart(rs.getString("body_part"));
		exercise.setEquipment(rs.getString("equipment"));
		exercise.setGifUrl(rs.getString("gif_url"));
		exercise.setName(rs.getString("exercise_name"));
        exercise.setTarget(rs.getString("exercise_target"));

		return exercise;
	}

    public JsonObject toJson() {
		return Json.createObjectBuilder()
			.add("eid", id)
			.add("body_part", bodyPart)
			.add("equipment", equipment)
            .add("gif_url", gifUrl)
            .add("exercise_name", name)
            .add("exercise_target", target)
			.build();
	}


}
