import java.math.BigInteger;

public class Q53 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 0; j <= i; j++) {
                if(Common.combinationBigInteger(i,j).compareTo(BigInteger.valueOf(1000000)) == 1){
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(Common.factorial(5) * Common.factorial(5 - 0));

    }
}
