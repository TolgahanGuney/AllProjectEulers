
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner;
public class FileReader
{ public static ArrayList readReturnArrayList(String fileName) {
    ArrayList fileList = new ArrayList();
    try {
        File myObj = new File(fileName);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            fileList.add(data);
        }
        myReader.close();
    } catch (Exception e) {
        System.out.println("An error occurred reading the file.");
        e.printStackTrace();
    }
    return fileList;
}
}
