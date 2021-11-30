package D_20211130;

// 남들 풀이

public class S_12977_2 {
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        System.out.println(solution(nums));
    }

    public static  int solution(int[] nums) {
        int answer = 0;
        int sum =0;
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    // 위치가 같지 않다
                    if(i!=j&&i!=k&&j!=k) {
                        sum= nums[i]+nums[j]+nums[k];
                        // 소수 구하는 로직
                        for(int l=2; l<sum; l++) {
                            if(sum%l==0) {
                                break;
                            }
                            if(l==sum-1) {
                                answer++;
                            }
                        }
                        //
                    }
                }
            }
        }

        return answer;

    }
}
