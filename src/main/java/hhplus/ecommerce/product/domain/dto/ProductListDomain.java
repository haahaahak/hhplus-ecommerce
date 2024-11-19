package hhplus.ecommerce.product.domain.dto;

import hhplus.ecommerce.product.interfaces.response.ProductListResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductListDomain {

	private final Long id;
	private final String name;
	private final Long price;
	private final Integer stock;

	@Builder
	protected ProductListDomain(Long id, String name, Long price, Integer stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public ProductListResponse toResponse() {
		return ProductListResponse.builder()
			.id(this.id)
			.name(this.name)
			.price(this.price)
			.stock(this.stock)
			.build();
	}
}
