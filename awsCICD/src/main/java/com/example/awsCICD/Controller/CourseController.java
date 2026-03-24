package com.example.awsCICD.Controller;

import com.example.awsCICD.DTO.Course;
import com.example.awsCICD.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courses=courseService.getCourses();
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Course> getCourseByid(@PathVariable int id){
        Optional<Course> course=courseService.getCourseById(id);
        return course.map(v-> new ResponseEntity<>(v,HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
