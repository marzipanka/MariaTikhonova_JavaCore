public class Note {
    private String headline;
    private String text;

    public Note(String headline, String text) {
        this.headline = headline;
        this.text = text;
    }

    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public void setHeadline(String headline) { this.headline = headline;}

    public void setText(String text) {this.text = text;}
}
