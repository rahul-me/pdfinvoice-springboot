package com.rpc.pdfinvoicespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfinvoiceSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfinvoiceSpringbootApplication.class, args);
	}

}

/**
 *
 *
 * READ-10
 * Adding the needed Spring Boot JDBC dependencies
 * Think back to the very beginning of this course, the plain Spring module. You needed a couple of things to connect to a database:
 *
 * You needed a JDBC Driver/database on your classpath. Remember, you are using H2 database in this course.
 *
 * You needed to configure a DataSource @Bean in your Spring configuration.
 *
 * You needed the spring-jdbc library on your classpath, to configure a JDBC Template etc.
 *
 * As a refresher, this is what it looked like in code. Note: do not copy this bit, you do not need it anymore!.
 *
 *     @Bean
 *     public DataSource dataSource() {
 *         JdbcDataSource ds = new JdbcDataSource();
 *         ds.setURL("jdbc:h2:˜/test;INIT=RUNSCRIPT FROM 'classpath:schema.sql'");
 *         ds.setUser("sa");
 *         ds.setPassword("sa");
 *         return ds;
 *     }
 *
 *     @Bean
 *     public JdbcTemplate jdbcTemplate() {
 *         return new JdbcTemplate(dataSource());
 *     }
 *
 * Setting up database access is going to be a bit simpler with Spring Boot. You need two things:
 *
 * The JDBC driver. Drivers and versions for basically all popular databases are managed by Spring Boot’s dependency management.
 *
 * You need the spring-boot-starter-jdbc dependency added to your project. Do not confuse this with spring-data.
 *
 */
