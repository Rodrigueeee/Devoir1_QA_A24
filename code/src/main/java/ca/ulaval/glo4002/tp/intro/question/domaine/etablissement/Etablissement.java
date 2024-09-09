package ca.ulaval.glo4002.tp.intro.question.domaine.etablissement;

import java.util.List;

import ca.ulaval.glo4002.tp.intro.question.domaine.etablissement.numero.NoEtablissement;
import ca.ulaval.glo4002.tp.intro.question.domaine.equipement.Equipement;

public class Etablissement {
    private final NoEtablissement noEtablissement;
    private final String nom;
    private final List<Equipement> equipements;

    public Etablissement(NoEtablissement noEtablissement, String nom, List<Equipement> equipements) {
        this.noEtablissement = noEtablissement;
        this.nom = nom;
        this.equipements = equipements;
    }

    public List<Equipement> obtenirEquipements() {
        return this.equipements;
    }

    public NoEtablissement getNumero() {
        return this.noEtablissement;
    }
}
