import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Film implements Serializable {

    private String filmName;
    private List<String> actors;

    public Film(String filmName) {
        this.filmName = filmName;
        this.actors = new ArrayList<>();
    }

    @Override
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
