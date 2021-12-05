package D_20211205;

import java.util.Stack;

public class S_68935 {
    public static void main(String[] args) {
        System.out.println(solution(45));   // 7
        System.out.println(solution(125));  // 229
    }
    static int NUM = 3;
    public static int solution(int n) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        while(n>=NUM){
            stack.add(n%NUM);
            n = n/NUM;
        }
        stack.add(n);

        int index=0;
        while(!stack.isEmpty()) {
            answer += stack.pop()*Math.pow(NUM,index);
            index++;
        }

        return answer;
    }

}
