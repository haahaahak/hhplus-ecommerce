package hhplus.ecommerce.interfaces.controller.user.dto;

import java.math.BigDecimal;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserDto {

	public record ChargeBalanceRequest(BigDecimal amount) {
		public void validate() {
			if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
				throw new IllegalArgumentException("충전 금액은 0보다 커야 합니다.");
			}
		}
	}

	public record UserBalanceResponse(boolean success, BigDecimal balance) {}

}
