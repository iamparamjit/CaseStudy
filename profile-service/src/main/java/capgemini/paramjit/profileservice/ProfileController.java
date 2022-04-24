package capgemini.paramjit.profileservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@PostMapping("/addProfile")
	public String addProfile(@RequestBody Profile profile) {
		return profileService.addProfile(profile);
		
		
	}
	
	@GetMapping("/getProfiles")
	public List<Profile> getProfiles() {
		return profileService.getProfiles();
	}

}
