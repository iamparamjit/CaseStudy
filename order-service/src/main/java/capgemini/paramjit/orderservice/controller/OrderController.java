package capgemini.paramjit.orderservice.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capgemini.paramjit.orderservice.model.CartItem;
import capgemini.paramjit.orderservice.model.Order;
import capgemini.paramjit.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	
	@GetMapping("/allOrders")
	public List<Order> getAllOrders(){
		
		return orderService.getAllOrders();
	}
	
	@PostMapping("/addOrder")
	public void addOrder(@RequestBody Order order) {
		 orderService.addOrder(order);
		
	}
	@GetMapping("/getMyOrders/{profileId}")
	public List<Order> getMyOrders(@PathVariable int profileId) {
		return orderService.getMyOrders(profileId);
	}
	@GetMapping("/getOrderById/{orderId}")
	public Order getOrderById(@PathVariable int orderId) {
		return orderService.getOrderById(orderId);
	}
	
	@GetMapping("/recentOrder/{profileId}")
	public Order getRecentOrder(@PathVariable int profileId) {
		return orderService.getRecentOrder(profileId);
	}
	

	@GetMapping("/recentItems/{profileId}")
	public Collection<CartItem> getRecentItems(@PathVariable int profileId){
		return orderService.getRecentItems(profileId);
	}
	
	
	
	
	
	
}