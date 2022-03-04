package workout.exerciseapp.model;

import java.io.ByteArrayInputStream;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class ExercisesAdd {

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

    public static ExercisesAdd create(String jsonStr) throws Exception {
		JsonReader reader = Json.createReader(new ByteArrayInputStream(jsonStr.getBytes()));
		return create(reader.readObject());
	}

    public static ExercisesAdd create(JsonObject o) {
		final ExercisesAdd ea = new ExercisesAdd();
		try {
			ea.setId(o.getInt("eid"));
		} catch (Exception ex) { }
        ea.setBodyPart(o.getString("body_part"));
        ea.setEquipment(o.getString("equipment"));
        ea.setGifUrl(o.getString("gif_url"));
		ea.setName(o.getString("exercise_name"));
		ea.setTarget(o.getString("exercise_target"));

		return ea;
	}

/*     public ExercisesAdd(String bodyPart, String equipment, String gifUrl, String name, String target) {
		this.bodyPart = bodyPart;
		this.equipment = equipment;
		this.gifUrl = gifUrl;
        this.name = name;
        this.target = target;
	} */
}


