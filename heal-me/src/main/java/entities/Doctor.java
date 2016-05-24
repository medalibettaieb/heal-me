package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Doctor
 *
 */
@Entity

public class Doctor extends User implements Serializable {

	private String speciality;
	private static final long serialVersionUID = 1L;

	private List<Appointement> appointements;

	public Doctor() {
		super();
	}

	public Doctor(String id, String firstName, String lastName, String cin, String speciality) {
		super(id, firstName, lastName, cin);
		this.speciality = speciality;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@OneToMany(mappedBy = "doctor")
	public List<Appointement> getAppointements() {
		return appointements;
	}

	public void setAppointements(List<Appointement> appointements) {
		this.appointements = appointements;
	}

}
