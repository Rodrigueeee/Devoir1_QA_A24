package ca.ulaval.glo4002.tp.intro.question.domaine.etablissement;

import ca.ulaval.glo4002.tp.intro.question.domaine.etablissement.numero.NoEtablissement;

public interface EtablissementStockage {
    Etablissement trouverEtablissement(NoEtablissement noEtablissement);
}
