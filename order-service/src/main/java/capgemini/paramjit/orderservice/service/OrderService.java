package capgemini.paramjit.orderservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capgemini.paramjit.orderservice.model.CartItem;
import capgemini.paramjit.orderservice.model.IdGenerator;
import capgemini.paramjit.orderservice.model.Order;
import capgemini.paramjit.orderservice.repository.IdRepository;
import capgemini.paramjit.orderservice.repository.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private IdRepository idRepo;

	public List<Order> getAllOrders() {
		List<Order> orders= new ArrayList<>();
		orderRepo.findAll().forEach(orders::add);
		return orders;
	}

	public String addOrder(Order order) {
		IdGenerator idGen= idRepo.findById("orderId").get();
		order.setOrderId(idGen.getSeq());
		idGen.setSeq(idGen.getSeq()+1);
		idRepo.save(idGen);
		order.setDate(LocalDate.now());
		orderRepo.save(order);
		System.out.println(order.getProfileId());
		return "Order Placed";

}

	public List<Order> getMyOrders(int profileId) {
		List<Order> orders = new ArrayList<>();
		orderRepo.findAll().stream().forEach(order ->{
			if(order.getProfileId()==profileId)
				orders.add(order);
		});
		Collections.reverse(orders);
		return orders;
	}

	public Order getOrderById(int orderId) {
		return orderRepo.findById(orderId).get();
	}

	public Order getRecentOrder(int profileId) {
		List<Order> orders= getMyOrders(profileId);
		return orders.get(0);
	}

	public Collection<CartItem> getRecentItems(int profileId) {
		return getRecentOrder(profileId).getItems().values();
	}
	
}
