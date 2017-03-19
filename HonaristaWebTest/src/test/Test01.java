package test;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test01 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
			username = req.getParameter("email");
			password = req.getParameter("password");
			System.out.println(username);
			System.out.println(password);
			
			if(pages.authenticate(username, password))
				loggedIn = true;
			if(loggedIn)
				s=pages.getProfilePage();
			break;
		case 101:
			s=pages.getBrowsePage("creativeArt");
			break;
		case 102:
			s=pages.getBrowsePage("toys");
			break;
		case 103:
			s=pages.getBrowsePage("woodwork");
			break;
		case 104:
			s=pages.getBrowsePage("plants");
			break;
		case 105:
			s=pages.getBrowsePage("antiques");
			break;
		case 106:
			s=pages.getBrowsePage("clothes");
			break;
		case 107:
			s=pages.getBrowsePage("jewelry");
			break;
		case 108:
			s=pages.getBrowsePage("decorations");
			break;
		case 109:
			s=pages.getBrowsePage("hallOfFame");
			break;
		case 201:
			//add new item
			s=pages.getCreateItemPage();
			break;
		case 2000:
			//item approve
			/*TODO fix selectlist for item */
			String itemTitle = req.getParameter("ItemTitle");
			String itemDesc = req.getParameter("ItemDescription");
			String shopName = req.getParameter("ItemShopName");
			s = itemTitle + "\n" + itemDesc + "\n" + shopName;
			break;
		case 2011:
			//cancel
			break;
		case 202:
			//vitrin
			break;
		case 203:
			//customer reviews
			break;
		case 204:
		//sending methods;
			break;
		case 300:
			//FAQ
			s=pages.getFAQPage();
			break;
			
		}
			bytes=s.getBytes("UTF-8");
			persian = new String(bytes, "UTF-8");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().println(persian);

	}

	
	
	
	
	

}
