package com.aa.socialmedia.common.db.config;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJndi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableJpaRepositories(basePackages = "com.aa.socialmedia", entityManagerFactoryRef = "cmtEntityManager", transactionManagerRef = "cmtTransactionManager")
public class DataSourceConfig extends AbstractDataSourceConfig {

	private Environment env;

	public DataSourceConfig(Environment env) {
		super(env);
	}

	@Bean(name = "cmtDataSource")
	@ConditionalOnJndi(value = "java:comp/env/jdbc/h2connection")
	public DataSource cmtDataSource() throws NamingException {
		return createJndiDataSource("spring.datasource.cmt.jndi-name");

	}

	@Bean(name = "cmtDataSource")
	@ConditionalOnMissingBean(name = "cmtDataSource")
	public DataSource cmtDataSourceUrl() {
		setDatabaseUrl("spring.datasource.url");
		setDriverClassName("spring.datasource.driver-class-name");
		setDatabaseUser("spring.datasource.username");
		return createDataSourceUrl();
	}

	@Bean(name = "cmtTransactionManager")
	public PlatformTransactionManager cmtTransactionManager(
			@Qualifier("cmtEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Bean(name = "cmtEntityManager")
	public LocalContainerEntityManagerFactoryBean cmtEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("cmtDataSource") DataSource dataSource, String... packagesToScan) {
		return createLocalContainerEntityManagerFactoryBean(builder, dataSource, "com.aa.socialmedia");

	}
}
