package hhplus.ecommerce.user.domain.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import hhplus.ecommerce.user.infra.entity.User;
import hhplus.ecommerce.user.infra.repository.UserRepository;
import hhplus.ecommerce.user.interfaces.response.UserResponse;

class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	static Stream<Long> invalidUserIds() {
		return Stream.of(null, -1L, 0L);
	}

	@Test
	@DisplayName("잔액 조회_성공")
	void getBalance() {
		// given
		Long userId = 1L;
		User user = User.builder()
			.id(userId)
			.balance(1000L)
			.build();
		when(userRepository.findById(userId)).thenReturn(Optional.of(user));

		// when
		UserResponse response = userService.getBalance(userId);

		// then
		assertNotNull(response);
		assertEquals(1000L, response.getBalance());
		verify(userRepository, times(1)).findById(userId);
	}

	@ParameterizedTest
	@MethodSource("invalidUserIds")
	@DisplayName("잔액 조회_실패_사용자 ID")
	void getBalance_validateUserId(Long userId) {
		// when & then
		assertThrows(IllegalArgumentException.class, () -> userService.getBalance(userId));
	}

	@Test
	@DisplayName("잔액 조회_실패_사용자 조회")
	void getBalance_userNotFound() {
		// given
		Long userId = 99999L;

		// when & then
		when(userRepository.findById(userId)).thenReturn(Optional.empty());
		assertThrows(NoSuchElementException.class, () -> userService.getBalance(userId));
		verify(userRepository, times(1)).findById(userId);
	}

	@Test
	@DisplayName("잔액 충전_성공")
	void chargeBalance() {
		// given
		Long userId = 1L;
		Long currentAmount = 500L;
		Long chargeAmount = 5000L;

		User user = User.builder()
				.id(userId)
				.balance(currentAmount)
				.build();

		when(userRepository.findById(userId)).thenReturn(Optional.of(user));

		// when
		userService.chargeBalance(userId, chargeAmount);

		// then
		assertEquals(currentAmount + chargeAmount, user.getBalance());
		verify(userRepository, times(1)).save(user);
	}

	@ParameterizedTest
	@MethodSource("invalidUserIds")
	@DisplayName("잔액 조회_실패_사용자 ID")
	void chargeBalance_validateUserId(Long userId) {
		// given
		Long amount = 5000L;

		// when & then
		assertThrows(IllegalArgumentException.class, () -> userService.chargeBalance(userId, amount));
	}

	@Test
	@DisplayName("잔액 충전_실패_사용자 조회")
	void chargeBalance_userNotFound() {
		// given
		Long userId = 99999L;
		Long chargeAmount = 1000L;

		// when & then
		when(userRepository.findById(userId)).thenReturn(Optional.empty());
		assertThrows(NoSuchElementException.class, () -> userService.chargeBalance(userId, chargeAmount));
		verify(userRepository, times(1)).findById(userId);
	}
}