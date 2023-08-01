package com.colleage.nit.resources;

import com.colleage.nit.model.Course;
import com.colleage.nit.services.CoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesServices coursesServices;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course course1 = coursesServices.addCourse(course);
        return new ResponseEntity<Course>(course1, HttpStatus.OK);
    }

    @GetMapping
    public List<Course> getCourses() {
        return coursesServices.getCourses();
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Integer id, @RequestBody Course course) {
        return coursesServices.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        coursesServices.deleteCourse(id);
    }
}
