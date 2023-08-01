package com.colleage.nit.repositroy;

import com.colleage.nit.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    public Optional<Student> findStudentById(Integer id);
}
