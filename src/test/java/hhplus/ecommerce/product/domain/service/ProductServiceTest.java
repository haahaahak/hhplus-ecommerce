package hhplus.ecommerce.product.domain.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import hhplus.ecommerce.product.domain.dto.ProductDomain;
import hhplus.ecommerce.product.domain.dto.ProductListDomain;
import hhplus.ecommerce.product.infra.entity.Product;
import hhplus.ecommerce.product.infra.repository.ProductRepository;

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
	@DisplayName("상품 목록 조회")
	void getProducts() {
		// given
		Product product1 = Product.builder()
			.id(1L)
			.name("Product A")
			.price(10000L)
			.stock(50)
			.build();
		Product product2 = Product.builder()
			.id(2L)
			.name("Product B")
			.price(20000L)
			.stock(30)
			.build();
		List<Product> productList = List.of(product1, product2);

		Pageable pageable = PageRequest.of(0, 10);
		Page<Product> productPage = new PageImpl<>(productList, pageable, productList.size());

		when(productRepository.findAll(pageable)).thenReturn(productPage);

		// when
		Page<ProductListDomain> domain = productService.getProducts(pageable);

		// then
		assertNotNull(domain);
		assertEquals(2, domain.getContent().size());
		assertEquals("Product A", domain.getContent().get(0).getName());
		assertEquals("Product B", domain.getContent().get(1).getName());
		verify(productRepository, times(1)).findAll(pageable);
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
		ProductDomain domain = productService.getProduct(productId);

		// then
		assertNotNull(domain);
		assertEquals(productId, domain.getId());
		assertEquals(name, domain.getName());
		assertEquals(price, domain.getPrice());
		assertEquals(stock, domain.getStock());
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