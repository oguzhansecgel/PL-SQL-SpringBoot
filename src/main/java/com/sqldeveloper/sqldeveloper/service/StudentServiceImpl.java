package com.sqldeveloper.sqldeveloper.service;

import com.sqldeveloper.sqldeveloper.entitiy.Student;
import com.sqldeveloper.sqldeveloper.repository.StudentRepository;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

@Service
public class StudentServiceImpl {

    private final JdbcTemplate jdbcTemplate;

    public StudentServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public String addStudent(Student student) {
        return jdbcTemplate.execute((ConnectionCallback<String>) conn -> {
            try (CallableStatement stmt = conn.prepareCall("{ ? = call add_student(?, ?) }")) {
                // Fonksiyonun döndüreceği değeri belirleyin
                stmt.registerOutParameter(1, Types.VARCHAR);
                // Fonksiyon parametrelerini ayarlayın
                stmt.setLong(2, student.getId());
                stmt.setString(3, student.getName());

                // Fonksiyonu çağırın
                stmt.execute();

                // Sonucu alın
                return stmt.getString(1);
            }
        });
    }
    public String updateStudent(Student student) {
        return jdbcTemplate.execute((ConnectionCallback<String>) conn -> {
            try (CallableStatement stmt = conn.prepareCall("{ ? = call update_student(?, ?) }")) {
                // Fonksiyonun döndüreceği değeri belirleyin
                stmt.registerOutParameter(1, Types.VARCHAR);
                // Fonksiyon parametrelerini ayarlayın
                stmt.setLong(2, student.getId());
                stmt.setString(3, student.getName());

                // Fonksiyonu çağırın
                stmt.execute();

                // Sonucu alın
                return stmt.getString(1);
            }
        });
    }
}
