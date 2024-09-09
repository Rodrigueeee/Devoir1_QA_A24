package ca.ulaval.glo4002.tp.intro.question.interfaces.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ca.ulaval.glo4002.tp.intro.question.domaine.equipement.NoSerie;
import ca.ulaval.glo4002.tp.intro.question.domaine.equipement.StatutEquipement;

public class EtatEquipement{
    @JsonProperty("no_serie")
    private final NoSerie noSerie;
    @JsonProperty("description")
    private final String description;
    @JsonProperty("statut")
    public final StatutEquipement statut;

    public EtatEquipement(NoSerie noSerie, String description, StatutEquipement statut) {
        this.noSerie = noSerie;
        this.description = description;
        this.statut = statut;
    }

    public boolean estPourMemeEquipement(EtatEquipement autre) {
        return this.noSerie.equals(autre.noSerie);
    }
}
