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
		return productRepo.findAll();
		
	}
	
	

	 public String updateProduct(Product product) {

	        Optional<Product> prod = productRepo.findById(product.getId());
	        if (!prod.isPresent()) {
	            return ("Updation FAILED");
	        }

	        Product updatedProduct = productRepo.save(product);

	        return "Updation SUCCESS";
	    }
	 
	 

	public Optional<Product> getProductById(String id) {
	        return productRepo.findById(id);	
	        }

	public String deleteProduct(String id) {
		productRepo.deleteById(id);
		return "deleted succesfully";
	}



	public String deleteAll() {
		productRepo.deleteAll();
		return "deleted all";
	}

	public List<Product> getProductByCategory(String productCategory) {

		return productRepo.findByProductCategory(productCategory);
	}

	public List<Product> getProductByType(String productType) {
		// TODO Auto-generated method stub
		return productRepo.findByProductType(productType);
	}

	
	
	

	}


