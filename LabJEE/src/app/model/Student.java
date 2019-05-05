package app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private Integer studentId;
	
	@Column(nullable = false, length = 50)
	private String firstName;
	
	@Column(nullable = false, length = 100)
	private String lastName;
	
	@Column(unique = true, nullable = false)
	private String indexNumber;
	
	@Column
	private String email;
	
	@Column(nullable = false)
	private boolean isStationary;
	
	@ManyToMany(mappedBy = "students")
	private Set<Project> projects;
	
	public Student() {
		
	}

	public Student(String firstName, String lastName, String indexNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.indexNumber = indexNumber;
	}

	public Student(String firstName, String lastName, String indexNumber, String email, boolean isStationary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.indexNumber = indexNumber;
		this.email = email;
		this.isStationary = isStationary;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStationary() {
		return isStationary;
	}

	public void setStationary(boolean isStationary) {
		this.isStationary = isStationary;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
}
