# TourGuide
객체 지향 학습을 위한 Command 기반의 여행지 관리 프로그램

## 목차
1. 목적
2. 기능
3. 구성
4. 클래스다이어 그램

## 목적
1. 객체 지향적 설계 학습
   - 전략 패턴과 커맨드 패턴
2. 파일 입출력 학습
3. 라이러리 활용
   - maven, mybatis, lombok
4. CRUD 활용
   - maven 프로젝트 활용
   
## 기능
1. 리스트 출력
   - 전체 출력 / 권역별 출력 /  페이지 출력 / 종료
2. 검색하기
   - 키워드 검색 / 번호 검색
3. 파일에 저장하기
4. 종료

## 구성
### BASE
어플리케이션에 공통적으로 적용가능 메뉴와 메뉴바를 전략패턴과 커맨드패턴으로 구성
1. Application : 공통 어플리케이션을 정의
2. IFCommand : 메뉴 기능 실행을 위한 인터페이스
3. IFCrudDao, IFPagination : 앱에 공통으로 적용가능 한 CRUD와 Pagination을 구성한 인터페이스
4. MenuBar : 메뉴를 적용시킬 메뉴 바
5. MenuItem : 각 메뉴의 구성 요소를 정의한 DTO
6. Input : 각종 입력을 처리하는 클래스

### TourGuide
전략패턴을 이용하여 메뉴를 구성하고 실제 어플리케이션을 실행
1. TourExample : stringtokenizer로 텍스트를 분석하고, 이를 데이터베이스 저장
2. TourApp : 실제 어플리케이션 실행 파일, 운영에 필요한 메뉴를 구성한다. 
3. Command패키지 : 출력 / 검색 / 파일에 저장 / 종료 기능을 실제 구현한 패키지
4. CommandList패키지 : 위의 출력에서 메뉴를 재 구성하여 출력 기능을 세분화 함
5. Dao패키지 : 메뉴 기능과 데이터베이스를 연동한 인터페이스 및 추상메서드를 구현
6. ConnectionProvider : sqlSession을 싱글톤으로 구성
7. Tour : 여행지 관리를 위한 DTO

## Class Diagram
... 진행 중 ...
