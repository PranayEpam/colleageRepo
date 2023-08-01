package com.colleage.nit.repositroy;

import com.colleage.nit.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {

     Course findByCourseName(final String courseName);
}
