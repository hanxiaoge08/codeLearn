package hot100_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 将有序数组转换为二叉搜索树 {

    /**
     * A simple class for fast input reading.
     */
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    /**
     * A simple class to store target coordinates.
     */
    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        // Read dimensions and number of targets
        long n = sc.nextLong();
        long m = sc.nextLong();
        int k = sc.nextInt();

        // If there are no targets, the score is 0.
        if (k == 0) {
            out.println(0);
            out.flush();
            return;
        }

        // Read target coordinates into a list.
        List<Point> targets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            targets.add(new Point(sc.nextLong(), sc.nextLong()));
        }

        int maxHits = 1; // If there's at least one target, we can always hit one.

        // Iterate through each target to define a potential shooting direction.
        for (int j = 0; j < k; j++) {
            Point p_j = targets.get(j);
            long xj = p_j.x;
            long yj = p_j.y;

            int currentHits = 0;

            // For the chosen direction, check how many targets lie on the path.
            for (int i = 0; i < k; i++) {
                Point p_i = targets.get(i);
                long xi = p_i.x;
                long yi = p_i.y;

                // We check if the Diophantine equation a*(n*yj) - b*(m*xj) = yi*xj - xi*yj has a solution.
                // A solution exists if and only if C is divisible by gcd(A, B).
                long termA = n * yj;
                long termB = m * xj;
                long termC = yi * xj - xi * yj;

                long commonDivisor = gcd(termA, termB);

                // If C is divisible by the GCD, the target is on the path.
                if (termC % commonDivisor == 0) {
                    currentHits++;
                }
            }

            if (currentHits > maxHits) {
                maxHits = currentHits;
            }
        }

        out.println(maxHits);
        out.flush();
    }


}
