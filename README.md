# fastlms


## 추가된 기능

1. 로그인 히스토리 기능
	- fastlms
      - member
          - entity/LoginHistory - 생성
          - entity/Member - lastLoginDt 필드 추가
          - repository/LoginHistoryRepository - 생성
          - service/MemberService, service/impl/MemberServiceImpl - 생성
      - admin
          - dto/MemberDto - lastLoginDt 필드 추가
	
	- resources/templates
		- admin/member/list.html - 마지막 로그인 일자 컬럼 추가
		
		
## 기타 리팩토링
- fastlms
	- configuration/SecurityConfiguration - formLogin에 defaultSuccessUrl("/") 추가