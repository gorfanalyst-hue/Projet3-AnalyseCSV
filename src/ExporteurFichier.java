import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExporteurFichier implements IExporteur {

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

