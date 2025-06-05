import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        String namus = "guerrero";
        String resulto="";

        char[] smo= namus.toCharArray();
        for (int i = 0; i < smo.length; i++) {




            resulto= resulto+(char) (smo[i]+ smo.length-1);
        }
        String newnamus= new String(smo);


        System.out.println(resulto);
    }



}
