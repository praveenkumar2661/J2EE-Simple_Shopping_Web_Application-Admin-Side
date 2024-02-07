package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

import DTO.ProductDTO;


public class ProductDAO
{
	public Connection connection() throws SQLException
	{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?user=root&password=root");
		return conn;
	}
	
	
	public Class<?> driver() throws ClassNotFoundException
	{
		return Class.forName("com.mysql.cj.jdbc.Driver");
	}
	
	
	public int saveProduct(ProductDTO PDTO) throws ClassNotFoundException, SQLException
	{
		driver();
		Connection conn = connection();
		PreparedStatement pst = conn.prepareStatement("insert into product values(?,?,?,?,?,?)");
		pst.setInt(1,PDTO.getId());
		pst.setString(2, PDTO.getName());
		pst.setString(3, PDTO.getBrand());
		pst.setDouble(4, PDTO.getPrice());
		pst.setDouble(5, PDTO.getDiscount());
		Blob image = new SerialBlob(PDTO.getImage());
		pst.setBlob(6, image);
		return pst.executeUpdate();
	}
	
	
	public int update(ProductDTO PDTO) throws ClassNotFoundException, SQLException
	{
		driver();
		Connection conn = connection();
		PreparedStatement pst = conn.prepareStatement("update product set name = ?, brand = ?, price = ?, discount = ?, image = ? where id = ?");
		pst.setString(1, PDTO.getName());
		pst.setString(2, PDTO.getBrand());
		pst.setDouble(3, PDTO.getPrice());
		pst.setDouble(4, PDTO.getDiscount());
		pst.setBytes(5, PDTO.getImage());
		pst.setInt(6,PDTO.getId());
		
		return pst.executeUpdate();
	}
	
	
	public ArrayList<ProductDTO > findAll() throws ClassNotFoundException, SQLException
	{
		driver();
		Connection conn = connection();
		ArrayList<ProductDTO> list = new ArrayList<>();
		PreparedStatement pst = conn.prepareStatement("select * from product");
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			ProductDTO PDTO = new ProductDTO();
			PDTO.setId(rs.getInt(1));
			PDTO.setName(rs.getString(2));
			PDTO.setBrand(rs.getString(3));
			PDTO.setPrice(rs.getDouble(4));
			PDTO.setDiscount(rs.getDouble(5));
			PDTO.setImage(rs.getBytes(6));
			list.add(PDTO);
		}
		return list;
	}
	
	
	public ProductDTO findByID(int id) throws ClassNotFoundException, SQLException
	{
		driver();
		Connection conn = connection();
		ProductDTO PDTO = new ProductDTO();
		PreparedStatement pst = conn.prepareStatement("select * from product where id = ?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
			PDTO.setId(rs.getInt(1));
			PDTO.setName(rs.getString(2));
			PDTO.setBrand(rs.getString(3));
			PDTO.setPrice(rs.getDouble(4));
			PDTO.setDiscount(rs.getDouble(5));
			PDTO.setImage(rs.getBytes(6));
			return PDTO;
	}
	public int Delete(int id) throws ClassNotFoundException, SQLException
	{
		driver();
		Connection conn = connection();
		PreparedStatement pst = conn.prepareStatement("delete from product where id = ?");
		pst.setInt(1, id);
		return pst.executeUpdate();
	}
	
	
	
	
	
}
