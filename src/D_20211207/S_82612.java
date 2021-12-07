package D_20211207;

public class S_82612 {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }
    public static long solution(int price, int money, int count) {
        long answer = 0;

        long total = 0;
        for(int i=1;i<=count;i++){
            total += price*i;
        }
        answer = money-total>0?answer:Math.abs(money-total);

        return answer;
    }
}
