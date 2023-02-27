package edu.fra.uas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BewertungsController {

    private Map<String, String> benutzer = new HashMap<String, String>();
    private Map<String, List<Bewertung>> bewertungen = new HashMap<String, List<Bewertung>>();

    @PostMapping("/anmeldung")
    public ResponseEntity<String> anmelden(HttpServletRequest request) {
        String email = request.getParameter("email");
        String passwort = request.getParameter("passwort");

        if (benutzer.containsKey(email) && benutzer.get(email).equals(passwort)) {
            return new ResponseEntity<String>("Erfolgreich angemeldet", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Falsche E-Mail oder Passwort", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/registrierung")
    public ResponseEntity<String> registrieren(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String passwort = request.getParameter("passwort");
        String accountTyp = request.getParameter("accountTyp");

        if (benutzer.containsKey(email)) {
            return new ResponseEntity<String>("E-Mail bereits registriert", HttpStatus.CONFLICT);
        } else {
            benutzer.put(email, passwort);
            if (accountTyp.equals("Arzt")) {
                bewertungen.put(email, new ArrayList<Bewertung>());
            }
            return new ResponseEntity<String>("Erfolgreich registriert", HttpStatus.CREATED);
        }
    }

    @PostMapping("/bewertung")
    public ResponseEntity<String> bewertungAbgeben(@RequestParam String arztName, @RequestParam int bewertung,
            @RequestParam String kommentar, HttpServletRequest request) {
        String email = request.getParameter("email");

        if (!benutzer.containsKey(email)) {
            return new ResponseEntity<String>("Nicht angemeldet", HttpStatus.UNAUTHORIZED);
        }

        if (!bewertungen.containsKey(email)) {
            return new ResponseEntity<String>("Kein Arztkonto", HttpStatus.FORBIDDEN);
        }

        bewertungen.get(email).add(new Bewertung(arztName, bewertung, kommentar));
        return new ResponseEntity<String>("Bewertung hinzugefügt", HttpStatus.CREATED);
    }

    @GetMapping("/bewertungen")
    public @ResponseBody List<Bewertung> bewertungenAnsehen(@RequestParam String arztName, HttpServletRequest request) {
        String email = request.getParameter("email");

        if (!benutzer.containsKey(email)) {
            return new ArrayList<Bewertung>();
        }

        if (!bewertungen.containsKey(arztName)) {
            return new ArrayList<Bewertung>();
        }

        return bewertungen.get(arztName);
    }

    
    
}