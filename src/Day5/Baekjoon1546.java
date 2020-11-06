package Day5;

import java.util.Scanner;

public class Baekjoon1546 {

//    자기 점수 중에 최댓값을 골랐다
//    이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfScores = input.nextInt();
        double[] scores = new double[numberOfScores];

        // put scores in scores array
        for (int i = 0; i < numberOfScores; i++) {
            scores[i] = input.nextInt();
        }

        // get the max value
        double maxScore = 0;
        for (int i = 0; i < numberOfScores; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }

        // make the rest scores score/max*100 and add to average for future use
        double average = 0;
        for (int i = 0; i < numberOfScores; i++) {
            scores[i] = scores[i] / maxScore * 100;
            average += scores[i];
        }

        // calculate the average
        average /= numberOfScores;

        System.out.println(average);
    }
}
