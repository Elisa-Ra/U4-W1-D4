/* Una registrazione Audio è riproducibile, ha associato un int volume con i metodi
 * abbassaVolume() e alzaVolume(). Se riprodotta -> play(), stampa il titolo un numero di volte
 * pari alla durata insieme a un numero di punti esclamativi uguali al volume.
 * Volume = punti esclamativi
 * Titolo = durata */

package entities;

import interfaces.Riproducibile;

public class Audio extends ElementoMultimediale implements Riproducibile {
    private final int durata; // uso final perché non si deve poter cambiare la durata
    private int volume;

    public Audio(String title, int durata, int volume) {
        super(title); // utilizzo il costruttore del padre per il titolo
        this.durata = durata;
        this.volume = 5;
    }

    public int getVolume() {
        return volume;
    }

    public int abbassaVolume(int newVolume) {
        if (this.volume > newVolume) {
            this.volume = newVolume;
        } else {
            System.out.println("Il volume è già più basso del numero inserito");
        }
        return this.volume;
    }

    public int alzaVolume(int newVolume) {
        if (this.volume < newVolume) {
            this.volume = newVolume;
        } else {
            System.out.println("Il volume è già più alto del numero inserito");
        }
        return this.volume;
    }

    @Override
    public String toString() {
        return "Tipo di media: Audio" +
                ". Titolo: " + this.getTitle();
    }

    @Override
    public void play() {
        String puntiEsclamativi = ""; // la inizializzo vuota
        // aggiungo un punto esclamativo n volte = volume
        for (int i = 0; i < volume; i++) {
            puntiEsclamativi += "!";
        }
        // stampo il titolo (con i punti esclamativi) n volte = durata
        for (int i = 0; i < durata; i++) {
            System.out.println("Titolo: " + getTitle() + puntiEsclamativi);
        }
    }
}