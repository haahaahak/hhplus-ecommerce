package hhplus.ecommerce.product.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hhplus.ecommerce.product.infra.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
