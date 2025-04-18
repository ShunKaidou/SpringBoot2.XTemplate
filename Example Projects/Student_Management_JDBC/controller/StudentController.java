package com.student.api.controller;

import com.student.api.domain.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing student system process. Use {@link StudentRowMapper} to map database rows to Student entity object.
 */
@RestController
@RequestMapping("/api/v1")
public class StudentController {
    
    // use JdbcTemplate to query for students aganist database
    @Autowired
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public StudentController(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * {@code GET  /students} : get all the Students.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     * of students in body.
     */
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        String sql = "SELECT * FROM student";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
        return ResponseEntity.ok(students);
    }

    /**
     * {@code GET  /students/:id} : get the "id" Student.
     *
     * @param id the id of the student to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     * the student, or if does not exist, return with status "noContent".
     */
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        try{
        String sql = "SELECT * FROM student WHERE id = :id";
        Student student = jdbcTemplate.queryForObject(sql, new MapSqlParameterSource("id", id), new StudentRowMapper());
        return ResponseEntity.ok(student);
        }
        catch(EmptyResultDataAccessException ex){
            return ResponseEntity.noContent().build();
        }
        
    }

    /**
     * {@code POST  /student} : Create a new student.
     *
     * @param student the student to create.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with
     * body the new student
     */
    @PostMapping("/students")
    public ResponseEntity<Void> createStudent(@RequestBody Student student) {
        String sql = "INSERT INTO student (id, name) VALUES (:id, :name)";
        int rowsAffected = jdbcTemplate.update(sql, 
        new MapSqlParameterSource()
        .addValue("id", student.getId())
        .addValue("name", student.getName()));
        if(rowsAffected > 0){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * {@code PUT  /student} : Updates an existing student.
     *
     * @param student the student to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     * the updated student.
     */
    @PutMapping("/students")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student) {
        String sql = "UPDATE student SET name = :name WHERE id = :id";
        int rowsAffected = jdbcTemplate.update(sql,
        new MapSqlParameterSource()
        .addValue("id", student.getId())
        .addValue("name", student.getName()));
        if(rowsAffected > 0){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * {@code DELETE  /student/:id} : delete the "id" student.
     *
     * @param id the id of the student to delete.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)}.
     */
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        String sql = "DELETE FROM student WHERE id = :id";
        int rowsAffected = jdbcTemplate.update(sql,
        new MapSqlParameterSource("id", id));
        if(rowsAffected > 0){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}