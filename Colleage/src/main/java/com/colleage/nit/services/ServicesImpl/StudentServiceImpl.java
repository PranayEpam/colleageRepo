package com.colleage.nit.services.ServicesImpl;

import com.colleage.nit.model.Course;
import com.colleage.nit.model.Student;
import com.colleage.nit.repositroy.StudentRepository;
import com.colleage.nit.services.CoursesServices;
import com.colleage.nit.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private CoursesServices coursesServices;

    @Override
    public Student saveStudent(Student student) {
              Student saveStudent=null;
             if(Objects.nonNull(student)){
                 Course course=new Course();
                 course.setCourseName(student.getCourses().getCourseName());
                 course.setStudent(List.of(student));
                 saveStudent=   repository.save(student);
               Course saveCoure=  coursesServices.addCourse(course);
             }
        return saveStudent;
    }

    @Override
    public List<Student> getStudentBaseOnCourse(String course_name) {
        Optional<Student>studentOptional=null;
             Course course=  coursesServices.getCourseByName(course_name);
                if(course!=null){
                    //if(!CollectionUtils.isEmpty(course.getStudent()))
                     return course.getStudent();

                }
          throw  new RuntimeException("no student found");
    }

    @Override
    public Student updateCourseBaseOnStudent(int student_id,Course course) {
       Optional<Student> student= repository.findStudentById(student_id);
       if(student.isPresent()){
           student.get().setCourses(course);
       }
        return student.get();
    }

    @Override
    public void deleteStudent(int student_id) {
       repository.deleteById(student_id);
    }
}
