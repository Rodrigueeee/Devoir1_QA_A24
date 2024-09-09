package ca.ulaval.glo4002.tp.intro.question.domaine.equipement;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class EquipementPerimable extends Equipement {
    private final LocalDateTime datePeremption;

    public EquipementPerimable(
        NoSerie noSerie,
        String description,
        String localisation,
        LocalDateTime derniereInspection,
        Duration dureValiditeInspection,
        LocalDateTime datePeremption
    ) {
        super(noSerie, description, localisation, derniereInspection, dureValiditeInspection);
        this.datePeremption = datePeremption;
    }

    @Override
    public boolean estPerimable() {
        return true;
    }

    @Override
    public LocalDateTime datePeremption() {
        return this.datePeremption;
    }

    @Override
    public boolean estUnContenant() {
        return false;
    }

    @Override
    public List<Equipement> getEquipementDansContenant() {
        return Collections.emptyList();
    }
}
