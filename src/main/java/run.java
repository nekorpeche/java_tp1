public class run {
    public static void main(String[] args){
        int degat;

        Personnage john = new Personnage("John", "Principal", "Humain");
        Personnage alduin = new Personnage("Alduin", "Ami", "Animal");
        Personnage jack = new Personnage("Jack", "Ennemi", "Humain");
        System.out.println("Perso 1 : ");
        john.presentation();
        System.out.println("\nPerso 2 : ");
        alduin.presentation();
        System.out.println("\nPerso 3 : ");
        jack.presentation();

        while(john.estVivant() && alduin.estVivant()) {
            System.out.println("\nPerso 1 attaque Perso 2 : ");
            degat = john.frapper();
            System.out.println("\nPerso 1 inflige " + degat + " de dégat à Perso 2 \n");
            alduin.blesser(degat);

            if(alduin.estVivant()) {
                System.out.println("Perso 2 est toujours en vie");
                alduin.presentation();
            } else {
                System.out.println("Perso 2 est mort");
                alduin.presentation();
            }

            System.out.println("\nPerso 2 prend une epee");
            alduin.prendreArme("Epee");
            alduin.prendreObjet("Att");
            alduin.presentation();

            System.out.println("\nPerso 2 attaque Perso 1 : ");
            degat = alduin.frapper();
            System.out.println("\nPerso 2 inflige " + degat + " de dégat à Perso 1 \n");
            john.blesser(degat);

            if(john.estVivant()) {
                System.out.println("Perso 2 est toujours en vie");
                john.presentation();
            } else {
                System.out.println("Perso 1 est mort");
                john.presentation();
            }
            alduin.deposerArme();
            alduin.presentation();
        }
    }
}
