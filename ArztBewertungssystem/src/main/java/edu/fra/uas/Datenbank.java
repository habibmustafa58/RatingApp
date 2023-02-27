package edu.fra.uas;

import java.util.ArrayList;
import java.util.List;

public class Datenbank {
    private List<Benutzer> benutzerListe;
    private List<Bewertung> bewertungsListe;

    public Datenbank() {
        this.benutzerListe = new ArrayList<Benutzer>();
        this.bewertungsListe = new ArrayList<Bewertung>();
    }

    // Methoden zum Hinzufügen von Benutzern und Bewertungen

    public void benutzerHinzufuegen(Benutzer benutzer) {
        benutzerListe.add(benutzer);
    }

    public void bewertungHinzufuegen(Bewertung bewertung) {
        bewertungsListe.add(bewertung);
    }

    // Methoden zum Abrufen von Benutzern und Bewertungen

    public List<Benutzer> getBenutzerListe() {
        return benutzerListe;
    }

    public List<Bewertung> getBewertungsListe() {
        return bewertungsListe;
    }

    public List<Bewertung> getBewertungenFuerArzt(String arztName) {
        List<Bewertung> bewertungen = new ArrayList<Bewertung>();
        for (Bewertung bewertung : bewertungsListe) {
            if (bewertung.getArztName().equals(arztName)) {
                bewertungen.add(bewertung);
            }
        }
        return bewertungen;
    }

    public double getDurchschnittlicheBewertungFuerArzt(String arztName) {
        double summe = 0.0;
        int anzahl = 0;
        for (Bewertung bewertung : bewertungsListe) {				//Einfache for Schleife zur berechnung des Durchschnittswertes
            if (bewertung.getArztName().equals(arztName)) {
                summe += bewertung.getBewertung();
                anzahl++;
            }
        }
        if (anzahl == 0) {
            return 0.0;
        } else {
            return summe / anzahl;
        }
    }
}
