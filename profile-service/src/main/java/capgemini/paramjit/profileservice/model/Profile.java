package capgemini.paramjit.profileservice.model;

import java.time.LocalDate;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("profile")
public class Profile {
	@Id
	private String profileId;
	private String fullName;
	private String emailId;
	private Long mobileNumber;
	private LocalDate dateOfBirth;
	private String gender;
	private String role;
	private String password;
	//private List Address;

	
}
