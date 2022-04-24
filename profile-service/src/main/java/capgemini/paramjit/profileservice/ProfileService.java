package capgemini.paramjit.profileservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepo;
	public String addProfile(Profile profile) {
		profileRepo.save(profile);
		return "Profile Added";
	}
	public List<Profile> getProfiles() {
		return profileRepo.findAll();
	}

}

