package entities;

// La mia classe astratta
public abstract class ElementoMultimediale {
    private String title;

    // Gli elementi multimediali hanno un titolo
    public ElementoMultimediale(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Titolo: " + title;
    }
}