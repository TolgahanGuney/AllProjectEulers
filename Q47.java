import java.util.ArrayList;

public class Q47 {
    public static void main(String[] args) {

        for (int i = 2; true; i++) {
            if(Common.getPrimeFactors(i).size()==4&&Common.getPrimeFactors(i+1).size()==4&&Common.getPrimeFactors(i+2).size()==4&&Common.getPrimeFactors(i+3).size()==4){
                System.out.println(i);
                break;
            }


        }
    }
}
