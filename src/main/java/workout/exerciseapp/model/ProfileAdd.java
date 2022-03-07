package workout.exerciseapp.model;

import jakarta.json.JsonObject;

public class ProfileAdd {

    public  String getExercise_name() {
        return this.exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }
    
    private String exercise_name;


    public static ProfileAdd convert(JsonObject obj ){
        ProfileAdd profileadd = new ProfileAdd();
        profileadd.setExercise_name(obj.getString("exercise_name"));


        return profileadd;
    }

}
