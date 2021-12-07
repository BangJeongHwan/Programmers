package D_20211207;

public class S_82612_1 {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }
    public static long solution(int price, int money, int count) {
//        1~N까지 더하기 = n(n+1)/2 -> 가우스 공식
        return Math.max(price*((count*(count+1))/2)-money,0);
    }
}
