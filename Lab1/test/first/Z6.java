package test.first;
public class Z6 {
    public static void main(String[] args) {
        int n = 100;
        boolean[] primes = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {

            if (primes[p]) {
                for (int i = p * p; i <= n; i += p) {
                    primes[i] = false;
                }
            }
        }

        // Выводим все найденные простые числа
        System.out.println("Простые числа от 2 до " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
