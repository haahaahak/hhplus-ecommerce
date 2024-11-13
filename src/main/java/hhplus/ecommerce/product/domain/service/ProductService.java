package hhplus.ecommerce.product.domain.service;

import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hhplus.ecommerce.product.domain.dto.ProductDomain;
import hhplus.ecommerce.product.domain.dto.ProductListDomain;
import hhplus.ecommerce.product.infra.entity.Product;
import hhplus.ecommerce.product.infra.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public Page<ProductListDomain> getProducts(Pageable pageable) {
		return productRepository.findAll(pageable)
			.map(Product::toListDomain);
	}

	public ProductDomain getProduct(Long productId) {
		return findById(productId).toDomain();
	}

	private Product findById(Long productId) {
		if (productId == null || productId < 1) {
			throw new IllegalArgumentException("ID는 1 이상의 값이어야 합니다.");
		}

		return productRepository.findById(productId)
			.orElseThrow(() -> new NoSuchElementException("존재하지 않는 상품입니다."));
	}

}
