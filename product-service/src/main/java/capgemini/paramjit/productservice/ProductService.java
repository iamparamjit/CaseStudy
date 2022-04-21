package capgemini.paramjit.productservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	public String addProduct(Product product) {
		productRepo.save(product);
		return "Product Added";
	}

	public List<Product> getAllProducts() {
		List<Product> products=productRepo.findAll();
		return products;
	}

	public String updateProducts(int id,Product product) {
		
		 productRepo.save(product);
		return "Product Updated";
	}

	public Optional<Product> getProductById(String prroductId) {
	        return productRepo.findById(prroductId);	
	        }
	
	

	}


