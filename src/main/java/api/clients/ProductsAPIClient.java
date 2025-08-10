package api.clients;

import api.models.products.AddNewProduct;
import io.restassured.response.Response;

public class ProductsAPIClient extends BaseAPIClient {

	private static final String PRODUCTS_ENDPOINTS = "/products";

	// get product by ID, returns Response object
	public static Response getProductById(int productId) {
		String endPoint = PRODUCTS_ENDPOINTS + "/" + productId;
		return sendGetRequest(endPoint);
	}

	// get all products, returns Response object
	public static Response getAllProducts() {
		String endPoint = PRODUCTS_ENDPOINTS;
		return sendGetRequest(endPoint);
	}

	// create product, returns Response object
	public static Response createProduct(AddNewProduct productRequest) {
		return sendPostRequest(PRODUCTS_ENDPOINTS, productRequest);
	}

}
