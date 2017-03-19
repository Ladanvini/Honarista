package test;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test01 extends HttpServlet {
	Boolean loggedIn;
	Pages pages;
	public Test01(){
		loggedIn = false;
	   pages = new Pages();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String s = req.getParameter("Action");
		String persian = "";
		byte[] bytes;
		int i = Integer.parseInt(s);
		switch(i) {
		case 10:
			//LOGIN
			s=pages.getLoginPage();	
		break;
		case 11:
			//REGISTRATION
			s=pages.getRegistrationPage();
		break;
		case 13:
			//FORGOTPASSWORD
			break;
		case 14:
			//LOGIN WITH PHONE
			break;
		case 1345:
			String username;
			String password;
			System.out.println("injayam");
			username = req.getParameter("email");
			password = req.getParameter("password");
			if(pages.authenticate(username, password))
				loggedIn = true;
			if(loggedIn)
				s=pages.getProfilePage();
		case 101:
			s=pages.viewAllShops();
		}
			bytes=s.getBytes("UTF-8");
			persian = new String(bytes, "UTF-8");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().println(persian);

	}

	
	
	
	
	

}
