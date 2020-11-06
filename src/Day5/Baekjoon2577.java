package Day5;

import java.util.Scanner;

public class Baekjoon2577 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 1;

        for (int i = 0; i < 3; i++) {
            sum *= input.nextInt();
        }

        input.close();

        String number = Integer.toString(sum);
        int[] counter = new int[10];


        for (int i = 0; i < number.length(); i++) {
            counter[Character.getNumericValue(number.charAt(i))]++;
        }

        for (int j : counter) {
            System.out.println(j);
        }

    }
}