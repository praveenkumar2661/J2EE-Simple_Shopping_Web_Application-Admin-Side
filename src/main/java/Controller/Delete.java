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
import DTO.ProductDTO;

@WebServlet("/delete")
public class Delete extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ProductDAO PDAO = new ProductDAO();
		int id = Integer.parseInt(req.getParameter("id"));
		//ProductDTO PDTO = new ProductDTO();
		//PDTO.setId(id);
		try {
			HttpSession session = req.getSession();
			String mail = (String)session.getAttribute("mail");
			if(mail!=null)
			{
			int res = PDAO.Delete(id);
			{
				if(res == 1)
				{
					RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");
					dispatcher.include(req, resp);
				}
			}
			}
			else
			{
				req.setAttribute("message", "Do login!!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
