import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
/*
*Task #A5
"Get the text file. Create an appication which outputs storm name and maximum sustained wind-speed in knots for each of the storms after 2015 with name ending with A
* Format description: http://www.nhc.noaa.gov/data/hurdat/hurdat2-format-nencpac.pdf
* Hurricane tracks file: http://www.nhc.noaa.gov/data/hurdat/hurdat2-nepac-1949-2016-041317.txt
*  method: parserPdfToTxt has error
*
* */

public class taskA5 {

    private static String filename = "https://www.nhc.noaa.gov/data/hurdat/hurdat2-format-nencpac.pdf";

    public static void main(String arg[]) {
        // extract only values to output
        pdfReader(filename);
        //pdfReaderAnother(filename);
        //parserPdfToTxt(filename);
    }

    static void pdfReader(String filename) {
        try {
            PdfReader reader = new PdfReader(filename);
            int n = reader.getNumberOfPages();
            String str = PdfTextExtractor.getTextFromPage(reader, 2); //Extracting the content from a particular page.
            System.out.println(str);
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void pdfReaderAnother(String filename) {
        try {

            PdfReader reader = new PdfReader(filename);
            System.out.println("This PDF has " + reader.getNumberOfPages() + " pages.");
            String page = PdfTextExtractor.getTextFromPage(reader, 2);
            System.out.println("Page Content:\n\n" + page + "\n\n");
            System.out.println("Is this document tampered: " + reader.isTampered());
            System.out.println("Is this document encrypted: " + reader.isEncrypted());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void parserPdfToTxt(String filename) {
        // SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
        // dependency updated but it's still error
        try {
            File f = new File(filename);
            String parsedText;
            PDFParser parser = new PDFParser((RandomAccessRead) new RandomAccessFile(f, "r"));
            parser.parse();
            COSDocument cosDoc = parser.getDocument();
            PDFTextStripper pdfStripper = new PDFTextStripper();
            PDDocument pdDoc = new PDDocument(cosDoc);
            parsedText = pdfStripper.getText(pdDoc);
            PrintWriter pw = new PrintWriter("src/output/pdf.txt");
            pw.print(parsedText);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
