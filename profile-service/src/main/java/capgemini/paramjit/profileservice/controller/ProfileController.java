package capgemini.paramjit.profileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capgemini.paramjit.profileservice.model.JwtRequest;
import capgemini.paramjit.profileservice.model.JwtResponse;
import capgemini.paramjit.profileservice.model.Profile;
import capgemini.paramjit.profileservice.service.ProfileService;
import capgemini.paramjit.profileservice.utility.JWTUtility;




@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	

	
	//this is for registration of an user(can be a merchant or a consumer)
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/registerUser")
	public String registerUser(@RequestBody Profile profile) {
		return profileService.registerUser(profile);
	}
	
	//this service is for developer purpose only
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/getAllUsers")
	public List<Profile> getAllUsers() {
		return profileService.getAllUsers();
	}
	
	
	//this service is for developer purpose only
	@GetMapping("/getUsersByRole/{role}")
    public List<Profile> findByRole(@PathVariable String role){
        return profileService.findByRole(role);
    }
	
	//this is to update his/her(merchant or consumer) profile details
	@PutMapping("/updateUserProfile")
	public String updateUserProfile(@RequestBody Profile profile) {
	    return profileService.updateUserProfile(profile);
	}
	
	
	 @PostMapping("/authenticate")
	    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            jwtRequest.getUsername(),
	                            jwtRequest.getPassword()
	                    )
	            );
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }

	        final UserDetails userDetails
	                = profileService.loadUserByUsername(jwtRequest.getUsername());

	        final String token =
	                jwtUtility.generateToken(userDetails);

	        return  new JwtResponse(token);
	    }
      
	
	
	
	

}
