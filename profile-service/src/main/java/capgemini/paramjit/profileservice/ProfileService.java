package capgemini.paramjit.profileservice;

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

}