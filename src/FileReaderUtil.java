import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files
import java.util.Vector;
/**
 * Reads data in target file
 * @throws IllegalArgumentException when the document was unreachable
 */
public class FileReaderUtil {
    public Vector<Token> ReadFile(String target) {
        File myObj = new File(target);
        Vector<Token> ans = new Vector<>();
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(" ");
                try{
                    ans.add(new Token((String) data[0],(String) data[1],(Float) Float.valueOf(data[2])));
                }
                catch (IllegalArgumentException _){}
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Couldn't read the document");
        }
        return ans;
    }
}