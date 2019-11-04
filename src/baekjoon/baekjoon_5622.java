package baekjoon;

import java.util.*;

public class baekjoon_5622 {
    public static void main(String[] args) {
        DialPhone dialPhone = new DialPhone();

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.next().split("");

        int totalTime = 0;
        for (String alphabet : input) {
            totalTime = dialPhone.sumTime(alphabet, totalTime);
        }
        System.out.println(totalTime);
    }
}

class DialPhone {
    private List<DialSection> phone;

    public DialPhone() {
        phone = new ArrayList<>();
        phone.add(new DialSection(1));
        phone.add(new DialSection(2, new String[]{ "A", "B", "C" }));
        phone.add(new DialSection(3, new String[]{ "D", "E", "F" }));
        phone.add(new DialSection(4, new String[]{ "G", "H", "I" }));
        phone.add(new DialSection(5, new String[]{ "J", "K", "L" }));
        phone.add(new DialSection(6, new String[]{ "M", "N", "O" }));
        phone.add(new DialSection(7, new String[]{ "P", "Q", "R", "S" }));
        phone.add(new DialSection(8, new String[]{ "T", "U", "V" }));
        phone.add(new DialSection(9, new String[]{ "W", "X", "Y", "Z" }));
        phone.add(new DialSection(0));
    }

    public int sumTime(String alphabet, int currentTime) {
        Optional<DialSection> filtered = phone.stream().filter(dial -> Arrays.asList(dial.text).contains(alphabet)).findFirst();
        return filtered.isPresent() ? filtered.get().sumTime(currentTime) : currentTime;
    }
}

class DialSection {
    int number;
    String[] text;
    int time;

    public DialSection(int number) {
        this.number = number;
        this.text = new String[0];
        this.time = this.number + 1;
    }

    public DialSection(int number, String[] text) {
        this.number = number;
        this.text = text;
        this.time = this.number + 1;
    }

    public int sumTime(int currentTime) {
        return this.time + currentTime;
    }
}