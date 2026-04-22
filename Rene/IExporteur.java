import java.util.List;

/**
 * IExporteur.java
 *
 * SOLID - ISP (Interface Segregation Principle) :
 *   Interface séparée uniquement pour l'export de fichiers.
 *   Une classe qui n'a besoin que d'afficher n'est pas forcée
 *   d'implémenter exporter().
 *
 * SOLID - OCP (Open/Closed Principle) :
 *   Pour ajouter un export PDF ou Excel, on crée
 *   ExporteurPDF implements IExporteur.
 *   On ne modifie jamais ExporteurFichier.
 *
 * SOLID - DIP (Dependency Inversion Principle) :
 *   AnalyseurDonnees dépend de cette abstraction.
 */
public interface IExporteur {

    /**
     * Exporte les statistiques vers un fichier texte (.txt).
     * @param statistiques  données à exporter
     * @param cheminFichier chemin du fichier de sortie
     */
    void exporterTXT(List<Statistiques> statistiques, String cheminFichier);

    /**
     * Exporte les statistiques vers un fichier CSV (.csv).
     * @param statistiques  données à exporter
     * @param cheminFichier chemin du fichier de sortie
     */
    void exporterCSV(List<Statistiques> statistiques, String cheminFichier);
}

