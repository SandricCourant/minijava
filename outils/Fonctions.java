package outils;

import java.util.Scanner;

public abstract class Fonctions {
    /* Retourne la somme de tous les entiers de 1 à max */
    public static int sommeTotale(int max) {
        int result = 0;
        for (int nombre = 1; nombre <= max; nombre++) {
            // System.out.printf(" %d + %d = %d\n", result, nombre, result + nombre);
            result += nombre;
        }
        return result;
    }

    /* Retourne le string tapé au clavier */
    public static String demanderLigne(String question) {
        System.out.println(question);
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    /* Retourne le nombre entier tapé au clavier */
    public static int demanderEntier(String question) {
        try {
            System.out.println(question);
            Scanner sc = new Scanner(System.in);
            return Integer.parseInt(sc.next());
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Ce n'est pas un nombre !");
        }
    }

    /* Retourne un nombre aléatoire dont la valeur est entre min et max */
    public static int aleatoire(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
    public static int meilleurChoix(int nombreBaton) {
        if((nombreBaton - 3) % 4 == 1) return 3;
        if((nombreBaton - 2) % 4 == 1) return 2;
        if((nombreBaton - 1) % 4 == 1) return 1;
        return aleatoire(3);
    }
    /* La version avec 1 argument retourne un nombre compris entre 1 et max */
    public static int aleatoire(int max) {
        return (int) (Math.random() * max + 1);
    }
}
