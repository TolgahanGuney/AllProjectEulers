import java.util.*;
//TODO:Understand this shi, I have no fucking idea.
public class Q26 {
    public static void main(String[] args) {


        int maxCycle=0;
        int maxCycleNumber=0;
        for(int i=1;i<1000;i++) {
            int result = getLongDivisionCycleLength(i);
            if(result>maxCycle) {
                maxCycle = result;
                maxCycleNumber = i;
            }

        }
        System.out.println("max cycle number "+maxCycleNumber);
        System.out.println("max cycle length "+maxCycle);

    }

    public static int getLongDivisionCycleLength(int denominator) {
        int numerator = 10;
        List<Integer> digits = new ArrayList<>();
        List<Integer> remainders = new ArrayList<>();
        int cur = numerator;

        while (true) {
            int digit = cur / denominator;
            cur = cur % denominator;
            if (remainders.contains(cur)) {
                break;
            }
            digits.add(digit);
            remainders.add(cur);
            cur *= 10;
            if (cur == 0) {
                return 0;
            }
            while (cur < denominator) {
                cur *= 10;
                digits.add(0);
            }
        }

        while (remainders.get(0) != cur) {
            remainders.remove(0);
        }

        return remainders.size();
    }

}