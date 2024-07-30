import javax.imageio.stream.ImageInputStream;

public class SortArrayN {
    public static void main(String[] args) {

        SortArrayN obj = new SortArrayN();
        int arr[] = {2, 1, 5, 3, 4};
        // Function call to sort the array
        obj.sortArray(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Function to sort the array in O(N)
    private void sortArray(int arr[]) {
        // Traverse the array
        for (int i = 0; i < arr.length; ) {
            // If the current element is at correct position
            if (arr[i] == i + 1) {
                i++;
            }
            // Else swap the current element with it's correct position
            else {
                // Swap the value of arr[i] and arr[arr[i]-1]
                int temp1 = arr[i];
                int temp2 = arr[arr[i] - 1];
                arr[i] = temp2;
                arr[temp1 - 1] = temp1;
            }
        }
    }
}