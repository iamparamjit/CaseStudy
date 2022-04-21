package capgemini.paramjit.productservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public String addProduct(@RequestBody Product product){
		
		return productService.addProduct(product);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts(){
		
		return productService.getAllProducts();
	}
	
	@GetMapping("/getProduct/{productId}")
	public Optional<Product> getProductById(@PathVariable String productId){
		return productService.getProductById(productId);
	}
	
	@PutMapping("/update/{productId}")
	public String updateProduct(@RequestBody Product product,@PathVariable int id) {
		return productService.updateProducts(id,product);
	}
		
	
	
	

}
