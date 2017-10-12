package es.upm.miw.apaw.ecp2.borja.guzman.api.dtos;

import es.upm.miw.apaw.ecp2.borja.guzman.api.entities.Subject;

public class SubjectDto {

	private int id;
	private String title;
	private int course;
	
	public SubjectDto(Subject subject) {
		this.id = subject.getId();
		this.title = subject.getTitle();
		this.course = subject.getCourse();
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getCourse() {
		return course;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTitle (String title) {
		this.title = title;
	}
	
	public void setCourse(int course) {
		this.course = course;
	}
	
	@Override
    public String toString() {
        return "{\"id\":" + id + ",\"course\":\"" + course + "\""+ ",\"title\":\"" + title + "\"}";
    }
}
