package capgemini.paramjit.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import capgemini.paramjit.productservice.model.IdGenerator;



@Repository
public interface IdRepository extends MongoRepository<IdGenerator, String>{

}
