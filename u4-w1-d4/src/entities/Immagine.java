package entities;
// L'immagine ha una luminosità ed è visualizzabile show()

import interfaces.Luminoso;
import interfaces.Visualizzabile;

public class Immagine extends ElementoMultimediale implements Luminoso, Visualizzabile {
    private int luminosita;

    public Immagine(String title, int luminosita) {
        super(title); // utilizzo il costruttore del padre per il titolo
        this.luminosita = luminosita;
    }

    public int getLuminosita() {
        return luminosita;
    }

    @Override
    public String toString() {
        return "Tipo di media: Immagine" +
                ". Titolo: " + this.getTitle() + ". Luminosità: " + luminosita;
    }

    @Override
    public void show() {
        String asterischi = ""; // la inizializzo vuota
        // aggiungo un asterisco n volte = luminosita
        for (int i = 0; i < luminosita; i++) {
            asterischi += "*";
        }
        // stampo il titolo (con gli asterischi)
        System.out.println("Titolo: " + getTitle() + asterischi);
    }

    @Override
    public void aumentaLuminosita(int newLuminosita) {
        // aggiungo un if per evitare che si mettano numeri negativi
        if (newLuminosita < 0) {
            newLuminosita = 0;
        }
        if (this.luminosita < newLuminosita) {
            this.luminosita = newLuminosita;
            System.out.println("La luminosità è stata impostata a " + this.luminosita);
        } else {
            System.out.println("La luminosità è già più alta del numero inserito");
        }
    }

    @Override
    public void diminuisciLuminosita(int newLuminosita) {
        // aggiungo un if per evitare che si mettano numeri negativi
        if (newLuminosita < 0) {
            newLuminosita = 0;
        }
        if (this.luminosita > newLuminosita) {
            this.luminosita = newLuminosita;
            System.out.println("La luminosità è stata impostata a " + this.luminosita);
        } else {
            System.out.println("La luminosità è già più bassa del numero inserito");
        }
    }
}