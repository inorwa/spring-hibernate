package io.inorwa.springhib.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@PropertySource("classpath:db.properties")
public class HibernateConfig {

	@Value("${hibernate.packagestoscan}")
	private String packagesToScan;

	@Value("${hibernate.driver}")
	private String driverClass;

	@Value("${hibernate.url}")
	private String url;

	@Value("${hibernate.user}")
	private String user;

	@Value("${hibernate.password}")
	private String password;

	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddlAuto;

	@Value("${hibernate.dialect}")
	private String dialect;

	@Value("${hibernate.temp.use_jdbc_metadata_defaults}")
	private String useJdbcMetadaDefaults;


	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(
				packagesToScan
				);
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager
				= new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(
				"hibernate.hbm2ddl.auto", hbm2ddlAuto);
		hibernateProperties.setProperty(
				"hibernate.dialect", dialect);
		hibernateProperties.setProperty(
				"hibernate.temp.use_jdbc_metadata_defaults",useJdbcMetadaDefaults
		);

		return hibernateProperties;
	}
}
