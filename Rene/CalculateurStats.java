import java.util.ArrayList;
import java.util.List;

/**
 * CalculateurStats.java
 *
 * SOLID - SRP (Single Responsibility Principle) :
 *   Une seule responsabilité : calculer les statistiques
 *   (moyenne, min, max) à partir de données brutes.
 *   Elle ne lit pas, n'affiche pas, n'exporte pas.
 *
 * SOLID - OCP (Open/Closed Principle) :
 *   Implémente ICalculateur.
 *   Si on veut d'autres calculs (médiane...), on crée
 *   CalculateurAvance implements ICalculateur sans modifier celle-ci.
 *
 * SOLID - LSP (Liskov Substitution Principle) :
 *   Peut remplacer ICalculateur partout sans changer le comportement attendu.
 */
public class CalculateurStats implements ICalculateur {

    /**
     * Parcourt chaque colonne, détecte si elle est numérique,
     * et calcule moyenne/min/max.
     *
     * Gestion des exceptions (cours Oracle Academy) :
     *   NumberFormatException non vérifiée est interceptée
     *   pour gérer les cellules non numériques sans planter.
     */
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
        for (List<String> ligne : donnees) {
            for (int i = 0; i < nbColonnes && i < ligne.size(); i++) {
                if (!colonneNumerique[i]) continue;

                String cellule = ligne.get(i);
                if (cellule.isEmpty()) continue; // cellule vide : on ignore

                try {
                    double valeur = Double.parseDouble(cellule);
                    stats.get(i).ajouterValeur(valeur);
                } catch (NumberFormatException e) {
                    // Colonne non numérique détectée → on la marque et on passe
                    colonneNumerique[i] = false;
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

