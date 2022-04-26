package capgemini.paramjit.profileservice;

import java.util.List;

import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String>{
	List<Profile> findByRole(String role);
	

	
}
