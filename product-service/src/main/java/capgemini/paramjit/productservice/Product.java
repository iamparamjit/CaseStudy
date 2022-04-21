package capgemini.paramjit.productservice;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Document("product")
public class Product {
	@Id
	private String id;
	private String productName;
	private String productType;
	private String productCategory;
	private String productDescription;
	private double productPrice;
	
	
	public Product() {
		super();
	}


	public Product(String productId, String productName, String productType, String productCategory,
			String productDescription, double productPrice) {
		super();
		this.id = productId;
		this.productName = productName;
		this.productType = productType;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}

	
	

	public String getProductId() {
		return id;
	}


	public void setProductId(String productId) {
		this.id = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductType() {
		return productType;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	@Override
	public String toString() {
		return "Product [productId=" + id + ", productName=" + productName + ", productType=" + productType
				+ ", productCategory=" + productCategory + ", productDescription=" + productDescription
				+ ", productPrice=" + productPrice + "]";
	}
	
	
	
	
	
	

}
