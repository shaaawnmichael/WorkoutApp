package workout.exerciseapp.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import workout.exerciseapp.model.Exercises;
import static workout.exerciseapp.repository.SQLs.*;

@Repository
public class ExerciseRepo {

    @Autowired
    private JdbcTemplate template;

    public List<Exercises> getAllExercises(int limit) {
        return getAllExercises(0, limit);
    }

    public List<Exercises> getAllExercises(int offset, int limit) {
        final List<Exercises> result = new LinkedList<>();

        final SqlRowSet rs = template.queryForRowSet(SQL_GET_ALL_EXERCISES_BY_LIMIT_OFFSET, limit, offset);
		while (rs.next()) {
			
            Exercises exercise = new Exercises();
            exercise.populate(rs, exercise);
            result.add(exercise);
        }

        return result;
    }

    public List<Exercises> getExerciseById(Integer id){
        final List<Exercises> result = new LinkedList<>();

        final SqlRowSet rs = template.queryForRowSet(SQL_GET_EXERCISE_BY_ID, id);
        while (rs.next()) {
			
            Exercises exercise = new Exercises();
            exercise.populate(rs, exercise);
            result.add(exercise);
        }

        return result;
    }
    
}
