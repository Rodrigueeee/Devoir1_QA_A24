package ca.ulaval.glo4002.tp.intro.question.interfaces.rest;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.ulaval.glo4002.tp.intro.question.application.ServiceInspection;
import ca.ulaval.glo4002.tp.intro.question.domaine.etablissement.numero.NoEtablissement;
import ca.ulaval.glo4002.tp.intro.question.interfaces.rest.dto.EtatEquipement;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/etablissements/{numero}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InspectionRessource {
    private static final Pattern REGEX_NO_V1 = Pattern.compile("\\d+");

    public ServiceInspection service;

    @Inject
    public InspectionRessource(ServiceInspection service) {
        this.service = service;
    }

    @GET()
    @Path("/equipements")
    public Response etatDesEquipement(
        @PathParam("numero") String noEtablissementStr,
        @QueryParam("inspectionSeulement") @DefaultValue("false") String inspectionSeulementStr
    ) {
        NoEtablissement noEtablissement;
        Matcher matcher = REGEX_NO_V1.matcher(noEtablissementStr);
        if (matcher.matches()) {
            noEtablissement = NoEtablissement.depuisStringV1(noEtablissementStr);
        } else {
            noEtablissement = NoEtablissement.depuisStringV2(noEtablissementStr);
        }

        boolean inspectionSeulement = Boolean.parseBoolean(inspectionSeulementStr);

        List<EtatEquipement> etatEquipements = this.service.listerEtatEquipement(noEtablissement, inspectionSeulement);

        return Response.ok(etatEquipements).build();
    }
}
