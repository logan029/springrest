package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    //Get the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    //Get course by courseID
    @GetMapping("/courses/{courseID}")
    public Course getCourseByID(@PathVariable String courseID){
        return this.courseService.getCourseByID(Long.parseLong(courseID));
    }

    //Add a course
    @PostMapping(path = "/courses", consumes = "application/json")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    //Update course
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    //Delete course by ID
    @DeleteMapping("/courses/{courseID}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID){
        try{
            this.courseService.deleteCourse(Long.parseLong(courseID));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
