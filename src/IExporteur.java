import java.util.List;

public interface IExporteur {
    void exporterTXT(List<Statistiques> statistiques, String cheminFichier);

    void exporterCSV(List<Statistiques> statistiques, String cheminFichier);
}

