package hhplus.ecommerce.interfaces.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/balance")
public class BalanceController {

    @GetMapping("/{userId}")
    @Operation(summary = "잔액 조회")
    public ResponseEntity<Map<String, Object>> getBalance(@PathVariable Long userId) {

        Map<String, Object> response = new HashMap<>();

        int balance = 100000;

        response.put("userId", userId);
        response.put("balance", balance);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/charge")
    @Operation(summary = "잔액 충전")
    public ResponseEntity<Map<String, Object>> charge(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        Long userId = Long.valueOf(request.get("userId").toString());
        int amount = Integer.parseInt(request.get("amount").toString());

        if (amount < 5000) {
            response.put("message", "충전 금액은 5000원 이상이어야 합니다.");
            return ResponseEntity.badRequest().body(response);
        }

        int currentBalance = 100000;
        int newBalance = currentBalance + amount;

        response.put("userId", userId);
        response.put("chargedAmount", amount);
        response.put("newBalance", newBalance);

        return ResponseEntity.ok(response);
    }
}
