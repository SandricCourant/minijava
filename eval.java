import outils.Fonctions;

/**
 * eval
 */
public abstract class eval {
    public static void main(String[] args) {
        System.out.println("Début du programme");
        menu();
        System.out.println("Fin du programme");
    }

    public static void menu() {
        System.out.println("Menu des exercices\n1. Exercice 1\n2. Exercice 2\n3. Exercice 3\n4. Exercice 4");
        int nombre;
        nombre = demandeNombre("Tapez le nombre correspondant, autre chose pour stop");
        switch (nombre) {
            case 1:
                exercice1();
                break;
            case 2:
                exercice2();
                break;
            case 3:
                exercice3();
                break;
            case 4:
                exercice4();
                break;
            default:
                System.out.println("STOP");
                break;
        }
    }

    public static void goToMenu() {
        if (Fonctions.demanderLigne("Retourner au menu ? \"OK\"").toUpperCase().equals("OK"))
            menu();
    }

    /* Renvoi un nombre et recommence la demande si l'entree est fausse */
    public static int demandeNombre(String message) {
        do {
            try {
                return Math.abs(Fonctions.demanderEntier(message));
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
            }
        } while (true);
    }

    public static void exercice1() {
        int nombre = demandeNombre("Tapez un nombre entier pour afficher les 20 nombres suivants");
        int count = nombre + 20;
        while (nombre < count) {
            System.out.println(" Nombre : " + ++nombre);
        }
        goToMenu();
    }

    public static void exercice2() {
        int nombre = demandeNombre("Tapez un nombre entier pour afficher sa table de multiplication");
        System.out.printf("*** TABLE DE MULTIPLICATION DE %d ***\n", nombre);
        for (int table = 1; table <= 10; table++) {
            System.out.printf("%d x %d = %d\n", nombre, table, nombre * table);
        }
        goToMenu();
    }

    public static void exercice3() {
        int nombre = 7;
        System.out.printf("Total de %d = %d\n", nombre, Fonctions.sommeTotale(nombre));
        nombre = 12;
        System.out.printf("Total de %d = %d\n", nombre, Fonctions.sommeTotale(nombre));
        nombre = 100;
        System.out.printf("Total de %d = %d\n", nombre, Fonctions.sommeTotale(nombre));
        goToMenu();
    }

    public static void exercice4() {
        int nombreBaton = 20, afficheBaton, choix, joueurSuivant = 0;
        boolean difficile;
        System.out.println("Choix du niveau:\n1.Débutant\n2.Hardcore");
        do {
            choix = demandeNombre("Saisir 1 ou 2 :");
        } while (choix > 2 || choix < 1);
        difficile = choix > 1 ? true : false;
        System.out.println("Début de la partie");

        do {
            afficheBaton = 0;
            System.out.printf("\nIl reste %d batons\n", nombreBaton);
            while (afficheBaton < nombreBaton) {
                System.out.print(" | ");
                afficheBaton++;
            }
            // Si c'est à l'humain de jouer
            if (joueurSuivant == 0) {
                do {
                    choix = demandeNombre("\nJoueur : combien de batons voulez-vous prendre ?");
                } while (choix > 3 || choix < 1);
            } else {// Sinon c'est à l'ordi de jouer
                if (!difficile) {
                    if (nombreBaton > 4) {// Si pleins de bâtons
                        choix = Fonctions.aleatoire(3);
                    } else if (nombreBaton > 3) {// Si plus que 4 bâtons
                        choix = 3;
                    } else if (nombreBaton > 2) {// Si plus que 3 batôns
                        choix = 2;
                    } else {// Il reste que 2 batôns
                        choix = 1;
                    }
                }
                else{
                    choix = Fonctions.meilleurChoix(nombreBaton);
                }
                System.out.println("\nL'ordinateur en prend " + choix + "\n");
            }
            nombreBaton -= choix;
            joueurSuivant = (joueurSuivant + 1) % 2;
        } while (nombreBaton > 1);// Fin si plus qu'un bâton
        if (joueurSuivant > 0 && nombreBaton > 0) {
            System.out.println("Bravo vous avez gagné la partie !");
        } else {
            System.out.println("Mince, vous avez perdu la partie...");
        }
        if (Fonctions.demanderLigne("Voulez vous rejouer ? Saisir \"OK\"").toUpperCase().equals("OK"))
            exercice4();
        else
            goToMenu();
    }

}