public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{54, 45, 21, 12, 0};
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }

        // Bubble sort
        boolean isSwapped = true;
        for(int i=0; i < numbers.length && isSwapped; i++) {
            isSwapped = false;
            for(int j=0; j< (numbers.length -(i+1)); j++) {
                if(numbers[j] > numbers[j+1]) {
                    // swap without using temp variable
                    numbers[j] = numbers[j] + numbers[j+1];
                    numbers[j+1] = numbers[j] - numbers[j+1];
                    numbers[j] = numbers[j] - numbers[j+1];
                    isSwapped = true;
                 }
            }
        }

        System.out.println("\nAfter sort: ");
        for(int number : numbers) {
            System.out.print(number);
        }
    }
}