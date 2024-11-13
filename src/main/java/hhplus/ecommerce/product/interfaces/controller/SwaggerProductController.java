package hhplus.ecommerce.product.interfaces.controller;

import hhplus.ecommerce.product.interfaces.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product API")
public interface SwaggerProductController {

	@Operation(summary = "상품 조회")
	ProductResponse getProduct(Long id);
}
