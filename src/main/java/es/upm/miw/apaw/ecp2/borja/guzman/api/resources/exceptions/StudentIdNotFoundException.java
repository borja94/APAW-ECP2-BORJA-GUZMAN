package es.upm.miw.apaw.ecp2.borja.guzman.api.resources.exceptions;

public class StudentIdNotFoundException extends Exception {

	private static final long serialVersionUID = -642045799876625537L;

	public static final String DESCRIPTION = "Id del estudiante no encontrado";

	public StudentIdNotFoundException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public StudentIdNotFoundException() {
		this("");
	}
}
