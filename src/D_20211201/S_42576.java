package D_20211201;

import java.util.*;

public class S_42576 {
    public static void main(String[] args) {
        String[] participant={"mislav", "stanko", "mislav", "ana"};
        String[] completion={"stanko", "ana", "mislav"};
        System.out.println(solution(participant,completion));
    }
    public static String solution(String[] participant, String[] completion) {
        String result = "";

        // 중복을 무시하고 값을 처리를 하려면 HashMap을 사용해야 한다.
        HashMap<String, Integer> map = new HashMap<>();
        for(String part : participant){
            if(!map.keySet().contains(part)){
                map.put(part,1);
            }else{
                map.put(part,map.get(part)+1);
            }
        }

        for(String com : completion){
            if(map.keySet().contains(com)){
                map.replace(com,map.get(com)-1);
            }
        }

        for(String key : map.keySet()){
            if(map.get(key)==1) {
                result = key;
                break;
            }
        }

        return result;
    }
}
