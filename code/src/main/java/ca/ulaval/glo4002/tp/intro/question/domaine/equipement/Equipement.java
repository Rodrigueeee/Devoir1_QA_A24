package ca.ulaval.glo4002.tp.intro.question.domaine.equipement;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public abstract class Equipement {
    protected final NoSerie noSerie;
    protected final String description;
    protected final String localisation;

    protected LocalDateTime derniereInspection;
    protected Duration dureValiditeInspection;

    public Equipement(
        NoSerie noSerie,
        String description,
        String localisation,
        LocalDateTime derniereInspection,
        Duration dureValiditeInspection
    ) {
        this.noSerie = noSerie;
        this.description = description;
        this.localisation = localisation;
        this.derniereInspection = derniereInspection;
        this.dureValiditeInspection = dureValiditeInspection;
    }

    public NoSerie getNoSerie() {
        return this.noSerie;
    }

    public String getDescription() {
        return description;
    }

    public abstract boolean estPerimable();

    public abstract LocalDateTime datePeremption();

    public abstract boolean estUnContenant();

    public abstract List<Equipement> getEquipementDansContenant();


    public StatutEquipement getStatutInspection() {
        LocalDateTime aujourdhui = LocalDateTime.now();
        if( this.derniereInspection.plus(this.dureValiditeInspection).isAfter(aujourdhui)) {
            return StatutEquipement.A_INSPECTER;
        }

        return StatutEquipement.OK;
    }

}
