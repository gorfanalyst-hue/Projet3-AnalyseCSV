
# René Eutyche Gouater

## Travail effectué

### 1- Création des interfaces

#### 1.1- ICalculateur
- Définition du contrat de calcul des statistiques
- Déclaration de la méthode calculer(donnees, entetes)
- Permet d'ajouter de nouveaux types de calculs sans modifier le code existant (OCP)

#### 1.2- IExporteur
- Définition du contrat d'export des résultats
- Déclaration des méthodes exporterTXT() et exporterCSV()
- Séparation en interface distincte de IAfficheur (ISP)

### 2- Implémentation des classes

#### 2.1- AnalyseurDonnees
- Orchestration du pipeline complet : lecture → calcul → affichage → export
- Injection des dépendances via le constructeur (DIP)
- Gestion des exceptions lors de la lecture du fichier CSV

#### 2.2- CalculateurStats
- Détection automatique des colonnes numériques
- Calcul de la moyenne, du minimum et du maximum par colonne
- Gestion des valeurs non numériques avec NumberFormatException
- Affichage d'un avertissement si une colonne mixte est détectée

#### 2.3- ExporteurFichier
- Export des statistiques dans un fichier texte (statistiques.txt)
- Export des statistiques dans un fichier CSV (resume.csv)
- Gestion des exceptions IOException lors de l'écriture des fichiers

#### 2.4- Main
- Point d'entrée du programme
- Injection des implémentations concrètes (LecteurCSV, CalculateurStats, etc.)
- Lancement du pipeline d'analyse et de l'export des résultats
