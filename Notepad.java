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
        if (lastEmpty%10==0) {
            Note[] extraArr = new Note[notes.length];
            for (int i = 0; i < notes.length; i++) {

            }
            notes = new Note[notes.length + ARRAY_SIZE];
            for (int i = 0; i < extraArr.length; i++) {
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
    }

    //редактировать заголовок
     public void editHeadline(int number, String headline) {
         notes[number-1] = new Note(headline, notes[number-1].getText());
    }

    //редактировать текст
    public void editText(int number, String text) {
        notes[number-1] = new Note(notes[number-1].getHeadline(), text);
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