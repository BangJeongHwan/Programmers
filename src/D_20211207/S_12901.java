package D_20211207;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class S_12901 {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
    }
    public static String solution(int a, int b) {
        String answer = "";
        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        switch(dayOfWeek.getValue()){
            case 1:
                answer = "MON";
                break;
            case 2:
                answer = "TUE";
                break;
            case 3:
                answer = "WED";
                break;
            case 4:
                answer = "THU";
                break;
            case 5:
                answer = "FRI";
                break;
            case 6:
                answer = "SAT";
                break;
            case 7:
                answer = "SUN";
                break;
        }

        return answer;
    }
}
