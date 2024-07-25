package com.sqldeveloper.sqldeveloper;

import com.sqldeveloper.sqldeveloper.entitiy.Student;
import com.sqldeveloper.sqldeveloper.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SqldeveloperApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SqldeveloperApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		List<Student> students = repository.findAll();

		students.forEach(System.out::println);
	}
}
