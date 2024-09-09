package ca.ulaval.glo4002.tp.intro.question.interfaces;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import ca.ulaval.glo4002.tp.intro.question.application.ServiceInspection;
import ca.ulaval.glo4002.tp.intro.question.domaine.etablissement.EtablissementStockage;
import ca.ulaval.glo4002.tp.intro.question.infrastructure.persistence.memoire.EtablissementStockageEnMemoire;

public class ConfigurationServeurRest extends AbstractBinder {
    @Override
    protected void configure() {
        bindAsContract(ServiceInspection.class);
        bind(EtablissementStockageEnMemoire.class).to(EtablissementStockage.class);
    }
}
