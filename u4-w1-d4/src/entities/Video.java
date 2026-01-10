package entities;
// Il video ha una luminosità ed è riproducibile

import interfaces.Luminoso;
import interfaces.Riproducibile;

public class Video extends ElementoMultimediale implements Riproducibile, Luminoso {
    private final int durata; // uso final perché non si deve poter cambiare la durata
    private int volume;
    private int luminosita;

    public Video(String title, int durata, int volume, int luminosita) {
        super(title); // utilizzo il costruttore del padre per il titolo
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public int getVolume() {
        return volume;
    }

    public int abbassaVolume(int newVolume) {
        // aggiungo un if per evitare che si mettano numeri negativi
        if (newVolume < 0) {
            newVolume = 0;
        }
        if (this.volume > newVolume) {
            this.volume = newVolume;
        } else {
            System.out.println("Il volume è già più basso del numero inserito");
        }
        return this.volume;
    }

    public int alzaVolume(int newVolume) {
        if (newVolume < 0) {
            newVolume = 0;
        }
        if (this.volume < newVolume) {
            this.volume = newVolume;
        } else {
            System.out.println("Il volume è già più alto del numero inserito");
        }
        return this.volume;
    }

    @Override
    public String toString() {
        return "Tipo di media: Video" +
                ". Titolo: " + this.getTitle() + ". Volume: " + volume + ". Durata: " + durata
                + ". Luminosità: " + luminosita;
    }

    @Override
    public void play() {
        String puntiEsclamativi = ""; // la inizializzo vuota
        // aggiungo un punto esclamativo n volte = volume
        for (int i = 0; i < volume; i++) {
            puntiEsclamativi += "!";
        }
        String asterischi = ""; // la inizializzo vuota
        // aggiungo un asterisco n volte = luminosita
        for (int i = 0; i < luminosita; i++) {
            asterischi += "*";
        }
        // stampo il titolo (con i punti esclamativi) n volte = durata
        for (int i = 0; i < durata; i++) {
            System.out.println("Titolo: " + getTitle() + puntiEsclamativi + asterischi);
        }
    }

    public int getLuminosita() {
        return luminosita;
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