package service;

import dao.*;
import model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class UserServiceImpl implements UserService{

	public String GenerateHash(String password)
	{
		String hash = null;
		try {
			
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hash = sb.toString();
	    	
	    	
    	} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
    	}
		return hash;
	}

	private UserDaoImpl UserDao = new UserDaoImpl();
	private RolesDaoImpl RoleDao = new RolesDaoImpl();
	
	@Override
	public String SignIn(String login, String password) {
		String role = "";
		
		if(login.isEmpty() || (login == null) || password.isEmpty() || (password == null)) {
			role = "";
		}
		else {
			User user = UserDao.findUserByLogin(login);
			
			if (user == null)
				return role;
			
			
			if((user.getLogin() != null) && (password.compareTo(user.getPassword()) == 0)) {
				role = RoleDao.findRolesById(user.getRole()).getName();
			}
		}
		
		return role;
	}


	@Override
	public void Registration(User user) {
		// TODO Auto-generated method stub
		
	}

	
}
