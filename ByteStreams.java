import java.util.HashMap;
import java.util.Map;

public class ByteStreams {

    public static void main(String[] args)  {
        Map<String, Integer> keyWordsMap = new HashMap<>();
        String text = KeyWords.readFileByte("C:/Users/maria/streams/src/input.txt");
        keyWordsMap = KeyWords.countKeyWords(text);
        KeyWords.writeKeyWordsByte("C:/Users/maria/streams/src/output.txt", keyWordsMap);
    }
}
