package D_20211205;

public class S_77884 {
    public static void main(String[] args) {
        System.out.println(solution(13,17));
        System.out.println(solution(24,27));
    }
    public static int solution(int left, int right) {
        int answer = 0;

        for(int i=left;i<=right;i++){
            if(findYakSuOddOREven(i)){
                answer += i;
            }else{
                answer -= i;
            }

        }

        return answer;
    }

    private static boolean findYakSuOddOREven(int num) {

        boolean checkCnt[] = new boolean[num+1];
        for(int i=1;i<=num;i++){
            if(num%i==0){
                if(!checkCnt[i]){
                    checkCnt[i] = true;
                    checkCnt[num/i] = true;
                }
            }
        }

        int yakSuCnt = 0;
        for(boolean cnt : checkCnt){
            if(cnt) yakSuCnt++;
        }

        return yakSuCnt%2==0?true:false;
    }

}
