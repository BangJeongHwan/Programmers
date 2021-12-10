package D_20211210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_42586_1 {
    public static void main(String[] args) {
//        int[] progresses={93, 30, 55};
//        int[] speeds={1, 30, 5};
//        int[] result = solution(progresses,speeds); // 2, 1

        int[] progresses={95, 90, 99, 99, 80, 99};
        int[] speeds={1, 1, 1, 1, 1, 1};
        int[] result = solution(progresses,speeds); // 1, 3, 2

        for(int rs : result){
            System.out.print(rs+", ");
        }
        System.out.println();
    }
    private static final int MAXIMUM_PROGRESS_CNT = 100;
    private static final int MAXIMUM_PROGRESS_PERCENT = 100;

    public static int[] solution(int[] progresses, int[] speeds) {

        int dayOfCnt[] = new int[MAXIMUM_PROGRESS_CNT];
        int day = -1;
        for(int i=0;i<progresses.length;i++){
            while(progresses[i]+(day*speeds[i])<MAXIMUM_PROGRESS_PERCENT){
                day++;
            }
            dayOfCnt[day]++;
        }
        return Arrays.stream(dayOfCnt).filter(i -> i!=0).toArray();
    }
}
