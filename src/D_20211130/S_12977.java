package D_20211130;
// 시간초과 76.9점 소스

public class S_12977 {
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        System.out.println(solution(nums));
    }

    static int totalCnt = 0;
    public static  int solution(int[] nums) {
        int answer = -1;

        //
        /*
         * 순서가 없는 조합
         * startIndex, startCnt, intMap, booleanMap
         */
        dfs(0,0, nums, new boolean[nums.length]);
//        System.out.println();
        answer = totalCnt;
        return answer;
    }

    public static void dfs(int startIndex, int startCnt, int[] intMap, boolean[] booleanMap){
        if(startCnt==3){
            // 덧셈이 소수 구하기
            totalCnt+=totalNumberIsSosu(intMap,booleanMap)?1:0;
            return ;
        }
        for(int i=startIndex;i<intMap.length;i++){
            booleanMap[i]=true;
            dfs(i+1,startCnt+1, intMap, booleanMap);
            booleanMap[i]=false;
        }
    }

    private static boolean totalNumberIsSosu(int[] intMap, boolean[] booleanMap) {
        int totalCnt = 0;
        for(int i=0;i<booleanMap.length;i++){
            if(booleanMap[i]) totalCnt+=intMap[i];
        }
        int i=2;
        boolean isPrime = true;
        while(i<=totalCnt){
            isPrime = true;
            for(int n=2;n<i;n++){
                if (i % n == 0) {
                    isPrime = false;
                    // ** 추가된 로직
                    break;
                }
                // ** 시간초과 걸렸던 이유?
//                continue;
            }
            i++;
        }
        if(isPrime) return true;
        return false;
    }

    public static void printBooleanMap(boolean[] booleanMap){
        System.out.println("----------------");
        for(int i=0;i<booleanMap.length;i++){
            if(booleanMap[i]) System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("----------------");
    }
}
