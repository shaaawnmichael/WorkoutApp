package workout.exerciseapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import workout.exerciseapp.model.Exercises;
import workout.exerciseapp.repository.ExerciseRepo;

@RestController
@RequestMapping(path ="/api/exercises", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExercisesRestController {

    @Autowired
    private ExerciseRepo exRepo;

    @GetMapping
    public ResponseEntity<String> getAllExercises(
        @RequestParam(defaultValue = "10") Integer limit,
        @RequestParam(defaultValue = "0") Integer offset) {

         List<Exercises> result = exRepo.getAllExercises(offset, limit);
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        result.stream().forEach(v -> arrBuilder.add(v.toJson()));

        return ResponseEntity.ok(arrBuilder.build().toString());       
    }

    @GetMapping(path="/search/{input}")
    public ResponseEntity<List<Exercises>> searchExercises(@PathVariable String input) {
        
        List<Exercises> result = exRepo.searchExercises(input);
        return ResponseEntity.ok(result);
    }

}
