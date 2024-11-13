package hhplus.ecommerce.product.interfaces.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hhplus.ecommerce.product.domain.service.ProductService;
import hhplus.ecommerce.product.interfaces.response.ProductResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController implements SwaggerProductController {

	private final ProductService productService;

	@Override
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductResponse getProduct(@PathVariable Long id) {
		return null;
	}
}
