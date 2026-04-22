import java.util.List;

public interface ILecteur {

    List<List<String>> lire() throws Exception;
    String[] getEntetes();
}
