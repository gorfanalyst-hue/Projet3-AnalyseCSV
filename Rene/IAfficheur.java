import java.util.List;

public interface IAfficheur {

    /**
     * IAfficheur.java
     *
     * SOLID - ISP (Interface Segregation Principle) :
     *   Interface séparée uniquement pour l'affichage console.
     *   On ne force pas une classe à implémenter afficher() ET exporter()
     *   dans la même interface.
     *   → IExporteur est une interface séparée.
     *
     * SOLID - DIP (Dependency Inversion Principle) :
     *   AnalyseurDonnees dépend de cette abstraction.
     */


        /**
         * Affiche les statistiques dans la console.
         * @param statistiques liste des statistiques à afficher
         */
        void afficher(List<Statistiques> statistiques);
}
