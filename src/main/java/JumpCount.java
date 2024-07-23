public class JumpCount {
    public static void main(String[] args) {
        System.out.println(solution(1, 1000000000 , 1));
    }

    public static int solution(int X, int Y, int D) {
        if(Y < X || D <= 0 ) {
            return 0;
        }

        int totalDistanceCovered = X;
        int count = 0;
        while(totalDistanceCovered < Y) {
            count++;
            totalDistanceCovered += D;
        }

        return count;
    }
}