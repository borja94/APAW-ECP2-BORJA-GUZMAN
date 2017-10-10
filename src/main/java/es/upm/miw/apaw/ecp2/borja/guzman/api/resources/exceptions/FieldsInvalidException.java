package es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions;

public class FieldsInvalidException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Campos incorrectos";

    public FieldsInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public FieldsInvalidException() {
        this("");
    }

}
