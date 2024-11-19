package hhplus.ecommerce.interfaces.controller.user;

import hhplus.ecommerce.interfaces.controller.user.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User API")
public interface SwaggerUserController {

	@Operation(summary = "잔액 조회")
	UserDto.UserBalanceResponse getUser(Long userId);

	@Operation(summary = "잔액 충전")
	UserDto.UserBalanceResponse chargeBalance(Long userId, UserDto.ChargeBalanceRequest request);
}
