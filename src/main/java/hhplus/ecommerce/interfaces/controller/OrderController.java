package hhplus.ecommerce.interfaces.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @PostMapping
    @Operation(summary = "주문 처리")
    public ResponseEntity<Map<String, Object>> placeOrder(@RequestBody Map<String, Object> orderRequest) {

        Map<String, Object> response = new HashMap<>();

        Long id = Long.valueOf(orderRequest.get("id").toString());
        Map<String, Integer> products = (Map<String, Integer>) orderRequest.get("products");

        boolean stockAvailable = true;
        boolean balanceSufficient = true;

        if (!stockAvailable) {
            response.put("message", "재고 부족");
            return ResponseEntity.badRequest().body(response);
        }

        if (!balanceSufficient) {
            response.put("message", "잔액 부족");
            return ResponseEntity.badRequest().body(response);
        }

        Long orderId = 123456L;
        int totalAmount = 300000;

        response.put("orderId", orderId);
        response.put("totalAmount", totalAmount);
        response.put("products", products);
        response.put("message", "주문이 성공적으로 처리되었습니다.");

        return ResponseEntity.ok(response);
    }
}
