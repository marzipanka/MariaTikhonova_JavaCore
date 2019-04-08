import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Film implements Serializable {

    private String filmName;
    private ArrayList<String> actors;

    Film(String filmName) {
        this.filmName = filmName;
        this.actors = new ArrayList<>();
    }

    public String toString() {
        return (filmName + Arrays.toString(actors.toArray()));
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void removeActors() {
        this.actors.removeAll(actors);
    }

    public void addActor(String name) {
        this.actors.add(name);
    }

}
