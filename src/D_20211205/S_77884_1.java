package D_20211205;

public class S_77884_1 {
    public static void main(String[] args) {
        System.out.println(solution(13,17));
        System.out.println(solution(24,27));
    }
    public static int solution(int left, int right) {
        int answer = 0;

        for(int i=left;i<=right;i++){
            // 제곱근이 있으면 홀수이다.
            if(i%Math.sqrt(i)==0){
                answer -= i;
            }else{
                answer += i;
            }
        }

        return answer;
    }
}
