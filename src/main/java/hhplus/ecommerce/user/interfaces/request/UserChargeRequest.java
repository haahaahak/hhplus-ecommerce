package hhplus.ecommerce.user.interfaces.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserChargeRequest {
	@NotNull(message = "충전 금액을 입력해 주세요.")
	@Min(value = 5000, message = "최소 충전 금액은 5000원 입니다.")
	private final Long amount;

	@Builder
	protected UserChargeRequest(final Long amount) {
		this.amount = amount;
	}
}
