package capgemini.paramjit.productservice;

import org.bson.codecs.IntegerCodec;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{

}
