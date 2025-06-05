import java.util.ArrayList;

public class Q46 {
//It was proposed by Christian Goldbach that every odd composite number
//can be written as the sum of a prime and twice a square.
//It turns out that the conjecture was false.
//What is the smallest odd composite that cannot be written as
//the sum of a prime and twice a square?


    public static void main(String[] args) {
        ArrayList<Integer> primos= new ArrayList<Integer>();
        int prime= 0;
        boolean foundPrime= false;
        for (int i = 3; !foundPrime; i+=2) {
            if (isCompositeNumber(i)) {
                boolean Goldbach= false;
                for (int j = 0; j <= Math.sqrt(i); j++) {

                    if(Common.isPrime(    i-2*j*j)){

                        Goldbach= true;
                        break;
                    }
                }
                if (!Goldbach) {
                    System.out.println(i);
                    foundPrime= true;

                }


            }
        }



    }
    public static boolean isCompositeNumber(int n) {
        return !Common.isPrime(n);
    }
    public static ArrayList<Integer> getPrimesTill(int n) {
        Common.create_primelist_Until(n);
        return Common.getprimelist();

    }
}
