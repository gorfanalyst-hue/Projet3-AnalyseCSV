# Projet 3 – Analyse de fichier CSV

## Membres du groupe
- Rene Eutyche Gouater
- Sylvain Effohi

## Description
Programme Java qui lit un fichier CSV, calcule les statistiques
(moyenne, minimum, maximum) pour chaque colonne numérique,
affiche les résultats et génère des rapports exportés.

## Fonctionnalités développées
- Lecture automatique d'un fichier CSV
- Détection des colonnes numériques
- Calcul de moyenne, minimum, maximum par colonne
- Affichage formaté dans la console
- Export des résultats dans statistiques.txt et resume.csv (bonus)

## Architecture (principes SOLID)
- `ILecteur` / `LecteurCSV` : lecture du fichier CSV
- `ICalculateur` / `CalculateurStats` : Analyse des données pour vérifier leur conformité
- `IAfficheur` / `AfficheurConsole` : affichage console
- `IExporteur` / `ExporteurFichier` : export TXT et CSV
- `AnalyseurDonnees` : orchestration du pipeline
- `Statistiques` : calcul des statistiques min, max, moyenne

## Instructions d'exécution
1. Cloner le dépôt
2. Placer un fichier data.csv à la racine du projet
3. Compiler : javac -d out src/*.java
4. Exécuter : java -cp out Main

## Format du fichier CSV attendu
- Première ligne = en-têtes des colonnes
- Séparateur : virgule (,)
- Les colonnes texte sont ignorées automatiquement
