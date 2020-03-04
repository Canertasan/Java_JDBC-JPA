package edu.sabanciuniv.cs310;

public class MainClass {
	
	public static void main(String[] args) {

		CanerJDBCManager.readFromFile("world.txt");
		CanerJDBCManager.writeIntoTable(CanerJDBCManager.countries);
		System.out.println("all countries are inserted.");
		Country temp;
		temp = CanerJDBCManager.getCountryByID(1);
		System.out.println("Find 1. countryID:");
		System.out.println(temp);
		CanerJDBCManager.deleteCountryByID(1);
		System.out.println("Deleted first element of database where countryID=1");
		CanerJDBCManager.updateCountryPopulationByID(2,100000000);
		System.out.println("Updated countryID=2 population to 100000000");
	}
}
