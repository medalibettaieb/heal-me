package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.User;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);

	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);

	}

	@Override
	public void deleteUserById(String id) {
		entityManager.remove(findUserById(id));

	}

	@Override
	public User findUserById(String id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> findAllUsers() {
		return entityManager.createQuery("select u from User u", User.class).getResultList();
	}

}
