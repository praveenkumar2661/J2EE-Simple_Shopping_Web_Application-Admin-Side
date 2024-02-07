package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.SellerDTO;

public class SellerDAO 
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
	
	
	public int saveSeller(SellerDTO SDTO) throws ClassNotFoundException, SQLException
	{
		driver();
		Connection conn = connection();
		PreparedStatement pst = conn.prepareStatement("insert into seller values(?,?,?,?,?)");
		pst.setInt(1,SDTO.getId());
		pst.setString(2, SDTO.getName());
		pst.setLong(3, SDTO.getContact());
		pst.setString(4, SDTO.getEmail());
		pst.setString(5, SDTO.getPassword());
		return pst.executeUpdate();
	}

	
	public SellerDTO findByMail(String mail) throws ClassNotFoundException, SQLException
	{
		driver();
		Connection conn = connection();
		PreparedStatement pst = conn.prepareStatement("select * from seller where mail = ?");
		pst.setString(1, mail);
		
		SellerDTO SDTO = new SellerDTO();
		
		ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				SDTO.setId(1);
				SDTO.setName(rs.getString(2));
				SDTO.setEmail(rs.getString(4));
				SDTO.setContact(rs.getLong(3));
				SDTO.setPassword(rs.getString(5));
				return SDTO;
			}
		
		return null;
	}
}
