public class Notepad {

    static Note[] arr;      //массив для хранения записей
    static int lastEmpty;           //lastEmpty отвечает за последнюю свободную ячейку массива

    Notepad() {
        arr = new Note[10];
        lastEmpty = 0;
    }

    public static void create(String headline, String text) {                                        //создать  запись
         arr[lastEmpty] = new Note(headline, text);
         lastEmpty++;

        if (((Notepad.lastEmpty+1)%10)==0) {                    //проверяем, заканчивается ли место в массиве
            Note[] extraArr = new Note[arr.length];  //если закончилось, то увеличиваем размер массива на 10
            for (int i = 0; i < arr.length; i++) {
                extraArr[i] = arr[i];                  //переписываем исходный массив во вспомогательный массив
            }
            Notepad.arr = new Note[arr.length + 10];
            for (int i = 0; i < extraArr.length; i++) {
                arr[i] = extraArr[i];         //и из вспомогательного в наш родненький уже расширенный
            }
        }
    }

    public static void delete(int number) {                    //удалить запись
        for (int i = number - 1; i < arr.length - 1; i++) {       //переписываем массив
            arr[i] = arr[i+1];
        }
        lastEmpty--;   //ввиду того, что одну запись удалили, последняя свободная ячейка сдвигается на -1
    }

    public static void edit(int number, String headline, String text) {                      //редактировать запись
        arr[number-1] = new Note(headline, text);

    }

    public static Note[] seeAll() {           //посмотреть все записи
        System.out.println("Список ваших записей:");
       // for(int i = 0; i < Notepad.lastEmpty; i++) {
       //     System.out.println((i+1) + " - " + Notepad.arr[i]);
       // }
        return arr;
    }

}
