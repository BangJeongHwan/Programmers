package D_20211130;

public class S_76501 {
    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        System.out.println(solution(absolutes,signs));
    }
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0;i<absolutes.length;i++){
            answer += (signs[i]?1:-1)*absolutes[i];
        }

        return answer;
    }

}
