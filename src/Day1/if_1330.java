package Day1;

import java.util.Scanner;

public class if_1330 {
    public static void main(String[] args) {

        // Taking inputs
        Scanner input = new Scanner(System.in);
        
        int i = input.nextInt();
        int j = input.nextInt();

        // Compare them and print right signs
        if (i > j){
            System.out.println(">");
        }
        if (i == j) {
            System.out.println("=");
        }
        if (i < j) {
            System.out.println(("<"));
        }
    }
}
