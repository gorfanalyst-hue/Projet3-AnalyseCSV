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

    public double getMoyenne() {
        if (nombreValeurs == 0) return 0.0;
        return somme / nombreValeurs;
    }
}