package hhplus.ecommerce.domain.user.service;

import java.util.Optional;

import hhplus.ecommerce.domain.user.User;

public interface UserRepository {
	Optional<User> findById(Long id);

	Optional<User> save(User user);
}
