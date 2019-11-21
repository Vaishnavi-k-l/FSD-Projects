package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.springboot.dao.DaoImplementation;
import com.example.springboot.dao.DaoInterface;

@Configuration
@ComponentScan(basePackages = "com.example")
@PropertySource("classpath:database.properties")

public class BeanDefinitionClass
{
	/*Giving values directly
	@Bean
	public DataSource datasource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/ServletDemo");
		datasource.setUsername("root");
		datasource.setPassword("pass@word1");
		return datasource;
	}*/
	
	
	@Value("${jdbc.url")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("{jdbc.driver}")
	private String driver;
	
	
	@Bean
	public DataSource datasource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(driver);
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		return datasource;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(datasource());
		return jdbcTemplate;
		
		//Or JdbcTemplate jdbctemplate = new JdbcTemplate(datasource()); and
		//in the daoimplementation class you must create a constructor and set this.jdbctempate = jdbctemplate. It is a parameterized constructor.
	}
	
	@Bean
	public DaoInterface daoImplementation()
	{
		DaoImplementation daoimplementation = new DaoImplementation();
		return daoimplementation;
	}
	
	
}
