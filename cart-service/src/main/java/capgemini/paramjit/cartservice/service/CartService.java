package capgemini.paramjit.cartservice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;


import capgemini.paramjit.cartservice.model.Cart;
import capgemini.paramjit.cartservice.model.CartItem;
import capgemini.paramjit.cartservice.model.IdGenerator;
import capgemini.paramjit.cartservice.repository.CartRepository;
import capgemini.paramjit.cartservice.repository.IdRepository;
import capgemini.paramjit.cartservice.valueobject.Product;



@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private IdRepository idRepo;

	
	//to view the cart 
	public Cart getCart(int profileId) {
		List<Cart> carts = new ArrayList<>();
		cartRepo.findAll().stream().forEach(cart -> {           //getting Cart for a particular User
			if(cart.getProfileId()==profileId)
				carts.add(cart);
		});
		System.out.println(carts);
		return carts.get(0);
	}


	public void createCart(int profileId) {
		IdGenerator idGen= idRepo.findById("cartId").get();
		int cartId= idGen.getSeq();                                       // Creating the cart for the new User
		idGen.setSeq(cartId+1);
		idRepo.save(idGen);
		cartRepo.save(new Cart(cartId, profileId, new HashMap<Integer,CartItem>(), (double) 0));
		
	}


	public Cart addItem(int profileId, int productId) {
		Product product= restTemplate.getForObject("http://localhost:8083/products/getProductById/"+productId, Product.class);
		System.out.println(product);
		Cart cart= getCart(profileId);
		Map<Integer,CartItem> items= cart.getItems();
		
		CartItem i= items.get(productId);                                   //adding a product by id to cart using User by Id
		if(items.containsKey(productId)) {
			i.setQuantity(i.getQuantity()+1);
			i.setProductPrice(product.getProductPrice()*i.getQuantity());
			items.put(productId, i);
		}
		else {
			items.put(productId, new CartItem(productId,product.getProductName(), product.getProductPrice(), 1));
		}
		cart.setItems(items);
		cart.setTotalPrice(0.0);
		items.values().forEach(item -> cart.setTotalPrice(cart.getTotalPrice()+item.getProductPrice()));
		cartRepo.save(cart);
		return cart;
	}


	public Cart removeItem(int profileId, int productId) {
		Product product= restTemplate.getForObject("http://localhost:8083/products/getProductById/"+productId, Product.class);
		System.out.println(product);
		Cart cart= getCart(profileId);
		Map<Integer, CartItem> items= cart.getItems();
		CartItem i= items.get(productId);                                   //Removing a product by id to cart using User by Id
		if(i.getQuantity()>1) {
			i.setQuantity(i.getQuantity()-1);
			i.setProductPrice(product.getProductPrice()*i.getQuantity());
			items.put(productId, i);
		}
		else {
			items.remove(productId);
		}
		cart.setItems(items);
		cart.setTotalPrice(0.0);
		items.values().forEach(item -> cart.setTotalPrice(cart.getTotalPrice()+item.getProductPrice()));
		cartRepo.save(cart);
		return cart;
	}


	public Collection<CartItem> getItems(int profileId) {
		return getCart(profileId).getItems().values();  
	}


	public int totalCartQuantity(int profileId) {
		Cart cart= getCart(profileId);
		int total=0;
		for(CartItem item: cart.getItems().values()) {
			total+=item.getQuantity();                               //Number Of items present in Cart
		}
		return total;
		
		
	}


	public List<Cart> getAllCarts() {
		List<Cart> carts= new ArrayList<>();
		cartRepo.findAll().stream().forEach(carts::add);         //Getting all the Carts present in Data Base
		return carts;
	}


	public void deleteCart(int profileId) {
		Cart cart= getCart(profileId);
		cart.setItems(new HashMap<Integer, CartItem>());
		cart.setTotalPrice(0.0);                                            //Clearing all the items present in cart of User
		cartRepo.save(cart);
	}
	



	
	
	

	

}












/*
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
*/
