import java.util.Scanner;

public class ConsoleNotepad {
    public static void main(String[] args) {
        System.out.println("   Добро пожаловать в блокнот!\n");
        Notepad notepad = new Notepad();
        menu(notepad);
    }


    public static void menu(Notepad notepad) {
        System.out.println("------------Меню------------");
        System.out.println("   1 - создать запись");
        System.out.println("   2 - удалить запись");
        System.out.println("   3 - редактировать запись");
        System.out.println("   4 - посмотреть все записи");
        System.out.println("   5 - выйти из блокнота");
        System.out.println("\n Введите цифру от 1 до 5.");

        int choice = scanNumber();

        switch (choice) {
            case 1:                      //создать запись
                System.out.println("Введите заголовок и текст записи.");
                String headline = scanText();
                String text = scanText();
                notepad.create(headline, text);
                menu(notepad);
                break;

            case 2:                     //удалить запись
                notepad.seeAll();
                System.out.println("Введите номер записи, которую хотите удалить.");
                int number = scanNumber();
                notepad.delete(number);
                menu(notepad);
                break;

            case 3:                       //редактировать запись
                notepad.seeAll();
                System.out.println("Введите номер записи, которую хотите отредактировать, а затем новый заголовок и текст.");
                int num = scanNumber();
                String head = scanText();
                String txt = scanText();
                notepad.edit(num, head, txt);
                menu(notepad);
                break;

            case 4:                         //посмотреть все записи
                notepad.seeAll();
                menu(notepad);
                break;

            case 5:
                System.out.println("До свидания!");       //выход из проги
                System.exit(0);

            default:
                System.out.println("Неправильный ввод. Введите цифру от 1 до 5.");
                menu(notepad);

        }
    }

        public static int scanNumber () {
            Scanner in = new Scanner(System.in);
            try {
                int number = in.nextInt();
                return number;
            }
            catch (java.util.InputMismatchException e) {
                return 0;
            }
        }

        public static String scanText () {
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            return text;
        }

    }

