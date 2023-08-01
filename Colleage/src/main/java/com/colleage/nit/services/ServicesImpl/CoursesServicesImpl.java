package com.colleage.nit.services.ServicesImpl;

import com.colleage.nit.exception.NotFoundException;
import com.colleage.nit.model.Course;
import com.colleage.nit.repositroy.CourseRepository;
import com.colleage.nit.services.CoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CoursesServicesImpl implements CoursesServices {

     @Autowired
      private CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {

        return courseRepository.save(course);
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourse(Integer id, Course course) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with id: " + id));
             if(Objects.nonNull(existingCourse)){
                 existingCourse.setCourseName(course.getCourseName());
             }

        return  existingCourse;
    }

    @Override
    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course getCourseByName(String name) {
        Course course= courseRepository.findByCourseName(name);
        if(course !=null){
            return  course;
        }
        throw new EntityNotFoundException("no course found");
    }

}
