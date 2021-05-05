package com.fernando.productapijdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    public void insertData(){
        jdbcTemplate.execute("CREATE TABLE produto (" +
                "    id int AUTO_INCREMENT," +
                "    name varchar(255)," +
                "    description varchar(255)," +
                "    price double(10)," +
                "    PRIMARY KEY (id)" +
                ");"
        );
        jdbcTemplate.execute("INSERT INTO produto (name, description, price) VALUES ('Coca-cola', 'Refrigerante cancer', 10.00)");
    }
}
