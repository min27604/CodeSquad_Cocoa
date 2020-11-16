### Agenda

- [ ]  한글시계 구현

---

### What I Learned

- ANSI Escape Code: standard to control cursor location, color, font styling etc on terminal

    한글시계를 구현하는 데 필요한 콘솔에서 출력문에 색 입히기

    - Define constant(String type, color code) then add it when print. Also can be used as sout("color-code" + "other things to print")
- LocalTime presents only time, no date
    - `LocalTime time = LocalTime.now();`
    - 위의 상태로 바로 프린트 가능, DateTimeFormatter로 포맷 정하고 프린트 해도 가능.
    - 앞에 String.valueOf() 붙여도 가능.
- Thread : 여러가지 작업을 동시에 수행할 수 있게 하는 것
    - Thread를 직접 상속받아서 생성하는 방법
    - Runnable 인터페이스를 이용하는 방법

---

### Links

- ANSI escape code

    [https://en.wikipedia.org/wiki/ANSI_escape_code](https://en.wikipedia.org/wiki/ANSI_escape_code)