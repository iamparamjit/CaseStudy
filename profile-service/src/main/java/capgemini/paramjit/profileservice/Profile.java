package capgemini.paramjit.profileservice;

import java.time.LocalDate;
import java.util.List;

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
