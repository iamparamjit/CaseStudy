package capgemini.paramjit.productservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	

	}


