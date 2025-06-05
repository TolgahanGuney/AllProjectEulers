import java.util.ArrayList;

public class Q43 {
    public static void main(String[] args) {
        ArrayList<String> permutations = new ArrayList<String>();
        Common.create_primelist_Until(17);
        String numero = "0123456789";
        Common.permutationArraylistString(numero,"",permutations);
        ArrayList<Integer> primelist = Common.getprimelist();
        long sum = 0;

        for (int i = 0; i < permutations.size(); i++) {
            if ((int)Math.log10(Long.valueOf( permutations.get(i)))+1==10) {

                boolean fitsProperty=true;
                for (int j = 1; j < 8; j++) {
                    if(Integer.valueOf( permutations.get(i).substring(j,j+3))%primelist.get(j-1)!=0) {
                        fitsProperty=false;

                    }

                }
                if(fitsProperty) {
                    sum+=Long.valueOf( permutations.get(i));
                }
            }


        }
        System.out.println(sum);


    }

}
