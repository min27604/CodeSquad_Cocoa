package Day5;

// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

import java.util.Scanner;

public class Backjoon1000 {

    static void addTwoNumbersAndPrint(int a, int b) {
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        input.close();

        addTwoNumbersAndPrint(a, b);
    }
}
