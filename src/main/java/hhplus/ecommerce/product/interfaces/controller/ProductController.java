package hhplus.ecommerce.product.interfaces.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hhplus.ecommerce.product.domain.dto.ProductListDomain;
import hhplus.ecommerce.product.domain.service.ProductService;
import hhplus.ecommerce.product.interfaces.response.ProductListResponse;
import hhplus.ecommerce.product.interfaces.response.ProductResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController implements SwaggerProductController {

	private final ProductService productService;

	@Override
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<ProductListResponse> getProducts(Pageable pageable) {
		return productService.getProducts(pageable)
			.map(ProductListDomain::toResponse);
	}

	@Override
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductResponse getProduct(@PathVariable Long id) {
		return productService.getProduct(id).toResponse();
	}
}
