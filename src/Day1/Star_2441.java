package Day1;


import java.util.Scanner;
public class Star_2441 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for (int k = n; k > i; k--){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
