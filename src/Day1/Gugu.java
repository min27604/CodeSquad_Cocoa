package Day1;

import java.util.Scanner;

public class Gugu {
    public static void main(String[] args) {

        // Taking two inputs
        System.out.println("시작단과 끝단을 입력해주세요. ");
        Scanner input = new Scanner(System.in);
        int start = input.nextInt();
        int end = input.nextInt();

        // Gugudan using for loop
        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }
}