package D_20211129;

public class S_67256_1 {
    static int[][] numpadPos = {
            {1,0}, //0
            {0,3}, //1
            {1,3}, //2
            {2,3}, //3
            {0,2}, //4
            {1,2}, //5
            {2,2}, //6
            {0,1}, //7
            {1,1}, //8
            {2,1}  //9
    };

    //초기 위치
    static int[] leftPos = {0,0};
    static int[] rightPos = {2,0};
    static String hand;

    static final String RIGHT = "R";
    static final String LEFT = "L";


    public static String solution(int[] numbers, String hand) {
        hand = "right".equals(hand)?RIGHT:LEFT;

        String answer="";
        for(int num : numbers){
            // 누를 버튼을 찾는다.
            String handStr = pushNumber(num);
            answer += handStr;

            // 오른손 위치 왼손 위치를 각각 셋팅한다.
            if(RIGHT.equals(handStr)) {
                rightPos = numpadPos[num];
                continue;
            }else{
                leftPos = numpadPos[num];
                continue;
            }
        }
        return answer;
    }

    public static String pushNumber(int num){
        if(num==1||num==4||num==7) return LEFT;
        if(num==3||num==6||num==9) return RIGHT;

        if(getDist(leftPos,num)>getDist(rightPos,num)) return RIGHT;
        if(getDist(leftPos,num)<getDist(rightPos,num)) return LEFT;

        return hand;
    }

    public static int getDist(int[] pos, int num){
        return Math.abs(pos[0]-numpadPos[num][0])+Math.abs(pos[1]-numpadPos[num][1]);
    }

    public static void main(String[] args) {

//        int numbers[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        // LRLLLRLLRRL

//        int numbers[] = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        hand = "left";
//        	"LRLLRRLLLRR"

        int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        hand = "right";
//        "LLRLLRLLRL"
        System.out.println(solution(numbers,hand));
    }
}
