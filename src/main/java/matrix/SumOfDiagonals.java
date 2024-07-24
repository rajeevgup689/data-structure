package matrix;

// https://www.geeksforgeeks.org/efficiently-compute-sums-of-diagonals-of-a-matrix/
public class SumOfDiagonals {
    static void printDiagonalSums(int[][] mat,
                                  int n) {
        int principal = 0, secondary = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Condition for principal
                // diagonal
                if (i == j)
                    principal += mat[i][j];

                // Condition for secondary
                // diagonal
                if ((i + j) == (n - 1))
                    secondary += mat[i][j];
            }
        }

        System.out.println("Principal Diagonal:"
                + principal);

        System.out.println("Secondary Diagonal:"
                + secondary);
    }

    // Driver code
    static public void main(String[] args) {

        int[][] a = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {1, 2, 3, 4},
                {5, 6, 7, 8}};

        printDiagonalSums(a, 4);
    }
}