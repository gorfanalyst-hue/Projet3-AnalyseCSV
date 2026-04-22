import java.util.List;

    public interface ICalculateur {

        List<Statistiques> calculer(List<List<String>> donnees, String[] entetes);
}
