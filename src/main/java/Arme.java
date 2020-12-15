import java.util.concurrent.ThreadLocalRandom;

public class Arme {
    private String nomArme;
    private int pdg; //Points de dégats
    private boolean lancable; //Si elle est lancable ou non
    private String fortContre; //Effet sur type de personnage

    public Arme(String nomArme) {
        this.nomArme = nomArme;
        this.pdg = ThreadLocalRandom.current().nextInt(5, 10 + 1);
    }

    public String getNom() {
        return this.nomArme;
    }
    //Points de dégats
    public int getPdg() {
        return this.pdg;

    }
}
