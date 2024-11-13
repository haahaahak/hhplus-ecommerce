package hhplus.ecommerce.user.interfaces.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hhplus.ecommerce.user.domain.service.UserService;
import hhplus.ecommerce.user.interfaces.request.UserChargeRequest;
import hhplus.ecommerce.user.interfaces.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController implements SwaggerUserController {

	private final UserService userService;

	@Override
	@GetMapping("/{id}/balance")
	@ResponseStatus(HttpStatus.OK)
	public UserResponse getBalance(@PathVariable Long id) {
		return userService.getBalance(id);
	}

	@Override
	@PatchMapping("/{id}/charge")
	@ResponseStatus(HttpStatus.OK)
	public void chargeBalance(@PathVariable Long id, @Valid @RequestBody UserChargeRequest request) {
		System.out.println("여기?" + request);
		userService.chargeBalance(id, request.getAmount());
	}
}
