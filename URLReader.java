import java.io.*;
import java.util.ArrayList;
import java.net.*;


public class URLReader {
    public static ArrayList<String> readReturnArrayList(String fileName) {
        ArrayList<String> urlList = new ArrayList<String>();
        String inputLine;
        try {
            URL myObj = new URL(fileName);
            BufferedReader myReader = new BufferedReader(new InputStreamReader(myObj.openStream()));
            while ((inputLine = myReader.readLine()) != null)
                urlList.add(inputLine);
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred reading the URL.");
            e.printStackTrace();
        }
        return urlList;
    }
}
