package D_20211129;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class S_81301 {

    static Map<String, String> map = new HashMap<>();
    static HashSet<String> hashSet = new HashSet<>();

    public static void main(String[] args) {
        String s = "one4seveneight";
        s = "23four5six7";
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        int answer = 0;
        hashSet.add("zero");
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");
        hashSet.add("four");
        hashSet.add("five");
        hashSet.add("six");
        hashSet.add("seven");
        hashSet.add("eight");
        hashSet.add("nine");

        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");

        String arrS[] = s.split("");

        String answerStr = "";

        String makeNumberStr = "";
        for(int i=0;i<arrS.length;i++){
            int arrSint = arrS[i].charAt(0);
            if(arrSint>=48 && arrSint<=57){
                answerStr+=arrS[i];
            }else{
                makeNumberStr += arrS[i];
                if(hashSet.contains(makeNumberStr)){
                    answerStr+=map.get(makeNumberStr);
                    makeNumberStr="";
                }
            }
        }
        answer = Integer.parseInt(answerStr);
        return answer;
    }
}
