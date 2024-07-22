public class Fibonaccie {

    static int counter = 0;

    static Integer[] memo = new Integer[100];

    public static void main(String[] args) {
        System.out.println(fib(7));
        System.out.println("counter: " + counter);

        System.out.println("memo: ");
        for(int n : memo) {
            System.out.print(n + " "); //exception is due to memo initialized with 100
        }
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
}