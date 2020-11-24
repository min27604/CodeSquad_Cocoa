### Agenda

- [x]  AWT, Swing을 이용해 뭐라도 만들어보기

---

### What I Learned

- AWT = Abstract Window Toolkit
    - 컴포넌트 > 독립적컨테이너 > 종속적컨테이너 > 나머지 컴포넌트
    - 독립적 컴포넌트(Frame etc): 혼자 사용 가능, 다른 컨테이너 포함 가능
    - 종속적 컴포넌트(Panel etc): 혼자 사용 불가
- Overloading v. Overriding
    - Focus on the meaning of the word(load, ride)
    - Overloading: Same method name with different parameter(class, # of para)
    - Overriding: When extends, same method name, type/# of parameter but different (or does something more)
- Callback Method: generally OS or JVM calls callback method, async method call, 불러와주기만 하고 사라짐

---

### Comment

어젠 아파서 조퇴 아닌 조퇴를 하고 못 한 학습을 오늘 하려니 좀 버거웠지만 유투브에 있는 프로젝트 튜토리얼을 따라하면서 어느정도 감을 잡았다. 루카스에 올려주신 pdf파일로 공부하며 노트필기를 하려니 왠지 끝도 없을 것만 같기도 하고(it covered most of the component and its constructor and methods) 내 경험에 따르면 개념공부를 한다고 코드가 잘 짜지는 것도 아니라(오히려 겉돌게 된다) 처음 파이썬을 배우던 것 처럼 무작정 튜토리얼을 따라해보기로 했다. 간단한 시계와 타이머를 따라 짜보고 후엔 어떤 요소들이 필요한 지, 또 어떤 순서대로 짜야하는 지를 중심으로 코드를 짰다.
매번 부족함을 느낀다. 열심히 하자. 그리고 체력관리 잘 하자(..)