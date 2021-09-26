package com.gaurav.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurav.springdatajpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
