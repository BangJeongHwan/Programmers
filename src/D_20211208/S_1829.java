package D_20211208;

import java.util.LinkedList;
import java.util.Queue;

class P{
    int x;
    int y;

    P(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class S_1829 {
    public static void main(String[] args) {
//        6	4	[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]	[4, 5]
//        int m = 6;
//        int n = 4;
//        int[][] picture = {{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3}};

//        입력값 〉	6, 4, [[1, 1, 1, 0], [1, 1, 1, 0], [0, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 1]]
//        기댓값 〉	[2, 6]
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0},{1, 1, 1, 0},{0, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 1}};

        int[] result = solution(m,n,picture);
        for(int rs : result){
            System.out.println(rs); //[4, 5]
        }
        System.out.println();
    }

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static int[] solution(int m, int n, int[][] picture) {

        printMap(m,n,picture);

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<picture.length;i++){
            for(int j=0;j<picture[0].length;j++){
                if(!visited[i][j]&&picture[i][j]!=0){
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,bfs(i,j,m,n,picture,visited));
                    numberOfArea++;
                }else if(picture[i][j]==0){
                    visited[i][j] = true;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static int bfs(int x, int y, int m, int n, int[][] picture, boolean[][] visited) {
        int sizeOfOneArea = 1;
        visited[x][y] = true;
        System.out.println(x+" "+y);
        Queue<P> q = new LinkedList<>();
        q.add(new P(x,y));
        int initNumber=picture[x][y];

        while(!q.isEmpty()){
            P p = q.poll();
            for(int i=0;i<4;i++){
                int nfx=p.x+dx[i];
                int nfy=p.y+dy[i];
                if(nfx<0||nfx>m-1||nfy<0||nfy>n-1||visited[nfx][nfy]||picture[nfx][nfy]!=initNumber){
                    continue;
                }
                q.add(new P(nfx,nfy));
                visited[nfx][nfy]=true;
                sizeOfOneArea++;
            }
        }
        return sizeOfOneArea;
    }

    public static void printMap(int m, int n, int[][] picture){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(picture[i][j]+" ");
            }
            System.out.println();
        }
    }
}
