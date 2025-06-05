import java.math.BigInteger;

public class Q48 {
    //self powers upto 1000
    public static void main(String[] args) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i = BigInteger.ONE; i.compareTo(BigInteger.valueOf(1001l))==-1; i=i.add(BigInteger.ONE)) {
            sum=sum.add(Common.getBigintegerPower(i,i));
        }
        System.out.println(sum.mod(BigInteger.valueOf((long)Math.pow(10l,10l))));

    }


}
