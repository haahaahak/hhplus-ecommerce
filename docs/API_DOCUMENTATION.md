# API Documentation

## 1. 잔액 조회 API

- **Endpoint**: `/api/balance/{userId}`
- **Method**: `GET`
- **Description**: 사용자 ID를 기반으로 잔액을 조회합니다.

### Request
- **Path Variables**:
    - `userId` (Long): 사용자 ID

### Response
- **Status Code**: `200 OK`
- **Body**:
  ```json
  {
    "userId": 1,
    "balance": 100000
  }

## 2. 잔액 충전 API
- **Endpoint**: `/api/balance/charge`
- **Method**: `POST`
- **Description**: 사용자 ID와 충전 금액을 받아 잔액을 충전합니다.

### Request
- **Headers**:
    - `Content-Type`: `application/json`

- **Body**:
  ```json
  {
    "userId": 1,
    "amount": 10000
  }

### Response
- **Status Code**: `200 OK`
- **Body**:
    ```json
    {
    "userId": 1,
    "chargedAmount": 10000,
    "newBalance": 110000
    }

### Error
- **400 Bad Request**: 충전 금액이 5000원 미만일 때
    ```json
    {
    "message": "충전 금액은 5000원 이상이어야 합니다."
    }

## 3. 상품 목록 조회 API
- **Endpoint**: `/api/products`
- **Method**: `GET`
- **Description**: 현재 등록된 상품 목록을 조회합니다.

### Request
- **Headers**:
    - `Content-Type`: `application/json`

- **Body**: 없음

### Response

- **Status Code**: `200 OK`
- **Body**:
  ```json
  [
    {
      "id": 1,
      "name": "도서",
      "price": 15000,
      "stock": 50
    },
    {
      "id": 2,
      "name": "키보드",
      "price": 120000,
      "stock": 100
    },
    {
      "id": 3,
      "name": "마우스",
      "price": 75000,
      "stock": 200
    }
  ]

## 4. 인기 상품 조회 API

- **Endpoint**: `/api/products/popular`
- **Method**: `GET`
- **Description**: 최근 3일간 가장 많이 팔린 인기 상품 5개를 조회합니다.

### Request
- **Headers**:
    - `Content-Type`: `application/json`

- **Body**: 없음

### Response

- **Status Code**: `200 OK`
- **Body**:
  ```json
  [
    {
      "id": 1,
      "name": "도서",
      "price": 15000,
      "stock": 50
    },
    {
      "id": 2,
      "name": "키보드",
      "price": 120000,
      "stock": 100
    },
    {
      "id": 3,
      "name": "마우스",
      "price": 75000,
      "stock": 200
    },
    {
      "id": 4,
      "name": "헤드셋",
      "price": 140000,
      "stock": 30
    },
    {
      "id": 5,
      "name": "충전기",
      "price": 12000,
      "stock": 20
    }
  ]

## 5. 주문 처리 API

- **Endpoint**: `/api/order`
- **Method**: `POST`
- **Description**: 사용자가 상품을 주문하고 결제를 처리합니다.

### Request
- **Headers**:
    - `Content-Type`: `application/json`

- **Body**:
  ```json
  {
    "id": 1,
    "products": {
      "1": 2,
      "2": 1
    }
  }

- id: 사용자 ID
- products: 주문하려는 상품의 ID와 수량을 포함한 객체
  - 예시: {"1": 2, "2": 1} → 상품 ID 1을 2개, 상품 ID 2를 1개 주문

### Response

- **Status Code**: `200 OK`
- **Body**:
    ```json
    {
      "orderId": 123456,
      "totalAmount": 300000,
      "products": {
        "1": 2,
        "2": 1
      },
      "message": "주문이 성공적으로 처리되었습니다."
    }

### Error
- **400 Bad Request**: 재고가 부족하거나 잔액이 부족할 때

    - **재고 부족 시**:
      ```json
      {
        "message": "재고 부족"
      }
      ```

    - **잔액 부족 시**:
      ```json
      {
        "message": "잔액 부족"
      }
      ```
