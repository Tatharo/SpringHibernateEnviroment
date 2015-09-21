package com.tatharo.onelegacy.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tatharo.onelegacy.hibernate.domain.model.WoWCharacter;
import com.tatharo.onelegacy.hibernate.domain.model.Person;
import com.tatharo.onelegacy.hibernate.domain.model.UserAccount;

@Configuration
@EnableTransactionManagement
public class RepositoryConfig {

	// TODO: properties file...
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/onelegacy_dev";
	private String username = "root";
	private String password = "";

	private DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return properties;

	}

	@Bean
	@Autowired
	public SessionFactory getSessionFactory() {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(this.getDataSource());
		sessionBuilder.addProperties(this.getHibernateProperties());
		sessionBuilder.addPackage("com.tatharo.onelegacy.hibernate.domain.model").addAnnotatedClass(WoWCharacter.class)
				.addAnnotatedClass(UserAccount.class).addAnnotatedClass(Person.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Bean
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
}
