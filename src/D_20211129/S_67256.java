package D_20211129;

import java.util.*;

class P {
    int x;
    int y;
    int cnt;

    public P(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class S_67256 {
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

    static final String RIGHT = "R";
    static final String LEFT = "L";

    static final int dx[]={0,1,0,-1};
    static final int dy[]={1,0,-1,0};

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        HashSet<Integer> hashSetLeft = new HashSet<>();
        hashSetLeft.add(1);
        hashSetLeft.add(4);
        hashSetLeft.add(7);

        HashSet<Integer> hashSetRigth = new HashSet<>();
        hashSetRigth.add(3);
        hashSetRigth.add(6);
        hashSetRigth.add(9);

        Map<Integer, P> hashMap = new HashMap<>();
        hashMap.put(1,new P(0,3,0));        // L
        hashMap.put(2,new P(1,3,0));
        hashMap.put(3,new P(2,3,0));        // R
        hashMap.put(4,new P(0,2,0));        // L
        hashMap.put(5,new P(1,2,0));
        hashMap.put(6,new P(2,2,0));        // R
        hashMap.put(7,new P(0,1,0));        // L
        hashMap.put(8,new P(1,1,0));
        hashMap.put(9,new P(2,1,0));        // R
        hashMap.put(0,new P(1,0,0));


        P leftP = new P(0,0,0);
        P rightP = new P(2,0,0);

        for(int i=0;i<numbers.length;i++){
            P p = hashMap.get(numbers[i]);
            // 1,4,7 일 경우 반드시 왼손으로 클릭
            if(hashSetLeft.contains(numbers[i])){
                leftP.x = p.x;
                leftP.y = p.y;
                answer+=LEFT;
            }
            // 3,6,9 일 경우 반드시 왼손으로 클릭
             else if(hashSetRigth.contains(numbers[i])){
                rightP.x = p.x;
                rightP.y = p.y;
                answer+=RIGHT;
            }
             // 나머지 경우
             else{
                answer+=findEles(p,leftP,rightP,hand);
            }
        }
        return answer;
    }
    public static String findEles(P p, P leftP, P rightP, String hand){
        String str="";

        final int N = 3;
        final int M = 4;
        boolean checked[][] = new boolean[N][M];

        Queue<P> leftQ = new LinkedList<>();
        leftQ.add(leftP);
        int leftCnt = 0;
        while(!leftQ.isEmpty()){
            P p1 = leftQ.poll();
            if(p1.x==p.x && p1.y==p.y){
                leftCnt=p1.cnt;
            }else{
                for(int i=0;i<4;i++){
                    int fx = dx[i]+p1.x;
                    int fy = dy[i]+p1.y;
                    if(fx<0||fx>N-1
                            ||fy<0||fy>M-1
                            ||checked[fx][fy]
                    ){
                        continue;
                    }

                    checked[fx][fy] = true;
                    leftQ.add(new P(fx,fy,p1.cnt+1));
                }
            }
        }

        checked = new boolean[N][M];
        Queue<P> rightQ = new LinkedList<>();
        rightQ.add(rightP);
        int rightCnt = 0;
        while(!rightQ.isEmpty()){
            P p1 = rightQ.poll();
            if(p1.x==p.x && p1.y==p.y){
                rightCnt=p1.cnt;
            }else{
                for(int i=0;i<4;i++){
                    int fx = dx[i]+p1.x;
                    int fy = dy[i]+p1.y;
                    if(fx<0||fx>N-1
                            ||fy<0||fy>M-1
                            ||checked[fx][fy]
                    ){
                        continue;
                    }
                    checked[fx][fy] = true;
                    rightQ.add(new P(fx,fy,p1.cnt+1));
                }
            }
        }

//        System.out.println("rightCnt : "+rightCnt+", leftCnt : "+leftCnt);
        if(rightCnt>leftCnt){
            str = LEFT;
            leftP.x = p.x;
            leftP.y = p.y;
        }else if(rightCnt<leftCnt){
            str = RIGHT;
            rightP.x = p.x;
            rightP.y = p.y;
        }else{
            if("right".equals(hand)){
                str = RIGHT;
                rightP.x = p.x;
                rightP.y = p.y;
            }else{
                str = LEFT;
                leftP.x = p.x;
                leftP.y = p.y;
            }
        }

        return str;
    }
}
