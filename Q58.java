public class Q58 {
    public static void main(String[] args) {
        float targetRatio= 0.1f;
        float primecount=0;
        float totalcount=1;
        long n=1;
        while(true ){
            for (int i = 0; i < 4; i++) {
                if(Common.isPrimeClassic(n*n -i*n+i)){
                    primecount++;
                }


            }

            if(n!=1){
                totalcount+=4;
            }




            if(primecount/totalcount<targetRatio &&n>7){
                break;
            }
            n+=2;

        }
        System.out.println("n = "+n);
        System.out.println("prime count = "+primecount);
        System.out.println("totalcount = "+totalcount);
        System.out.println("primecount/totalcount ="+primecount/totalcount);

    }
}
