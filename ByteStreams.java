import java.io.*;

public class ByteStreams {

    public static void main(String[] args) throws IOException {

        KeyWords kw = new KeyWords();
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("C:/Users/maria/streams/src/input.txt");
            out = new FileOutputStream("C:/Users/maria/streams/src/output.txt");
            int c;
            String str = "";

            //чтение символов и подсчет ключевых слов
            while ((c = in.read()) != -1) {

                str = kw.countKeyWords(c, str, kw);

            }

            //вывод встреченных ключевых слов и их кол-ва в файл
            kw.writeKeyWordsByte(out, kw);
        }
        catch (FileNotFoundException exc) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("I/O exception");
        }
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }
}
