package capgemini.paramjit.productservice;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

	 
	

}
