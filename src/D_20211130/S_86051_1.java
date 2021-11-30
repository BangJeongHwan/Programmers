package D_20211130;

import java.util.Arrays;

public class S_86051_1 {
    public static void main(String[] args) {
        int[] numbers = {5,8,4,0,6,7,9};
        System.out.println(solution(numbers));
    }
    public static int solution(int[] numbers) {
        /**
         * 제약조건에 의해서 가능하다
         * 1 ≤ numbers의 길이 ≤ 9
         * 0 ≤ numbers의 모든 수 ≤ 9
         * numbers의 모든 수는 서로 다릅니다.
         */
        return 45-Arrays.stream(numbers).sum();
    }
}
