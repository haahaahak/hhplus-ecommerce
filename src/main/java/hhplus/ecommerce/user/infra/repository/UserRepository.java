package hhplus.ecommerce.user.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hhplus.ecommerce.user.infra.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
