package capgemini.paramjit.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import capgemini.paramjit.productservice.model.Product;
import capgemini.paramjit.productservice.repository.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ProductServiceApplicationTests {

	@Autowired
	ProductRepository productRepo;

	@Test
	@Order(1)
	public void testCreate() {
		Product product = new Product();
		product.setId("200");
		product.setProductName("iPhone XR");
		product.setProductDescription("Fantastic");
		product.setProductPrice(70000.00);
		productRepo.save(product);
		assertNotNull(productRepo.findById("200").get());
	}

	@Test
	@Order(2)
	public void testGetAllProducts() {
		List<Product> list = productRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testGetProduct() {
		Product product = productRepo.findById("200").get();
		assertEquals("iPhone XR", product.getProductName());
	}

	@Test
	@Order(4)
	public void testUpdateProduct() {
		Product p = productRepo.findById("200").get();
		p.setProductPrice(800.00);
		productRepo.save(p);
		assertNotEquals(700.00, productRepo.findById("200").get().getProductPrice());
	}

	@Test
	@Order(5)
	public void testDeleteProduct() {
		productRepo.deleteById("200");
		assertThat(productRepo.existsById("200")).isFalse();
	}
}