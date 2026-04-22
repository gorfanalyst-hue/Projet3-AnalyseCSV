import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * ExporteurFichier.java
 *
 * SOLID - SRP (Single Responsibility Principle) :
 *   Une seule responsabilité : exporter les statistiques dans des fichiers.
 *   Elle ne lit pas, ne calcule pas, n'affiche pas à la console.
 *
 * SOLID - OCP (Open/Closed Principle) :
 *   Si on veut exporter en PDF, on crée ExporteurPDF implements IExporteur.
 *   On ne modifie JAMAIS cette classe.
 *
 * SOLID - LSP (Liskov Substitution Principle) :
 *   Peut remplacer IExporteur partout sans changer le comportement attendu.
 */
public class ExporteurFichier implements IExporteur {

    /**
     * Exporte un rapport lisible au format texte (.txt).
     *
     * Gestion des exceptions (cours Oracle Academy) :
     *   IOException est une exception vérifiée → on la gère avec try/catch.
     *   On utilise catch(IOException e) spécifique plutôt que catch(Exception e).
     */
    @Override
    public void exporterTXT(List<Statistiques> statistiques, String cheminFichier) {
        try (BufferedWriter ecrivain = new BufferedWriter(new FileWriter(cheminFichier))) {

            ecrivain.write("=== RAPPORT STATISTIQUE ===");
            ecrivain.newLine();
            ecrivain.write("Colonnes analysées : " + statistiques.size());
            ecrivain.newLine();
            ecrivain.write("-".repeat(60));
            ecrivain.newLine();

            for (Statistiques stat : statistiques) {
                ecrivain.write("Colonne  : " + stat.getNomColonne());
                ecrivain.newLine();
                ecrivain.write(String.format("  Moyenne : %.2f", stat.getMoyenne()));
                ecrivain.newLine();
                ecrivain.write(String.format("  Minimum : %.2f", stat.getMinimum()));
                ecrivain.newLine();
                ecrivain.write(String.format("  Maximum : %.2f", stat.getMaximum()));
                ecrivain.newLine();
                ecrivain.write(String.format("  Valeurs : %d", stat.getNombreValeurs()));
                ecrivain.newLine();
                ecrivain.write("-".repeat(60));
                ecrivain.newLine();
            }

            System.out.println("Export TXT réussi : " + cheminFichier);

        } catch (IOException e) {
            // Exception spécifique (bonne pratique Oracle Academy)
            System.out.println("Erreur export TXT : " + e.getMessage());
        }
    }

    /**
     * Exporte un résumé au format CSV (.csv).
     *
     * Gestion des exceptions (cours Oracle Academy) :
     *   IOException vérifiée → gérée avec catch spécifique.
     */
    @Override
    public void exporterCSV(List<Statistiques> statistiques, String cheminFichier) {
        try (BufferedWriter ecrivain = new BufferedWriter(new FileWriter(cheminFichier))) {

            // En-tête CSV
            ecrivain.write("Colonne,Moyenne,Minimum,Maximum,NombreValeurs");
            ecrivain.newLine();

            for (Statistiques stat : statistiques) {
                ecrivain.write(String.format("%s,%.2f,%.2f,%.2f,%d",
                        stat.getNomColonne(),
                        stat.getMoyenne(),
                        stat.getMinimum(),
                        stat.getMaximum(),
                        stat.getNombreValeurs()));
                ecrivain.newLine();
            }

            System.out.println("Export CSV réussi : " + cheminFichier);

        } catch (IOException e) {
            System.out.println("Erreur export CSV : " + e.getMessage());
        }
    }
}

