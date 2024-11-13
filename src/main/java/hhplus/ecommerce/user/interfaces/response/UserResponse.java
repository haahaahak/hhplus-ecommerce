package hhplus.ecommerce.user.interfaces.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {
	private final Long id;
	private final Long balance;

	@Builder
	protected UserResponse(Long id, Long balance) {
		this.id = id;
		this.balance = balance;
	}
}
