package capgemini.paramjit.productservice.model;



import org.springframework.data.annotation.Id;
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
	private int productId;
	private String productName;
	private String productType;
	private String productCategory;
	private String productDescription;
	private double productPrice;
	private String imageURL;
	
	}