import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] A = new int[]{-3,-1,-2,-2,-5,-6};
        System.out.println("\n" + obj.solution(A));
    }

    public int solution(int[] A) {
        // Implement your solution here
        if(A.length == 0) {
            return 0;
        }
        int maxProd = A[0]; // can be negative as well

        int prod; // can be negative as well
        for(int i=0; i< A.length; i++) {
            for(int j=i+1;j<A.length; j++) {
                for(int k = j+1; k< A.length; k++){
                    prod = A[i]*A[j]*A[k];
                    if(maxProd < prod) {
                        maxProd = prod;
                    }
                }
            }
        }


        return maxProd;
    }

}