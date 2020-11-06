package Day5;

//    "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
//            문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
//            "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
//
//            OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

import java.util.Scanner;

public class Backjoon8958 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = Integer.parseInt(input.nextLine());
        String[] quizResult = new String[testCases];

        for (int i = 0; i < quizResult.length; i++) {
            quizResult[i] = input.nextLine();
        }

        input.close();

        for (int i = 0; i < testCases; i++) {
            int score = 0;
            int counter = 0;
            for (int j = 0; j < quizResult[i].length(); j++) {
                if (quizResult[i].charAt(j) == 'O') {
                    counter++;
                } else if (quizResult[i].charAt(j) == 'X') {
                    counter = 0;
                }
                score += counter;
            }
            System.out.println(score);
        }
    }
}