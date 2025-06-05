import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

public class Q22 {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String[] words;
        HashMap<String , Integer> alphabet= Common.alphabetGetValuesOrdered();
        String website="https://projecteuler.net/resources/documents/0022_names.txt";
        try {
            words = Common.websiteReader(website);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Arrays.sort(words);
        BigInteger sumofall;
        sumofall = BigInteger.valueOf(0);



        for(int i=0; i<words.length; i++){
            long sum=0;
            for (int j=0;j<words[i].length();j++){
                sum+= alphabet.get(String.valueOf(words[i].charAt(j)));


            }
            sumofall = sumofall.add(BigInteger.valueOf(sum*(i+1)));

        }
        System.out.println(sumofall);

    }

}
