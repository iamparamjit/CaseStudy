package capgemini.paramjit.productservice.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import capgemini.paramjit.productservice.model.Product;




@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

	List<Product> findByProductCategory(String productCategory);

	List<Product> findByProductType(String productType);

	 
	

}