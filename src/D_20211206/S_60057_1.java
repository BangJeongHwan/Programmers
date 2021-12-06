package D_20211206;

/**
 * 블로그 참고
 * https://tmdrl5779.tistory.com/192
 */
public class S_60057_1 {
    public static void main(String[] args) {
        String s = "aabbaccc";  // 7
//        s = "xababcdcdababcdcd";    // 17
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
        String prev = s.substring(0, cnt);
        int count = 1;
        String enc = "";
        String last = "";

        for(int i=cnt;i<s.length();i+=cnt){

            // lastIdx가 String Length를 넘어간다면
            if(i+cnt>s.length()){
                last = s.substring(i);
                continue;
            }

            if(prev.equals(s.substring(i,i+cnt))){
                count++;
            }else{
                enc += (count!=1?count:"")+prev;
                prev = s.substring(i,i+cnt);
                count=1;
            }
        }
//        System.out.println(prev+"  "+last);
        enc +=  (count!=1?count:"")+prev+ last;
//        System.out.println("cnt:"+cnt+" / enc:"+enc);

        return enc.length();
    }
}
