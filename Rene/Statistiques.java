/**
 * Statistiques.java
 *
 * SOLID - SRP (Single Responsibility Principle) :
 *   Cette classe a une seule responsabilité : stocker les statistiques
 *   d'une colonne numérique (moyenne, min, max).
 *   Elle ne lit pas, ne calcule pas, n'affiche pas.
 */
public class Statistiques {

    private String nomColonne;
    private double somme;
    private double minimum;
    private double maximum;
    private int    nombreValeurs;

    public Statistiques(String nomColonne) {
        this.nomColonne    = nomColonne;
        this.somme         = 0.0;
        this.minimum       = Double.MAX_VALUE;
        this.maximum       = Double.MIN_VALUE;
        this.nombreValeurs = 0;
    }

    // --- Mise à jour des données ---

    /**
     * Ajoute une valeur et met à jour min, max, somme.
     */
    public void ajouterValeur(double valeur) {
        if (valeur < minimum) minimum = valeur;
        if (valeur > maximum) maximum = valeur;
        somme += valeur;
        nombreValeurs++;
    }

    // --- Getters ---

    public String getNomColonne()   { return nomColonne; }
    public int    getNombreValeurs(){ return nombreValeurs; }
    public double getMinimum()      { return minimum; }
    public double getMaximum()      { return maximum; }

    /**
     * Calcule et retourne la moyenne à la volée.
     */
    public double getMoyenne() {
        if (nombreValeurs == 0) return 0.0;
        return somme / nombreValeurs;
    }
}