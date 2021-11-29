package D_20211129;

public class S_81301_1 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        s = "23four5six7";
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        int rs = 0;

        String arr[] = {"zero", "one", "two", "three","four","five","six","sevne","eight","nine"};
        for(int i=0;i<arr.length;i++){
            s = s.replaceAll(arr[i],Integer.toString(i));
        }

        rs = Integer.parseInt(s);

        return rs;
    }
}
