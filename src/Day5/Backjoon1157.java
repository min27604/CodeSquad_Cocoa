package Day5;

import java.util.Scanner;

public class Backjoon1157 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine().toUpperCase();
        input.close();

        int[] counter = new int[26];

        for (int i = 0; i < word.length(); i++) {
            counter[word.charAt(i) - 'A']++;
        }

        int checker = -1;
        char theLetter = '?';

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > checker) {
                theLetter = (char) (i + 'A');
                checker = counter[i];
            } else if (counter[i] == checker) {
                theLetter = '?';
            }
        }

        System.out.println(theLetter);
    }
}