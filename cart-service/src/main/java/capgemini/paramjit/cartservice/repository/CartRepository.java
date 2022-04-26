package capgemini.paramjit.cartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import capgemini.paramjit.cartservice.model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

}
