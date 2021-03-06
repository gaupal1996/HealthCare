package com.gaurav.springdatajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gaurav.springdatajpa.entity.Student;
import com.gaurav.springdatajpa.repos.StudentRepository;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDataJpaApplicationTests {
	
	@Autowired
	private StudentRepository repository;

	@Test
	public void testSaveStudent() {
		
		Student student = new Student();
		
		student.setId(1);
		student.setName("Gaurav");
		student.setTestScore(10);
		repository.save(student);
		
		//repository.save(student);
		
		Student savedStudent= repository.findById(1).get();
		assertNotNull(savedStudent);
	}

}
