package D_20211129;

import java.util.Stack;

public class S_64061 {

    public static void printMap(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int move : moves){
            for(int i=0;i<board[0].length;i++){
                if(board[i][move-1]!=0){
                    if(stack.size()>0){
                        if(board[i][move-1]==stack.peek()){
                            stack.pop();
                            answer+=2;
                        }else{
                            stack.push(board[i][move-1]);
                        }
                    }else{
                        stack.push(board[i][move-1]);
                    }
                    board[i][move-1]=0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        // 4
        System.out.println(solution(board,moves));
    }
}
