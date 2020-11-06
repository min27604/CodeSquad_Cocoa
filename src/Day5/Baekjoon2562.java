package Day5;

import java.util.Scanner;

public class Baekjoon2562 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[9];
        int max = 0;

        for (int i = 0; i < 9; i++) {
            numbers[i] = input.nextInt();
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        input.close();

        System.out.println(max);

        for (int i = 0; i < 9; i++) {
            if (numbers[i] == max) {
                System.out.println(i + 1);
            }
        }
    }
}
