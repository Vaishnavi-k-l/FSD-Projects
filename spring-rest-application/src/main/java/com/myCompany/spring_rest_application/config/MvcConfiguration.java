package com.myCompany.spring_rest_application.config;

import java.beans.PropertyVetoException;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@SuppressWarnings("deprecation")
@Configuration
@ComponentScan(basePackages = "com.myCompany.spring_rest_application")
@EnableWebMvc
@EnableTransactionManagement
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
	 @Bean 
	 public DataSource dataSource() 
	 { 
		 ComboPooledDataSource ds = new ComboPooledDataSource();
		 try
		 {
			ds.setDriverClass("com.mysql.cj.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/springDb");
			ds.setUser("root");
			ds.setPassword("pass@word1");
			ds.setMinPoolSize(20);
			ds.setMaxPoolSize(40);
			
		} 
		 catch (PropertyVetoException e)
		 {
			
			e.printStackTrace();
		}
		 
		return ds;
	 }
	 
	 
	 @Bean
		public LocalSessionFactoryBean sessionFactory() {

			LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

			sessionFactory.setDataSource(dataSource());
			sessionFactory.setPackagesToScan(new String[] { "com.myCompany.spring_rest_application.entity" });
			Properties props = new Properties();
			props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			props.setProperty("hibernate.show_sql", "true");
			//props.setProperty("hibernate.hbm2ddl.auto", "create");
			sessionFactory.setHibernateProperties(props);

			return sessionFactory;
		}
	
	/*
	 * @Bean public DataSource dataSource() { return new
	 * EmbeddedDatabaseBuilder().generateUniqueName(false).setName("testdb")
	 * .setType(EmbeddedDatabaseType.H2) // .addDefaultScripts()
	 * .setScriptEncoding("UTF-8").ignoreFailedDrops(true).build(); }
	 */

	/*
	 * @Bean public LocalSessionFactoryBean sessionFactory() {
	 * 
	 * LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	 * 
	 * sessionFactory.setDataSource(dataSource());
	 * sessionFactory.setPackagesToScan(new String[] {
	 * "com.myCompany.spring_rest_application.entity" }); Properties props = new
	 * Properties(); props.setProperty("hibernate.dialect",
	 * "org.hibernate.dialect.H2Dialect"); props.setProperty("hibernate.show_sql",
	 * "true"); props.setProperty("hibernate.hbm2ddl.auto", "create");
	 * sessionFactory.setHibernateProperties(props);
	 * 
	 * return sessionFactory; }
	 */

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

}
