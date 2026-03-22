![스크린샷 2026-03-21 180133.png](%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202026-03-21%20180133.png)

////

1주차 학습내용
웹이란? 인터넷 위에서 동작하는 서비스 중 하나.
인터넷에 연결된 전 세계 사용자들이 서로의 정보를
공유할 수 있는 장소.

클라이언트: 요청을 보내고 , 서버의 응답 결과를 받아서 사용
서버: 클라이언트의 요청을 받아 처리하고, 그에 대한 응답을 반환
URL: 웹상에서 특정 자원의 위치를 나타내는 주소

이 주소는 Host, Port, Path, Query 그리고 scheme(protocol)으로 이루어져있다
이때 Http 프로토콜은 웹에서 데이터를 주고받는 서버-클라이언트 모델의 프로토콜로 2가지 특징이있다.
1.무상태성(Stateless) : 서버는 클라이언트의 이전 요청을 저장하지 않고, 매 요청을 독립적으로 처리
2.비연결성(Connectionless) : 클라이언트가 요청을 보내고 응답을 받은 후 서버와 연결을 유지하지 않음

프론트엔드: 사용자가 직접 보고 상호작용하는 화면, 사용자 인터페이스(UI)를 개발
백엔드:사용자의 요청을 받아 실제 동작을 처리하고 데이터를 저장, 관리

이때 서버가 다루는 데이터는 영구적으로, 안전하게 그리고 효율적으로 보관되어야 한다.
이를 체계적으로 모아둔 장소가 DB이며 DBMS으로 데이터베이스를 관리,조작한다.

API : 한 프로그램이 다른 프로그램의 기능이나 데이터를 사용할 수 있도록 미리 정해놓은 약속(규
칙)이자 소통 창구

REST는 네트워크 아키텍처 스타일로, HTTP의 장점을 최대한 활용할 수 있는 아키텍처
REST API는 자원(Resource)을 고유한 URI로 식별하고, 해당 자원에 대한 행위(Verb)를 HTTP 메서드(GET,
POST, PUT, DELETE 등)로 정의하며, 그 결과를 JSON 같은 표준 형식으로 표현하는 웹 서비스 아키텍처 스타일

//////

API 명세서 작성

상품기능
1. 상품 정보 등록
HTTP Method : POST
URI : /items
2. 상품 목록 조회
HTTP Method : GET
URI : /items
3. 개별 상품 정보 상세 조회
HTTP Method : GET
URI : /items/{itemId}
4. 상품 정보 수정
HTTP Method : PATCH
URI : /items/{itemId}
5. 상품 삭제
HTTP Method : DELETE
URI: /items/{itemId}


주문 기능
1. 주문 정보 생성
HTTP Method : POST
URI : /orders
2. 주문 목록 조회
HTTP Method : GET
URI : /orders
3. 개별 주문 정보 상세 조회
HTTP Method : GET
URI : /orders/{orderId}
4. 주문 취소
HTTP Method : DELETE
URI : /orders/{orderId}