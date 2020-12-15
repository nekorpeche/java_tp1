import java.util.concurrent.ThreadLocalRandom;


public class Personnage {

    private String pseudo;
    private int pdv; // Points de vie
    private String typePerso; //Ami, Personnage Principal, Ennemi
    private String racePerso; //Humain,Animal,Element de la nature
    private Arme arme;
    private Objet objet;

    public Personnage(String pseudo, String typePerso, String racePerso){
        this.pseudo = pseudo;
        this.pdv = ThreadLocalRandom.current().nextInt(10, 20 + 1);
        this.arme = null;
        this.objet = null;
    }

    public void presentation(){
        System.out.println("Pseudo : " + this.pseudo);
        System.out.println("Point de vie : " + this.pdv);
        if(this.arme != null) {
            System.out.println("Arme : " + this.arme.getNom() + " " + this.arme.getPdg() + " de degat" );
        }
        if (this.objet != null) {
            if (this.objet.getType() == "Att") {
                System.out.println("Objet : Potion de force + 5 de dégats");
            }
            if (this.objet.getType() == "Def") {
                System.out.println("Objet : Potion de defense + 5 de defense");
            }
        }
    }

    public int frapper(){

        if(this.arme == null) {
            return ThreadLocalRandom.current().nextInt(1, 3 + 1);

        } else if (this.objet.getType() == "Att"){
            return this.arme.getPdg() + 5;
        } else return this.arme.getPdg();
    }

    public void blesser(int degat){
        if (this.objet != null) {
            if (this.objet.getType() == "Def") {
                this.pdv -= degat - 5;
            } else this.pdv -= degat;
        }
    }

    public boolean estVivant(){
        if(this.pdv>0) {
            return true;
        } else return false;
    }

    public void prendreArme(String nomArme) {
        this.arme = new Arme(nomArme);
    }

    public void prendreObjet(String typeObjet) {
        this.objet = new Objet(typeObjet);
    }

    public void deposerArme() {
        this.arme = null;
    }

}
