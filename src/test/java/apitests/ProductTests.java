package apitests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.clients.ProductsAPIClient;
import api.models.products.AddNewProduct;
import io.restassured.response.Response;

public class ProductTests {

	@Test
	public void testCreateProducts() {

		// use the Product Request model to send structure data
		AddNewProduct productRequest = new AddNewProduct(911, "Avatar", 50.00, "Holywood Movie", "Sci-Fi");

		// create the product and get response
		Response response = ProductsAPIClient.createProduct(productRequest);

		// validate response status code and body
		Assert.assertEquals(response.getStatusCode(), 201, "Expected Status code 201");
		System.out.println(productRequest.getCategory());

	}
	
	@Test
	public void testGetAllProducts() {
		
		Response response = ProductsAPIClient.getAllProducts();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test
	public void testGetProductById() {
		
		Response response = ProductsAPIClient.getProductById(2);
		System.out.println(response.asPrettyString());
	}

}
