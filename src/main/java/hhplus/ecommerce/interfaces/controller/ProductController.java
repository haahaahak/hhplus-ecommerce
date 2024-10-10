package hhplus.ecommerce.interfaces.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    @Operation(summary = "상품 목록 조회")
    public ResponseEntity<List<Map<String, Object>>> getProducts() {
        List<Map<String, Object>> products = new ArrayList<>();

        Map<String, Object> product1 = new HashMap<>();
        product1.put("id", 1);
        product1.put("name", "도서");
        product1.put("price", 15000);
        product1.put("stock", 50);

        Map<String, Object> product2 = new HashMap<>();
        product2.put("id", 2);
        product2.put("name", "키보드");
        product2.put("price", 120000);
        product2.put("stock", 100);

        Map<String, Object> product3 = new HashMap<>();
        product3.put("id", 3);
        product3.put("name", "마우스");
        product3.put("price", 75000);
        product3.put("stock", 200);

        products.add(product1);
        products.add(product2);
        products.add(product3);

        return ResponseEntity.ok(products);
    }
}
