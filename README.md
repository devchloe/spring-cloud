## Spring Cloud를 이용한 Microservice 샘플 만들기

#### 1번째 작업내역

2018.05.31
- Service Discovery 하기 위해서 Eureka에 Client로 등록
- Feign을 통해 상대 서비스에 REST 요청함
- Hystrix를 이용해서 상대 서비스에서 응답하지 못할 경우를 대비해 fallback 실행하도록 함
- Spring Data JPA, Hsql 적용