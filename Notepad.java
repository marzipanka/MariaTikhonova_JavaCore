import java.util.Scanner;

public class Notepad {
    static String[] arr = new String[10];      //массив для хранения записей
    static int lastEmpty = 0;           //lastEmpty отвечает за последнюю свободную ячейку массива

    public static void main(String[] args) {
        System.out.println("   Добро пожаловать в блокнот!\n");
        menu();
    }

    public static void menu() {
        System.out.println("------------Меню------------");
        System.out.println("   1 - создать запись");
        System.out.println("   2 - удалить запись");
        System.out.println("   3 - редактировать запись");
        System.out.println("   4 - посмотреть все записи");
        System.out.println("   5 - выйти из блокнота");
        System.out.println("\n Введите цифру от 1 до 5.");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();                      //узнаём, что хочет сделать пользователь
        System.out.printf("Вы выбрали: %d \n", choice);

        switch (choice) {
            case 1:                      //создать запись
                Note.create();
                menu();
                break;

            case 2:                     //удалить запись
                Note.delete();
                menu();
                break;

            case 3:                       //редактировать запись
                Note.edit();
                menu();
                break;

            case 4:                         //посмотреть все записи
                Note.seeAll();
                menu();
                break;

            case 5:
                System.out.println("До свидания!");       //выход из проги
                System.exit(0);

            default:
                System.out.println("Неправильный ввод. Введите цифру от 1 до 5.");
                menu();
        }
    }
}

class Note {                                     //класс со всеми методами, которые можно выполнять с записями
    public static void create() {                                        //создать запись
        System.out.println("Введите вашу запись и нажмите Enter: ");
        Scanner in = new Scanner(System.in);
        Notepad.arr[Notepad.lastEmpty] = in.nextLine();
        Notepad.lastEmpty++;

        if (((Notepad.lastEmpty+1)%10)==0) {                    //проверяем, заканчивается ли место в массиве
            String[] extraArr = new String[Notepad.arr.length];  //если закончилось, то увеличиваем размер массива на 10
            for (int i = 0; i < Notepad.arr.length; i++) {
                extraArr[i] = Notepad.arr[i];                  //переписываем исходный массив во вспомогательный массив
            }
            Notepad.arr = new String[Notepad.arr.length + 10];
            for (int i = 0; i < extraArr.length; i++) {
                Notepad.arr[i] = extraArr[i];         //и из вспомогательного в наш родненький уже расширенный
            }
        }
    }

    public static void delete() {                    //удалить запись
        seeAll();                               //пусть пользователь освежит у себя в памяти, что он вообще писал
        System.out.println("Введите номер записи, которую вы хотите удалить:");
        Scanner in = new Scanner(System.in);
        int deleteIndex = in.nextInt();
        for (int i = deleteIndex - 1; i < Notepad.arr.length - 1; i++) {       //переписываем массив
            Notepad.arr[i] = Notepad.arr[i+1];
        }
        Notepad.lastEmpty--;   //ввиду того, что одну запись удалили, последняя свободная ячейка сдвигается на -1

    }

    public static void edit() {                      //редактировать запись
        seeAll();                             //показываем пользователю все записи
        System.out.println("Введите номер записи, которую вы хотите отредактировать:");
        Scanner in = new Scanner(System.in);
        int editIndex = in.nextInt();
        System.out.println("Введите новую запись");
        Notepad.arr[editIndex-1] = in.nextLine();
        Notepad.arr[editIndex-1] = in.nextLine();

    }

    public static void seeAll() {           //посмотреть все записи
        System.out.println("Список ваших записей:");
        for(int i = 0; i < Notepad.lastEmpty; i++) {
            System.out.println((i+1) + " - " + Notepad.arr[i]);
        }
    }
        }
