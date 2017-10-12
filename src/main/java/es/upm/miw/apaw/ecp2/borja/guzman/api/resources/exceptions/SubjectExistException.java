package es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions;

public class SubjectExistException extends Exception {

	private static final long serialVersionUID = -642045799876625537L;

	public static final String DESCRIPTION = "Asignatura repetida en un mismo curso";

	public SubjectExistException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public SubjectExistException() {
		this("");
	}

}
