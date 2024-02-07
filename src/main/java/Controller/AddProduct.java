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
@WebServlet("/addproduct")
@MultipartConfig(maxFileSize = 1024*1024*100)
public class AddProduct extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String brand = req.getParameter("brand");
		double price = Double.parseDouble(req.getParameter("price"));
		double discount = Double.parseDouble(req.getParameter("discount"));
		Part image = req.getPart("image");
		
		ProductDTO PDTO = new ProductDTO();
		PDTO.setId(id);
		PDTO.setName(name);
		PDTO.setBrand(brand);
		PDTO.setPrice(price);
		PDTO.setDiscount(discount);
		PDTO.setImage(image.getInputStream().readAllBytes());
		
		ProductDAO PDAO = new ProductDAO();
		try {
			int res=PDAO.saveProduct(PDTO);
			if(res==1)
			{
			req.getSession().setAttribute("products", PDAO.findAll());
			RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");
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
