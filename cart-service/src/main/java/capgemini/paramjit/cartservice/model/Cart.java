package capgemini.paramjit.cartservice.model;


import java.util.Map;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("cart")
public class Cart {
	@Id
	private int cartId;
	private int profileId;
	private Map<Integer, CartItem> items;
	private Double totalPrice;
	//private Double price;
	//private String productName;
	//private int quantity;
	//private String id;   //this product id from product micro service
	
	

}
