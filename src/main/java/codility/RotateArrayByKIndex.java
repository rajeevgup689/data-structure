package codility;

public class RotateArrayByKIndex {

    public static void main(String[] args) {
        RotateArrayByKIndex obj = new RotateArrayByKIndex();
        //System.out.println(obj);

        int[] A = new int[] {3,8,9,7,6};
        int[] result = obj.solution(A,3);
        for(int n : result) {
            System.out.print(n + ", ");
        }
    }

    public int[] solution(int[] A, int K) {
        if(A.length == 0) {
            return new int[0];
        }
        int j;
        while(K > 0) {
            int temp = A[A.length -1];
            for(j= A.length -1 ; j > 0 ; j--) {
                A[j] = A[j-1];
            }
            A[j] = temp;
            K--;
        }

        return A;
    }
}