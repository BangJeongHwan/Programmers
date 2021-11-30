package D_20211130;

        /*
        제약조건은 아래와 같다
        nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
        nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
         */

//        1000이하 숫자이고 3개만 구하면 되기 때문에 합계의 최대 값인 998, 999, 1000 합을 구한 뒤 소수를 미리 구해둔다

import java.util.HashSet;

public class S_12977_1 {
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        System.out.println(solution(nums));
    }

    static int totalCnt = 0;
    static HashSet<Integer> hashSet = new HashSet<>();

    public static  int solution(int[] nums) {
        int answer = -1;

        findMaxTotalCntSosuNums();

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
//            printBooleanMap(booleanMap);
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
        if(hashSet.contains(totalCnt)) return true;
        return false;
    }
    private static HashSet<Integer> findMaxTotalCntSosuNums(){
        /*
        제약조건은 아래와 같다
        nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
        nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
         */

//        1000이하 숫자이고 3개만 구하면 되기 때문에 합계의 최대 값인 998, 999, 1000 합을 구한 뒤 소수를 미리 구해둔다
        int maxSumCnt = 998+999+1000;
        int i=2;
        boolean isPrime = true;
        while(i<=maxSumCnt){
            isPrime = true;
            for(int n=2;n<i;n++){
                if (i % n == 0) {
                    isPrime = false;
                }
                continue;
            }
            if(isPrime) hashSet.add(i);
            i++;
        }
        return hashSet;
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
