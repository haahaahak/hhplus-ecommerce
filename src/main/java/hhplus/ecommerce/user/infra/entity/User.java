package hhplus.ecommerce.user.infra.entity;

import hhplus.ecommerce.user.domain.dto.UserDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long balance;

	@Builder
	protected User(Long id, Long balance) {
		this.id = id;
		this.balance = balance;
	}

	public UserDomain toDomain() {
		return UserDomain.builder()
			.id(this.id)
			.balance(this.balance)
			.build();
	}

	public void chargeBalance(Long amount) {
		this.balance += amount;
	}
}
