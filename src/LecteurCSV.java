import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecteurCSV implements ILecteur {

    private String   cheminFichier;
    private String[] entetes;

    public LecteurCSV(String cheminFichier) {
        this.cheminFichier = cheminFichier;
    }

    @Override
    public String[] getEntetes() {
        return entetes;
    }

    @Override
    public List<List<String>> lire() throws IOException {

        List<List<String>> donnees = new ArrayList<>();

        try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier))) {

            // --- Lecture des en-têtes ---
            String ligneEntetes = lecteur.readLine();
            if (ligneEntetes == null) {
                throw new IOException("Le fichier CSV est vide : " + cheminFichier);
            }
            entetes = ligneEntetes.split(",");
            for (int i = 0; i < entetes.length; i++) {
                entetes[i] = entetes[i].trim();
            }

            // --- Lecture des lignes de données ---
            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                if (ligne.trim().isEmpty()) continue;  // ignorer lignes vides
                String[] cellules = ligne.split(",", -1);
                List<String> ligneList = new ArrayList<>();
                for (String c : cellules) {
                    ligneList.add(c.trim());
                }
                donnees.add(ligneList);
            }

        } catch (IOException e) {
            // Gestion des exceptions vérifiées (cours Oracle Academy)
            throw new IOException("Erreur de lecture du fichier CSV : " + e.getMessage());
        }

        return donnees;
    }
}

