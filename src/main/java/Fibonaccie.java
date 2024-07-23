public class Fibonaccie {

    static int counter = 0;

    static Integer[] memo = new Integer[100];

    public static void main(String[] args) {
//        System.out.println(fib(7)); // will have O(2n) -- TOP/DOWN approach
//        System.out.println("counter: " + counter);

//        System.out.println("memo: ");
//        for(int n : memo) {
//            System.out.print(n + " "); //exception is due to memo initialized with 100
//        }

        System.out.println(fib2(7)); // will have O(n-1) -- BOTTOM/UP approach
        System.out.println("counter: " + counter);
    }

    public static int fib(int n) {
        counter++;

        if(memo[n] != null) {
            return memo[n];
        }

        if(n == 0 || n == 1) {
            memo[n] = n;
            return n;
        }

        memo[n] = fib(n-1) + fib(n-2);
        return memo[n];
    }

    public static int fib2(int n) {
        int[] fibList = new int[n + 1];
        fibList[0] = 0;
        fibList[1] = 1;
        for(int i=2; i <= n ; i++) {
            counter++;
            fibList[i] = fibList[i-1] + fibList[i-2];
        }

        return fibList[n];
    }
}