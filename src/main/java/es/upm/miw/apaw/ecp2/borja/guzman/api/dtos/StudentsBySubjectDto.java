package es.upm.miw.apaw.ecp2.borja.guzman.api.dtos;

import java.util.List;

public class StudentsBySubjectDto {

	private List<StudentDto> students;
	private SubjectDto subject;

	public StudentsBySubjectDto(List<StudentDto> students, SubjectDto subject) {
		this.subject = subject;
		this.students = students;
	}

	public List<StudentDto> getStudents() {
		return students;
	}

	public SubjectDto getSubject() {
		return subject;
	}

	public void setSudents(List<StudentDto> students) {
		this.students = students;
	}

	public void setSubject(SubjectDto subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		String result = "{" + subject.toString() + "[";
		boolean first = true;
		for (StudentDto item : students) {
			if (!first)
				result = result + ",";
			
			result = result + item.toString();
			first = false;
		}
		result = result + "]}";

		return result;
	}

}
