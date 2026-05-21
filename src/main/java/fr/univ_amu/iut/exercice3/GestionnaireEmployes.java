package fr.univ_amu.iut.exercice3;

import java.util.Comparator;
import java.util.List;

/// Kata 3 - Gestionnaire d'employés.
///
/// Opérations simples sur une collection d'[Employe] : filtrer, agréger, trier.
/// Kata idéal pour pratiquer les collections Java et la pensée "fonctions pures"
/// (les méthodes ne modifient pas la liste initiale).
public class GestionnaireEmployes {

  private final List<Employe> employes;

  public GestionnaireEmployes(List<Employe> employes) {
    this.employes = List.copyOf(employes);
  }

  /// Retourne la liste des employés âgés d'au moins 18 ans, dans
  /// l'ordre d'origine.
  public List<Employe> getMajeurs() {
    // TODO kata 3 : filtrer employes pour ne garder que ceux d'age >= 18.
    return employes.stream().filter(e -> e.age() >= 18).toList();
  }

  /// Retourne l'âge moyen des employés majeurs, ou `0.0` s'il n'y a aucun majeur
  /// (pour éviter une division par zéro).
  public double ageMoyenDesMajeurs() {
    // TODO kata 3 : additionner les âges des majeurs puis diviser par leur nombre.
    // Attention au cas "aucun majeur" → 0.0 (pas NaN).
    return getMajeurs().stream().mapToInt(Employe::age).average().orElse(0.0);
  }

  /// Retourne les employés triés par ordre alphabétique du nom (ne modifie pas
  /// la liste).
  public List<Employe> parOrdreAlphabetique() {
    // TODO kata 3 : trier tries avec un Comparator sur le nom.
    return employes.stream().sorted(Comparator.comparing(Employe::nom)).toList();
  }

  /// Retourne les employés triés par ordre croissant d'âge (ne modifie pas
  /// la liste).
  public List<Employe> parAgeCroissant() {
    // TODO kata 3 : trier tries avec un Comparator sur l'âge.
    return employes.stream().sorted(Comparator.comparingInt(Employe::age)).toList();
  }
}
