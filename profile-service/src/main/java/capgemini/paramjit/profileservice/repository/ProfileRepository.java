package capgemini.paramjit.profileservice.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import capgemini.paramjit.profileservice.model.Profile;

public interface ProfileRepository extends MongoRepository<Profile, Integer>{
	List<Profile> findByRole(String role);

	Profile findByEmailId(String emailId);
	

	
}
