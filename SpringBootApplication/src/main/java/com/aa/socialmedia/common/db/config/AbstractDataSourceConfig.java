package com.aa.socialmedia.common.db.config;

import java.util.HashMap;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public abstract class AbstractDataSourceConfig {

	private Environment env;

	private String driverClassName;
	private String databaseUrl;
	private String databaseUser;

	public AbstractDataSourceConfig(Environment env) {
		this.env = env;
	}

	public DataSource createJndiDataSource(String jndiName) throws NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName(env.getProperty(jndiName));
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(false);
		bean.afterPropertiesSet();
		return (DataSource) bean.getObject();

	}

	public DataSource createDataSourceUrl() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(env.getProperty(getDriverClassName()));
		dataSourceBuilder.url(env.getProperty(getDatabaseUrl()));
		dataSourceBuilder.username(env.getProperty(getDatabaseUser()));
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
