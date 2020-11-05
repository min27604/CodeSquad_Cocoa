package Day3.RPG;
//        11 * 11 배열 초기화
//        화면 중앙에는 캐릭터 위치
//        임의의 장소에 몬스터 위치
//        임의의 장소에 1개의 지뢰를 배치한다. 단 지뢰는 플레이어가 밟기 전까지 화면에 표시하지 않는다.
//        콘솔 입력으로 WASD 중 하나의 키를 입력받고 엔터를 누르면 캐릭터가 상좌하우로 이동함
//        캐릭터가 지뢰를 밟으면 사망
//        캐릭터가 몬스터의 위치까지 이동하면 몬스터가 사라지고 정해진 점수 획득
//        점수 획득시 새로운 몬스터와 지뢰를 배치한다. 단 지뢰의 갯수는 2배 증가시킨다.
//        매 턴마다 현재 배열의 상태를 화면에 출력. 단 밟지 않은 지뢰는 표시하지 않는다.
//        똑같이 구현하지 않아도 되니 재미있는 게임을 만들어 보자.

import java.util.Random;
import java.util.Scanner;

class Player {

    public static int x;
    public static int y;
    public static int pointsTaken = 0;

    public static void init() {
        int origin = 5;
        x = origin;
        y = origin;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class Monster {

    public static int x;
    public static int y;
    public static int points;

    public static void monsterInit() {
        Random rand = new Random();
        points = rand.nextInt(50);
        x = rand.nextInt(Map.edge);
        y = rand.nextInt(Map.edge);
        if ((x == Player.x && y == Player.y) || (x == Bomb.x && y == Bomb.y)) {
            monsterInit();
        }
    }
}

class Bomb {

    public static int x;
    public static int y;

    public static void bombInit() {
        Random rand = new Random();
        x = rand.nextInt(Map.edge);
        y = rand.nextInt(Map.edge);
        if ((x == Player.x && y == Player.y) || (x == Monster.x && y == Monster.y)) {
            bombInit();
        }
    }
}

class Map {

    public static int edge = 10;
    
    public static void printMap() {
        for (int i = 0; i < edge + 1; i++) {
            for(int j = 0; j < edge + 1; j++) {
                if (j == Player.x && i == Player.y) {
                    System.out.print("♖ ");
                } else if (j == Monster.x && i == Monster.y) {
                    System.out.print("♟ ");
                } else {
                    System.out.print("☐ "); }
            }
            System.out.println();
        }
    }
}
public class Launch {

    private static boolean monsterMeet = false;

    public static char takeDirection() {
        Scanner input = new Scanner(System.in);
        System.out.println("Where would you like to go? (w, s, a, d to move, q to quit)");
        return input.next().charAt(0);
    }

    public static void movePlayer(char direction) {
        switch (direction) {
            case 'w' :
                if (Player.y == 0) {
                    System.out.println("You cannot move further.");
                } else {Player.y--;}
                break;
            case 's':
                if (Player.y == Map.edge) {
                    System.out.println("You cannot move further.");
                } else {Player.y++;}
                break;
            case 'a':
                if (Player.x == 0) {
                    System.out.println("You cannot move further.");
                } else {Player.x--;}
                break;
            case 'd':
                if (Player.x == Map.edge) {
                    System.out.println("You cannot move further.");
                } else {Player.x++;}
                break;
        }
    }

    public static void initialize() {
        Player.init();
        Monster.monsterInit();
        Bomb.bombInit();
    }

    public static void checkIfMonster() {
        Scanner input = new Scanner(System.in);
        if (Player.x == Monster.x && Player.y == Monster.y) {
            Player.pointsTaken += Monster.points;
            System.out.println("Congrats! You've defeated the monster. You've got " + Monster.points +".");
            System.out.println("Your point is now: " + Player.pointsTaken);
            monsterMeet = true;
        }
    }

    public static void playGame() {
        Launch.initialize();
        Map.printMap();
        boolean running = true;
        while (running) {
            char direction = takeDirection();

            if (direction == 'q') {
                System.out.println("Quit");
                running = false;
            } else if (direction == 'w' || direction == 's' || direction == 'a' || direction =='d') {
                movePlayer(direction);
            } else {
                System.out.println("You put the wrong command. Try Again.");
            }

            checkIfMonster();
            if (monsterMeet) {
                monsterMeet = false;
                playGame();
            }

            Map.printMap();
        }

        if (!running) {
            System.out.println("Game Over");
        }
    }

    public static void main(String[] args) {

        playGame();
    }
}
