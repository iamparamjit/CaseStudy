package capgemini.paramjit.productservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	public String addProducts(Product product) {
		List <Product> products=new ArrayList<>();
		products.add(product);
		return "success";
		
	}
	
	
	private List<Product> products=new ArrayList<>
	(Arrays.asList(
			new Product(2,"spring FrameWork","Spring FrameWork Description","hg","jhgj",654)));

	public List<Product> getAllProducts() {
		return products;
	}

}
