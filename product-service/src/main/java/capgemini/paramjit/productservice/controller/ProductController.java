package capgemini.paramjit.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capgemini.paramjit.productservice.model.Product;
import capgemini.paramjit.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product){
		
		return productService.addProduct(product);
	}
	
	@GetMapping("/getAllProducts")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Product> getAllProducts(){
		
		return productService.getAllProducts();
	}
	
	@GetMapping("/getProductById/{productId}")
	public Optional<Product> getProductById(@PathVariable int productId){
		return productService.getProductById(productId);
	}
	
	@GetMapping("/getProductByName/{productName}")
	public Optional<Product> getProductByName(@PathVariable String productName){
		return productService.getProductByName(productName);
	}
	
	@GetMapping("/getProductByCategory/{productCategory}")
	public List<Product> getProductByCategory(@PathVariable String productCategory){
		return productService.getProductByCategory(productCategory);
	}
	
	@GetMapping("/getProductByType/{productType}")
	public List<Product> getProductByType(@PathVariable String productType){
		return productService.getProductByType(productType);
	}
	
	  @PutMapping("/updateProduct")
	    public String updateProduct(@RequestBody Product product) {

	        return productService.updateProduct(product);
	    }
	  @CrossOrigin(origins="http://localhost:4200")
	 @DeleteMapping("/deleteProduct/{productId}")
	 public String deleteProduct(@PathVariable int productId){
			return productService.deleteProduct(productId);
		}
	 
		
	
	 @DeleteMapping("/deleteAll")
	 public String deleteProduct(){
			return productService.deleteAll();
		}
	 
		
	
	
	

}
