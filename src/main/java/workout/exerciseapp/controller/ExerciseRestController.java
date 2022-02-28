package workout.exerciseapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
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
@RequestMapping(path="/api", produces=MediaType.APPLICATION_JSON_VALUE)
public class ExerciseRestController {

    @Autowired
    private ExerciseRepo exerciseRepo;

    @GetMapping(path="/exercise/{id}")
    public ResponseEntity<List<Exercises>> getExerciseById(@PathVariable Integer id) {

        List<Exercises> result = exerciseRepo.getExerciseById(id);
        return ResponseEntity.ok(result);


        /* List<Exercises> result = exerciseRepo.getExerciseById(eid);
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        result.stream().forEach(v -> arrBuilder.add(v.toJson()));

        return ResponseEntity.ok(arrBuilder.build().toString()); */

    }


    
}
