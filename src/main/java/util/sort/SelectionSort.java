package util.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{54, 45, 21, 12, 0};
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }

        // Selection sort
        for(int i=0; i < numbers.length; i++) {
            for(int j=i+1; j< numbers.length; j++) {
                if(numbers[i] > numbers[j]) {
                    // swap without using temp variable
                    numbers[i] = numbers[i] + numbers[j];
                    numbers[j] = numbers[i] - numbers[j];
                    numbers[i] = numbers[i] - numbers[j];
                 }
            }
        }

        System.out.println("\nAfter sort: ");
        for(int number : numbers) {
            System.out.print(number);
        }
    }
}