package Day3;

import java.util.Scanner;

public class RPG {

    static int edge = 10;
    static int origin = edge / 2;
    private static int x = origin;
    private static int y = origin;

    public static void move(char direction){
        switch (direction){
            case 'w':
                if (y == 0) {
                    System.out.println("더 이상 이동할 수 없습니다.");
                } else {
                    y--;
                }
                break;
            case 's':
                if (y == edge) {
                    System.out.println("더 이상 이동할 수 없습니다.");
                } else {
                    y++;
                }
                break;
            case 'a':
                if (x == 0) {
                    System.out.println("더 이상 이동할 수 없습니다.");
                } else {x--;}
                break;
            case 'd':
                if (y == edge) {
                    System.out.println("더 이상 이동할 수 없습니다.");
                } else {
                    x++;
                }
                break;
        }
    }

    public static void printMap() {
        for (int i = 0; i <= edge; i++) {
            for (int j = 0; j <= edge; j++) {
                if (j == x && i == y) {
                    System.out.print("C ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public static char takeDirection() {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    public static void main(String[] args) {

        boolean running = true;
        // running main function
        while (running){
            RPG.printMap();
            System.out.println("이동할 방향을 정해주세요. (w, s, a, d) (q to quit)\n----------------------");
            char direction = takeDirection();
            if (direction == 'q') {
                System.out.println("게임이 종료되었습니다.");
                running = false;
            } else {RPG.move(direction);}
        }
    }
}
