package fr.univ_amu.iut.exercice4;

/// Kata 4 - Pagination.
///
/// Kata algorithmique avec beaucoup de cas limites. Idéal pour pratiquer la
/// **discipline TDD** : on active les tests dans l'ordre (du plus simple au plus
/// complexe) et on résiste à la tentation d'anticiper.
public class Pagination {

  private final int courant;
  private final int total;

  public Pagination(int courant, int total) {
    this.courant = courant;
    this.total = total;
  }

  /// Retourne la représentation textuelle de la barre de pagination.
  ///
  /// Format : pages séparées par des espaces, page courante entre parenthèses,
  /// `...` pour combler les trous quand il y a plus de 7 pages au total.
  public String afficher() {
    // TODO kata 4 : construire la chaîne de pagination selon les règles
    // du README. Activez les tests dans l'ordre, ils vous guident :
    // - d'abord le cas "total <= 7" (affichage complet)
    // - puis le cas "beaucoup de pages" avec gestion des ellipses
    if (total <= 7) {
      return afficherToutes();
    }
    return afficherAvecEllipses();
  }

  private String afficherToutes() {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= total; i++) {
      if (i > 1) sb.append(" ");
      sb.append(formatPage(i));
    }
    return sb.toString();
  }

  private String afficherAvecEllipses() {
    StringBuilder sb = new StringBuilder();

    // Toujours afficher la première page
    sb.append(formatPage(1));

    // Page avant le courant (si elle existe et n'est pas la page 1)
    if (courant - 1 > 1) {
      sb.append(courant - 1 > 2 ? " ..." : "");
      sb.append(" ").append(formatPage(courant - 1));
    }

    // Page courante (si différente de 1)
    if (courant > 1) {
      sb.append(" ").append(formatPage(courant));
    }

    // Page après le courant (si elle existe et n'est pas la dernière)
    if (courant + 1 < total) {
      sb.append(" ").append(formatPage(courant + 1));
      sb.append(courant + 1 < total - 1 ? " ..." : "");
    }

    // Toujours afficher la dernière page (si différente du courant)
    if (courant < total) {
      sb.append(" ").append(formatPage(total));
    }

    return sb.toString();
  }

  private String formatPage(int page) {
    return page == courant ? "(" + page + ")" : String.valueOf(page);
  }
}
