public class Q44 {
    public static void main(String[] args) {
        System.out.println(Common.getPentagonalNumber(5));
        System.out.println(Common.whichPentagonalNumber(35));
        System.out.println(Common.isPentagonalNumber(34   ));
        long smallestD =10000000;
        for (int a = 1; a < 50000; a++) {
            for (int b = a+1; b <= a+5000; b++) {

                if (Common.isPentagonalNumber(Common.getPentagonalNumber(a)+Common.getPentagonalNumber(b))&&Common.isPentagonalNumber(Math.abs( Common.getPentagonalNumber(a)-Common.getPentagonalNumber(b)))&&Math.abs( Common.getPentagonalNumber(a)-Common.getPentagonalNumber(b))<smallestD) {
                    smallestD = Math.abs( Common.getPentagonalNumber(a)-Common.getPentagonalNumber(b));
                    System.out.println(a);

                }
            }

        }
        System.out.println(smallestD);
    }
}
