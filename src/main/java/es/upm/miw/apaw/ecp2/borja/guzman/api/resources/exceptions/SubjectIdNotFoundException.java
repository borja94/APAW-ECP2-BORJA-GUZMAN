package es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions;

public class SubjectIdNotFoundException extends Exception {

	private static final long serialVersionUID = -642045799876625537L;

	public static final String DESCRIPTION = "Id de la asignatura no encontrado";

	public SubjectIdNotFoundException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public SubjectIdNotFoundException() {
		this("");
	}
}
