# E-Commerce Service

---

## 프로젝트 마일스톤

### WEEK 1. 시나리오 분석 및 프로젝트 준비 (10/6 ~ 10/10)
- 개발 환경 준비
  - Architecture : Layered + Clean Architecture
  - DB ORM : JPA
  - Test : JUnit + AssertJ
- 프로젝트 마일스톤 작성
- 시나리오 요구사항 분석
   - 시퀀스 다이어그램
   - 플로우 차트
   - API 명세
   - ERD 설계
- Mock API 작성

### WEEK 2. 기능 구현 (10/13 ~ 10/17)
- 잔액 충전 / 조회 API
- 상품 조회 API
- 주문 / 결제 API
- 상위 상품 조회 API

### WEEK 3. 서비스 고도화 (10/20 ~ 10/24)
- 장바구니 기능 구현
  - 장바구니 상품 추가/삭제 API
  - 장바구니 조회 API
- 다중 주문 처리 및 재고 관리
  - 동시성 제어

---

## 시퀀스 다이어그램

### 잔액 충전 / 조회
![class-diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/hhplus-ecommerce/STEP-5/docs/diagram/balance.puml)

### 주문 / 결제
![class-diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/hhplus-ecommerce/STEP-5/docs/diagram/order.puml)

### 상품 조회
![class-diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/hhplus-ecommerce/STEP-5/docs/diagram/product.puml)

### 상위 상품 조회
![class-diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/hhplus-ecommerce/STEP-5/docs/diagram/popular.puml)

---

## 플로우 차트

### 잔액 충전 / 조회
![class-diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/hhplus-ecommerce/STEP-5/docs/flowChart/balance.puml)

### 주문 / 결제
![class-diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/hhplus-ecommerce/STEP-5/docs/flowChart/order.puml)

### 상품 조회
![class-diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/hhplus-ecommerce/STEP-5/docs/flowChart/product.puml)

### 상위 상품 조회
![class-diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/hhplus-ecommerce/STEP-5/docs/flowChart/popular.puml)

