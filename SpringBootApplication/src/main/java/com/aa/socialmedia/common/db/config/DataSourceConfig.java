package com.aa.socialmedia.common.db.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.aa.socialmedia.repository", entityManagerFactoryRef = "cmtEntityManager", transactionManagerRef = "cmtTransactionManager")
public class DataSourceConfig extends AbstractDataSourceConfig {

	private Environment env;

	public DataSourceConfig(Environment env) {
		super(env);
	}

	@Bean(name = "cmtDataSource")
	public DataSource cmtDataSource() {
		return cmtDataSourceUrl();
	}

	@Bean(name = "cmtTransactionManager")
	public PlatformTransactionManager cmtTransactionManager(
			@Qualifier("cmtEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Bean(name = "cmtEntityManager")
	public LocalContainerEntityManagerFactoryBean cmtEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("cmtDataSource") DataSource dataSource, String... packagesToScan) {
		return createLocalContainerEntityManagerFactoryBean(builder, dataSource, "com.aa.socialmedia.repository",
				"com.aa.socialmedia.dao");

	}
}
