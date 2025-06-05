
import java.util.ArrayList;
public class Q24 {
    public static void main(String[] args) {
        ArrayList permutations = new ArrayList();
        String numbers = "";

        for(int i = 0; i < 10; ++i) {
            numbers = numbers + i;
        }

        System.out.println(numbers);
        Common.permutationArraylistString(numbers, "", permutations);
        System.out.println(permutations.get(999999));
    }


}







