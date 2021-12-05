package D_20211205;

public class S_1845_1 {
    public static void main(String[] args) {
//        int[] nums = {3,1,2,3};
//        int[] nums = {3,3,3,2,2,4};
        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        int maxNum = 0;
        for(int num : nums){
            maxNum = Math.max(maxNum,num);
        }

        boolean cntArray[] = new boolean[maxNum+1];
        for(int i=0;i<nums.length;i++){
            if(!cntArray[nums[i]]) cntArray[nums[i]]=true;
        }

        int halfNum = nums.length/2;
        int total = 0;
        for(int i=0;i<cntArray.length;i++){
            if(total==halfNum) break;
            if(cntArray[i]) total++;
        }
        answer = total;
        return answer;
    }
}
