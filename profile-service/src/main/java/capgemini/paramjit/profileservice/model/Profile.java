package capgemini.paramjit.profileservice.model;

import java.time.LocalDate;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("profile")
public class Profile {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	@Id
	private String profileId;
	private String fullName;
	private String emailId;
	private Long mobileNumber;
	//private LocalDate dateOfBirth;
	private String gender;
	private String role;
	private String password;
	//private List Address;

	
}
