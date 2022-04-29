package capgemini.paramjit.cartservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("cart")
public class Cart {
	private String cartId;
	private Double totalPrice;
	//private Double price;
	//private String productName;
	//private int quantity;
	private String id;            //this product id from product micro service
	
	

}
