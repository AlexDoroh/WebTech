package service;

import model.User;

public interface UserService {

	String SignIn(String login, String password);
	void Registration(User user);
}
