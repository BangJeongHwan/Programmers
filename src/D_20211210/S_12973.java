package D_20211210;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 60.2% 시간초과 (1/8)
 */
public class S_12973 {
    public static void main(String[] args) {
//        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s)
    {
        HashSet<String> set = new HashSet<>();
        for(int i=97;i<=122;i++){
            set.add(String.valueOf((char)i)+""+String.valueOf((char)i));
        }
        int result = 1;
        while(!s.equals("")){
            boolean isTrue = false;

            Iterator iter = set.iterator();	// Iterator 사용
            while(iter.hasNext()) {//값이 있으면 true 없으면 false
                String value = String.valueOf(iter.next());
                if(s.indexOf(value)>-1){
                    s = s.replaceAll(value,"");
                    isTrue = true;
                }
            }
            if(!isTrue){
                result = 0;
                break;
            }
        }
        return  result;
    }
}
