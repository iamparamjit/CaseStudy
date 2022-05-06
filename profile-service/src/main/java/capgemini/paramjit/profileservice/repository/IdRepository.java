package capgemini.paramjit.profileservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import capgemini.paramjit.profileservice.model.IdGenerator;









@Repository
public interface IdRepository extends MongoRepository<IdGenerator, String>{

}
