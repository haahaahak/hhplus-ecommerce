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
@RequestMapping("/api/history")
public class OrderHistoryController {

    @GetMapping("/popular")
    @Operation(summary = "인기 상품 조회")
    public ResponseEntity<List<Map<String, Object>>> getTopSellingProducts() {
        List<Map<String, Object>> topProducts = new ArrayList<>();

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

        Map<String, Object> product4 = new HashMap<>();
        product4.put("id", 4);
        product4.put("name", "헤드셋");
        product4.put("price", 140000);
        product4.put("stock", 30);

        Map<String, Object> product5 = new HashMap<>();
        product5.put("id", 5);
        product5.put("name", "충전기");
        product5.put("price", 12000);
        product5.put("stock", 20);

        topProducts.add(product1);
        topProducts.add(product2);
        topProducts.add(product3);
        topProducts.add(product4);
        topProducts.add(product5);

        return ResponseEntity.ok(topProducts);
    }

}
