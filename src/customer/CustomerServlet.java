package customer;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.services.CustomerAuthentication;

//Import Database Connection Class file 
import customer.DatabaseConnecter; 

@WebServlet("/CustomerServlet") 
public class CustomerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
	
		String Cname = request.getParameter("Cname");		
		String Caddress = request.getParameter("Caddress");
		String cEmail = request.getParameter("cEmail");	
		String CpNo = request.getParameter("CpNo");
		String pwd = request.getParameter("pwd");

		CustomerAuthentication authentication = new CustomerAuthentication();
		boolean result = authentication.customerRegistration(Cname, Caddress, cEmail, CpNo, pwd);
		
		if(result == true) {
			PrintWriter out = response.getWriter(); 

			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( ' Customer Registerion Successfully' ,  '' ,  'success' );");
			out.println("});");
			out.println("</script>");
          
			RequestDispatcher rd = request.getRequestDispatcher("/CustomerView.jsp");
          
			rd.include(request, response);
		}
			

//		        if (row > 0) {
//		          System.out.println("File uploaded and saved into database");
//		          
//		          
//					PrintWriter out = response.getWriter(); 
//
//					out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
//					out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
//					out.println("<script>");
//					out.println("$(document).ready(function(){");
//					out.println("swal ( ' Customer Registerion Successfully' ,  '' ,  'success' );");
//					out.println("});");
//					out.println("</script>");
//		          
//		          RequestDispatcher rd = request.getRequestDispatcher("/CustomerView.jsp");
//		          
//		          rd.include(request, response);
//		        }
		       
//		    }catch (Exception e) {
//				e.printStackTrace();
//
//      } 		
	} 	
} 



