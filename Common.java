import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Common {


    public static long permutation(int n, int k) {
        //assuming n>k
        return factorial(n)/ factorial(n-k);
    }
    public static long combination(int n, int k) {
        //assuming n>k

        if ((factorial(k) * factorial(n - k))==0){
            System.out.println("Combination mistake " +n+" "+ k);
            return 1;
        }

        return factorial(n) / (factorial(k) * factorial(n - k));

    }
    public static BigInteger combinationBigInteger(int n, int k) {
        //assuming n>k


        return factorialBigInteger(n) .divide (factorialBigInteger(k) .multiply(factorialBigInteger(n - k)));

    }
    public static BigInteger factorialBigInteger(int n) {
        if(2>n){
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorialBigInteger(n-1));

    }

    public static long factorial(int n) {
        if (n < 2) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static ArrayList<Long> getPrimeFactors(long n) {
        ArrayList<Long> primes = new ArrayList<Long>();
        for (long i = 2; i < n; i++) {
            if (n % i == 0 && isPrimeClassic(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
    public static String sorted_String(String n) {
        char[] chars = n.toCharArray();

        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;

    }
    public static long getTriangularNumber(long n) {
        //the nth triangular number
        return n*(n+1)/2;
    }
    public static long whichTriangularNumber(long n) {
        //assuming n is a triangular number
        return (long)(-1+ Math.sqrt(1+8*n))/2;
    }
    public static boolean isTriangularNumber(long n) {
        return n== Common.getTriangularNumber(Common.whichTriangularNumber(n));
    }
    public static long getPentagonalNumber(long n) {
        //the nth triangular number
        return n*(3*n-1)/2;
    }
    public static long whichPentagonalNumber(long n) {
        //assuming n is a triangular number
        return (long)(1+ Math.sqrt(1+24*n))/6;
    }
    public static boolean isPentagonalNumber(long n) {
        return n == Common.getPentagonalNumber(Common.whichPentagonalNumber(n));
    }



    public static boolean isPandigitalUntil(long number,int digit) {
        // checks if the number is pandigital until digit
        String str = String.valueOf(number);
        for (int i = 1; i <= digit; i++) {
            if (!str.contains(String.valueOf(i)) ) {
                return false;

            }
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (String.valueOf(str.charAt(j)).equals(String.valueOf(i))) {
                    count++;

                }
            }

            if (count >1) {
                return false;
            }
            str=str.replace(String.valueOf(i).charAt(0), ' ');

        }
        if (str.isBlank()){
            return true;
        }

        return false;

    }



    public static HashMap<String, Integer> alphabetGetValuesOrdered() {
        HashMap<String, Integer> alphabet = new HashMap<String, Integer>();
        alphabet.put(",", 0);
        alphabet.put("\"", 0);
        alphabet.put("A", 1);
        alphabet.put("B", 2);
        alphabet.put("C", 3);
        alphabet.put("D", 4);
        alphabet.put("E", 5);
        alphabet.put("F", 6);
        alphabet.put("G", 7);
        alphabet.put("H", 8);
        alphabet.put("I", 9);
        alphabet.put("J", 10);
        alphabet.put("K", 11);
        alphabet.put("L", 12);
        alphabet.put("M", 13);
        alphabet.put("N", 14);
        alphabet.put("O", 15);
        alphabet.put("P", 16);
        alphabet.put("Q", 17);
        alphabet.put("R", 18);
        alphabet.put("S", 19);
        alphabet.put("T", 20);
        alphabet.put("U", 21);
        alphabet.put("V", 22);
        alphabet.put("W", 23);
        alphabet.put("X", 24);
        alphabet.put("Y", 25);
        alphabet.put("Z", 26);
        return alphabet;
    }

    public static String[] websiteReader(String website) throws Exception {

        URL oracle = new URL(website);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        String words = "";
        while ((inputLine = in.readLine()) != null) {
            words = (inputLine);

        }
        in.close();
        String regex = "[,]";
        return words.replace("\"", "").split(regex);

    }

    public static void permutationArraylistString(String word, String result, ArrayList wordos) {
        //at begining result is "", word will be permutated to all combinations, and will be added to Arraylist wordos
        if (word.length() == 0) {
            wordos.add(result);
        } else {
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                String left_substr = word.substring(0, i);
                String right_substr = word.substring(i + 1);
                String rest = left_substr + right_substr;
                permutationArraylistString(rest, result + ch, wordos);
            }

        }


    }


    public static boolean isabundantNumber(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        if (sum > n) {
            return true;
        }

        return false;


    }
    public static boolean isPrimeClassic(Long n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static BigInteger getBigintegerPower(BigInteger a, BigInteger b) {
        //a^b
        return a.pow(b.intValue());
    }
    public static ArrayList<Integer> primelist = new ArrayList<Integer>();
   public static ArrayList<Integer> getprimelist() {
       return primelist;
   }

   public static void clearprimelist() {
       primelist.clear();
   }
    public static void create_primelist_Until(int n) {
        if (primelist.size() >0) {
            addToPrimeListRange(primelist.getLast(),n);
        }
        else {
            for (int i = 0; i <= n; i++) {
                if (isPrime(i)) {
                    primelist.add(i);
                }
            }
        }
    }
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if(primelist.size()==0){
            primelist.add(2);
        }
        if(primelist.contains(n)){
            return true;
        }
        if(Math.sqrt(n)>primelist.getLast()){
            addToPrimeListRange(primelist.getLast()+1,(int)Math.sqrt(n)+1);

        }
        for (int i = 0; i < primelist.size(); i++) {
            if (n % primelist.get(i) == 0) {
                return false;
            }
            if (Math.sqrt(n)<primelist.get(i)){
                break;


            }
        }


        return true;
    }
    public static void addToPrimeListRange(int beg,int end) {
       for (int i = beg; i <= end; i++) {
           if (isPrime(i)) {
               primelist.add(i);
           }
       }
       System.out.println(primelist);
    }





}
