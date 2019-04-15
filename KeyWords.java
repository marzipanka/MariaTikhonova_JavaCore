import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.lang.model.SourceVersion;

public class KeyWords {

    private Map<String, Integer> keyWordsMap = new HashMap<>();

    //Функция, считывающая весь файл с помощью байтовых потоков и возвращающая содержание файла в виде текста.
    public String readFileByte(String fileName) {
        try(FileInputStream in = new FileInputStream(fileName)) {
            int c;
            StringBuilder stringBuilder = new StringBuilder();
            while ((c = in.read()) != -1) {
                stringBuilder.append((char)c);
            }
            return stringBuilder.toString();
        } catch(FileNotFoundException e) {
            System.out.println(e + ": " + fileName);
        } catch(IOException ex) {
            System.out.println(ex);
        }
        return "";
    }


    //Функция, считывающая весь файл с помощью символьных потоков и возвращающая содержание файла в виде текста.
    public String readFileChar(String fileName) {
        try(FileReader in = new FileReader(fileName)) {
            int c;
            StringBuilder stringBuilder = new StringBuilder();
            while ((c = in.read()) != -1) {
                stringBuilder.append((char)c);
            }
            return stringBuilder.toString();
        } catch(FileNotFoundException e) {
            System.out.println(e + ": " + fileName);
        } catch(IOException ex) {
            System.out.println(ex);
        }
        return "";
    }


    //В методе проверяется, является ли поступающая строка словом.
    //Если является, то проверяем, является ли оно ключевым словом языка Java.
    //Если в нашем Map-е уже есть такое ключевое слово, увеличиваем его value на 1.
    //Если это его первое попадание в Map, то value устанавливается равным 1.
    public KeyWords countKeyWords(KeyWords kw, String str) {
        Pattern p = Pattern.compile("\\b[a-z]*\\b");
        Matcher m = p.matcher(str);

        while (m.find()) {
            String word = str.substring(m.start(), m.end());
            if (SourceVersion.isKeyword(word)) {
                if (kw.keyWordsMap.containsKey(word)) {
                    kw.keyWordsMap.put(word, kw.keyWordsMap.get(word) + 1);
                } else {
                    kw.keyWordsMap.put(word, 1);
                }
            }
        }
        return kw;
    }


    //Функция для вывода ключевых слов в файл с помощью байтовых потоков.
    public void writeKeyWordsByte(String fileName, KeyWords kw) {

        try(FileOutputStream out = new FileOutputStream(fileName)) {
            String message = "Powered with byte streams";
            out.write(message.getBytes());
            out.write("\r\n".getBytes());
            for (String key : kw.keyWordsMap.keySet()) {
                int value = kw.keyWordsMap.get(key);
                if (value > 0) {
                    out.write(key.getBytes());
                    out.write(" ".getBytes());
                    String valueStr = value + "";
                    out.write(valueStr.getBytes());
                    out.write("\r\n".getBytes());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e + ": " + fileName);
        } catch(IOException ex) {
            System.out.println(ex);
        }
    }


    //Функция для вывода ключевых слов в файл с помощью символьных потоков.
    public void writeKeyWordsChar(String fileName, KeyWords kw) {

        try(FileWriter out = new FileWriter(fileName)) {
            out.write("Powered with character streams\r\n");
            for (String key : kw.keyWordsMap.keySet()) {
                    out.write(key + " " + kw.keyWordsMap.get(key) + "\r\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e + ": " + fileName);
        } catch(IOException ex) {
            System.out.println(ex);
        }


    }
}
