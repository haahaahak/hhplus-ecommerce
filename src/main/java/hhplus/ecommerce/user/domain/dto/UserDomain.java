package hhplus.ecommerce.user.domain.dto;

import hhplus.ecommerce.user.interfaces.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserDomain {
	private final Long id;
	private final Long balance;

	@Builder
	protected UserDomain(final Long id, final Long balance) {
		this.id = id;
		this.balance = balance;
	}

	public UserResponse toResponse() {
		return UserResponse.builder()
			.id(this.id)
			.balance(this.balance)
			.build();
	}
}
