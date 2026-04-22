import java.util.List;

/**
 * ILecteur.java
 *
 * SOLID - DIP (Dependency Inversion Principle) :
 *   Interface abstraite pour la lecture de données.
 *   Les modules de haut niveau (AnalyseurDonnees) dépendent
 *   de cette abstraction, pas d'une implémentation concrète.
 *
 *   On pourrait brancher un LecteurJSON, LecteurBD, etc.
 *   sans toucher au reste du code.
 */
public interface ILecteur {

    /**
     * Lit les données et retourne les lignes sous forme de listes de chaînes.
     * @return liste de lignes (chaque ligne = liste de cellules)
     * @throws Exception si la lecture échoue
     */
    List<List<String>> lire() throws Exception;

    /**
     * Retourne les noms des colonnes (en-têtes).
     * @return tableau des noms de colonnes
     */
    String[] getEntetes();
}
