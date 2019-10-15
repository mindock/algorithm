package baekjoon;

import java.util.Scanner;

public class baekjoon_1057 {
    private static int getBattleRound(int participants, int jimin, int hansu) {
        int round;
        int lastRound = participants % 2 == 0 ? participants / 2 : participants / 2 + 1;

        for (round = 1; round <= lastRound; round++) {
            if (isBattleRound(jimin, hansu)) {
                break;
            }
            jimin = getNextNumber(jimin);
            hansu = getNextNumber(hansu);
        }

        return round;
    }

    private static int getNextNumber(int num) {
        return num % 2 == 0 ? num / 2 : num / 2 + 1;
    }

    private static boolean isBattleRound(int jimin, int hansu) {
        boolean isJiminEven = jimin % 2 == 0;
        boolean isHansuEven = hansu % 2 == 0;

        if ((isJiminEven && isHansuEven) || (!isJiminEven && !isHansuEven)) {
            return false;
        }

        if (isJiminEven) {
            return jimin - 1 == hansu;
        }
        return hansu - 1 == jimin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int participants = scanner.nextInt();
        int jimin = scanner.nextInt();
        int hansu = scanner.nextInt();

        int round = getBattleRound(participants, jimin, hansu);

        System.out.println(round);
    }
}
