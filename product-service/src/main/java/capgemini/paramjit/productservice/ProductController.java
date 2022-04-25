package capgemini.paramjit.productservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product){
		
		return productService.addProduct(product);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts(){
		
		return productService.getAllProducts();
	}
	
	@GetMapping("/getProductById/{id}")
	public Optional<Product> getProductById(@PathVariable String id){
		return productService.getProductById(id);
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
	
	 @DeleteMapping("/deleteProduct/{id}")
	 public String deleteProduct(@PathVariable String id){
			return productService.deleteProduct(id);
		}
	 
		
	
	 @DeleteMapping("/deleteAll")
	 public String deleteProduct(){
			return productService.deleteAll();
		}
	 
		
	
	
	

}
