package edu.sabanciuniv.cs310;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CanerJDBCManager {

	static ArrayList<Country> countries = new ArrayList<Country>();
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs310");
	static EntityManager entityManager =emf.createEntityManager();

	

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

	public static void writeIntoTable ( ArrayList<Country> countries ) {
		try {

			for(Country c: countries) {

				entityManager.getTransaction().begin();

				entityManager.persist(c);

				entityManager.getTransaction().commit();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		};


	}

	public static Country getCountryByID (int countryID) {
		Country c = new Country();
		try {
			c = entityManager.find(Country.class,countryID);
		}
		catch (Exception e) {
			System.out.println(e);
			
		};
		return c;
		
	}

	public static void deleteCountryByID (int countryID) {
		try {
			Country c =getCountryByID(countryID);
			entityManager.getTransaction().begin();
			entityManager.remove(c);
			entityManager.getTransaction().commit();
		}
		catch (Exception e) {
			System.out.println(e);
		};
	}

	public static void updateCountryPopulationByID (int countryID, int population) {
		try {
			Country c =getCountryByID(countryID);
			entityManager.getTransaction().begin();
			c.setCountryPopulation(population);
			entityManager.merge(c);
			entityManager.getTransaction().commit();
		}
		catch (Exception e) {
			System.out.println(e);
		};

	}

}
