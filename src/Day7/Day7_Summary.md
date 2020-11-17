### Agenda

- [x]  홀짝게임 랭킹기능 구현 및 미션 4
- [ ]  재귀관련 알고리즘 문제 풀이

---

### What I Learned

- The basic usage of file and filewriter
    - Create an instance of file to bring a file(I used it to read a text file)
    - To print out lines of the file, I used Scanner, but many other uses 'Buffer'
    - `while(hasnextLine())` 이용해서 줄 끝까지 읽을 수 있음
- String formatting
    - `String.format(format, object1, object 2, ... args)`
    - format의 수가 들어오는 args의 수가 맞아야 한다. 안 맞으면 포맷적용은 물론 뒤에 짤려서 값 반환이 안됨
- 랭크 리어레인지
    - ArrayList를 만들고 store ranks line by line using file and scan instances.
    - Used Collections.sort() to sort the elements in ascending order.
    - Then FileWriter instance.write() to rewrite the file. (false to append)

---

### Comment

설계는 어제 했는데 진짜 엄두가 전혀 안 나서 참고할 소스만 구글링 해놓고 멀뚱멀뚱 바라보기만 하다 천천히 하자 싶어 우선 현재 기록을 써주는 메소드부터 짜보았다. 역시 천천히 하나씩 하니까 되더라. 바로 랭크 순서바꾸는 것도 하고싶었지만 랭크를 보여주는데 있어 포매팅이 제대로 안 된 게 계속 걸려 하나씩 찬찬히 고쳤다. 그러다 한 5시쯤 오늘 계획한 랭크기능 구현을 완성했다! 너무 뿌듯하다. 배울 게 너무 많다는 사실이 가끔씩은 부담이 되어서 나를 무기력하게 만들 때가 있다. 현진이한테 말하니 그래도 어느정도 레벨에 올라가면 지금보단 덜 할거라고, 덧붙여 이 분야가 원래 그런 게 아니겠냐 했고 그 말을 들으니 개발자는 평생 공부하는 직업이라는 말이 떠올랐다. 앞으로도 부담감에 숨이 턱하고 막힐 때가 계속해서 생기겠지만 부담감을 딛고 하나씩 해 나가다보면 커다랗게 보이던 장애물도 어찌저찌 넘기게 될 거라고 믿는다. 내가 오늘 한 게 사실 별 거 아니란 걸 잘 알고 있지만 내가 해냈다는 성취감, 뿌듯함은 부담을 넘게 할 거야. 다들 이 맛에 개발자 하나?