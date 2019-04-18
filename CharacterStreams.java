import java.util.HashMap;
import java.util.Map;

public class CharacterStreams {

    public static void main(String[] args) {
        Map<String, Integer> keyWordsMap = new HashMap<>();
        String text = KeyWords.readFileChar("C:/Users/maria/streams/src/input.txt");
        keyWordsMap = KeyWords.countKeyWords(text);
        KeyWords.writeKeyWordsChar("C:/Users/maria/streams/src/output.txt", keyWordsMap);
    }
}
