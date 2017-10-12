package es.upm.miw.apaw.ecp2.borja.guzman.api.dtos;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import es.upm.miw.apaw.ecp2.borja.guzman.api.entities.Student;

public class StudentDto {

	private int id;
	private String name;
	private String dni;
	private Calendar birthdate;
	private SubjectDto subject;

	public StudentDto(Student student) {
		this.id = student.getId();
		this.name = student.getName();
		this.birthdate = student.getBirthDate();
		this.dni = student.getDni();
		this.subject = new SubjectDto(student.getSubject());
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDni() {
		return dni;
	}

	public Calendar getBirthdate() {
		return birthdate;
	}

	public SubjectDto getSubject() {
		return subject;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setBirthdate(Calendar birthdate) {
		this.birthdate = birthdate;
	}

	public void setSubject(SubjectDto subject) {
		this.subject = subject;
	}
	@Override
    public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        return "{\"id\":" + id + ",\"name\":\"" + name + "\""+ ",\"dni\":\"" + dni + "\""+ ",\"birthdate\":\"" + format1.format(birthdate.getTime())+ "\""+  ",\"subject\":" + subject.toString() + "}";
    }
}
