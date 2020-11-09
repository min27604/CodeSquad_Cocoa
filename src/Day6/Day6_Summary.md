### **Agenda**

- [x]  Mission 3 홀짝게임
- [ ]  Mission 3 가계부 만들기

---

### **What I Learned**

**Self taught / Online Lecture**

- 홀짝게임 - 클래스를 플레이어, 에네미, 라운드, 메인으로 나누고 그 안에서 변수와 메소드 설정을 해줬음. 초반에 시작할 때 종이에 어떻게 나눌 지 써가면 했는데 I think it's a great way to start.

    Had trouble running one method under round class: occasionally nothing happened when input is typed. Asked Dion and he told me not to mix next(), nextLine() and nextInt() and find [the difference between them](https://www.geeksforgeeks.org/why-is-scanner-skipping-nextline-after-use-of-other-next-functions/). 

    - When next() or nextInt() is used, the cursor remains at the same line of the input. Therefor after using next() or nextInt(), nextLine() automatically reads the remaining stuff of the first input(which is nothing, "";).
    - To solve this problem you either need to use nextLine() only and use parseInt

        Or put another nextLine() before using them. ⇒ so that the cursor moves, read the leftover

    Debugged for the first time. It lets you know the status of variable(like what they have as value).

---

### **Comment**

처음에 미션 읽고 어떻게 해야하나 막막했는데 전에 [repl.it](http://repl.it)에 있던 text based game 프로젝트를 하나 참고하려고 링크를 챙겨뒀었는데 그게 도움이 많이 됐다. 여러 클래스를 나누고 그 안에 어떤 변수와 어떤 메소드를 넣어야 하는지 참고를 많이 했고 게임이 돌아가는 단계도 그 링크를 참고하고 시작했다. 종이에 표를 만들어 클래스별로 넣을 변수와 어떤 기능을 하는 메소드가 필요한지 대충 적으면서 시작했더니 무작정 인텔리제이에서 시작하는 것 보다 윤곽이 잡힌 상태에서 시작할 수 있어 내가 지금 뭘 하고 있는지 덜 헤맸다. 중간에 홀수/짝수 값을 인풋으로 받는 메소드를 실행시키는데 1. 인풋을 넣으면 열에 일곱번은 아무 일도 일어나지 않고 2. if문으로 들어가자마자 else로 빠져서 이리저리 바꿔본다고 1시간정도 낭비를 하다 결국 Dion에게 물어봤는데 next(), nextLine(), nextInt()는 섞어 쓰면 안된다고 했다..

---

### Links

- Why does it cause trouble using nextLine() after next()

    [https://www.geeksforgeeks.org/why-is-scanner-skipping-nextline-after-use-of-other-next-functions/](https://www.geeksforgeeks.org/why-is-scanner-skipping-nextline-after-use-of-other-next-functions/)