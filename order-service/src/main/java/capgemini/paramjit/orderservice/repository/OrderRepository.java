package capgemini.paramjit.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import capgemini.paramjit.orderservice.model.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{

}
