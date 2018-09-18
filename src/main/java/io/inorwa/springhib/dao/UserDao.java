package io.inorwa.springhib.dao;

import io.inorwa.springhib.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDao {

	private SessionFactory sessionFactory;

	@Autowired
	public UserDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void save(User user){
		sessionFactory.getCurrentSession().save(user);
	}

	@Transactional
	public List<User> findAll(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u");
		return q.getResultList();
	}

	@Transactional
	public void delete(User user){
		this.sessionFactory.getCurrentSession().delete(user);
	}

	@Transactional
	public void deleteAll(){
		sessionFactory.getCurrentSession().createQuery("DELETE FROM User").executeUpdate();
	}

	@Transactional
	public User get(String userId){
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u WHERE u.id = :id");
		query.setParameter("id",userId);
		return (User)query.getSingleResult();
	}
}
