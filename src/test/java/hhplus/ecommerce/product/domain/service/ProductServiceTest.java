package hhplus.ecommerce.product.domain.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import hhplus.ecommerce.product.infra.entity.Product;
import hhplus.ecommerce.product.infra.repository.ProductRepository;
import hhplus.ecommerce.product.interfaces.response.ProductResponse;

class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductService productService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	static Stream<Long> invalidProductId() {
		return Stream.of(null, -1L, 0L);
	}

	@Test
	@DisplayName("상품 조회")
	void getProduct() {
		// given
		Long productId = 1L;
		String name = "test product";
		Long price = 10000L;
		Integer stock = 100;

		Product product = Product.builder()
			.id(productId)
			.name(name)
			.price(price)
			.stock(stock)
			.build();

		when(productRepository.findById(productId)).thenReturn(Optional.of(product));

		// when
		ProductResponse response = productService.getProduct(productId);

		// then
		assertNotNull(response);
		assertEquals(productId, response.getId());
		assertEquals(name, response.getName());
		assertEquals(price, response.getPrice());
		assertEquals(stock, response.getStock());
		verify(productRepository, times(1)).findById(productId);
	}

	@ParameterizedTest
	@MethodSource("invalidProductId")
	@DisplayName("상품 조회_실패_상품 ID")
	void getProduct_validateProductId(Long productId) {
		// when & then
		assertThrows(IllegalArgumentException.class, () -> productService.getProduct(productId));
	}

	@Test
	@DisplayName("상품 조회_실패_존재하지 않는 상품")
	void getProduct_productNotFound() {
		// given
		Long productId = 99999L;

		// when & then
		when(productRepository.findById(productId)).thenReturn(Optional.empty());
		assertThrows(NoSuchElementException.class, () -> productService.getProduct(productId));
		verify(productRepository, times(1)).findById(productId);
	}

}