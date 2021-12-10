package D_20211210;

import java.util.Stack;

/**
 * stack를 활용하면 O(n) 의 시간 복잡도를 가진다
 * String strArr[] = s.split("") 제거 후 s.charAt(i) 로 변경
 * 성공!!!!
 */
public class S_12973_2 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
//        System.out.println(solution("cdcd"));
    }

    public static int solution(String s)
    {
        if(s.length()%2!=0) return 0;
        Stack<String> stack = new Stack<>();
        // 이 로직 때문에 효율성에서 시간초과가 된다!!!!
//        String strArr[] = s.split("");
        for(int i=0;i< s.length();i++){
            if(!stack.isEmpty() && stack.peek().equals(String.valueOf(s.charAt(i)))) stack.pop();
            else stack.add(String.valueOf(s.charAt(i)));
        }
        return stack.size()==0?1:0;
    }
}
