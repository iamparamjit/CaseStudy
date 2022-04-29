package capgemini.paramjit.cartservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import capgemini.paramjit.cartservice.model.Cart;
import capgemini.paramjit.cartservice.repository.CartRepository;
import capgemini.paramjit.cartservice.valueobject.Product;
import capgemini.paramjit.cartservice.valueobject.ResponseTemplate;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	public String addToCart(Cart cart) {
		cartRepo.save(cart);
		return "Cart made";
	}

	public ResponseTemplate getCartWithProducts(String cartId) {
		ResponseTemplate resp=new ResponseTemplate();
		Cart cart=cartRepo.findByCartId(cartId);
		Product product=restTemplate.getForObject("http://localhost:8083/products/getProductById/" + cart.getId(),Product.class);
		resp.setCart(cart);
		resp.setProduct(product);
		
		return resp;
	}

}
