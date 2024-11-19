package hhplus.ecommerce.interfaces.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hhplus.ecommerce.application.UserFacade;
import hhplus.ecommerce.domain.user.service.UserService;
import hhplus.ecommerce.interfaces.controller.user.dto.UserBalanceMapper;
import hhplus.ecommerce.interfaces.controller.user.dto.UserDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController implements SwaggerUserController {

	private final UserService userService;
	private final UserFacade userFacade;

	@Override
	@GetMapping("/{userId}/balance")
	@ResponseStatus(HttpStatus.OK)
	public UserDto.UserBalanceResponse getUser(@PathVariable Long userId) {
		return UserBalanceMapper.toResponse(userService.getUser(userId));
	}

	@Override
	@PatchMapping("/{userId}/charge")
	@ResponseStatus(HttpStatus.OK)
	public UserDto.UserBalanceResponse chargeBalance(@PathVariable Long userId, @RequestBody UserDto.ChargeBalanceRequest request) {
		request.validate();

		return UserBalanceMapper.toResponse(
			userFacade.chargeBalance(userId, request.amount()));
	}
}
