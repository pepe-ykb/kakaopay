**특정 고객 거래내역 조회 서비스**

1. 사용한 개발 언어 및 기술
    - Spring Boot
    - Java 8
    - Mybatis
    - Javascript(JQuery 3.4.1)
    - HTML5
    - MySQL 8.0.17
    
2. 문제 해결 방법
    - Spring Boot 기반으로하여 Ajax 통신으로 각각 API 4개 기능 결과가 나타납니다.
    - 고객 거래내역, 고객 데이터, 지점 데이터는 csv파일을 읽어서 추출하지 않고, MySQL을 사용하여 데이터 삽입 후 Query 조회 하였습니다.
    - jdbc 정보는 아래와 같습니다.
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.datasource.jdbc-url=jdbc:mysql://localhost:3306/test?serverTimezone=UTC
        spring.datasource.username=kakaopay
        spring.datasource.password=kakaopay

3. 실행방법
    - result 폴더에 실행 할 pay.jar 파일, MySQL 테이블 스크립트가 있습니다.
    - Java 설치 된 pc에서 "java -jar pay.jar" 를 실행한 후 localhost(서버 IP):8080 접속 하신 후 테스트 가능합니다.