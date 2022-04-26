package capgemini.paramjit.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capgemini.paramjit.cartservice.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	//@PostMapping("/addToCart")
	//public List<Product> addToCart(@RequestBody Product product){
		//return cartService.addToCart(product);
	//}

}
