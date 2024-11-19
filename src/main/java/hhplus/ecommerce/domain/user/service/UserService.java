package hhplus.ecommerce.domain.user.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import hhplus.ecommerce.domain.user.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User getUser(Long userId) {
		return userRepository.findById(userId).orElseThrow(
			() -> new NoSuchElementException("사용자 정보를 찾을 수 없습니다. ID: " + userId)
		);
	}

	public User chargeBalance(User user) {
		return userRepository.save(user).orElseThrow(
			() -> new NoSuchElementException("사용자 정보를 찾을 수 없습니다. ID: " + user.getId())
		);
	}
}
