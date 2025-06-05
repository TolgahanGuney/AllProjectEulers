
public class Q52 {

    //It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.</p>
    //Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
    public static void main(String[] args) {
        int n =1;
        while (true){
            int[] array=new int[6];

            for (int i = 1; i <7; i++) {
                array[i-1]=i*n;

            }
            if(containsSameDigits(array)){
                break;
            }
            n++;
        }
        System.out.println(n);

    }
    public static boolean containsSameDigits(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            String first = Common.sorted_String(String.valueOf(array[i]));
            String second = Common.sorted_String(String.valueOf(array[i+1]));
            if (!first.equals(second)) {
                return false;
            }

        }
        return true;
    }
}
