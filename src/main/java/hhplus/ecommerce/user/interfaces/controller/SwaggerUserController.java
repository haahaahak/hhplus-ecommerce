package hhplus.ecommerce.user.interfaces.controller;

import hhplus.ecommerce.user.interfaces.request.UserChargeRequest;
import hhplus.ecommerce.user.interfaces.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User API")
public interface SwaggerUserController {

	@Operation(summary = "잔액 조회")
	UserResponse getBalance(Long userId);

	@Operation(summary = "잔액 충전")
	void chargeBalance(Long userId, UserChargeRequest request);
}
