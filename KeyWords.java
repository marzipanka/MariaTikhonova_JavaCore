import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class KeyWords {
    private Map<String, Integer> keyWordsMap = new HashMap<>();

    KeyWords() {
        keyWordsMap.put("abstract", 0);
        keyWordsMap.put("assert", 0);
        keyWordsMap.put("boolean", 0);
        keyWordsMap.put("break", 0);
        keyWordsMap.put("byte", 0);
        keyWordsMap.put("case", 0);
        keyWordsMap.put("catch", 0);
        keyWordsMap.put("char", 0);
        keyWordsMap.put("class", 0);
        keyWordsMap.put("const", 0);
        keyWordsMap.put("continue", 0);
        keyWordsMap.put("default", 0);
        keyWordsMap.put("do", 0);
        keyWordsMap.put("double", 0);
        keyWordsMap.put("else", 0);
        keyWordsMap.put("enum", 0);
        keyWordsMap.put("extends", 0);
        keyWordsMap.put("final", 0);
        keyWordsMap.put("finally", 0);
        keyWordsMap.put("float", 0);
        keyWordsMap.put("for", 0);
        keyWordsMap.put("goto", 0);
        keyWordsMap.put("if", 0);
        keyWordsMap.put("implements", 0);
        keyWordsMap.put("import", 0);
        keyWordsMap.put("instanceof", 0);
        keyWordsMap.put("int", 0);
        keyWordsMap.put("interface", 0);
        keyWordsMap.put("long", 0);
        keyWordsMap.put("native", 0);
        keyWordsMap.put("new", 0);
        keyWordsMap.put("package", 0);
        keyWordsMap.put("private", 0);
        keyWordsMap.put("protected", 0);
        keyWordsMap.put("public", 0);
        keyWordsMap.put("return", 0);
        keyWordsMap.put("short", 0);
        keyWordsMap.put("static", 0);
        keyWordsMap.put("strictfp", 0);
        keyWordsMap.put("super", 0);
        keyWordsMap.put("switch", 0);
        keyWordsMap.put("synchronized", 0);
        keyWordsMap.put("this", 0);
        keyWordsMap.put("throw", 0);
        keyWordsMap.put("throws", 0);
        keyWordsMap.put("transient", 0);
        keyWordsMap.put("try", 0);
        keyWordsMap.put("void", 0);
        keyWordsMap.put("volatile", 0);
        keyWordsMap.put("while", 0);
    }

    //Метод для проверки соответствия поступающей строки регулярному выражению.
    //Если она соответствует, то проверяем, есть ли такой ключ в нашем Map-e.
    //Если такой ключ есть, то обнуляем строку.
    //Если не соответствует, то тоже обнуляем строку, т.к. это значит, что нам попался какой-то небуквенный символ.
    public String countKeyWords(int c, String str, KeyWords kw) {

        if (Pattern.matches("[a-z]", (char)c+"")) {
            str = str + (char)c;

            if(kw.keyWordsMap.containsKey(str)) {
                kw.keyWordsMap.put(str, kw.keyWordsMap.get(str)+1);
                str = "";
                return str;
            }
        }
        else {
            str = "";
        }
        return str;
    }

    //Функция для вывода ключевых слов в файл с помощью байтовых потоков.
    //Выводятся все ключи, у которых value > 0.
    public void writeKeyWordsByte(FileOutputStream out, KeyWords kw) {
        try {
            String message = "Были использованы байтовые потоки";
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
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    //Функция для вывода ключевых слов в файл с помощью символьных потоков.
    //Выводятся все ключи, у которых value > 0.
    public void writeKeyWordsChar(FileWriter out, KeyWords kw) {
        try {
            out.write("Были использованы символьные потоки\r\n");
            for (String key : kw.keyWordsMap.keySet()) {
                int value = kw.keyWordsMap.get(key);
                if (value > 0) {
                    out.write(key + " " + value + "\r\n");
                }
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
