package ca.ulaval.glo4002.tp.intro.question.interfaces.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErreurRest {
    @JsonProperty("message")
    private final String message;

    public ErreurRest(String message) {
        this.message = message;
    }
}
