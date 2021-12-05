package D_20211205;

// 시간 초과 30/100 성공

public class S_1845 {
    public static void main(String[] args) {
//        int[] nums = {3,1,2,3};
//        int[] nums = {3,3,3,2,2,4};
        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));
    }

    static int maxNum = 0;
    static int result = 0;

    public static int solution(int[] nums) {
        int answer = 0;

        for(int num : nums){
            maxNum = Math.max(maxNum,num);
        }

        int selCnt = nums.length/2;
        boolean[] checked = new boolean[nums.length];
        dfs(0,0,selCnt,nums,checked);

        answer = result;
        return answer;
    }

    public static void dfs(int index, int cnt, int selCnt, int[] nums, boolean[] checked){
        if(cnt == selCnt){
            result = Math.max(result,findMaxNumberCnt(checked, nums, new boolean[maxNum+1]));
            return;
        }

        for(int i=index;i<nums.length;i++){
            if(!checked[i]){
                checked[i] = true;
                dfs(i,cnt+1, selCnt, nums, checked);
                checked[i] = false;
            }
        }
    }

    private static int findMaxNumberCnt(boolean[] checked, int[] nums, boolean[] boolNumberCheck) {
        for(int i=0;i<checked.length;i++){
            if(checked[i]) {
                if(!boolNumberCheck[nums[i]]){
                    boolNumberCheck[nums[i]]=true;
                }
            }
        }
        int totalCnt = 0;
        for(boolean b : boolNumberCheck){
            if(b) totalCnt++;
        }
        return totalCnt;
    }


}
