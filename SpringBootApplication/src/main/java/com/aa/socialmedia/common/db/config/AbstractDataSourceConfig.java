package com.aa.socialmedia.common.db.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class AbstractDataSourceConfig {

	private Environment env;

	protected AbstractDataSourceConfig(Environment env) {
		this.env = env;
	}

	public DataSource cmtDataSourceUrl() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:h2:file:./testdb");
		dataSourceBuilder.username("sa");
		dataSourceBuilder.password("");
		return dataSourceBuilder.build();
	}

	public LocalContainerEntityManagerFactoryBean createLocalContainerEntityManagerFactoryBean(
			EntityManagerFactoryBuilder builder, DataSource dataSource, String... packagesToScan) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("spring.jpa.hibernate.ddl-auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		return builder.dataSource(dataSource).properties(properties).packages(packagesToScan).build();

	}
}
