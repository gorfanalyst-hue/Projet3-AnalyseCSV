import java.util.List;

/**
 * AnalyseurDonnees.java
 *
 * SOLID - SRP (Single Responsibility Principle) :
 *   Une seule responsabilité : orchestrer le pipeline d'analyse.
 *   Elle coordonne ILecteur → ICalculateur → IAfficheur → IExporteur.
 *   Elle ne fait aucun calcul, aucune lecture, aucun affichage elle-même.
 *
 * SOLID - DIP (Dependency Inversion Principle) :
 *   Dépend UNIQUEMENT des interfaces (ILecteur, ICalculateur, etc.),
 *   JAMAIS des classes concrètes (LecteurCSV, CalculateurStats, etc.).
 *   → On peut brancher n'importe quelle implémentation sans toucher ce code.
 *
 * SOLID - OCP (Open/Closed Principle) :
 *   Fermée à la modification : on ne change jamais ce code.
 *   Ouverte à l'extension : on peut injecter de nouveaux lecteurs,
 *   calculateurs ou exporteurs via le constructeur.
 */
public class AnalyseurDonnees {

    // Dépendances vers les ABSTRACTIONS, pas les implémentations (DIP)
    private ILecteur    lecteur;
    private ICalculateur calculateur;
    private IAfficheur  afficheur;
    private IExporteur  exporteur;

    private List<Statistiques> statistiques;

    /**
     * Constructeur avec injection de dépendances (DIP).
     * Main choisit les implémentations concrètes.
     */
    public AnalyseurDonnees(ILecteur lecteur,
                            ICalculateur calculateur,
                            IAfficheur afficheur,
                            IExporteur exporteur) {
        this.lecteur      = lecteur;
        this.calculateur  = calculateur;
        this.afficheur    = afficheur;
        this.exporteur    = exporteur;
    }

    /**
     * Lance le pipeline complet : lire → calculer → afficher.
     *
     * Gestion des exceptions (cours Oracle Academy) :
     *   Exception vérifiée lancée par ILecteur.lire() → gérée ici avec
     *   catch spécifique. Le programme ne plante pas.
     */
    public void analyser() {
        try {
            // Étape 1 : Lecture des données
            List<List<String>> donnees = lecteur.lire();
            String[] entetes = lecteur.getEntetes();

            // Étape 2 : Calcul des statistiques
            statistiques = calculateur.calculer(donnees, entetes);

            if (statistiques.isEmpty()) {
                System.out.println("Aucune colonne numérique trouvée.");
                return;
            }

            // Étape 3 : Affichage console
            afficheur.afficher(statistiques);

        } catch (Exception e) {
            // Gestion des exceptions vérifiées (IOException de ILecteur)
            System.out.println("Erreur lors de l'analyse : " + e.getMessage());
        }
    }

    /**
     * Lance l'export des résultats (bonus).
     * Séparé de analyser() → respecte SRP.
     */
    public void exporter(String cheminTXT, String cheminCSV) {
        if (statistiques == null || statistiques.isEmpty()) {
            System.out.println("Aucun résultat à exporter. Lancez analyser() d'abord.");
            return;
        }
        exporteur.exporterTXT(statistiques, cheminTXT);
        exporteur.exporterCSV(statistiques, cheminCSV);
    }
}
