package io.inorwa.springhib.bootstrap;

import io.inorwa.springhib.dao.UserDao;
import io.inorwa.springhib.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserDao userDao;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		userDao.deleteAll();
		userDao.save(new User("login","name","familyName"));
	}
}
