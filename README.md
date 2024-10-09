# E-Commerce Service

---

## 프로젝트 마일스톤

### 시나리오 분석 및 프로젝트 준비
- 개발 환경 준비
  - Architecture : Layered + Clean Architecture
  - DB ORM : JPA
  - Test : JUnit + AssertJ
- 프로젝트 마일스톤 작성
- 시나리오 요구사항 분석
   - 시퀀스 다이어그램
   - API 명세
   - ERD 설계
- Mock API 작성

### 기능 구현
- 잔액 충전 / 조회 API

- 상품 조회 API

- 주문 / 결제 API

- 상위 상품 조회 API

- 장바구니 기능

### 대용량 트래픽과 데이터 처리
- 시나리오 애플리케이션 설계

### 장애 시나리오 대응

---

## 시퀀스 다이어그램

### 잔액 충전 / 조회
![class-diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/hhplus-ecommerce/STEP-5/diagram/balance.puml)

### 주문 / 결제
![class-diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/hhplus-ecommerce/STEP-5/diagram/order.puml)

### 상품 조회 / 상위 상품 조회
![class-diagram](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/hhplus-ecommerce/STEP-5/diagram/product.puml)