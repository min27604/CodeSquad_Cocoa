package Day6;

//        플레이어의 이름을 입력받는데, 초기 자본은 100원
//        상대방 플레이어는 120원을 가지고 시작한다.
//        상대방은 Random 을 이용, 1- 20까지 임의의 수를 뽑는다. 단 화면에 해당 숫자가 출력되지는 않는다.
//        플레이어는 홀 또는 짝을 입력하고 배팅을 한다. 배팅 최대 금액은 min(내 소지금, 상대방 소지금) 으로 결정한다.
//        맞았을 경우 배팅 금액만큼 상대방에게 얻고, 반대의 경우 상대방에게 빼앗긴다.
//        플레이어의 소지금이 0원이 되면 게임 종료
//        상대방의 소지금이 0원이 되면 다음 상대가 등장. 다음 상대는 내 소지금 * pow(1.2, numStage) 의 소지금을 가지고 등장한다.
//        라이벌은 총 8명이 등장한다.
//        게임 오버시 소지금과 진행 턴을 표시해 준다.
//        (옵션) 게임 오버시 이름을 입력받고 랭킹을 출력해 준다. 랭킹은 소지금이 많을 수록, 턴이 작을수록 높아진다.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class Player {
    String name = "";
    int money = 100;
    String choiceInLetter;
    int choice = 0;
    int betMoney;

    Scanner input = new Scanner(System.in);

    public void getName() {
        System.out.println("Welcome to Odd or Even Game.");
        System.out.println("Please type in your name.");
        String getLine = input.nextLine();
        if (getLine.length() > 10) {
            System.out.println("Keep it short!\n");
            getName();
        } else {
            this.name = getLine;
        }
    }

    public void changeMoney(int money) {
        this.money += money;
    }

    public int getMoney() {
        return money;
    }
}

class Enemy {
    Random rand = new Random();
    int money = 120;
    int numberPicked;

    public int pickANumber() {
        return (rand.nextInt(21) + 1);
    }

    public int getMoney() {
        return money;
    }

    public void changeMoney(int money) {
        this.money += money;
    }
}

class Round {
    Scanner input = new Scanner(System.in);
    Player player;
    Enemy enemy;
    int turn = 0;
    int stage = 0;

    public void setTurn() {
        turn++;
    }

    public void startRound(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        while (true) {
            setTurn();
            System.out.println("Turn #" + this.turn);
            System.out.println(player.name + "'s Money: " + player.getMoney());
            System.out.println("Enemy's Money: " + enemy.getMoney());

            enemy.numberPicked = enemy.pickANumber();
            System.out.println(enemy.numberPicked);
            setBetting();
            getChoice();
            compareAndResult();

            if (enemy.getMoney() <= 0) {
                System.out.println("You've defeated the enemy.");
                System.out.println("Starting another round \n ... ");
                break;
            }
            if (player.getMoney() <= 0) {
                System.out.println("You've lost all of your money.");
                System.out.println("Game Over");
                break;
            }
        }
    }

    public int getTurn() {
        return turn;
    }

    public void getChoice() {
        System.out.println("Odd or Even? (O for Odd, E for Even) ");
        player.choiceInLetter = input.nextLine();
        if (player.choiceInLetter.equalsIgnoreCase("o")) {
            player.choice = 1;
        } else if (player.choiceInLetter.equalsIgnoreCase("e")) {
            player.choice = 0;
        } else {
            System.out.println("Please type in a valid input.");
            getChoice();
        }
    }

    public void setBetting() {
        System.out.println("How much would you like to bet? ");
        String temp = input.nextLine();
        // player.betMoney = Integer.parseInt(input.nextLine());
        try {
            player.betMoney = Integer.parseInt(temp);
        } catch (Exception e) {
            System.out.println("Please enter a valid amount.");
            setBetting();
        }

        if (player.betMoney > Math.min(player.money, enemy.money)) {
            System.out.println("Too much. Should be less than: " + Math.min(player.money, enemy.money));
            setBetting();
        }
    }

    public void compareAndResult() {
        if (enemy.numberPicked % 2 == player.choice) {
            player.changeMoney(player.betMoney);
            enemy.changeMoney(-player.betMoney);
            System.out.println("You Won! You've got " + player.betMoney);
            return;
        }
        if (enemy.numberPicked % 2 != player.choice) {
            player.changeMoney(-player.betMoney);
            enemy.changeMoney(player.betMoney);
            System.out.println("You Lost! You've lost " + player.betMoney);
            return;
        }
    }

    public void newRound() {
        enemy.money = (int) (player.money * Math.pow(1.2, stage));
        enemy.numberPicked = enemy.pickANumber();
    }
}

class Rank implements Comparable<Rank> {
    String formatInfo = "%4s %9s %11s";
    Player player;
    Round round;
    String turn, money, name;

    public Rank(Player player, Round round) {
        this.turn = Integer.toString(round.turn);
        this.money = Integer.toString(player.money);
        this.name = player.name;
    }

    public Rank(String[] str) {
        this.turn = str[0];
        this.money = str[1];
        this.name = str[2];
    }

    public boolean wannaSave() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nWould you like to save your record? (y/n)");

        if (input.nextLine().equalsIgnoreCase("y")) {
            return true;
        }
        if (input.nextLine().equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Please enter valid answer.");
            wannaSave();
        }
        input.close();
        return false;
    }

    public String toString() {
        return (this.turn + " " + this.money + " " + this.name);
    }

    public void writeRank() throws IOException {
        FileWriter fw = new FileWriter("rank.txt", true);
        fw.write(this.toString() + "\n");
        fw.close();
    }

    public void firstFiveRank() throws FileNotFoundException {
        System.out.println(" ...\n########## Rank ##########");
        System.out.printf((formatInfo) + "%n", "turn", "money", "name");
        File file = new File("rank.txt");
        Scanner scan = new Scanner(file);

        for (int i = 0; i < 5; i++) {
            System.out.println(scan.nextLine());

        }
    }

    public int compareTo(Rank rank) {
        int thisTurn = Integer.parseInt(this.turn);
        int rankTurn = Integer.parseInt(rank.turn);
        return thisTurn - rankTurn;
    }

    public void arrangeRank() throws IOException {
        File file = new File("rank.txt");
        Scanner scan = new Scanner(file);

        ArrayList<Rank> arrange = new ArrayList<>();

        while (scan.hasNextLine()) {
            String temp;
            temp = scan.nextLine();
            Rank rank = new Rank(temp.split(" "));
            arrange.add(rank);
        }

        Collections.sort(arrange);

        FileWriter fw = new FileWriter("rank.txt");

        for (Rank rank : arrange) {
            fw.write(rank.toString() + "\n");
        }
        fw.close();
    }
}

public class Mission_3_Game {
    public static void main(String[] args) throws IOException {
        Player player = new Player();
        player.getName();
        Enemy enemy = new Enemy();
        Round round = new Round();


        while (true) {
            System.out.println("Round #" + (round.stage + 1));
            round.startRound(player, enemy);
            if (enemy.getMoney() <= 0) {
                round.stage += 1;
                round.newRound();
            }
            if (player.getMoney() <= 0) break;
            if (round.stage == 1) {
                System.out.println("You've defeated all the enemies! Your total: " + player.getMoney() + " Total turn: " + round.getTurn());
                System.out.println("Congrats!");
                Rank rank = new Rank(player, round);
                if (rank.wannaSave()) {
                    rank.writeRank();
                }
                rank.arrangeRank();
                rank.firstFiveRank();
                break;
            }
        }
        System.out.println("\nThanks for playing!");
    }
}
