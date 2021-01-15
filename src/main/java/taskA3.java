import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/*
 * Task #A3
 * Write an application that downloads the page from (http://www.mercado.ren.pt/EN/Electr/MarketInfo/Gen/Pages/Forecast.aspx) and prints the amount of energy,
 * the source from which it was produced and if it’s forecast or actual value.
 * Note, that black numbers are actual data, green ones – forecast.

 * The output should follow the format:
 * Actual: HH Wind:<amount of energy created from "Wind"> Solar:<amount of energy created from "Solar"> Others:<amount of energy created from "Others">
 * Forecast: HH Wind:<amount of energy created from "Wind"> Solar:<amount of energy created from "Solar"> Others:<amount of energy created from "Others">
 */
public class taskA3 {
    static final String url = "https://www.mercado.ren.pt/EN/Electr/MarketInfo/Gen/Pages/Forecast.aspx";

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements rows = doc.select("tr");
        for (Element row : rows) {
            Elements columns = row.select("tr");
            for (Element column : columns) {
                System.out.println(column.text());

            }
            System.out.println(" ");
        }
    }
}
