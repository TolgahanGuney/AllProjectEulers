import java.util.ArrayList;

public class Q23 {
    public static void main(String[] args) {
        System.out.println(Common.isabundantNumber(12));
        ArrayList<Integer> abundantList = new ArrayList<Integer>();
        for (int i = 0; i <= 28123; i++) {
            if(Common.isabundantNumber(i)){
                abundantList.add(i);
            }

        }
        long sum = 0;

        for (int i = 0; i < 28123; i++) {
            if(!sumOfTwoAbundantNumbers(i, abundantList)){
                sum += i;

            }

        }
        System.out.println(sum);










    }
    public static boolean sumOfTwoAbundantNumbers(int n,ArrayList<Integer> abundantList) {
        for (int j = 0; j < abundantList.size(); j++) {
            if (abundantList.contains(n-abundantList.get(j))){
                return true;

            }

        }
        return false;
    }
}
