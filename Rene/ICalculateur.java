import java.util.List;

    /**
     * ICalculateur.java
     *
     * SOLID - OCP (Open/Closed Principle) :
     *   Si on veut ajouter un nouveau type de calcul (médiane, écart-type...),
     *   on crée une nouvelle implémentation. On ne modifie JAMAIS CalculateurStats.
     *
     * SOLID - DIP (Dependency Inversion Principle) :
     *   AnalyseurDonnees dépend de cette abstraction,
     *   pas d'une implémentation concrète.
     */
    public interface ICalculateur {

        /**
         * Calcule les statistiques à partir des données brutes et des en-têtes.
         *
         * @param donnees  liste de lignes (chaque ligne = liste de valeurs brutes)
         * @param entetes  noms des colonnes
         * @return liste de statistiques, une par colonne numérique
         */
        List<Statistiques> calculer(List<List<String>> donnees, String[] entetes);
}
