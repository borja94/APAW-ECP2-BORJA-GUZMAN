package es.upm.miw.apaw.ecp2.borja.guzman.api.entities;

public class Subject {

	private int id;
	private int course;
	private String title;

	

	public Subject(String title,int course) {

		assert course > 0;
		assert title != null;

		this.setCourse(course);
		this.setTitle(title);
	}

	public int getId() {
		return id;
	}

	public int getCourse() {
		return course;
	}

	public String getTitle() {
		return title;
	}

	public void setId(int id) {
		assert id > 0;
		this.id = id;
	}

	public void setCourse(int course) {
		assert course > 0;
		this.course = course;
	}

	public void setTitle(String title) {
		assert title != null;
		this.title = title;
	}
}
