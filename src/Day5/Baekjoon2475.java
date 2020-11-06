package Day5;

import java.util.Scanner;

public class Baekjoon2475 {
    public static void main(String[] args) {
        // take the numbers and put in to int array
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }
        input.close();

        // calculate veri number
        int veriNumber = 0;
        for (int number : numbers) {
            veriNumber += Math.pow(number, 2);
        }
        veriNumber %= 10;
        System.out.println(veriNumber);
    }
}
