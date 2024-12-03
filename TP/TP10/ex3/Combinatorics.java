public class Combinatorics {
    @Profiling
    @Cache
    static long comb(int n, int k) {
        if (k == 0 || k == n)
            return 1;
        else
            return comb(n - 1, k) + comb(n - 1, k - 1);
    }

    public static void main(String args[]) {
        for (int n = 0; n <= 25; n++) {
            for (int k = 0; k <= n; k++) {
                System.out.println("Comb(" + n + ", " + k + ")=" + comb(n, k));
            }
        }
        System.exit(0);
    }
}