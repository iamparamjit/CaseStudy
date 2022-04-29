package capgemini.paramjit.cartservice.valueobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private String id;
	private String productName;
	private String productType;
	private String productCategory;
	private String productDescription;
	private double productPrice;
	
	
	
	}