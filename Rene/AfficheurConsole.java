import java.util.List;

/**
 * AfficheurConsole.java
 *
 * SOLID - SRP (Single Responsibility Principle) :
 *   Une seule responsabilité : afficher les statistiques dans la console.
 *   Elle ne lit pas, ne calcule pas, n'exporte pas.
 *
 * SOLID - LSP (Liskov Substitution Principle) :
 *   Peut remplacer IAfficheur partout sans changer le comportement attendu.
 *   Ex : AfficheurHTML implements IAfficheur fonctionnerait pareil.
 */
public class AfficheurConsole implements IAfficheur {

    /**
     * Affiche un tableau formaté des statistiques dans la console.
     */
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

