import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.System.out;

/*
 *  Summing series to achieve something
 *
 *  H = 1 + 1/2 + 1/3 + 1/4 + ...   (Harmonic series)
 *  PI/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ...    (very slow convergence)
 *
 *  Create methods to let the below print true.
 *
 * See:
 * -lectweek1
 */
public class Ex2SumSeries {

    public static void main(String[] args) {
        new Ex2SumSeries().program();
    }

    void program() {
        // How many terms from harmonic series to exceed some positive limit
        out.println(nTermsForLimitHS(1) == 2);   // Limit is 1, two terms will do
        out.println(nTermsForLimitHS(1.7));
        out.println(nTermsForLimitHS(1.7) == 3); // Limit is 1.7, need 3 terms
        out.println(nTermsForLimitHS(7) == 616);
        out.println(pi(100000));
        out.println(abs(pi(100000))-PI);

        // Calculate PI using series above
        out.println(abs(pi(100000) - PI) < 0.0001);

    }

    // ---------- Write method below this  ---------------------------
    int nTermsForLimitHS(double x) {
        double sum = 0;
        int count = 0;
        double i=1;

        while (sum < x) {
            double y = 1 / i;
            sum = sum + y;
            i++;
            count++;
        }
        return count;
    }

    double pi(int n) {
        int count = 0;
        double sum = 0;
        double i = 1;

        for (int j=1; j<=n; j++) {
            double y = 1 / i;
            if (count == 0) {
                sum = sum + y;
                count++;
            }
            else {
                sum = sum - y;
                count--;
            }
            i = i+2;
        }
        return sum*4;
    }
}
