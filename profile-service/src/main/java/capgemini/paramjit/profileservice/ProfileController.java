package capgemini.paramjit.profileservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@PostMapping("/registerUser")
	public String registerUser(@RequestBody Profile profile) {
		return profileService.registerUser(profile);
	}
	
	@GetMapping("/getAllUsers")
	public List<Profile> getAllUsers() {
		return profileService.getAllUsers();
	}
	
	@GetMapping("/getUsersByRole/{role}")
    public List<Profile> findByRole(@PathVariable String role){
        return profileService.findByRole(role);
    }
	
	  @PutMapping("/updateUserProfile")
	    public String updateUserProfile(@RequestBody Profile profile) {

	        return profileService.updateUserProfile(profile);
	    }
	

}
