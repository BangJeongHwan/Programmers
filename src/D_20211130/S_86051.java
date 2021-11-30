package D_20211130;

public class S_86051 {
    public static void main(String[] args) {
        int[] numbers = {5,8,4,0,6,7,9};
        System.out.println(solution(numbers));
    }
    public static int solution(int[] numbers) {
        int answer = 0;

        boolean[] checked = new boolean[10];
        for(int number : numbers){
            checked[number] = true;
        }

        for(int i=0;i<checked.length;i++){
            if(!checked[i]) answer+=i;
        }

        return answer;
    }
}
