package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Appointement
 *
 */
@Entity

public class Appointement implements Serializable {

	private AppointementId appointementId;
	private StateAppointement state = StateAppointement.REQUEST;
	private static final long serialVersionUID = 1L;

	private Patient patient;
	private Doctor doctor;

	public Appointement() {
		super();
	}

	public Appointement(Patient patient, Doctor doctor, Date date) {
		super();
		getAppointementId().setIdDoctor(doctor.getId());
		getAppointementId().setIdPatient(patient.getId());
		getAppointementId().setDateOfAppointement(date);
		this.patient = patient;
		this.doctor = doctor;
	}

	@ManyToOne
	@JoinColumn(name = "idPatient", referencedColumnName = "id", updatable = false, insertable = false)
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@ManyToOne
	@JoinColumn(name = "idDoctor", referencedColumnName = "id", updatable = false, insertable = false)
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@EmbeddedId
	public AppointementId getAppointementId() {
		if (appointementId == null)
			appointementId = new AppointementId();
		return appointementId;
	}

	public void setAppointementId(AppointementId appointementId) {
		this.appointementId = appointementId;
	}
	@Enumerated(EnumType.STRING)
	public StateAppointement getState() {
		return state;
	}

	public void setState(StateAppointement state) {
		this.state = state;
	}

}
