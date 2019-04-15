import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.io.*;

public class KeyWordsTest {

    @BeforeAll
    public static void gettingReadyForTesting() {
        byte data[] = "public class Hello { \r\n public static void main(String[] args) { \r\n } }".getBytes();

        try(FileOutputStream out = new FileOutputStream("C:/Users/maria/streams/src/fileWithCode.txt")) {
            out.write(data);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test
    public void readFileByteMethodReturnsProperText() {
        KeyWords kw = new KeyWords();

        String text = kw.readFileByte("C:/Users/maria/streams/src/fileWithCode.txt");
        assertEquals("public class Hello { \r\n public static void main(String[] args) { \r\n } }", text);
    }

    @Test
    public void readFileCharMethodReturnsProperText() {
        KeyWords kw = new KeyWords();

        String text = kw.readFileChar("C:/Users/maria/streams/src/fileWithCode.txt");
        assertEquals("public class Hello { \r\n public static void main(String[] args) { \r\n } }", text);
    }

    @Test
    public void keyWordsAreWrittenWithByteStreams() {
        KeyWords kw = new KeyWords();
        String text = kw.readFileByte("C:/Users/maria/streams/src/fileWithCode.txt");
        kw = kw.countKeyWords(kw, text);
        kw.writeKeyWordsByte("C:/Users/maria/streams/src/fileForOutput.txt", kw);
        String result = kw.readFileByte("C:/Users/maria/streams/src/fileForOutput.txt");
        String expectation = "Powered with byte streams\r\nstatic 1\r\nvoid 1\r\npublic 2\r\nclass 1\r\n";
        assertEquals(expectation, result);
    }

    @Test
    public void keyWordsAreWrittenWithCharStreams() {
        KeyWords kw = new KeyWords();
        String text = kw.readFileByte("C:/Users/maria/streams/src/fileWithCode.txt");
        kw = kw.countKeyWords(kw, text);
        kw.writeKeyWordsChar("C:/Users/maria/streams/src/fileForOutput.txt", kw);
        String result = kw.readFileChar("C:/Users/maria/streams/src/fileForOutput.txt");
        String expectation = "Powered with character streams\r\nstatic 1\r\nvoid 1\r\npublic 2\r\nclass 1\r\n";
        assertEquals(expectation, result);
    }

}
