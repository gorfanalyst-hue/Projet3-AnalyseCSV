/**
 * Main.java
 *
 * Point d'entrée du programme.
 *
 * SOLID - DIP (Dependency Inversion Principle) :
 *   C'est ici, et SEULEMENT ici, qu'on choisit les implémentations concrètes.
 *   AnalyseurDonnees ne connaît que les interfaces.
 *
 *   Pour changer de format d'entrée (JSON, Excel...) :
 *   → Remplacer "new LecteurCSV(...)" par "new LecteurJSON(...)"
 *   → Aucun autre fichier n'est modifié. OCP respecté.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Analyse de fichier CSV (version SOLID) ===\n");

        // --- Injection des dépendances (DIP) ---
        // On branche les implémentations concrètes UNE SEULE FOIS ici.
        ILecteur     lecteur     = new LecteurCSV("data.csv");
        ICalculateur calculateur = new CalculateurStats();
        IAfficheur   afficheur   = new AfficheurConsole();
        IExporteur   exporteur   = new ExporteurFichier();

        // --- Création de l'analyseur avec injection ---
        AnalyseurDonnees analyseur = new AnalyseurDonnees(
                lecteur, calculateur, afficheur, exporteur
        );

        // --- Lancement du pipeline ---
        analyseur.analyser();

        // --- Export des résultats (bonus) ---
        System.out.println();
        analyseur.exporter("statistiques.txt", "resume.csv");

        System.out.println("\nProgramme terminé.");
    }
}
