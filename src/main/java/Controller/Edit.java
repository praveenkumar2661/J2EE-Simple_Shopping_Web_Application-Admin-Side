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
import javax.servlet.http.Part;

import DAO.ProductDAO;
import DTO.ProductDTO;

@WebServlet("/edit")
public class Edit extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ProductDAO PDAO = new ProductDAO();
		try {
			ProductDTO PDTO = PDAO.findByID(Integer.parseInt(req.getParameter("id")));
			if(PDTO != null)
			{
				req.getSession().setAttribute("editp", PDTO);
				RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				PrintWriter pw = resp.getWriter();
				pw.println("null");
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
