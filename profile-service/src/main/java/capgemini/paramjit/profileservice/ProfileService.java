package capgemini.paramjit.profileservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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

	        Profile updatedProfile = profileRepo.save(profile);

	        return "Updation SUCCESS";
	    }
	public List<Profile> findByRole(String role) {
		return profileRepo.findByRole(role);
		
	}
	
	
	
}
	

	
	



