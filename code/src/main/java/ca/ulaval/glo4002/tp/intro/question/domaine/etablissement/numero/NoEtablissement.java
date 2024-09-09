package ca.ulaval.glo4002.tp.intro.question.domaine.etablissement.numero;

import java.util.UUID;

public class NoEtablissement {
    private Long numeroV1 = null;
    private UUID numeroV2 = null;

    @Deprecated
    public static NoEtablissement genererV1() {
        throw new RuntimeException("La version 1 n'est plus supporté pour des nouveau numéros.");
    }

    public static NoEtablissement genererV2() {
        return new NoEtablissement(UUID.randomUUID());
    }

    public static NoEtablissement depuisStringV1(String numero) {
        return new NoEtablissement(Long.parseLong(numero));
    }

    public static NoEtablissement depuisStringV2(String numero) {
        return new NoEtablissement(UUID.fromString(numero));
    }

    private NoEtablissement(Long numeroV1) {
        this.numeroV1 = numeroV1;
    }

    private NoEtablissement(UUID numeroV2) {
        this.numeroV2 = numeroV2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NoEtablissement that = (NoEtablissement) o;
        if (this.numeroV1 != null && that.numeroV1 != null) {
            return this.numeroV1 == that.numeroV1;
        }

        if (this.numeroV2 != null && that.numeroV2 != null) {
            return this.numeroV2.equals(that.numeroV2);
        }

        return false;
    }

    @Override
    public int hashCode() {
        if (this.numeroV1 != null) {
            return this.numeroV1.hashCode();
        }

        return this.numeroV2.hashCode();
    }

    public String asString() {
        if (this.numeroV1 != null) {
            return this.numeroV1.toString();
        } else {
            return this.numeroV2.toString();
        }
    };
}
