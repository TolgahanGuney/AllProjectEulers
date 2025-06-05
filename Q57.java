import java.math.*;

public class Q57 {
    public static void main(String[] args) {
        int counter=0;
        float currentNumerator=3;
        float currentDenominator=2;
        BigDecimal numerator=new BigDecimal(currentNumerator);
        BigDecimal denominator=new BigDecimal(currentDenominator);
        for (int i = 1; i <1000; i++) {




            currentNumerator=  Math.round(currentNumerator*(Math.sqrt(2)+1));
            currentDenominator= Math.round( currentNumerator/(Math.sqrt(2)));
            if ((int) Math.log10(currentNumerator)< (int) Math.log10(currentDenominator)) {
                counter++;
                System.out.println(currentNumerator);
                System.out.println(currentDenominator);
                System.out.println(currentNumerator/currentDenominator-Math.sqrt(2));
            }
            if((int)currentNumerator<0 || (int)currentDenominator<0){
                System.out.println("The number is incorrect");
            }


        }
        System.out.println(counter);
    }
}
