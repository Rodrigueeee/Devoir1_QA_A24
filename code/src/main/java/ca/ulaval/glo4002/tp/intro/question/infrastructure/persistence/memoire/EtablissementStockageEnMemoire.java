package ca.ulaval.glo4002.tp.intro.question.infrastructure.persistence.memoire;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jvnet.hk2.annotations.Service;

import ca.ulaval.glo4002.tp.intro.question.domaine.equipement.EquipementPerimable;
import ca.ulaval.glo4002.tp.intro.question.domaine.equipement.NoSerie;
import ca.ulaval.glo4002.tp.intro.question.domaine.etablissement.EtablissementNonTrouveException;
import ca.ulaval.glo4002.tp.intro.question.domaine.etablissement.EtablissementStockage;
import ca.ulaval.glo4002.tp.intro.question.domaine.etablissement.numero.NoEtablissement;
import ca.ulaval.glo4002.tp.intro.question.domaine.etablissement.Etablissement;

@Service
public class EtablissementStockageEnMemoire implements EtablissementStockage {
    private static final Map<NoEtablissement, Etablissement> stockage = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Etablissement trouverEtablissement(NoEtablissement noEtablissement) {
        var etablissement = stockage.get(noEtablissement);
        if (etablissement == null) {
            throw new EtablissementNonTrouveException(noEtablissement);
        }

        return etablissement;
    }

    public void ajouterEtablissement(Etablissement etablissement) {
        stockage.put(etablissement.getNumero(), etablissement);
    }
}
