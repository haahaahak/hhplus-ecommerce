package hhplus.ecommerce.product.interfaces.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponse {
	private final Long id;
	private final String name;
	private final Long price;
	private final Integer stock;

	@Builder
	protected ProductResponse(final Long id, final String name, final Long price, final Integer stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
}
