import java.util.*;


public class Q49 {
    public static void main(String[] args) {
        //prime permutations
        Common.create_primelist_Until(10000);
        ArrayList<Integer> primelist = Common.getprimelist();
        ArrayList<String> foundedPrimes= new ArrayList<String>();
        for (int i = 0; i < primelist.size(); i++) {
            if ((int)Math.log10(primelist.get(i))==3 ) {
                List<String> permutations = permute(String.valueOf(primelist.get(i)));
                ArrayList<Integer> numeros = new ArrayList<Integer>();
                for (String permutation : permutations) {

                    numeros.add(Integer.parseInt(permutation));
                }

                ArrayList<Integer> numerinos = new ArrayList<Integer>();
                for(int num : numeros) {
                    if(primelist.contains(num)){
                        numerinos.add(num);
                    }
                }


                if (numerinos.size()>=3){
                    numerinos.sort(null);
                    for (int num = 0; num < numerinos.size(); num++) {

                        if (numerinos.get(num)>1000) {
                            for(int adder = num; adder < numerinos.size()-num; adder++) {
                                int diff= numerinos.get(num+adder) - numerinos.get(num);

                                if(numerinos.contains(numerinos.get(num+adder)+diff)&&diff!=0&& !numerinos.contains(1487)){
                                    System.out.print(numerinos.get(num) +" ");
                                    System.out.print(numerinos.get(num+adder)+" " );

                                    System.out.println(numerinos.get(num+adder)+diff );
                                    System.out.println(diff);
                                }

                            }
                        }


                    }

                }


            }
        }

    }
    public static List<String> permute(String str) {
        // Base case: one permutation – the empty string
        if (str.length() == 0) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Remove character at index i
            String remaining = str.substring(0, i) + str.substring(i + 1);

            // Recurse on the remaining string
            List<String> subPermutations = permute(remaining);

            // Add current character to each sub-permutation
            for (String sub : subPermutations) {
                result.add(ch + sub);
            }
        }

        return result;
    }

}
