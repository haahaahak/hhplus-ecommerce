package hhplus.ecommerce.user.domain.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import hhplus.ecommerce.user.infra.entity.User;
import hhplus.ecommerce.user.infra.repository.UserRepository;
import hhplus.ecommerce.user.interfaces.response.UserResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public UserResponse getBalance(Long userId) {
		return findById(userId).toDomain().toResponse();
	}

	public void chargeBalance(Long userId, Long amount) {
		User user = findById(userId);

		user.chargeBalance(amount);
		userRepository.save(user);
	}

	private User findById(Long userId) {
		if (userId == null || userId <= 0) {
			throw new IllegalArgumentException("ID는 1 이상의 값이어야 합니다.");
		}

		return userRepository.findById(userId)
			.orElseThrow(() -> new NoSuchElementException("사용자 ID: " + userId + "을(를) 찾을 수 없습니다."));
	}
}
