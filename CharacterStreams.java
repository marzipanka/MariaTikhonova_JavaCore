import java.io.*;

public class CharacterStreams {

    public static void main(String[] args) throws IOException {
        KeyWords kWords = new KeyWords();
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("C:/Users/maria/streams/src/input.txt");
            outputStream = new FileWriter("C:/Users/maria/streams/src/output.txt");

            int c;
            String str = "";

            //чтение символов и подсчет ключевых слов
            while ((c = inputStream.read()) != -1) {
                str = kWords.countKeyWords(c, str, kWords);
            }

            //вывод встреченных ключевых слов и их кол-ва в файл
            kWords.writeKeyWordsChar(outputStream, kWords);
        }
        catch (FileNotFoundException exc) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("I/O exception");
        }

         finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
