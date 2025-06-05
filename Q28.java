public class Q28 {
    public static void main(String[] args) {

        System.out.println(spiralDiagonalSum(1001));


    }

    public static long spiralDiagonalSum(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return 4*n*n -6*n+6+spiralDiagonalSum(n-2);
        }
    }
}
