package edu.sabanciuniv.cs310;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

public class CanerJDBCManager {
	
	static ArrayList<Country> countries = new ArrayList<Country>();
	
	//Main Class for testing
	
	
	//basic read file func return arraylist of country into main
	public static void readFromFile(String filename) {
		try 
		{
			FileReader reader = new FileReader(filename);
			BufferedReader bfr = new BufferedReader(reader);
			while(true)
			{
				String line = bfr.readLine();
				if (line == null)
				{
					break;
				}
				String[] arrCountry = line.split(","); 
				//creating new Country object
				Country currentCountry = new Country(arrCountry[0],arrCountry[1],arrCountry[2],Integer.parseInt(arrCountry[3]));
				//add to countries array list which is global.
		        countries.add(currentCountry);   
			}
			reader.close();
		
		}
		catch (FileNotFoundException e) {
			System.out.println("no file");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("no have rights to read that file");
			e.printStackTrace();
		}
		
	}
	
	//Write existing arraylist To database. I created database and my table by hand
	public static void writeIntoTable(ArrayList<Country> countries) {
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310", "root", "159753Caner.");		
			for (Country country : countries)
			{
				PreparedStatement ps =  connection.prepareStatement("insert into country (countryID, countryName,continent,capitalName,countryPopulation) values (?,?,?,?,?) ");
				ps.setInt(1, country.getCountryID());
				ps.setString(2, country.getCountryName());
				ps.setString(3, country.getContinent());
				ps.setString(4, country.getCapitalName());
				ps.setInt(5, country.getCountryPopulation());
				
				ps.execute();
			}
			
			
			System.out.println("Data inserted!!!");
		}
		catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Entries already in database.");
		}
		catch (Exception e) {
			e.printStackTrace();
		};
	}
	//
	public static Country getCountryByID (int countryID) {
		Country countryTemp = new Country();
		try
	    {
	        // create our mysql database connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310", "root", "159753Caner.");
	      
	        // our SQL SELECT query. 
	        // if you only need a few columns, specify them by name instead of using "*"
	        String query = "SELECT * FROM country WHERE countryID = " + countryID;
	        
	        // create the java statement
	        Statement st = conn.createStatement();
	      
	        // execute the query, and get a java resultset
	        ResultSet rs = st.executeQuery(query);
	        
	        // iterate through the java resultset
	        while (rs.next())
	        {
	        	String countryName = rs.getString("countryName");
	        	String continent = rs.getString("continent");
	        	String capitalName = rs.getString("capitalName");
	        	int countryId = rs.getInt("countryID");
	        	int countryPopulation = rs.getInt("countryPopulation");
	        	countryTemp = new Country(countryName, continent, capitalName, countryPopulation);
	        	countryTemp.setCountryID(countryId);
	      }
	      st.close();
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		return countryTemp;
	}
	
	public static void deleteCountryByID (int countryID) {
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310", "root", "159753Caner.");		
			
			PreparedStatement ps =  connection.prepareStatement("delete from country where countryID =  " + countryID);
			
			ps.executeUpdate();	
		
		}
		catch (Exception e) {
			e.printStackTrace();
		};
	}
	
	public static void updateCountryPopulationByID (int countryID, int population) {
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310", "root", "159753Caner.");		
			
			PreparedStatement ps =  connection.prepareStatement("update country set countryPopulation = ? where countryID = ?");
			
			ps.setInt(1,population);
			ps.setInt(2,countryID);
			
			ps.executeUpdate();	
		
		}
		catch (Exception e) {
			e.printStackTrace();
		};
	}
	
}
 