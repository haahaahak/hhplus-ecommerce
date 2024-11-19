package hhplus.ecommerce.infra.user;

import org.springframework.data.jpa.repository.JpaRepository;

import hhplus.ecommerce.domain.user.User;

public interface UserJPARepository extends JpaRepository<User, Long> {
}
