package edu.fra.uas;
import java.util.List;

public class Anmeldung {
    private Datenbank datenbank;

    public Anmeldung(Datenbank datenbank) {
        this.datenbank = datenbank;
    }

    public Benutzer benutzerAnmelden(String email, String passwort) {
        List<Benutzer> benutzerListe = datenbank.getBenutzerListe();
        for (Benutzer benutzer : benutzerListe) {
            if (benutzer.getEmail().equals(email) && benutzer.getPasswort().equals(passwort)) {
                return benutzer;
            }
        }
        return null;
    }

    public void benutzerRegistrieren(String name, String email, String passwort, String accountTyp) {
        Benutzer benutzer = new Benutzer(name, email, passwort, accountTyp);
        datenbank.benutzerHinzufuegen(benutzer);
    }
}
