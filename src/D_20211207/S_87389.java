package D_20211207;

public class S_87389 {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
    public static int solution(int n) {
        for(int i=2; ;i++) {
            if (n % i == 1) return i;
        }
    }
}
