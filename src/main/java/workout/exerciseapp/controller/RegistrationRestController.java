package workout.exerciseapp.controller;

import java.io.ByteArrayInputStream;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import workout.exerciseapp.exerciseappApplication;
import workout.exerciseapp.repository.UserRepository;

@RestController
@RequestMapping(path="/api/signup")
public class RegistrationRestController {


    @Autowired
    private UserRepository userRepo;

    @PostMapping (consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerUser(@RequestBody String body){

        try {
            JsonReader reader = Json.createReader(new ByteArrayInputStream(body.getBytes("UTF-8")));
            JsonObject obj = reader.readObject();

            this.userRepo.addUser(obj.getString("username"),obj.getString("password"));
            return ResponseEntity.accepted().body(obj.toString());

        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Something is wrong. Please try registering again.");
        }

    }
}
