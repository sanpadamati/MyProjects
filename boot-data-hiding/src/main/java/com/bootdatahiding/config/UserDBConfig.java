package com.bootdatahiding.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryRef", basePackages = {
		"com.bootdatahiding.user.repository" }, transactionManagerRef = "transactionManager")
public class UserDBConfig {
	@Primary
	@Bean(name = "datasource")
	@ConfigurationProperties(prefix = "spring.user.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();

	}

	@Primary
	@Bean(name = "entityMangerFactory")
	public LocalContainerEntityManagerFactoryBean entityMangerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("datasource") DataSource datasource) {

		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.putIfAbsent("hibernate.dialect", "org.hibernate.dialect.MYSQL5Dialect");

		return builder.dataSource(datasource).properties(properties).packages("com.bootdatahiding.model.user")
				.persistenceUnit("User").build();
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityMangerFactory") EntityManagerFactory entityMangerFactory) {

		return new JpaTransactionManager(entityMangerFactory);
	}

}
