package capgemini.paramjit.productservice;

import java.util.List;
import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

	List<Product> findByProductCategory(String productCategory);

	List<Product> findByProductType(String productType);

	 
	

}