package workout.exerciseapp.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import workout.exerciseapp.exerciseappApplication;
import workout.exerciseapp.model.Profile;
import workout.exerciseapp.repository.UserProfileRepository;

@CrossOrigin (origins = "*", allowedHeaders = "*")
@RestController 
@RequestMapping(path = "/api")
public class SecureProfileRestController {

    private final Logger logger = Logger.getLogger(exerciseappApplication.class.getName());


    @Autowired
    private UserProfileRepository repo;


    @GetMapping (path="/profile")
    public ResponseEntity<List<Profile>> getProfile() {
        logger.log(Level.INFO,"retreiving profile");
        List<Profile> result = repo.getProfile();
        return ResponseEntity.ok(result);

    }
/*      @GetMapping(value="profile")
    public ResponseEntity<String> getProfile() {

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        repo.getProfile().stream()
                .forEach(v -> arrBuilder.add(v.toJson()));

        return ResponseEntity.ok().body(arrBuilder.build().toString());
    }   */
} 

