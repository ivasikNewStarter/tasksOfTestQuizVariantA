import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*Create an application that will load text from file task_B4.txt
and print out all the countries which GDP is a prime number,
ordered alphabetically and in clear format (without info in braces “[n 1][19]” ) .*/

public class taskB4 {
    private static String filename = "\\C:\\Users\\xxxxxxxx\\Desktop\\task_B4.txt";

    public static void read(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            ArrayList<String> list = new ArrayList<>();
            String st;
            while ((st = br.readLine()) != null) {
                list.add(st.replaceAll("\\[.*\\]", ""));
            }
            Arrays.sort(new ArrayList[]{list}, Collections.reverseOrder());//does not sort DESC
            Arrays.sort(new ArrayList[]{list});// does not sort ASC
            for (String s : list) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        read(filename);
    }
}
