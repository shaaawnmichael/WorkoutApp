package workout.exerciseapp.controller;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import workout.exerciseapp.exerciseappApplication;
import workout.exerciseapp.model.MyProfile;
import workout.exerciseapp.model.Profile;
import workout.exerciseapp.model.ProfileAdd;
import workout.exerciseapp.repository.UserProfileRepository;

//@CrossOrigin (origins = "*", allowedHeaders = "*")
@RestController 
@RequestMapping(path = "/api")
public class SecureProfileRestController {

    private final Logger logger = Logger.getLogger(exerciseappApplication.class.getName());


    @Autowired
    private UserProfileRepository repo;

    @GetMapping(path="/profile")
    public ResponseEntity<String> getAllUserProfileExercises() {
        List<MyProfile> result = repo.getExerciseForProfileByUsername();
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        result.stream().forEach(v -> arrBuilder.add(v.toJson()));

        return ResponseEntity.ok(arrBuilder.build().toString());
    }

   /*  @GetMapping (value="profile")
    public ResponseEntity<String> getProfile(@RequestHeader(value="subject") String subject) {
        
        String username = subject.replace("\"","");

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        repo.getExerciseForProfileByUsername(username).stream()
                .forEach(v -> arrBuilder.add(v.toJson()));

        return ResponseEntity.ok().body(arrBuilder.build().toString());
    } */


    @PostMapping(path="/profileadd", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> AddtoUserProfile(@RequestBody String body){

        try {
            JsonReader reader = Json.createReader(new ByteArrayInputStream(body.getBytes("UTF-8")));
            JsonObject obj = reader.readObject();

            this.repo.addExerciseToProfile(obj.getString("username"),obj.getString("name"));

            return ResponseEntity.accepted().body(obj.toString());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error. Please try again.");
        }

    }

   /*  @PostMapping(path="/profileadd")
    public ResponseEntity<String> AddtoUserProfile(@RequestBody String exercise, @RequestHeader(value="subject") String subject) throws UnsupportedEncodingException {
        
        String username = subject.replace("\"","");
        String exercise_name = subject.replace("\"","");
 

        logger.log(Level.INFO, username);
        logger.log(Level.INFO, exercise_name);
        
        JsonReader reader = Json.createReader(new ByteArrayInputStream(exercise.getBytes("UTF-8")));
        JsonObject obj = reader.readObject();

        //ProfileAdd profileadd = ProfileAdd.convert(obj);

        repo.addExerciseToProfile(username, exercise_name);
        
        

    return ResponseEntity.ok(obj.toString());
   
    } */
/*      @GetMapping(value="profile")
    public ResponseEntity<String> getProfile() {

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        repo.getProfile().stream()
                .forEach(v -> arrBuilder.add(v.toJson()));

        return ResponseEntity.ok().body(arrBuilder.build().toString());
    }   */
} 

