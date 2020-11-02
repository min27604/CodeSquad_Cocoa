package Day1;

import java.util.Scanner;

public class Star_2442 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        for (int line = 1; line <= n; line++){
            for (int space = n - 1; space >= line; space--){
                System.out.print(" ");
            }
            for (int star = 1; star <= 2 * line - 1; star++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
