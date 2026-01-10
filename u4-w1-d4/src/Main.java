// Il main deve fare due cose principali:
// 1. Creo un array di 5 elementi multimediali con valori letti da tastiera (con scanner)
// 2. Chiedo all'utente quale oggetto eseguire (con valori int da 1 a 5. 0 per finire)

import entities.Audio;
import entities.ElementoMultimediale;
import entities.Immagine;
import entities.Video;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Creo un array di 5 elementi
        ElementoMultimediale[] player = new ElementoMultimediale[5];
        // quindi creo un for in cui per 5 volte, chiederò all'utente il tipo di elemento e il titolo
        for (int i = 0; i < player.length; i++) {
            System.out.println("Aggiungi un elemento multimediale. Scrivi 1 per audio, 2 per video e 3 per immagine.");
            int elemento = Integer.parseInt(scanner.nextLine());
            // controllo che venga inserito un numero da 1 a 3
            while (elemento < 1 || elemento > 3) {
                System.out.println("Numero non valido. Puoi inserire un valore compreso tra 1 e 3.");
                elemento = Integer.parseInt(scanner.nextLine());
            }
            System.out.println("Ora inserisci il titolo!");
            String titolo = scanner.nextLine();
            // l'audio ha anche una durata e un volume
            // il video ha una durata, volume e luminosità
            // l'immagine ha solo la luminosità
            int durata = 0;
            int volume = 0;
            int luminosita = 0;

            if (elemento == 1) {
                System.out.println("Aggiungi la durata della riproduzione. Minimo 1, massimo 10");
                durata = Integer.parseInt(scanner.nextLine());
                // inserisco un while per controllare che la durata sia massimo 10
                // altrimenti poi quando devo stampare il titolo, c'è il rischio che venga stampato troppe volte
                while (durata < 1 || durata > 10) {
                    System.out.println("Numero non valido. Puoi inserire un valore compreso tra 1 e 10.");
                    durata = Integer.parseInt(scanner.nextLine());
                }
                // faccio la stessa cosa per gli altri valori numerici
                System.out.println("Aggiungi il volume della riproduzione");
                volume = Integer.parseInt(scanner.nextLine());
                while (volume < 1 || volume > 10) {
                    System.out.println("Numero non valido. Puoi inserire un valore compreso tra 1 e 10.");
                    volume = Integer.parseInt(scanner.nextLine());
                }
            } else if (elemento == 2) {
                System.out.println("Aggiungi la durata della riproduzione");
                durata = Integer.parseInt(scanner.nextLine());
                while (durata < 1 || durata > 10) {
                    System.out.println("Numero non valido. Puoi inserire un valore compreso tra 1 e 10.");
                    durata = Integer.parseInt(scanner.nextLine());
                }
                System.out.println("Aggiungi il volume della riproduzione");
                volume = Integer.parseInt(scanner.nextLine());
                while (volume < 1 || volume > 10) {
                    System.out.println("Numero non valido. Puoi inserire un valore compreso tra 1 e 10.");
                    volume = Integer.parseInt(scanner.nextLine());
                }
                System.out.println("Aggiungi la luminosità della riproduzione");
                luminosita = Integer.parseInt(scanner.nextLine());
                while (luminosita < 1 || luminosita > 10) {
                    System.out.println("Numero non valido. Puoi inserire un valore compreso tra 1 e 10.");
                    luminosita = Integer.parseInt(scanner.nextLine());
                }
            } else {
                System.out.println("Aggiungi la luminosità dell'immagine");
                luminosita = Integer.parseInt(scanner.nextLine());
                while (luminosita < 1 || luminosita > 10) {
                    System.out.println("Numero non valido. Puoi inserire un valore compreso tra 1 e 10.");
                    luminosita = Integer.parseInt(scanner.nextLine());
                }
            }
            // ora devo creare gli oggetti corrispondenti
            switch (elemento) {
                // caso 1 è l'audio
                case 1: {
                    player[i] = new Audio(titolo, durata, volume);
                    System.out.println("Hai creato un elemento audio!");
                    break;
                }
                // caso 2 è il video
                case 2: {
                    player[i] = new Video(titolo, durata, volume, luminosita);
                    System.out.println("Hai creato un elemento video!");
                    break;
                }
                // caso 3 è l'immagine
                case 3: {
                    player[i] = new Immagine(titolo, luminosita);
                    System.out.println("Hai creato un elemento immagine!");
                    break;
                }
                // come default, scrivo un messaggio se il numero inserito non è valido
                default: {
                    System.out.println("Il numero inserito non è valido.");

                }
            }

        }
        // controllo se gli elementi sono stati correttamente creati e aggiunti all'array
        System.out.println(Arrays.toString(player));
        // PARTE 2


        // Eseguo il while finché il numero inserito è diverso da 0. Perché con 0 esco.
        int esecuzione = -1;
        while (esecuzione != 0) {
            System.out.println("Quale elemento vuoi eseguire?. Scrivi un numero da 1 a 5. 0 per uscire.");
            esecuzione = Integer.parseInt(scanner.nextLine());

            // se si inserisce lo zero, si esce.
            if (esecuzione == 0) {
                break;
            } else if (esecuzione < 1 || esecuzione > 5) {
                System.out.println("Numero non valido. Puoi inserire un valore compreso tra 1 e 5.");
                esecuzione = Integer.parseInt(scanner.nextLine());
            }
            ElementoMultimediale playerEseguibile = player[esecuzione - 1];
            // ora devo controllare però che tipo di oggetto è, per eseguirlo o con play() o con show()
            //  uso instanceof

            if (playerEseguibile instanceof Audio) {
                ((Audio) playerEseguibile).play();
            } else if (playerEseguibile instanceof Video) {
                ((Video) playerEseguibile).play();
            } else {
                ((Immagine) playerEseguibile).show();
            }
        }
    }
}