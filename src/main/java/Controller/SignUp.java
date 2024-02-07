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

import DAO.SellerDAO;
import DTO.SellerDTO;
@WebServlet("/signup")
public class SignUp extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long contact = Long.parseLong(req.getParameter("contact"));
		String mail = req.getParameter("mail");
		String password = req.getParameter("password");
		
		SellerDTO SDTO = new SellerDTO();
		SDTO.setId(id);
		SDTO.setName(name);
		SDTO.setContact(contact);
		SDTO.setEmail(mail);
		SDTO.setPassword(password);
		
		SellerDAO SDAO = new SellerDAO();
		try 
		{
			SDAO.saveSeller(SDTO);
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			req.getSession().setAttribute("signupmessage", "User already exist");
			e.printStackTrace();
		} 
	}
}
