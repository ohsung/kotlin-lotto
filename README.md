# kotlin-lotto

## 🚀 4단계 - 로또(수동)

### 기능 요구 사항

- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

### 프로그래밍 요구 사항

- 모든 원시값과 문자열을 포장한다.
- 예외 처리를 통해 에러가 발생하지 않도록 한다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- Enum 클래스를 적용해 프로그래밍을 구현한다.
- 일급 컬렉션을 쓴다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다. <br> 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 힌트

- 모든 원시값과 문자열을 포장한다.
    - 로또 숫자 하나는 Int다. 이 숫자 하나를 추상화한 LottoNumber를 추가해 구현한다.
- 예외 처리를 통해 에러가 발생하지 않도록 한다.
- 참고로 코틀린에서는 아래와 같이 예외 처리를 한다. 장기적으로는 아래와 같이 예외 처리하는 걸 연습해 본다.
    - 논리적인 오류일 때만 예외를 던진다.
    - 논리적인 오류가 아니면 예외를 던지지 말고 null을 반환한다.
    - 실패하는 경우가 복잡해서 null로 처리할 수 없으면 sealed class를 반환한다.
    - 일반적인 코틀린 코드에서 try-catch를 사용하지 않는다.

### 기능 목록

- [x] 로또 구입
    - [x] 구입 금액 만큼 구입 가능한 로또 개수를 계산한다.
    - [x] 구입 금액이 1000원 미만인 경우, 구입 금액 입력을 다시 한다.
- [x] 로또
    - [x] 로또 숫자는 6개이다.
    - [x] 로또 숫자들은 랜덤하게 생성된다.
    - [x] 로또 숫자들은 오름차순으로 정렬된다.
- [x] 당첨
    - [x] 당첨된 숫자 개수를 확인한다.
    - [x] 맞춘 번호 개수 만큼 당첨 금액이 계산된다.
    - [x] 구매 금액과 당첨금을 비교해서 수익률을 계산한다.
- [x] 당첨 번호 입력
    - [x] 입력 문장으로 당첨 번호를 분리한다.
    - [x] 보너스 숫자를 추가로 입력 받는다.
- [x] 당첨 통계
    - [x] 맞춘 개수 만큼 당첨 통계를 출력한다.
    - [x] 맟춘 개수 5개 + 보너스 숫자 일치 된 경우(2등) 당첨 통계를 출력한다.
