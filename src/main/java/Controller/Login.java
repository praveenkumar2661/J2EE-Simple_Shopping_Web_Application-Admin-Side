package Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import DAO.SellerDAO;
import DTO.SellerDTO;
@WebServlet("/login")
public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String mail = req.getParameter("mail");
		String pass = req.getParameter("password");
		
		SellerDAO SDAO = new SellerDAO();
		try {
			
			SellerDTO SDTO = SDAO.findByMail(mail);
			if(SDTO != null)
			{
				if(pass.equals(SDTO.getPassword()))
				{	
					HttpSession session = req.getSession();
					session.setAttribute("mail", mail);
					
					ProductDAO PDAO = new ProductDAO();
					RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");
					dispatcher.include(req, resp);
				}
				else
				{
					req.setAttribute("message", "Invalid Password");
					RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, resp);
					
				}
			}
			else
			{
				req.setAttribute("message", "Invalid Mail ID");

				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
				}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
 