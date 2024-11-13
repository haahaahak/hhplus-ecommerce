package hhplus.ecommerce.product.domain.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import hhplus.ecommerce.product.infra.entity.Product;
import hhplus.ecommerce.product.infra.repository.ProductRepository;
import hhplus.ecommerce.product.interfaces.response.ProductResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public ProductResponse getProduct(Long productId) {
		return findById(productId).toDomain().toResponse();
	}

	private Product findById(Long productId) {
		if (productId == null || productId < 1) {
			throw new IllegalArgumentException("ID는 1 이상의 값이어야 합니다.");
		}

		return productRepository.findById(productId)
			.orElseThrow(() -> new NoSuchElementException("존재하지 않는 상품입니다."));
	}

}
