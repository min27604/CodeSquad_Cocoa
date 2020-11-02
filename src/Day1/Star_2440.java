package Day1;

import java.util.Scanner;

public class Star_2440 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        for (int i = 0; i < n; i++){
            for (int j = n; j > i; j--){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
