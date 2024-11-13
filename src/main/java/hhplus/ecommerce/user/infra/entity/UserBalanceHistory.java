package hhplus.ecommerce.user.infra.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_balance_history")
public class UserBalanceHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id", nullable = false)
	private Long userId;

	@Column(nullable = false)
	private Long amount;

	@Column(nullable = false)
	private String type;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Builder
	protected UserBalanceHistory(Long userId, Long amount, String type, LocalDateTime createdAt) {
		this.userId = userId;
		this.amount = amount;
		this.type = type;
		this.createdAt = createdAt;
	}
}
