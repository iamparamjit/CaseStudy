package capgemini.paramjit.profileservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="profileId")
@Data
public class IdGenerator {
	
	@Id
	String id;
	int seq;
}
