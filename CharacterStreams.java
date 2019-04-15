public class CharacterStreams {

    public static void main(String[] args) {
        KeyWords kw = new KeyWords();
        String text = kw.readFileChar("C:/Users/maria/streams/src/input.txt");
        kw = kw.countKeyWords(kw, text);
        kw.writeKeyWordsChar("C:/Users/maria/streams/src/output.txt", kw);
    }
}
