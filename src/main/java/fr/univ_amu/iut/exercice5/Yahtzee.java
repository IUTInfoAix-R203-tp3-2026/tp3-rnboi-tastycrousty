package fr.univ_amu.iut.exercice5;

/// Kata 5 - Yahtzee scoring.
///
/// Chaque méthode statique calcule le score selon sa règle pour un lancer de 5
/// dés. Le kata est un classique du refactoring (Yatzy Refactoring Kata) : les
/// solutions "brute-force" fonctionnent vite, mais vous verrez que certaines
/// règles partagent une structure (compter les occurrences de chaque face) qu'on
/// peut factoriser.
///
/// Conseil : implémentez chaque méthode en TDD puis, quand plusieurs sont
/// vertes, cherchez une factorisation. C'est un bon entraînement au
/// TP4 (Refactoring).
public class Yahtzee {

  private Yahtzee() {}

  /// Compte les occurrences de chaque face (index 0 inutilisé, index 1..6
  /// = faces).
  private static int[] compterOccurrences(int d1, int d2, int d3, int d4, int d5) {
    int[] occurrences = new int[7];
    for (int d : new int[] {d1, d2, d3, d4, d5}) {
      occurrences[d]++;
    }
    return occurrences;
  }

  /// Somme des 5 dés (quelle que soit leur valeur).
  public static int chance(int d1, int d2, int d3, int d4, int d5) {
    // TODO kata 5 : sommer les 5 dés.
    return d1 + d2 + d3 + d4 + d5;
  }

  /// 50 points si les 5 dés sont identiques, 0 sinon.
  public static int yahtzee(int d1, int d2, int d3, int d4, int d5) {
    // TODO kata 5 : 50 si d1 == d2 == d3 == d4 == d5, 0 sinon.
    return d1 == d2 && d2 == d3 && d3 == d4 && d4 == d5 ? 50 : 0;
  }

  /// Somme des dés qui montrent la face demandée (utilisé pour ones, twos,
  /// ..., sixes).
  public static int nombres(int face, int[] des) {
    int total = 0;
    // TODO kata 5 : additionner les dés qui valent 'face'.
    for (int d : des) {
      if (d == face) total += face;
    }
    return total;
  }

  /// Valeur de la paire la plus haute (2 * valeur). 0 si aucune paire.
  public static int paire(int d1, int d2, int d3, int d4, int d5) {
    // TODO kata 5 : compter les occurrences de chaque face (1..6) puis
    // renvoyer 2 * la plus haute face qui apparaît au moins 2 fois.
    int[] occ = compterOccurrences(d1, d2, d3, d4, d5);
    for (int face = 6; face >= 1; face--) {
      if (occ[face] >= 2) return 2 * face;
    }
    return 0;
  }

  /// Somme de deux paires de valeurs différentes. 0 sinon.
  public static int deuxPaires(int d1, int d2, int d3, int d4, int d5) {
    // TODO kata 5 : trouver deux faces distinctes qui apparaissent >= 2 fois.
    int[] occ = compterOccurrences(d1, d2, d3, d4, d5);
    int score = 0;
    int pairestrouvees = 0;
    for (int face = 6; face >= 1; face--) {
      if (occ[face] >= 2) {
        score += 2 * face;
        pairestrouvees++;
      }
    }
    return pairestrouvees == 2 ? score : 0;
  }

  /// Somme de 3 dés identiques, 0 sinon.
  public static int brelan(int d1, int d2, int d3, int d4, int d5) {
    // TODO kata 5 : trouver la face qui apparaît au moins 3 fois, renvoyer 3 *
    // face.
    int[] occ = compterOccurrences(d1, d2, d3, d4, d5);
    for (int face = 6; face >= 1; face--) {
      if (occ[face] >= 3) return 3 * face;
    }
    return 0;
  }

  /// 15 si les 5 dés sont exactement 1-2-3-4-5, 0 sinon.
  public static int petiteSuite(int d1, int d2, int d3, int d4, int d5) {
    // TODO kata 5 : vérifier que chaque face de 1 à 5 apparaît exactement une fois.
    int[] occ = compterOccurrences(d1, d2, d3, d4, d5);
    for (int face = 1; face <= 5; face++) {
      if (occ[face] != 1) return 0;
    }
    return 15;
  }

  /// 20 si les 5 dés sont exactement 2-3-4-5-6, 0 sinon.
  public static int grandeSuite(int d1, int d2, int d3, int d4, int d5) {
    int[] occ = compterOccurrences(d1, d2, d3, d4, d5);
    for (int face = 2; face <= 6; face++) {
      if (occ[face] != 1) return 0;
    }
    return 20;
  }

  /// Somme des 5 dés si on a un brelan plus une paire d'une autre valeur,
  /// 0 sinon.
  public static int full(int d1, int d2, int d3, int d4, int d5) {
    // TODO kata 5 : un brelan (une face 3 fois) + une paire (autre face 2 fois).
    int[] occ = compterOccurrences(d1, d2, d3, d4, d5);
    boolean aBrelan = false;
    boolean aPaire = false;
    for (int face = 1; face <= 6; face++) {
      if (occ[face] == 3) aBrelan = true;
      if (occ[face] == 2) aPaire = true;
    }
    return aBrelan && aPaire ? d1 + d2 + d3 + d4 + d5 : 0;
  }
}
