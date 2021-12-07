package D_20211207;

import java.time.LocalDate;

public class S_12901_1 {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
    }
    public static String solution(int a, int b) {
        return LocalDate.of(2016,a,b).getDayOfWeek().toString().substring(0,3);
    }
}
