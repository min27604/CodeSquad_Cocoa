package Day1;

import java.util.Scanner;

public class if_9498_Scores {
    public static void main(String[] args) {
        // 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.

        // Taking input
        Scanner input = new Scanner(System.in);
        int score = input.nextInt();

        if (score <= 100 && score >= 90){
            System.out.println("A");
        } else if (score <= 89 && score >= 80){
            System.out.println("B");
        } else if (score <= 79 && score >= 70){
            System.out.println("C");
        } else if (score <= 69 && score >= 60){
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}