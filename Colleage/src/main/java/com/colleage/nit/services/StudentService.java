package com.colleage.nit.services;

import com.colleage.nit.model.Course;
import com.colleage.nit.model.Student;

import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);

    public List<Student> getStudentBaseOnCourse(String course_name);

    public Student updateCourseBaseOnStudent(int student_id, Course course);
     public void deleteStudent(int student_id);



}
