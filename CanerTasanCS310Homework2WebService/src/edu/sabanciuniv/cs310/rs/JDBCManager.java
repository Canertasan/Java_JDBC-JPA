package edu.sabanciuniv.cs310.rs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class JDBCManager {

	public static boolean save(Product p) 
	{
		try 
		{
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cs310", "root","159753Caner.");
			PreparedStatement ps =  con.prepareStatement("insert into product (productName,productPrice,productStock) values (?,?,?)");
			ps.setString(1, p.getProductName());
			ps.setDouble(2, p.getProductPrice());
			ps.setInt(3, p.getProductStock());
			int result = ps.executeUpdate();

			if(result==1)
			{
				return true;
			}
			
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public static boolean delete(int productID) 
	{
		
		try
		{
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cs310", "root","159753Caner.");
			PreparedStatement ps =  con.prepareStatement("delete from product where productID = ?");
			ps.setInt(1, productID);
			int result = ps.executeUpdate();
			
			
			if(result==1)
			{
				return true;
			}
			
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public static boolean update(int productID, double productNewPrice, int productNewStock ) 
	{
		
		try
		{
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cs310", "root","159753Caner.");
			PreparedStatement ps =  con.prepareStatement("update product set productPrice = ?, productStock = ? where productID = ?");
			ps.setDouble(1, productNewPrice);
			ps.setInt(2, productNewStock);
			ps.setInt(3, productID);
			int result = ps.executeUpdate();
			
			
			if(result==1)
			{
				return true;
			}
			
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}
