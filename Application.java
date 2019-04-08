import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в приложение!");
        ArrayList<Film> filmCollection = new ArrayList<>();

        //проверка, была ли уже сериализована коллекция фильмов
        if (objectInput() != null) {
            filmCollection = objectInput();
        }
        menu(filmCollection);
    }

    public static void menu(ArrayList<Film> filmCollection) {
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
                Film film = addFilm(name);
                for (int i = 0; i < number; i++) {
                    System.out.println("Введите имя актера");
                    String actorName = scanString();
                    film.addActor(actorName);
                }
                filmCollection.add(film);
                menu(filmCollection);
                break;

            // редактировать фильм
            case 2:
                seeAll(filmCollection);
                System.out.println("Фильм под каким номером вы хотите отредактировать?");
                int editNum = scanNum();
                System.out.println("Если хотите отредактировать название фильма, нажмите 1, если список актеров - нажмите 2.");
                int n = scanNum();
                switch (n) {
                    case 1:
                        System.out.println("Введите новое название фильма.");
                        String newName = scanString();
                        editNameOfTheFilm(filmCollection, editNum-1, newName);
                        break;
                    case 2:
                        filmCollection.get(editNum-1).removeActors();
                        System.out.println("Введите количество актеров.");
                        int numOfActors = scanNum();
                        for (int i = 0; i < numOfActors; i++) {
                            System.out.println("Введите имя актера");
                            String actorName = scanString();
                            filmCollection.get(editNum-1).addActor(actorName);
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
                seeAll(filmCollection);
                System.out.println("Фильм под каким номером вы хотите удалить?");
                int deleteIndex = scanNum();
                deleteFilm(filmCollection, deleteIndex-1);
                menu(filmCollection);
                break;

            //посмотреть все фильмы
            case 4:
                seeAll(filmCollection);
                menu(filmCollection);
                break;

            //выйти из программы
            case 5:
                System.out.println("До свидания!");
                objectOutput(filmCollection);
                System.exit(0);

            default:
                System.out.println("Неправильный ввод. Введите цифру от 1 до 5.");
                menu(filmCollection);
        }
    }

        public static Film addFilm (String name) {
            Film film = new Film(name);
            return film;
        }

        public static void editNameOfTheFilm (ArrayList<Film> filmCollection, int n, String name) {
            filmCollection.get(n).setFilmName(name);
        }

        public static void deleteFilm (ArrayList<Film> filmCollection, int index) {
            filmCollection.remove(index);
        }

        public static void seeAll (ArrayList<Film> filmCollection) {
            try {
                if (filmCollection.size() == 0) System.out.println("Ваша коллекция фильмов пуста.");
                else System.out.println(Arrays.toString(filmCollection.toArray()));
            }
            catch(NoSuchElementException exc) {
                System.out.println(exc + " Ваша коллекция фильмов пуста.");
            }
            catch(NullPointerException excep) {
                System.out.println(excep + " Ваша коллекция фильмов пуста.");
            }
        }


        public static int scanNum() {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            return n;
        }

        public static String scanString () {
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            return str;
        }

        public static ArrayList<Film> objectInput () {
            try {
                FileInputStream fis = new FileInputStream("file");
                ObjectInputStream ois = new ObjectInputStream(fis);
                ArrayList films = (ArrayList) ois.readObject();
                return films;
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException e) {
                System.out.println(e);
            }
            return null;
        }

        public static void objectOutput (ArrayList<Film> filmCollection) {
            try {
                FileOutputStream fos = new FileOutputStream("file");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(filmCollection);
                fos.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
