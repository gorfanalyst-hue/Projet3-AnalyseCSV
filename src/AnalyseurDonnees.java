import java.util.List;

public class AnalyseurDonnees {

    // Dépendances vers les ABSTRACTIONS, pas les implémentations (DIP)
    private ILecteur    lecteur;
    private ICalculateur calculateur;
    private IAfficheur  afficheur;
    private IExporteur  exporteur;

    private List<Statistiques> statistiques;

    public AnalyseurDonnees(ILecteur lecteur,
                            ICalculateur calculateur,
                            IAfficheur afficheur,
                            IExporteur exporteur) {
        this.lecteur      = lecteur;
        this.calculateur  = calculateur;
        this.afficheur    = afficheur;
        this.exporteur    = exporteur;
    }

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

    public void exporter(String cheminTXT, String cheminCSV) {
        if (statistiques == null || statistiques.isEmpty()) {
            System.out.println("Aucun résultat à exporter. Lancez analyser() d'abord.");
            return;
        }
        exporteur.exporterTXT(statistiques, cheminTXT);
        exporteur.exporterCSV(statistiques, cheminCSV);
    }
}
