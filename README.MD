# 학사관리 시스템 구현

## 기술 스택
- jpa
  - queyrdsl
- spring-batch
- spring-security
- flyway
- mysql
- redis
- docker & docker compose
- logback
- feignClient
- junit5
- testcontainers

## 구조
- application
  - 타 도메인 서비스를 주입 받음
  - 타 도메인의 application 서비스를 주입받을 수는 없음 (도메인 어그리게이트 및 순환참조 방지)
- domain
  - 해당 도메인을 대표하는 엔티티를 갖음
  - service
    - 해당 도메인 로직을 처리하는 서비스
  - entity
    - 고유 식별자를 갖는 객체 

## ERD
<img width="1276" alt="image" src="https://github.com/runnz121/academic/assets/54499829/d0080075-6525-4fe0-8c51-f8cf33b05df7">
