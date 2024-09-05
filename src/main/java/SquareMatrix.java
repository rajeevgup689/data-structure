import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareMatrix {
    public static void main(String[] args) {
        int A[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12, 13, 14, 15, 16};

        List<Integer> distinctAList = Arrays.stream(A).distinct().boxed().collect(Collectors.toList());

        int squareMatrixSize = 0;
        if(A.length > 0) {
            squareMatrixSize = 1;
        } else {
            System.out.println("Square Matrix cannot be formed.");
        }

        for(int i = 1; i < Integer.MAX_VALUE; i++) {
            if(i*i <= A.length) {
                squareMatrixSize = i;
            } else {
                break;
            }
        }

        System.out.println("squareMatrix : " + squareMatrixSize);

        int squareMatrix[][] = new int[squareMatrixSize][squareMatrixSize];
        int k = 0;
        for(int i = 0; i< squareMatrixSize; i++) {
            for(int j = 0; j< squareMatrixSize; j++) {
                squareMatrix[i][j] = distinctAList.get(k++);
            }
        }

        for(int i = 0; i< squareMatrixSize; i++) {
            for(int j = 0; j< squareMatrixSize; j++) {
                System.out.print(squareMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }


    }
}