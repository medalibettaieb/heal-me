package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Patient
 *
 */
@Entity

public class Patient extends User implements Serializable {
	private Integer age;
	private static final long serialVersionUID = 1L;

	private List<Appointement> appointements;

	public Patient() {
		super();
	}

	public Patient(String id, String firstName, String lastName, String cin, Integer age) {
		super(id, firstName, lastName, cin);
		this.age = age;
	}

	@OneToMany(mappedBy = "patient")
	public List<Appointement> getAppointements() {
		return appointements;
	}

	public void setAppointements(List<Appointement> appointements) {
		this.appointements = appointements;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Patient [age=" + age + ", toString()=" + super.toString() + "]";
	}

}
