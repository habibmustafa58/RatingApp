package edu.fra.uas;

public class Bewertung {
    private String arztName;
    private String kommentar;
    private int bewertung;
    
    

        public Bewertung(String arztName, int bewertung, String kommentar) {
            this.arztName = arztName;
            this.bewertung = bewertung;
            this.kommentar = kommentar;
        }
    

    public Bewertung(String arztName, String kommentar, int bewertung) {
        this.arztName = arztName;
        this.kommentar = kommentar;
        this.bewertung = bewertung;
    }

    public String getArztName() {
        return arztName;
    }

    public void setArztName(String arztName) {
        this.arztName = arztName;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public int getBewertung() {
        return bewertung;
    }

    public void setBewertung(int bewertung) {
        this.bewertung = bewertung;
    }
}
