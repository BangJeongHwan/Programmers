package D_20211202;

import java.util.Arrays;

public class S_42862 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
//        int[] reserve = {3};
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        //        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        int total = n - lost.length;

        // true 는 이미 할당했을 경우
        boolean check[] = new boolean[n+1];
        // 이런 경우는 사전에 제외 시칸다.
        // 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
        // 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며,
        // 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
        for(int i=0;i<reserve.length;i++){
            for(int j=0;j<lost.length;j++){
                if(reserve[i]==lost[j]){
                    total++;
                    check[reserve[i]] = true;
                }
            }
        }

        for(int j=0;j<lost.length;j++){
            // 위에서 이미 찾은 경우를 제외하기 위해서
            if(!check[lost[j]]){
                for(int i=0;i<reserve.length;i++){
                    // true 인 것은 굳이 체크할 필요 없다
                    if(!check[reserve[i]]){
                        // lost가 기준이기 때문에 lost 에 -, + 처리를 한다.
                        if(reserve[i]==lost[j]-1){
                            total++;
                            check[reserve[i]]=true;
                            break;
                        }else if(reserve[i]==lost[j]+1){
                            total++;
                            check[reserve[i]]=true;
                            break;
                        }else if(reserve[i]>lost[j]+1){ // 오름차순으로 두었기 때문에 lost[j]+1 보단 큰 것은 제낀다.
                            break;
                        }
                    }
                }
            }
        }

        return total;
    }
}
