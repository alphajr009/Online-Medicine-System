package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.services.CustomerAuthentication;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("psw");
		
		CustomerAuthentication authentication = new CustomerAuthentication();
		boolean result = authentication.customerLogin(uname, pwd);
		
		if(result == true) {
			HttpSession session = request.getSession();
			session.setAttribute("Username", uname);
			
			response.sendRedirect("OrderForm.jsp");
		} else {
			response.sendRedirect("Login.jsp");
		}
		
//		if(uname.equals("customer")&& pwd.equals("1234")) {
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("Username", uname);
//			 response.sendRedirect("CustomerForm.jsp");
//		}
//		else if(uname.equals("order")&& pwd.equals("1234")) {
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("Username", uname);
//			 response.sendRedirect("OrderForm.jsp");
//		}
//		else if(uname.equals("payment")&& pwd.equals("1234")) {
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("Username", uname);
//			 response.sendRedirect("PaymentForm.jsp");
//		}
//		else if(uname.equals("pharmacy")&& pwd.equals("1234")) {
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("Username", uname);
//			 response.sendRedirect("PharmacyForm.jsp");
//		}
//		
//		
//		else {
//			response.sendRedirect("Login.jsp");
//		}
		
	}

}
