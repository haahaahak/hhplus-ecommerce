package hhplus.ecommerce.product.domain.dto;

import hhplus.ecommerce.product.interfaces.response.ProductResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductDomain {
	private final Long id;
	private final String name;
	private final Long price;
	private final Integer stock;

	@Builder
	protected ProductDomain(Long id, String name, Long price, Integer stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public ProductResponse toResponse() {
		return ProductResponse.builder()
			.id(this.id)
			.name(this.name)
			.price(this.price)
			.stock(this.stock)
			.build();
	}
}
