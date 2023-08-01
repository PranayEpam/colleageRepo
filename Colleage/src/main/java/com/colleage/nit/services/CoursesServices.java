package com.colleage.nit.services;

import com.colleage.nit.model.Course;

import java.util.List;
import java.util.Optional;

public interface CoursesServices {


        public Course addCourse(Course course) ;

        public List<Course> getCourses();

        public Course updateCourse(Integer id, Course course);

        public void deleteCourse(Integer id);

        public  Course getCourseByName(String name);

    }


