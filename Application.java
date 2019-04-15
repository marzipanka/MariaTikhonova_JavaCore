import java.io.*;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в приложение!");
        FilmCollection filmCollection = new FilmCollection();

        //проверка, была ли уже сериализована коллекция фильмов
        if (objectInput("file") != null) {
            filmCollection = objectInput("file");
        }
        menu(filmCollection);
    }

    public static void menu(FilmCollection filmCollection) {
        System.out.println("-------— Меню —--------");
        System.out.println("1 - добавить новый фильм");
        System.out.println("2 - редактировать фильм");
        System.out.println("3 - удалить фильм");
        System.out.println("4 - посмотреть все фильмы");
        System.out.println("5 - выйти из программы");
        System.out.println("-------------------------");
        System.out.println("Введите цифру от 1 до 5.");

        int choice = scanNum();

        switch (choice) {

            //добавить новый фильм
            case 1:
                System.out.println("Введите название фильма");
                String name = scanString();
                System.out.println("Сколько главных ролей в вашем фильме?");
                int number = scanNum();
                Film film = new Film(name);
                for (int i = 0; i < number; i++) {
                    System.out.println("Введите имя актера");
                    String actorName = scanString();
                    film.addActor(actorName);
                }
                filmCollection.addFilm(film);
                menu(filmCollection);
                break;

            // редактировать фильм
            case 2:
                filmCollection.seeAll();
                System.out.println("Фильм под каким номером вы хотите отредактировать?");
                int editNum = scanNum();
                System.out.println("Если хотите отредактировать название фильма, нажмите 1, если список актеров - нажмите 2.");
                int n = scanNum();
                switch (n) {
                    case 1:
                        System.out.println("Введите новое название фильма.");
                        String newName = scanString();
                        filmCollection.editNameOfTheFilm(editNum-1, newName);
                        break;
                    case 2:
                        filmCollection.removeAllTheActors(editNum);
                        System.out.println("Введите количество актеров.");
                        int numOfActors = scanNum();
                        for (int i = 0; i < numOfActors; i++) {
                            System.out.println("Введите имя актера");
                            String actorName = scanString();
                           filmCollection.addNewActor(editNum, actorName);
                        }
                        break;
                    default:
                        System.out.println("Неправильный ввод");
                        menu(filmCollection);
                        break;
                }
                menu(filmCollection);
                break;

            //удалить фильм
            case 3:
                filmCollection.seeAll();
                System.out.println("Фильм под каким номером вы хотите удалить?");
                int deleteIndex = scanNum();
                filmCollection.deleteFilm(deleteIndex);
                menu(filmCollection);
                break;

            //посмотреть все фильмы
            case 4:
                filmCollection.seeAll();
                menu(filmCollection);
                break;

            //выйти из программы
            case 5:
                System.out.println("До свидания!");
                objectOutput(filmCollection, "file");
                System.exit(0);

            default:
                System.out.println("Неправильный ввод. Введите цифру от 1 до 5.");
                menu(filmCollection);
        }
    }


        private static int scanNum() {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            return n;
        }

        private static String scanString () {
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            return str;
        }

        //десериализация
        public static FilmCollection objectInput (String fileName) {
            try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis)) {

                FilmCollection filmCollection = (FilmCollection) ois.readObject();
                return filmCollection;
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException e) {
                System.out.println(e);
            }
            return null;
        }

        //сериализация
        public static void objectOutput (FilmCollection filmCollection, String fileName) {
            try(FileOutputStream fos = new FileOutputStream(fileName); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(filmCollection);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
