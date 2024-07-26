package com.sqldeveloper.sqldeveloper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Types;

@Service
public class ProductServiceImpl {

    public ProductServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final JdbcTemplate jdbcTemplate;


    public double avgPriceProduct()
    {
        return jdbcTemplate.queryForObject("select avg(price) from PRODUCTS", Integer.class);
    }
    public double avgPriceProducts() {
        return jdbcTemplate.execute((ConnectionCallback<Double>) conn -> {
            try (CallableStatement stmt = conn.prepareCall("{ ? = call avg_price_product() }")) {
                // Fonksiyonun döndüreceği değeri belirleyin
                stmt.registerOutParameter(1, Types.NUMERIC);

                // Fonksiyonu çağırın
                stmt.execute();

                // Sonucu alın
                return stmt.getDouble(1);
            }
        });
    }
}
