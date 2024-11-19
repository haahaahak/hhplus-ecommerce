package hhplus.ecommerce.infra.user;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import hhplus.ecommerce.domain.user.User;
import hhplus.ecommerce.domain.user.service.UserRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final UserJPARepository userJPARepository;

	@Override
	public Optional<User> findById(Long id) {
		return userJPARepository.findById(id);
	}

	@Override
	public Optional<User> save(User user) {
		return Optional.of(userJPARepository.save(user));
	}

}
