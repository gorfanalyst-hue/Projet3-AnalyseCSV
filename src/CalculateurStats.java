import java.util.ArrayList;
import java.util.List;

public class CalculateurStats implements ICalculateur {

    @Override
    public List<Statistiques> calculer(List<List<String>> donnees, String[] entetes) {

        int nbColonnes = entetes.length;

        // Initialiser une Statistiques par colonne
        List<Statistiques> stats = new ArrayList<>();
        for (String entete : entetes) {
            stats.add(new Statistiques(entete));
        }

        // Suivre quelles colonnes sont numériques
        boolean[] colonneNumerique = new boolean[nbColonnes];
        for (int i = 0; i < nbColonnes; i++) {
            colonneNumerique[i] = true;
        }

        // Parcourir chaque ligne de données
        boolean[] avertissementAffiche = new boolean[nbColonnes]; // ← AJOUTER cette ligne

        for (List<String> ligne : donnees) {
            for (int i = 0; i < nbColonnes && i < ligne.size(); i++) {
                if (!colonneNumerique[i]) continue;

                String cellule = ligne.get(i);
                if (cellule.isEmpty()) continue;

                try {
                    double valeur = Double.parseDouble(cellule);
                    stats.get(i).ajouterValeur(valeur);
                } catch (NumberFormatException e) {
                    colonneNumerique[i] = false;
                    // Afficher l'avertissement seulement si la colonne avait déjà des valeurs numériques
                    if (stats.get(i).getNombreValeurs() > 0 && !avertissementAffiche[i]) {
                        System.out.println("⚠ Colonne '" + entetes[i] + "' ignorée (données non numériques détectées).");
                        avertissementAffiche[i] = true;
                    }
                }
            }
        }
        // Retourner uniquement les colonnes numériques avec des données
        List<Statistiques> resultat = new ArrayList<>();
        for (int i = 0; i < nbColonnes; i++) {
            if (colonneNumerique[i] && stats.get(i).getNombreValeurs() > 0) {
                resultat.add(stats.get(i));
            }
        }

        return resultat;
    }
}

