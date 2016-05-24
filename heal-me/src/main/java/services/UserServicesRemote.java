package services;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServicesRemote {
	void addUser(User user);

	void updateUser(User user);

	void deleteUserById(String id);

	User findUserById(String id);

	List<User> findAllUsers();

}
