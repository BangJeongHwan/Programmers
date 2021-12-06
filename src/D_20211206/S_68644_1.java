package D_20211206;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class S_68644_1 {
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

        // HashMap과 TreeMap의 차이
        // TreeMap은 적재하면서 정렬이 된다.
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                treeSet.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = treeSet.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
