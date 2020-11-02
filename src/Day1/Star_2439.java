package Day1;

import java.util.Scanner;

public class Star_2439 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        for (int i = 0; i < n; i++){
            for (int j = n-1; j > i; j--){
                System.out.print(" ");
            }
            for (int k = 1; k <= i + 1; k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}