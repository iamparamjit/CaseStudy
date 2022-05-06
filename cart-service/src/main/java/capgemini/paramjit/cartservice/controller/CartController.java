package capgemini.paramjit.cartservice.controller;




import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import capgemini.paramjit.cartservice.model.Cart;
import capgemini.paramjit.cartservice.model.CartItem;
import capgemini.paramjit.cartservice.service.CartService;



@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;

	
	//to view the cart
	@GetMapping("/get/{profileId}")
	public Cart getCart(@PathVariable int profileId) {
		return cartService.getCart(profileId);
	}
	
	
	@PostMapping("/create/{profileId}")
	public void createCart(@PathVariable int profileId) {
		cartService.createCart(profileId);
		//return "cart created";
	}
	
	@PutMapping("/add/{profileId}/{productId}")
	public Cart addItem(@PathVariable int profileId, @PathVariable int productId) {
	
		return cartService.addItem(profileId,productId);
	}
	
	@PutMapping("/remove/{profileId}/{productId}")
	public Cart removeItem(@PathVariable int profileId, @PathVariable int productId) {
		return cartService.removeItem(profileId,productId);
	}
	
	@GetMapping("/items/{profileId}")
	public Collection<CartItem> getItems(@PathVariable int profileId){
		return cartService.getItems(profileId);
																//Getting Items List for a particular User
	}
	
	@GetMapping("/totalCartQuantity/{profileId}")
	public int totalCartQuantity(@PathVariable int profileId) {
		return cartService.totalCartQuantity(profileId);
	}
	
	@GetMapping("/allCarts")
	public List<Cart> getAllCarts(){
		return cartService.getAllCarts();
	}
	
	@PutMapping("/clearCart/{profileId}")
	public void deleteCart(@PathVariable int profileId) {
		cartService.deleteCart(profileId);
	}
	
		
}
	















/*
@PostMapping("/addToCart")
public String addToCart(@RequestBody Cart cart){
	return cartService.addToCart(cart);
}

@GetMapping("/getCart/{cartId}")
public ResponseTemplate getCartWithProducts(@PathVariable String cartId) {
	return cartService.getCartWithProducts(cartId);
	
}
*/
