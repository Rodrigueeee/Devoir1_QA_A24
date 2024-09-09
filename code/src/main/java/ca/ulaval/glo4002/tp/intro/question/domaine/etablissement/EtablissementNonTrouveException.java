package ca.ulaval.glo4002.tp.intro.question.domaine.etablissement;

import ca.ulaval.glo4002.tp.intro.question.domaine.etablissement.numero.NoEtablissement;

public class EtablissementNonTrouveException extends RuntimeException {
    public EtablissementNonTrouveException(NoEtablissement noEtablissement) {
        super("Aucun établissement ne correspond au numéro: " + noEtablissement.asString());
    }
}
