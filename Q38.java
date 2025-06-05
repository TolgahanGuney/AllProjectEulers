import java.util.ArrayList;

public class Q38 {
    public static void main(String[] args) {
        long maxpandigital=0;
        for (long i = 500000000; i > 0; i--) {
            String pandigital = String.valueOf(i);
            for (int j = 2; j <= 9&& pandigital.length()<=9; j++) {
                pandigital = pandigital + i * j;

                if(pandigital.length()==9) {
                    if(Common.isPandigitalUntil(Long.valueOf(pandigital),9)){
                        maxpandigital=i;
                        System.out.println(maxpandigital);
                        System.out.println(pandigital);
                        System.out.println(j);
                        break;

                    }

                }

            }
            if(maxpandigital==i){
                break;
            }



            
        }
        System.out.println(maxpandigital);


    }

}
