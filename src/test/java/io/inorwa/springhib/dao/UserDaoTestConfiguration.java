package io.inorwa.springhib.dao;

import io.inorwa.springhib.config.HibernateConfig;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class UserDaoTestConfiguration {
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	HibernateConfig hibernateConfig;

	@Bean
	public UserDao userDao(){
		return new UserDao(sessionFactory);
	}
}
