package es.upm.miw.apaw.ecp2.borja.guzman.entities;

import java.util.Calendar;

public class Student {

	private int id;
	private String dni;
	private String name;
	private Calendar birthdate;
	private Subject subject;

	public Student(int id ) {
		assert id>0;
		this.id = id;
	}
	public Student(int id, String dni, String name, Calendar birthdate, Subject subject) {
		assert id > 0;
		assert dni != null;
		assert name != null;
		assert birthdate != null;
		assert subject != null;

		this.setId(id);
		this.setDni(dni);
		this.setName(name);
		this.setBirthDate(birthdate);
		this.setSubject(subject);
	}

	public int getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}

	public Calendar getBirthDate() {
		return birthdate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setId(int id) {
		assert id > 0;
		this.id = id;
	}

	public void setDni(String dni) {
		assert dni != null;
		this.dni = dni;
	}

	public void setName(String name) {
		assert name != null;
		this.name = name;
	}

	public void setBirthDate(Calendar birthdate) {
		assert birthdate != null;
		this.birthdate = birthdate;
	}

	public void setSubject(Subject subject) {
		assert subject != null;
		this.subject = subject;
	}

}
