package com.example.awsCICD.Service;

import com.example.awsCICD.DTO.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final List<Course> courses= new ArrayList<>();

    public void addCourse(Course course){
        courses.add(course);
    }

    public  List<Course> getCourses(){
        return courses;
    }

    public Optional<Course> getCourseById(int id){
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }

}
