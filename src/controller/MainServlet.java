package controller;

import dao.CarDaoImpl;
import dao.CharacteristicDaoImpl;
import dao.DispathcerDaoImpl;
import dao.DriverDaoImpl;
import dao.OrdersDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import dao.RolesDaoImpl;
import dao.TripsDaoImpl;
import model.*;
import service.UserServiceImpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class WTServlet
 */
@WebServlet(urlPatterns = "/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        try {
    			Class.forName("com.mysql.jdbc.Driver");
    	} 
        catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }


    
    
    
    private UserDaoImpl UserDao = new UserDaoImpl();
    private UserServiceImpl UserService = new UserServiceImpl();
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
		session.setMaxInactiveInterval(-1);
 	
		HttpSession locSession = request.getSession(true);
		locSession.setMaxInactiveInterval(-1);
		if((request.getParameter("local") != null))
		{
			locSession.setAttribute("local", request.getParameter("local"));
		}
		
		request.setAttribute("local", locSession.getAttribute("local"));
		
	
		
		if(request.getParameter("logout") != null && request.getParameter("logout").compareTo("true") == 0) {
			session.removeAttribute("login");
			session.removeAttribute("role");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		    dispatcher.forward(request, response);
		}
		else if(session.getAttribute("login") != null || session.getAttribute("role") != null) {
			
			
			if(session.getAttribute("role").toString().compareTo("driver") == 0){
    			
    			request.setAttribute("users", UserDao.listAllUsers());
    		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
    		    dispatcher.forward(request, response);
        	}
    		else if (session.getAttribute("role").toString().compareTo("dispather") == 0){
    			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
    			dispatcher.forward(request, response);
    		}
		}
		else {
			
			if(request.getParameter("login") == null || request.getParameter("password") == null) {
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			    dispatcher.forward(request, response);
	    	}
	    	else 
	    	{
	    		String roleName = UserService.SignIn(request.getParameter("login"), request.getParameter("password"));
	    		
	    			
	    		session.setAttribute("login", request.getParameter("login"));
	    		session.setAttribute("role", roleName);
	    		
	    		if(roleName.compareTo("driver") == 0){
	    			request.setAttribute("users", UserDao.listAllUsers());
	    		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
	    		    dispatcher.forward(request, response);
	        	}
	    		else if (roleName.compareTo("dispather") == 0){
	    			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
	    			dispatcher.forward(request, response);
	    		}
	    		else
	    		{
	    			session.removeAttribute("login");
	    			session.removeAttribute("role");
	    			
	    			
	    			request.setAttribute("login_error", "Wrong Login or Password");
	    			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
	    		    dispatcher.forward(request, response);
	    		}
	    	}
		}
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		processRequest(request, response);
	}
	

	
}
