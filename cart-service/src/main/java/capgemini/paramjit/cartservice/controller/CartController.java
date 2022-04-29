package capgemini.paramjit.cartservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capgemini.paramjit.cartservice.model.Cart;
import capgemini.paramjit.cartservice.service.CartService;
import capgemini.paramjit.cartservice.valueobject.ResponseTemplate;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addToCart")
	public String addToCart(@RequestBody Cart cart){
		return cartService.addToCart(cart);
	}
	
	@GetMapping("/getCart/{cartId}")
	public ResponseTemplate getCartWithProducts(@PathVariable String cartId) {
		return cartService.getCartWithProducts(cartId);
		
	}

	
	

}
