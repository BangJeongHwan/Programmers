package D_20211201;

import java.util.HashMap;

public class S_42576_1 {

    public static void main(String[] args) {
        String[] participant={"mislav", "stanko", "mislav", "ana"};
        String[] completion={"stanko", "ana", "mislav"};
        System.out.println(solution(participant,completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        // getOrDefault 함수로 값이 없을 때 0값을 넣을 수 있다.
        // if(!map.keySet().contains(part)){ 와 같은 불필요한 로직이 안들어갈 수 있다.
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
