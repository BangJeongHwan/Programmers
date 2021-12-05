package D_20211205;

public class S_68935_1 {
    public static void main(String[] args) {
        System.out.println(solution(45));   // 7
//        System.out.println(solution(125));  // 229
    }
    public static int solution(int n){
        int result = 0;

        String str = "";
        while(n>0){
            str = str + (n%3);
            n = n/3;
        }
        // str 을 radix 의 진수에 맞춰 int형으로 변환한다.
        result = Integer.parseInt(str,3);

        return result;
    }
}
