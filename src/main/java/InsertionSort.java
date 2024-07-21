public class InsertionSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{54, 45, 21, 12, 0};
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(STR."\{numbers[i]} ");
        }

        // Insertion sort
        int j;
        for(int i=1; i < numbers.length; i++) {
            int temp = numbers[i];
            for(j=i-1; j>= 0; j--) {
                if(temp < numbers[j]) {
                    numbers[j+1] = numbers[j]; // shifting the number so that it make place to insert temp
                 } else {
                    break;
                }
            }
            numbers[j+1] = temp; // finally insert temp
        }

        System.out.println("\nAfter sort: ");
        for(int number : numbers) {
            System.out.print(STR."\{number} ");
        }
    }
}