import java.util.List;

public class AfficheurConsole implements IAfficheur {

    @Override
    public void afficher(List<Statistiques> statistiques) {
        System.out.println("Statistiques par colonne numérique :");
        System.out.println("-".repeat(85));
        System.out.printf("%-20s | %12s | %12s | %12s | %s%n",
                "Colonne", "Moyenne", "Minimum", "Maximum", "Valeurs");
        System.out.println("-".repeat(85));

        for (Statistiques stat : statistiques) {
            System.out.printf("%-20s | %12.2f | %12.2f | %12.2f | %d%n",
                    stat.getNomColonne(),
                    stat.getMoyenne(),
                    stat.getMinimum(),
                    stat.getMaximum(),
                    stat.getNombreValeurs());
        }

        System.out.println("-".repeat(85));
    }
}

