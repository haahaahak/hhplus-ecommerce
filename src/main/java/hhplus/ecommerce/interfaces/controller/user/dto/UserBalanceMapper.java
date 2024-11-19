package hhplus.ecommerce.interfaces.controller.user.dto;

import java.math.BigDecimal;

import hhplus.ecommerce.domain.user.User;

public class UserBalanceMapper {

	public static UserDto.UserBalanceResponse toResponse(User user) {
		BigDecimal result = user.getBalance();
		if (result != null) {
			return new UserDto.UserBalanceResponse(true, result);
		}
		return new UserDto.UserBalanceResponse(false, null);
	}

}
