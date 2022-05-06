package capgemini.paramjit.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import capgemini.paramjit.orderservice.model.IdGenerator;




@Repository
public interface IdRepository extends MongoRepository<IdGenerator, String>{

}
