package hhplus.ecommerce.product.interfaces.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import hhplus.ecommerce.product.interfaces.response.ProductListResponse;
import hhplus.ecommerce.product.interfaces.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product API")
public interface SwaggerProductController {

	@Operation(summary = "상품 목록 조회")
	Page<ProductListResponse> getProducts(Pageable pageable);

	@Operation(summary = "상품 조회")
	ProductResponse getProduct(Long id);
}
