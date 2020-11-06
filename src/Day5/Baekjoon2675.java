package Day5;

import java.util.Scanner;

public class Baekjoon2675 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int i = 0; i < testCases; i++) {
            int repeatNumber = input.nextInt();
            String stringToRepeat = input.next();
            String newString = "";

            for (int j = 0; j < stringToRepeat.length(); j++) {
                for (int k = 0; k < repeatNumber; k++) {
                    newString += stringToRepeat.charAt(j);
                }
            }
            System.out.println(newString);
        }
    }
}