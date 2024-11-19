package hhplus.ecommerce.application;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import hhplus.ecommerce.domain.user.User;
import hhplus.ecommerce.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserFacade {

	private final UserService userService;

	public User chargeBalance(Long userId, BigDecimal amount) {
		User user = userService.getUser(userId).chargeBalance(amount);
		return userService.chargeBalance(user);
	}
}
