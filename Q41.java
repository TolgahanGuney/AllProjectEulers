import java.util.ArrayList;

public class Q41 {

    public static void main(String[] args) {
        ArrayList<Integer> permutations = new ArrayList<Integer>();
        String numero = "123456789";
        Common.permutationArraylistString(numero,"",permutations);
        System.out.println(permutations);


    }

}
