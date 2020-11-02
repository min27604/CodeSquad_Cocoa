package Day1;

import java.util.Scanner;

public class if_14681_Quadrant {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();

        // Quad
        if (x > 0 && y > 0) {
            System.out.println("1");
        } if (x < 0 && y > 0) {
            System.out.println("2");
        } if (x < 0 && y < 0) {
            System.out.println("3");
        } if (x > 0 && y < 0) {
            System.out.println("4");
        }
    }
}
