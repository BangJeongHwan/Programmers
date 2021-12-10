package D_20211210;

import java.util.ArrayList;
import java.util.List;

public class S_42586 {
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
    public static int[] solution(int[] progresses, int[] speeds) {

        int totalProgressCnt = progresses.length;

        int nowIdx = 0;                                         // 현 위치 idx
        int completeCnt = 0;                                    // 완료 갯수
        List<Integer> dailyCompletelist = new ArrayList<>();    // 처리 현황 기록

        while(totalProgressCnt>nowIdx){
            // 100 이상이면 완료 갯수와 현재 index 갯수를 늘리고, 다음으로 넘어간다.
            if(progresses[nowIdx]>=100) {
                completeCnt++;
                nowIdx++;
                continue;
            }
            // 완료 갯수가 존재하면 처리 현황에 적재하고, 완료 갯수를 초기화 시킨다.
            if(completeCnt>0) {
                dailyCompletelist.add(completeCnt);
                completeCnt = 0;
            }
            // 현재 인덱스부터 배열의 숫자를 더해주는 작업을한다.
            for(int i=nowIdx;i<totalProgressCnt;i++){
                progresses[i]+=speeds[i];
            }
        }

        // 마지막 인덱스에서 완료 갯수가 존재한다면 언젠간 끝날 것이기 때문에 완료 갯수를 처리 현황에 적재시켜주는 작업을 진행한다.
        if(completeCnt>0) {
            dailyCompletelist.add(completeCnt);
        }

        return dailyCompletelist.stream().mapToInt(Integer::intValue).toArray();
    }
}
