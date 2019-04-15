public class ByteStreams {

    public static void main(String[] args)  {
        KeyWords kw = new KeyWords();
        String text = kw.readFileByte("C:/Users/maria/streams/src/input.txt");
        kw = kw.countKeyWords(kw, text);
        kw.writeKeyWordsByte("C:/Users/maria/streams/src/output.txt", kw);
    }
}
