import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
        Task #SQL2
        Using a table below write a SQL commands that:
        •	Will find any customers that ordered more than 200 tones of the product and is from the UK.
        •	Will update the type of the product to corn for client with id=2
        •	Get the total amount for UK
        Table 1: ORDERS
        ID	ContactName	Address	City	PostalCode	Country	Amount[tones]	Type
        1	Schmidt GmbH	Obere,Str. 57	Frankfurt	12209	Germany	150	Barley
        2	Meraux	Avda. de la Constitucion 2222	Paris	05021	France	24	Soybean
        3	Petersen A/S	Sundvej 2312	Aarhus	05023	Denmark	89	Cotton
        4	Hardy Co.	120 Hanover Sq.	London	WA1 1DP	UK	32	Potato
        5	Berglund	Berguvsvägen 8	Luleå	S-958 22	Sweden	78	Cotton
        6	Fonda,Commodities	Mosley,Street 11	Manchester	M2 3JL	UK	220	Early Rice
        5	McBoatie	Baker Street 21	London	81-3782	UK	78	Onion

*/

public class taskA2 {

    public static void main(String... args) {

        try {
            String strCurrentLine;
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/sql.txt"));

            // read your file
            while ((strCurrentLine = br.readLine()) != null) {

                System.out.println(strCurrentLine);
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
