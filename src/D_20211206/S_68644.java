package D_20211206;

import java.util.Arrays;
import java.util.HashSet;

public class S_68644 {
    public static void main(String[] args) {
//        int[] numbers = {2,1,3,4,1};    // [2,3,4,5,6,7]
        int[] numbers = {5,0,2,7};  // 2,5,7,9,12
        int[] result = solution(numbers);
        for(int rs : result){
            System.out.print(rs+", ");
        }
        System.out.println();
    }
    public static int[] solution(int[] numbers) {

        HashSet<Integer> hashSet = new HashSet<>();
        dfs(0,0,numbers,new boolean[numbers.length],hashSet);
        int[] answer = hashSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);

        return answer;
    }

    public static void dfs(int index, int cnt, int[] numbers, boolean[] visited,HashSet<Integer> hashSet){
        if(cnt==2){
            int sum = 0;
            for(int i=0;i<visited.length;i++){
                if(visited[i]) sum+=numbers[i];
            }
            if(!hashSet.contains(sum)) hashSet.add(sum);
            return;
        }

        for(int i=index;i<numbers.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(index,cnt+1,numbers,visited,hashSet);
                visited[i] = false;
            }
        }
    }
}
