package Day5;

import java.util.Scanner;

public class Backjoon1018 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sentence = input.nextLine().trim();
        input.close();

        if (sentence.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(sentence.split(" ").length);
        }
    }
}