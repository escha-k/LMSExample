# fastlms - 미니 LMS 서비스


## 추가된 기능

1. 로그인 히스토리(로그) 기능
	- `LoginHistory` 엔티티, 리포지토리, 서비스, 컨트롤러 추가 및 DTO, Mapper 구현
    - 기존 `Member` 엔티티에 마지막 로그인 일자 추가
    - 스프링 시큐리티 `SecurityConfiguration`에 `successHandler` 추가
      - `UserAuthenticationSuccessHandler`에서 로그인 성공시 로그인 히스토리 저장, 
        마지막 로그인 일자 갱신
    - 관리자 회원 목록 페이지에 마지막 로그인 일자 추가
		
2. 관리자 회원 상세 정보에 로그인 목록 보기 기능
    - 회원 상세 정보 페이지에 로그인 히스토리 테이블 추가
    - `RequestUtils`에 ip, userAgent 가져오는 코드 추가

3. 배너관리(백오피스 기능)
    - `Banner` 엔티티, 리포지토리, 서비스, 컨트롤러 추가 및 DTO, Mapper 구현
    - 배너 관리 페이지 추가
    - 배너 생성, 수정, 삭제 구현

4. 프론트 배너 노출 기능
    - Bxslider 이용하여 메인 페이지에 공개 설정한 배너 노출
