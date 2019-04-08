import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ApplicationTest {

@Test
public void deserializationShouldGiveTheRightArrayList() {

    //creating a new object
    ArrayList<Film> filmCollection = new ArrayList<>();

    //adding films
    Film film1 = new Film("Titanic");
    film1.addActor("Leonardo");
    film1.addActor("Kate");
    filmCollection.add(film1);

    Film film2 = new Film("Some Blue Guys");
    film2.addActor("Sam Worthington");
    film2.addActor("Zoe Saldana");
    film2.addActor("Michelle Rodriguez");
    filmCollection.add(film2);

    Film film3 = new Film("Pirates of the Caribbean");
    film3.addActor("Jack Sparrow");
    film3.addActor("Keira Nightley");
    filmCollection.add(film3);


    //editing films
    //changing the name of "Some Blue Guys"
    Application.editNameOfTheFilm(filmCollection, 1, "Avatar");
    //changing actors in "Pirates of the Caribbean"
    filmCollection.get(2).removeActors();
    filmCollection.get(2).addActor("Johny Depp");

    //deleting a film
    Application.deleteFilm(filmCollection, 0);

    //serializing
    Application.objectOutput(filmCollection);

    //deserializing
    ArrayList<Film> newFilmCollection = Application.objectInput();

    //creating an array list which we expect to get
    ArrayList<Film> expectedFilmCollection = new ArrayList<>();

    //filling the array list with a couple of expected films
    Film expFilm1 = new Film("Avatar");
    expFilm1.addActor("Sam Worthington");
    expFilm1.addActor("Zoe Saldana");
    expFilm1.addActor("Michelle Rodriguez");
    expectedFilmCollection.add(expFilm1);

    Film expFilm2 = new Film("Pirates of the Caribbean");
    expFilm2.addActor("Johny Depp");
    expectedFilmCollection.add(expFilm2);

    //checking if equal
    assertEquals(Arrays.toString(newFilmCollection.toArray()), Arrays.toString(expectedFilmCollection.toArray()));
}

}
