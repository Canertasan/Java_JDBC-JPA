package edu.sabanciuniv.cs310;



/*
 
CREATE TABLE `cs310`.`country` (
		  `countryID` INT NOT NULL AUTO_INCREMENT,
		  `countryName` VARCHAR(100) NULL,
		  `continent` VARCHAR(100) NULL,
		  `capitalName` VARCHAR(100) NULL,
		  `countryPopulation` INT NULL,
		  PRIMARY KEY (`countryID`));
*/

public class MainClass {

	public static void main(String[] args) {

		CanerJDBCManager.readFromFile("world.txt");
		CanerJDBCManager.writeIntoTable(CanerJDBCManager.countries);
		Country temp;
		temp = CanerJDBCManager.getCountryByID(12); // Country [countryID=12, countryName=Bahrain, continent=Asia, capitalName=Manama, countryPopulation=726617]
		System.out.println(temp);
		CanerJDBCManager.deleteCountryByID(11);
		System.out.println("Country deleted which is countryID=11");
		CanerJDBCManager.updateCountryPopulationByID(12,10000000);
		System.out.println("countryID=12's population updated to 10000000");
	}

}
