package edu.sabanciuniv.cs310;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Country class for arrayList
@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int countryID;
	private String countryName;
	private String continent;
	private String capitalName;
	private int countryPopulation;
	
	
	
	
	public Country() {
		super();
	}




	public Country(String countryName, String continent, String capitalName, int countryPopulation) {
		super();
		this.countryName = countryName;
		this.continent = continent;
		this.capitalName = capitalName;
		this.countryPopulation = countryPopulation;
	}




	public int getCountryID() {
		return countryID;
	}




	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}




	public String getCountryName() {
		return countryName;
	}




	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}




	public String getContinent() {
		return continent;
	}




	public void setContinent(String continent) {
		this.continent = continent;
	}




	public String getCapitalName() {
		return capitalName;
	}




	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}




	public int getCountryPopulation() {
		return countryPopulation;
	}




	public void setCountryPopulation(int countryPopulation) {
		this.countryPopulation = countryPopulation;
	}




	@Override
	public String toString() {
		return "Country [countryID=" + countryID + ", countryName=" + countryName + ", continent=" + continent
				+ ", capitalName=" + capitalName + ", countryPopulation=" + countryPopulation + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
