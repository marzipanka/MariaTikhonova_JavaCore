import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.io.*;

public class KeyWordsTest {
    @Test
    public void keyWordsAreWrittenWithByteStreams() {
        KeyWords kw = new KeyWords();
        byte data[] = "public class Hello { \r\n public static void main(String[] args) { \r\n } }".getBytes();
        try {
            FileOutputStream out = new FileOutputStream("C:/Users/maria/streams/src/fileWithCode.txt");

            out.write(data);
            out.close();
            FileInputStream in = new FileInputStream("C:/Users/maria/streams/src/fileWithCode.txt");
            FileOutputStream output = new FileOutputStream("C:/Users/maria/streams/src/fileForOutput.txt");
            int c;
            String str = "";
            while ((c = in.read()) != -1) {

                str = kw.countKeyWords(c, str, kw);

            }

            kw.writeKeyWordsByte(output, kw);
            in.close();
            output.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        String expectation = "Были использованы байтовые потоки\r\nstatic 1\r\nvoid 1\r\npublic 2\r\nclass 1\r\n";
        int c;
        String str ="";
        try {
            FileReader inputStream = new FileReader("C:/Users/maria/streams/src/fileForOutput.txt");
            while ((c = inputStream.read()) != -1) {
                str = str + (char)c;
            }
            inputStream.close();

        }
        catch (IOException e) {
            System.out.println(e);
        }
        assertEquals(expectation, str);
    }

    @Test
    public void keyWordsAreWrittenWithCharStreams() {
        KeyWords kw = new KeyWords();
        String data = "public class Hello { \r\n public static void main(String[] args) { \r\n } }";
        try {
            FileWriter out = new FileWriter("C:/Users/maria/streams/src/fileWithCode.txt");

            out.write(data);
            out.close();
            FileReader in = new FileReader("C:/Users/maria/streams/src/fileWithCode.txt");
            FileWriter output = new FileWriter("C:/Users/maria/streams/src/fileForOutput.txt");
            int c;
            String str = "";
            while ((c = in.read()) != -1) {

                str = kw.countKeyWords(c, str, kw);

            }

            kw.writeKeyWordsChar(output, kw);
            in.close();
            output.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        String expectation = "Были использованы символьные потоки\r\nstatic 1\r\nvoid 1\r\npublic 2\r\nclass 1\r\n";
        int c;
        String str ="";
        try {
            FileReader inputStream = new FileReader("C:/Users/maria/streams/src/fileForOutput.txt");
            while ((c = inputStream.read()) != -1) {
                str = str + (char)c;
            }
            inputStream.close();

        }
        catch (IOException e) {
            System.out.println(e);
        }
        assertEquals(expectation, str);
    }

}
