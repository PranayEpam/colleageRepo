package com.colleage.nit.resources;

import com.colleage.nit.model.Student;
import com.colleage.nit.repositroy.StudentRepository;
import com.colleage.nit.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> registorStudnent(@RequestBody Student student) {
        Student saveStudent = studentService.saveStudent(student);
        return new ResponseEntity<Student>(saveStudent, HttpStatus.CREATED);
    }

    @GetMapping({"/{courseName}"})
    public ResponseEntity<List<Student>> findAllStudent(@PathVariable String courseName) {
        List<Student>studentList = studentService.getStudentBaseOnCourse(courseName);
       return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);

    }
}
