public class Notepad {

    //массив для хранения записей
    private Note[] notes;

    //lastEmpty отвечает за последнюю свободную ячейку массива
    private  int lastEmpty;

    public static final int ARRAY_SIZE = 10;

    public Notepad() {
        notes = new Note[ARRAY_SIZE];
        lastEmpty = 0;
    }


    //создать запись
    public void create(String headline, String text) {
        notes[lastEmpty] = new Note(headline, text);
         lastEmpty++;

         /*
         Проверяем, заканчивается ли место в массиве.
         Если закончилось, то увеличиваем размер массива на 10.
         Переписываем исходный массив во вспомогательный массив, и из вспомогательного в исходный уже расширенный.
          */
        if (lastEmpty == notes.length-1) {
            Note[] extraArr = new Note[lastEmpty];
            for (int i = 0; i < lastEmpty; i++) {
                extraArr[i] = notes[i];
            }
            notes = new Note[lastEmpty + ARRAY_SIZE];
            for (int i = 0; i < lastEmpty; i++) {
                notes[i] = extraArr[i];
            }
        }
    }

    //удалить запись
     public void delete(int number) {

         //переписываем массив
        for (int i = number - 1; i < lastEmpty - 1; i++) {
            notes[i] = notes[i+1];
        }

         //ввиду того, что одну запись удалили, последняя свободная ячейка сдвигается на -1
        lastEmpty--;

        /*
         Проверка оставшегося места в массиве.
         Если оно больше, чем половина массива, то массив ужимается в 2 раза.
         Переписываем исходный массив во вспомогательный массив, и из вспомогательного в исходный с измененным размером.
          */
        if(notes.length-lastEmpty > notes.length/2) {
            int newLength = notes.length/2;
            Note[] extraArr = new Note[lastEmpty];
            for (int i = 0; i < lastEmpty; i++) {
                extraArr[i] = notes[i];
            }
            notes = new Note[newLength];
            for (int i = 0; i < lastEmpty; i++) {
                notes[i] = extraArr[i];
            }
         }
    }

    //редактировать заголовок
     public void setHeadline(int number, String headline) {
         notes[number-1].setHeadline(headline);
    }

    //редактировать текст
    public void setText(int number, String text) {
        notes[number-1].setText(text);
    }

    //посмотреть все записи
     public void seeAll() {
        System.out.println("Список ваших записей:");
       for(int i = 0; i < lastEmpty; i++) {
            System.out.println((i+1) + " - " + notes[i].getHeadline());
           System.out.println("    " + notes[i].getText());
        }

    }

}