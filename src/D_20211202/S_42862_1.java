package D_20211202;

import java.util.Arrays;

public class S_42862_1 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
//        int[] reserve = {3};
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n+1];
        int answer = n;

        // 읽어버린 숫자를 --
        for (int l : lost)
            people[l]--;
        // 여분이 있는 숫자를 ++
        for (int r : reserve)
            people[r]++;

        for (int i = 1; i < n+1; i++) {
            // -1 에 해당하는 값에 대해서만 비교
            if(people[i] == -1) {
                //
                if(i>=2 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i<n && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
        return answer;
    }
}
