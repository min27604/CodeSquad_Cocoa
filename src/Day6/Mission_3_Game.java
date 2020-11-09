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

import java.util.Random;
import java.util.Scanner;

class Player {
    String name = "";
    int money = 100;
    String choiceInLetter;
    int choice = 0;
    int betMoney;

    Scanner input = new Scanner(System.in);

    public int getMoney() {
        return money;
    }

    public Player() {
        System.out.println("Welcome to Odd or Even Game.");
        System.out.println("Please type in your name.");
        this.name = input.nextLine();
    }

    public void changeMoney(int money) {
        this.money += money;
    }
}

class Enemy {
    Random rand = new Random();
    int money = 120;
    int numberPicked;

    public int pickANumber() {
        return (rand.nextInt(20));
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
    String inp;
    int stage = 0;

    public void startRound(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        while (true) {
            System.out.println(player.name + "'s Money: " + player.getMoney());
            System.out.println("Enemy's Money: " + enemy.getMoney());

            enemy.numberPicked = enemy.pickANumber();
            System.out.println(enemy.numberPicked);
            setBetting();
            System.out.println("Odd or Even? (O for Odd, E for Even) ");
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

    public void getChoice() {
//        System.out.println("Odd or Even? (O for Odd, E for Even) ");
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
        player.betMoney = Integer.parseInt(input.nextLine());
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

public class Mission_3_Game {
    public static void main(String[] args) {
        Player player = new Player();
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
            if (round.stage == 8) {
                System.out.println("You've defeated all the enemies! Your total: " + player.getMoney());
                System.out.println("Congrats!");
                break;
            }
        }
        System.out.println("\nThanks for playing!");
    }
}
