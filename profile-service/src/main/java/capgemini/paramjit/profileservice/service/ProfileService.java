package capgemini.paramjit.profileservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import capgemini.paramjit.profileservice.model.IdGenerator;
import capgemini.paramjit.profileservice.model.Profile;
import capgemini.paramjit.profileservice.repository.IdRepository;
import capgemini.paramjit.profileservice.repository.ProfileRepository;



@Service
public class ProfileService implements UserDetailsService {

	@Autowired
	private ProfileRepository profileRepo;
	@Autowired
	private IdRepository idRepo;
	


	public String registerUser(Profile profile) {
		IdGenerator idGen= idRepo.findById("profileId").get();
		profile.setProfileId(idGen.getSeq());
		idGen.setSeq(idGen.getSeq()+1);
		idRepo.save(idGen);
 
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
	public List<Profile> getUsersByRole(String role) {
		return profileRepo.findByRole(role);
		
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//return new User("param","pass",new ArrayList<>());
		Profile user= profileRepo.findByEmailId(username);
		return new User(user.getEmailId(), user.getPassword(), new ArrayList<>());
			}
	public Optional<Profile> getUserById(int profileId) {
		
		return profileRepo.findById(profileId);
	}
	public String deleteAllProfiles() {
		profileRepo.deleteAll();
		return "Deleted All Profiles";
	}
	
	
	
	
	
	
	
}
	

	
	
/*
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Profile user = profileRepo.findByEmailId(username);
    if(user != null) {
        System.out.println(user.toString());
        return user(profileRepo.findByEmailId(username),"pass",new ArrayList<>());
    }
    throw new UsernameNotFoundException("User "+ username +" not found");
} 
 

private UserDetails user(Profile findByEmailId, String string, ArrayList arrayList) {
	// TODO Auto-generated method stub
	return null;
}*/



