import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class FilmCollection implements Serializable {

    private List<Film> films;

    public FilmCollection() {
        this.films = new ArrayList<>();
    }

    //добавить фильм
    public void addFilm(Film film) {
        films.add(film);
    }

    //редактировать название фильма
    public void editNameOfTheFilm (int n, String name) {
        films.get(n-1).setFilmName(name);
    }

    //очистка списка актеров перед редактированием списка актеров
    public void removeAllTheActors(int editNum) {
        films.get(editNum-1).removeActors();
    }

    //добавить нового актера
    public void addNewActor(int editNum, String name) {
        films.get(editNum-1).addActor(name);
    }

    //удалить фильм
    public void deleteFilm (int index) {
        films.remove(index-1);
    }

    //посмотреть все фильмы
    public String seeAll () {
        try {
            if (films.size() == 0) System.out.println("Ваша коллекция фильмов пуста.");
            else System.out.println(Arrays.toString(films.toArray()));
            return Arrays.toString(films.toArray());
        } catch(NoSuchElementException e) {
            System.out.println(e + " Ваша коллекция фильмов пуста.");
        } catch(NullPointerException ex) {
            System.out.println(ex + " Ваша коллекция фильмов пуста.");
        }
        return "";
    }

}
