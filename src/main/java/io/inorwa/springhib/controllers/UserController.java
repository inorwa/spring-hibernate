package io.inorwa.springhib.controllers;

import io.inorwa.springhib.dao.UserDao;
import io.inorwa.springhib.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserDao userDao;

	public UserController(UserDao userDao) {
		this.userDao = userDao;
	}

	@GetMapping
	public List<User> list(){
		return userDao.findAll();
	}
}
