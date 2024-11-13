package hhplus.ecommerce.product.infra.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "product_statistics")
public class ProductStatistics {
	@Id
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "sale_count", nullable = false)
	private Integer saleCount;

	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
}
