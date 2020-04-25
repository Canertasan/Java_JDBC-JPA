package edu.sabanciuniv.cs310.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainClass {

	public static void consumer(URL url) {
		try 
		{
			InputStreamReader reader = new InputStreamReader(  url.openStream());
			
			BufferedReader rd = new BufferedReader(reader);
			
			while(true)
			{
				String line = rd.readLine();
				if(line==null)
					break;
				System.out.println(line);
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) throws MalformedURLException {
		URL url1  =  new URL("http://localhost:8080/CanerTasanCS310Homework2WebService/rest/ProductWebService/addNewProduct/Apple/5.0/3000");
		consumer(url1);
		URL url2  =  new URL("http://localhost:8080/CanerTasanCS310Homework2WebService/rest/ProductWebService/deleteProduct/13");
		consumer(url2);
		URL url3  =  new URL("http://localhost:8080/CanerTasanCS310Homework2WebService/rest/ProductWebService/updateProductStock/11/25.0/554");
		consumer(url3);
		
	}

}
