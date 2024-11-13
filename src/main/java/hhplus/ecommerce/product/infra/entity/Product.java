package hhplus.ecommerce.product.infra.entity;

import hhplus.ecommerce.product.domain.dto.ProductDomain;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Long price;

	@Column(nullable = false)
	private Integer stock;

	@Builder
	protected Product(Long id, String name, Long price, Integer stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public ProductDomain toDomain() {
		return ProductDomain.builder()
			.id(this.id)
			.name(this.name)
			.price(this.price)
			.stock(this.stock)
			.build();
	}
}
