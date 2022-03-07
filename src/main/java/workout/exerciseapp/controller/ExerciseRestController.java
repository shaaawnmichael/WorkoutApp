package workout.exerciseapp.controller;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import workout.exerciseapp.model.ContactUs;
import workout.exerciseapp.model.Exercises;
import workout.exerciseapp.model.ExercisesAdd;
import workout.exerciseapp.repository.ExerciseRepo;
import workout.exerciseapp.services.EmailService;


@RestController
@RequestMapping(path="/api", produces=MediaType.APPLICATION_JSON_VALUE)
public class ExerciseRestController {

    @Autowired
    private ExerciseRepo exerciseRepo;

    @Autowired
    private EmailService emailService;

    @GetMapping(path="/exercise/{id}")
    public ResponseEntity<List<Exercises>> getExerciseById(@PathVariable Integer id) {

        List<Exercises> result = exerciseRepo.getExerciseById(id);
        return ResponseEntity.ok(result);


        /* List<Exercises> result = exerciseRepo.getExerciseById(eid);
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        result.stream().forEach(v -> arrBuilder.add(v.toJson()));

        return ResponseEntity.ok(arrBuilder.build().toString()); */

    }

    @PostMapping(path="exercise", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> AddExercise(@RequestBody String exercises) throws UnsupportedEncodingException {
        JsonReader reader = Json.createReader(new ByteArrayInputStream(exercises.getBytes("UTF-8")));
            JsonObject obj = reader.readObject();

            this.exerciseRepo.addExercise(obj.getString("body_part"), 
            obj.getString("equipment"), 
            obj.getString("gif_url"), 
            obj.getString("exercise_name"), 
            obj.getString("exercise_target"));
        return ResponseEntity.accepted().body(obj.toString());
		
    } 

    @PostMapping(path="/contactus", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactUs> contactUs(@RequestBody ContactUs contactus){
      try {
        emailService.sendEmail(contactus);
        return ResponseEntity.ok(contactus);
      } catch( MailException e){
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  
  
    }
    
    
}
