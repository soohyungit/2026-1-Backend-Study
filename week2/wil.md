스프링 계층형 아키텍처(Layered Architecture)
Controller, Service, Repository, Entity
만약 계층형 아키텍처를 레스토랑으로 비유한다면)
browser: 손님, controller: 웨이터, Service: 주방장, DAO/Repository: 창고 관리인, DB: 냉장/냉동창고, DTO: 주문서, 영수증, Entity: 원재료

오늘은 Controller 와 Service 계층에 대해 학습

Controller 계층: 

-HTTP 요청 / 응답
-특정 endpoint(URL)로 요청을 가장 먼저
처리 -DTO (Data Transfer Object)를 사용하
여 서비스 계층과 데이터 주고받음.

JSON : key와 value가 쌍을 이루는 타입

HTTP 데이터 구조 :HTTP body
요청: request body
응답: response body
API 서버: json 응답

패키지 구조 - 계층형 VS 도메인형
계층형 : 애플리케이션을 기능별로 나눈다 ex) controller, service, repository 등등
도메인형: 도메인을 기준으로 해당 도메인과 관련된 코드를 모두 한곳에 모아둔다 ex) member,product 등등

도메인형이 코드탐색이 쉽고, 유지보수에 용이하므로 도메인 형으로 진행

Controller 코드를 작성할때 어노태이션들을 먼저 설정한다
1.@Controller : 컨트롤러임을 명시 
2.@RequestBody : 메서드 반환값을 HTTP 응답 본문에 직접 작성
3.@RequiredArgsConstructor : 모든 필드값을 파라미터로 받는 생성자 생성
4.@PathVariable : URI 일부를 변수처럼 사용하는것 ex) {memberId}
5.@RequestMapping : 공통적인 엔드포인트를 생략가능
6.@RestController : 1,2를 한번에 선언해주는 어노태이션

상태 코드(status code)
200 OK [처리 성공]
201 Created [데이터 생성 성공]
204 No Content [요청 성공 but 보내줄 콘텐츠 없음] = Delete 통한 영구 삭제
400 Bad Request [클라이언트 요청 오류]
404 Not Found [요청 데이터 없음]
500 Internal Server Error [서버 에러]

@Getter = lombok에서 제공해주는 get메서드 자동 생성


service 계층

-애플리케이션의 비즈니스 로직이 담기는 계층
-레포지토리 계층과 소통 with 엔티티 또는
DTO
-컨트롤러와 레포지토리 사이의 중간 다리

스프링에서는 예를들어 메서드에서 3개를 실행한다고 하면 셋다 실행 or 셋다 안됨을 만족해야한다
이를 원자성을 갖는다고 함 -> 트랜잭션 단위로 처리하면 됨 -> @Transactional 붙이면 끝


스프링 빈 & 의존성 주입
spring container : 스프링 빈 저장소 , 어플리케이션 컨텍스트
spring bean : 어플리케이션 전역에서 사용할 공용객체, 스프링 컨테이너에 빈을 저장 필요할때 사용,
필요한 빈은 스프링 프레임워크가 자동으로 가져옴, 빈을 필요로하는 객체 역시 빈이다.

빈으로 등록하고 싶은 클래스 앞에 @Component를 붙이면 된다.
@Controller, @Service 같은 어노태이션이 실은 빈으로 등록하기 위한 어노태이션 이었음. 

의존성 주입: 내가 의존하는 객체를 직접 생성하지 않고 밖에서 받는것.
@RequiredArgsConstructor를 통해 의존성 주입이 쉽게 가능하다. (생성자 선언 @Autowired 어노태이션 붙이기를 생략할수 있음)
