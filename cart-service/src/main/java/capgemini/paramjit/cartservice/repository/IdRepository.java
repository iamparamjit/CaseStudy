package capgemini.paramjit.cartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import capgemini.paramjit.cartservice.model.IdGenerator;





@Repository
public interface IdRepository extends MongoRepository<IdGenerator, String>{

}
