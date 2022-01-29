import java.util.List;

public class Text {
    private String text;
    private List<String> bigWords;

    public Text() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getBigWords() {
        return bigWords;
    }

    public void setBigWords(List<String> bigWords) {
        this.bigWords = bigWords;
    }
}
