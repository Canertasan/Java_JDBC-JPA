package edu.sabanciuniv.cs310.rs;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("ProductWebService")
public class ProductWebService {
	
	@GET
	@Path("addNewProduct/{pn}/{pp}/{ps}")
	public boolean addNewProduct(@PathParam("pn") String productName,
							  @PathParam("pp") double productPrice,
							  @PathParam("ps") int productStock) {
		Product p = new Product(0, productName, productPrice, productStock);
		boolean res = JDBCManager.save(p);
		return res;
		
	}
	
	@GET
	@Path("deleteProduct/{pid}")
	public boolean deleteProduct(@PathParam("pid") int productID) {
		boolean res = JDBCManager.delete(productID);
		return res;
		
	}
	
	@GET
	@Path("updateProductStock/{pid}/{npp}/{nps}")
	public boolean updateProductStock(@PathParam("pid") int productID,
			@PathParam("npp") double productNewPrice,
			@PathParam("nps") int productNewStock) {
		boolean res = JDBCManager.update(productID,productNewPrice,productNewStock);
		return res;
		
	}
	
}
