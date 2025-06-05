import java.util.ArrayList;
import java.util.HashMap;

public class Q42 {
    public static void main(String[] args) {
        ArrayList<String > words = new ArrayList<String >();
        HashMap<String, Integer> alphabet = Common.alphabetGetValuesOrdered();
        words=URLReader.readReturnArrayList("https://projecteuler.net/resources/documents/0042_words.txt");
        String[] wordoes = words.get(0).split(",");

        int counter = 0;
        for(int i=0;i<wordoes.length;i++) {
            int wordstrength=0;
            for(int j=0;j<wordoes[i].length();j++) {

                wordstrength+=alphabet.get(String.valueOf( wordoes[i].charAt(j)));

            }
            if(Common.isTriangularNumber(wordstrength)) {
                counter++;
                System.out.println(wordoes[i]);
            }
        }
        System.out.println(counter);




    }
}
