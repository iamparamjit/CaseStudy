package capgemini.paramjit.productservice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	
	@PostMapping("/add")
	public ResponseEntity <String> addProduct(@RequestBody Product product){
		
		productRepo.save(product);
		
		return new ResponseEntity<String>("Product added",HttpStatus.OK);
	}
	
	
	

}
