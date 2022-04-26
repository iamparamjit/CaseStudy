package capgemini.paramjit.profileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capgemini.paramjit.profileservice.model.Profile;
import capgemini.paramjit.profileservice.repository.ProfileRepository;



@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepo;
	
	public String registerUser(Profile profile) {
		profileRepo.save(profile);
		return "User Registered";
	}
	public List<Profile> getAllUsers() {
		return profileRepo.findAll();
	}
	
	
	public String updateUserProfile(Profile profile) {
		 Optional<Profile> prof = profileRepo.findById(profile.getProfileId());
	        if (!prof.isPresent()) {
	            return ("Updation FAILED");
	        }

	        profileRepo.save(profile);

	        return "Updation SUCCESS";
	    }
	public List<Profile> findByRole(String role) {
		return profileRepo.findByRole(role);
		
	}
	
	
	
}
	

	
	



