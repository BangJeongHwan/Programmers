package D_20211210;

import java.util.Stack;

/**
 * stack를 활용하면 O(n) 의 시간 복잡도를 가진다
 * 효율성 2번에서 시간초과
 */
public class S_12973_1 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
//        System.out.println(solution("cdcd"));
    }

    public static int solution(String s)
    {

        if(s.length()%2!=0) return 0;

        Stack<String> stack = new Stack<>();
        String strArr[] = s.split("");
        for(int i=0;i< strArr.length;i++){

            if(stack.isEmpty()){
                stack.add(strArr[i]);
            }else{
                if(stack.peek().equals(strArr[i])){
                    stack.pop();
                }else{
                    stack.add(strArr[i]);
                }
            }
        }
        return stack.size()==0?1:0;
    }
}
