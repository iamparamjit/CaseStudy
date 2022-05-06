package capgemini.paramjit.orderservice.model;


import java.time.LocalDate;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	private int OrderId;
	private int profileId;
	private long amount;
	private Map<Integer, CartItem> items;
	private LocalDate date;
	private String status;
}