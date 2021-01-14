
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;


/* Task #A1
        Create a code that will output each of the one-day headers from a task_A1.html file in the same way.

        Sample output:
        10-10-2017    DEMAND (B.C)    GENERATION(1234,56)    MOTORES DIESEL    TURBINA DE GAS    FUEL Y GAS    CICLO COMBINADO    GENERACIóN.AUXILIAR
        10-10-2017    DEMAND (B.C)    GENERATION(1234,56)    MOTORES DIESEL    TURBINA DE GAS    FUEL Y GAS    CICLO COMBINADO    GENERACIóN.AUXILIAR
        10-10-2017    DEMAND (B.C)    GENERATION(1234,56)    MOTORES DIESEL    TURBINA DE GAS    FUEL Y GAS    CICLO COMBINADO    GENERACIóN.AUXILIAR
*/

public class taskA1 {
    static final File task = new File("C:\\Users\\xxxxxxx\\Desktop\\task_A1.html");
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.parse(task, "UTF-8","http://whatever.com");
            Elements tables = doc.select("table");
            for (Element table : tables) {
                Element tableBody = table.selectFirst("tbody");
                for (Node tr : tableBody.childNodes()) {
                    if (!(tr instanceof TextNode)) {
                        for (Node th : tr.childNodes()) {
                            System.out.println(th.toString());
                            // System.out.println(th.toString());
                        }
                    }
                }
            }
            System.out.println("Jsoup way");
            Elements specificRows = doc.select("th:contains(2017/10/10)");

            for (Element r : specificRows) {
                System.out.println(r.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
