package edu.fra.uas;

public class Benutzer {
    private String name;
    private String email;
    private String passwort;
    private String accountTyp;
    
    public Benutzer(String name, String email, String passwort, String accountTyp) {
        this.name = name;
        this.email = email;
        this.passwort = passwort;
        this.accountTyp = accountTyp;
    }
    
    // Getter- und Setter-Methoden für die Klassenvariablen
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getAccountTyp() {
        return accountTyp;
    }

    public void setAccountTyp(String accountTyp) {
        this.accountTyp = accountTyp;
    }
}
