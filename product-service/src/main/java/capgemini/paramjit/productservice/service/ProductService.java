package capgemini.paramjit.productservice.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capgemini.paramjit.productservice.model.IdGenerator;
import capgemini.paramjit.productservice.model.Product;
import capgemini.paramjit.productservice.repository.IdRepository;
import capgemini.paramjit.productservice.repository.ProductRepository;



@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private IdRepository idRepo;

	public String addProduct(Product product) {
		IdGenerator idGen= idRepo.findById("productId").get();
		product.setProductId(idGen.getSeq());
		idGen.setSeq(idGen.getSeq()+1);
		idRepo.save(idGen);
		
		  
		productRepo.save(product);
		return "Product Added";
	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
		
	}
	
	

	 public String updateProduct(Product product) {

	        Optional<Product> prod = productRepo.findById(product.getProductId());
	        if (!prod.isPresent()) {
	            return ("Updation FAILED");
	        }

	        Product updatedProduct = productRepo.save(product);

	        return "Updation SUCCESS";
	    }
	 
	 

	public Optional<Product> getProductById(int productId) {
	        return productRepo.findById(productId);	
	        }

	public String deleteProduct(int productId) {
		productRepo.deleteById(productId);
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
		
		return productRepo.findByProductType(productType);
	}

	
	
	

	}


