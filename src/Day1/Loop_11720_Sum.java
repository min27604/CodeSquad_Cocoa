package Day1;

import java.util.Scanner;

public class Loop_11720_Sum {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        // Take the first input, the number of numbers that'll add all together
        int n = input.nextInt();

        // Take the second input(numbers to add) as String
        String numbers = input.next();
        input.close();

        int result = 0;

        for (int i = 0; i < n; i++) {
            result += numbers.charAt(i) - '0';
        }
        System.out.println(result);
    }
}
