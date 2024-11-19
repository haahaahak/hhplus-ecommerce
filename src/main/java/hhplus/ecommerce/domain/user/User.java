package hhplus.ecommerce.domain.user;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Column(nullable = false)
	@Getter
	private BigDecimal balance;

	public User() {

	}

	public User(Long id, BigDecimal balance) {
		this.id = id;
		this.balance = balance;
	}

	public User chargeBalance(BigDecimal amount) {
		this.balance = this.balance.add(amount);
		return this;
	}
}
