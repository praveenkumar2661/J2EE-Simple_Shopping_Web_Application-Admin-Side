package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.ProductDAO;
import DTO.ProductDTO;

@WebServlet("/update")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class Update extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Part image = req.getPart("image");
		ProductDTO product = (ProductDTO)req.getSession().getAttribute("editp");
		product.setId(Integer.parseInt(req.getParameter("id")));
		product.setName(req.getParameter("name"));
		product.setBrand(req.getParameter("brand"));
		product.setPrice(Double.parseDouble(req.getParameter("price")));
		product.setDiscount(Double.parseDouble(req.getParameter("discount")));
		if(image.getSize()>0)
		{
			byte[] img = image.getInputStream().readAllBytes();
			product.setImage(img);
		}
		ProductDAO PDAO = new ProductDAO();
		try {
			int res = PDAO.update(product);
			if(res == 1)
			{
				req.setAttribute("message", "Updated Successfully");
				RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "Something went wrong!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("Welcome.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
