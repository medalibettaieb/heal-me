package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entities.Patient;

@Remote
public interface AppointementServicesRemote {
	void addAppointement(String patientId, String doctorId, Date dateOfTheAppointement);

	void accepteAppointement(String patientId, String doctorId, Date dateOfTheAppointement);

	void refuseAppointement(String patientId, String doctorId, Date dateOfTheAppointement);

	List<Patient> findAppointementsPatientsByDoctorId(String doctorId);

	List<Patient> findAcceptedAppointementsPatientsByDoctorId(String doctorId);

}
