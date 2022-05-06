package capgemini.paramjit.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	
	int productId;
	//String productType;
	//String imageURL;
	String productName;
	double productPrice;
	public int quantity;
	        
	
	
	

}
