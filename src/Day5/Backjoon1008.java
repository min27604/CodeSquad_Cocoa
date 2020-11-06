package Day5;

// 두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.

import java.util.Scanner;

public class Backjoon1008 {

    static void divideNumbersAndPrint(double a, double b) {
        System.out.println(a / b);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        divideNumbersAndPrint(input.nextDouble(), input.nextDouble());
    }
}
