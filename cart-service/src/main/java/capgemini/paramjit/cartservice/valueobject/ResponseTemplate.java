package capgemini.paramjit.cartservice.valueobject;

import java.util.List;

import capgemini.paramjit.cartservice.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
	
	private Cart cart;
	private Product product;

}
