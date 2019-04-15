import org.junit.Test;
import static org.junit.Assert.*;

public class ApplicationTest {

    public FilmCollection gettingReadyForTesting() {
        FilmCollection filmCollection = new FilmCollection();
        Film film = new Film("Titanic");
        film.addActor("Leonardo");
        film.addActor("Kate");
        filmCollection.addFilm(film);
        return filmCollection;
    }

    @Test
    public void addFilmMethodShouldAddNewFilm() {
        FilmCollection filmCollection = gettingReadyForTesting();
        Film film = new Film("Winx");
        film.addActor("Bloom");
        film.addActor("Stella");
        film.addActor("Flora");
        filmCollection.addFilm(film);
        assertEquals("[Titanic[Leonardo, Kate], Winx[Bloom, Stella, Flora]]", filmCollection.seeAll());
    }

    @Test
    public void editNameOfTheFilmMethodShouldWorkProperly() {
        FilmCollection filmCollection = gettingReadyForTesting();
        filmCollection.editNameOfTheFilm(1, "Iceberg turned out to be stronger");
        assertEquals("[Iceberg turned out to be stronger[Leonardo, Kate]]", filmCollection.seeAll());
    }

    @Test
    public void settingNewListOfActorsShouldWorkProperly() {
        FilmCollection filmCollection = gettingReadyForTesting();
        filmCollection.removeAllTheActors(1);
        filmCollection.addNewActor(1, "Leo");
        assertEquals("[Titanic[Leo]]", filmCollection.seeAll());
    }

    @Test
    public void deleteFilmMethodShouldRemoveFilm() {
        FilmCollection filmCollection = gettingReadyForTesting();
        filmCollection.deleteFilm(1);
        assertEquals("[]", filmCollection.seeAll());
    }

    @Test
    public void seeAllFunctionShouldShowAllTheFilms() {
        FilmCollection filmCollection = gettingReadyForTesting();
        assertEquals("[Titanic[Leonardo, Kate]]", filmCollection.seeAll());
    }

    @Test
    public void serializationShouldWorkProperly() {
        FilmCollection filmCollection = gettingReadyForTesting();

        //сериализация
        Application.objectOutput(filmCollection, "testFile");
        //десериализация
        FilmCollection  newFilmCollection = Application.objectInput("testFile");

        assertEquals(filmCollection.seeAll(), newFilmCollection.seeAll());
    }
}