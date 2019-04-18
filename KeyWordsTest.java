import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
        String text = KeyWords.readFileByte("C:/Users/maria/streams/src/fileWithCode.txt");
        assertEquals("public class Hello { \r\n public static void main(String[] args) { \r\n } }", text);
    }

    @Test
    public void readFileCharMethodReturnsProperText() {
        String text = KeyWords.readFileChar("C:/Users/maria/streams/src/fileWithCode.txt");
        assertEquals("public class Hello { \r\n public static void main(String[] args) { \r\n } }", text);
    }

    @Test
    public void keyWordsAreWrittenWithByteStreams() {
        String text = KeyWords.readFileByte("C:/Users/maria/streams/src/fileWithCode.txt");
        Map<String, Integer> keyWordsMap = new HashMap<>();
        keyWordsMap = KeyWords.countKeyWords(text);
        KeyWords.writeKeyWordsByte("C:/Users/maria/streams/src/fileForOutput.txt", keyWordsMap);
        String result = KeyWords.readFileByte("C:/Users/maria/streams/src/fileForOutput.txt");
        String expectation = "Powered with byte streams\r\nstatic 1\r\nvoid 1\r\npublic 2\r\nclass 1\r\n";
        assertEquals(expectation, result);
    }

    @Test
    public void keyWordsAreWrittenWithCharStreams() {
        String text = KeyWords.readFileByte("C:/Users/maria/streams/src/fileWithCode.txt");
        Map<String, Integer> keyWordsMap = new HashMap<>();
        keyWordsMap = KeyWords.countKeyWords(text);
        KeyWords.writeKeyWordsChar("C:/Users/maria/streams/src/fileForOutput.txt", keyWordsMap);
        String result = KeyWords.readFileChar("C:/Users/maria/streams/src/fileForOutput.txt");
        String expectation = "Powered with character streams\r\nstatic 1\r\nvoid 1\r\npublic 2\r\nclass 1\r\n";
        assertEquals(expectation, result);
    }

}
