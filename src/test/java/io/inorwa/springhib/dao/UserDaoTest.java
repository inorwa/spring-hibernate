package io.inorwa.springhib.dao;

import io.inorwa.springhib.models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(UserDaoTestConfiguration.class)
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Before
	public void setUp() throws Exception {
		userDao.deleteAll();
		userDao.save(new User("testuser1","user","test"));
		userDao.save(new User("testuser2","user","test"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void save() {
	}

	@Test
	public void findAll() {
		System.out.println(userDao.findAll());
	}

	@Test
	public void delete() {
	}

	@Test
	public void deleteAll() {
	}

	@Test
	public void get() {
	}
}