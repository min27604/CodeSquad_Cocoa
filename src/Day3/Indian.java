package Day3;

import java.util.Scanner;

public class Indian {

    public static int[] getBirthday() {
        System.out.println("생년월일을 입력해 주세요. ");
        Scanner input = new Scanner(System.in);
        int[] birthday = {input.nextInt(), input.nextInt(), input.nextInt()};
        input.close();
        return birthday;
    }

    public static int[] shortenBirthday() {
        int[] shortBirthday = getBirthday();

        int shortYear = shortBirthday[0] % 10;
        int shortMonth = shortBirthday[1] - 1;
        int shortDate = shortBirthday[2] - 1;

        return new int[]{shortYear, shortMonth, shortDate};
    }

    public static String[] getYourIndianName() {
        String[] YearNameCandidate = new String[]{"시끄러운", "푸른", "붉은", "조용한", "웅크린", "하얀", "지혜로운", "용감한", "날카로운", "욕심 많은"};
        String[] MonthNameCandidate = new String[]{"늑대", "태양", "양", "매", "황소", "불꽃", "나무", "달빛", "말", "돼지", "하늘", "바람"};
        String[] DateNameCandidate = new String[]{"와/과 함께 춤을", "의 기상", "은/는 그림자 속에", "", "", "", "의 환생", "의 죽음", "아래에서",
                "를/을 보라", "이/가 노래하다", "의 그림자", "의 일격", "에게 쫓기는 남자/여자", "의 행진", "의 왕", "의 유령", "을/를 죽인 자",
                "는/은 맨날 잠잔다", "처럼", "의 고향", "의 전사", "은/는 나의 친구", "의 노래", "의 정령", "의 파수꾼", "의 악마",
                "와/과 같은 사나이/아가씨", "를/을 쓰러트린 자", "의 혼", "는/은 말이 없다"};

        int[] numbers = shortenBirthday();

        String yearname = YearNameCandidate[numbers[0]];
        String monthname = MonthNameCandidate[numbers[1]];
        String datename = DateNameCandidate[numbers[2]];

        return new String[]{yearname, monthname, datename};
    }

    public static void print(String[] nameToPrint) {
        System.out.println("당신의 이름은 " + nameToPrint[0] + " " + nameToPrint[1] + nameToPrint[2] + "입니다.");
    }
}