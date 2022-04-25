package capgemini.paramjit.productservice;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;

//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
@Data

@Document("product")
public class Product {
	@Id
	private String id;
	private String productName;
	private String productType;
	private String productCategory;
	private String productDescription;
	private double productPrice;
	
	
	
	}