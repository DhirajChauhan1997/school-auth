package com.dc.school.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@EntityScan(basePackages = "com.dc.school.model")
@SpringBootApplication(
        exclude = HibernateJpaAutoConfiguration.class,
        scanBasePackages = {
                "com.dc.school.service",
                "com.dc.school.dao",
                "com.dc.school.subject"
        })
public class SchoolAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolAuthApplication.class, args);
    }

}
