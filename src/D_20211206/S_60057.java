package D_20211206;

/**
 * 스스로 풀이
 * 82% 만 성공
 */
public class S_60057 {
    public static void main(String[] args) {
        String s = "aabbaccc";  // 7
        s = "xababcdcdababcdcd";    // 17
//        s = "abcabcabcabcdededededede"; // 14
//        s = "abcabcdede";   // 8
//        s = "ababcdcdababcdcd"; // 9
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        int answer = 0;
        int min = s.length();

        // 몇개 단위로 자를지
        for(int i=1;i<=s.length()/2;i++){
            min = Math.min(findStrLength(s,i),min);
        }
        answer = min;
        return answer;
    }

    private static int findStrLength(String s, int cnt) {
        String str = "";

        int continueCnt = 1;

        int startIdx = 0;
        int endIdx= cnt;

        String preStr = s.substring(startIdx,endIdx);
        boolean isStart = false;

        while(endIdx<=s.length()){

            startIdx = endIdx;
            endIdx += cnt;

            if(endIdx>s.length()) {
                startIdx -= cnt;
                break;
            }

            if(!preStr.equals(s.substring(startIdx,endIdx))){
                str = str+(continueCnt!=1?String.valueOf(continueCnt):"")+preStr;
                continueCnt = 1;
            }else{
                isStart = true;
                continueCnt ++;
            }
            // 처음 자른 문자열이 다음 문자열과 맞지 않다면 무조건 전체 string으로 return한다.
            if(!isStart) {
                str = s;
                break;
            }
            preStr = s.substring(startIdx,endIdx);

        }

        str = str+(continueCnt!=1?String.valueOf(continueCnt):"")+s.substring(startIdx);

        return str.length();
    }
}
