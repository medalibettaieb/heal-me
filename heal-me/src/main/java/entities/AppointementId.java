package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class AppointementId implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String idDoctor;
	private String idPatient;
	private Date dateOfAppointement;

	public AppointementId() {
		// TODO Auto-generated constructor stub
	}

	public AppointementId(String idDoctor, String idPatient, Date dateOfAppointement) {
		super();
		this.idDoctor = idDoctor;
		this.idPatient = idPatient;
		this.dateOfAppointement = dateOfAppointement;
	}

	public String getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(String idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(String idPatient) {
		this.idPatient = idPatient;
	}

	public Date getDateOfAppointement() {
		return dateOfAppointement;
	}

	public void setDateOfAppointement(Date dateOfAppointement) {
		this.dateOfAppointement = dateOfAppointement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfAppointement == null) ? 0 : dateOfAppointement.hashCode());
		result = prime * result + ((idDoctor == null) ? 0 : idDoctor.hashCode());
		result = prime * result + ((idPatient == null) ? 0 : idPatient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppointementId other = (AppointementId) obj;
		if (dateOfAppointement == null) {
			if (other.dateOfAppointement != null)
				return false;
		} else if (!dateOfAppointement.equals(other.dateOfAppointement))
			return false;
		if (idDoctor == null) {
			if (other.idDoctor != null)
				return false;
		} else if (!idDoctor.equals(other.idDoctor))
			return false;
		if (idPatient == null) {
			if (other.idPatient != null)
				return false;
		} else if (!idPatient.equals(other.idPatient))
			return false;
		return true;
	}
}
