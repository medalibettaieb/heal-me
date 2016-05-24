package services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Appointement;
import entities.AppointementId;
import entities.Doctor;
import entities.Patient;
import entities.StateAppointement;

/**
 * Session Bean implementation class AppointementServices
 */
@Stateless
public class AppointementServices implements AppointementServicesRemote {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private UserServicesRemote userServices;

	/**
	 * Default constructor.
	 */
	public AppointementServices() {
	}

	@Override
	public void addAppointement(String patientId, String doctorId, Date dateOfTheAppointement) {
		Patient patient = (Patient) userServices.findUserById(patientId);
		Doctor doctor = (Doctor) userServices.findUserById(doctorId);

		Appointement appointement = new Appointement(patient, doctor, dateOfTheAppointement);

		entityManager.persist(appointement);

	}

	@Override
	public void accepteAppointement(String patientId, String doctorId, Date dateOfTheAppointement) {

		Appointement appointement = entityManager.find(Appointement.class,
				new AppointementId(doctorId, patientId, dateOfTheAppointement));
		appointement.setState(StateAppointement.ACCEPTED);

		entityManager.merge(appointement);

	}

	@Override
	public void refuseAppointement(String patientId, String doctorId, Date dateOfTheAppointement) {
		Appointement appointement = entityManager.find(Appointement.class,
				new AppointementId(doctorId, patientId, dateOfTheAppointement));
		appointement.setState(StateAppointement.REFUSED);

		entityManager.merge(appointement);

	}

	@Override
	public List<Patient> findAppointementsPatientsByDoctorId(String doctorId) {
		return entityManager
				.createQuery("select p from Patient p join p.appointements pa where pa.doctor.id=:param", Patient.class)
				.setParameter("param", doctorId).getResultList();

	}

	@Override
	public List<Patient> findAcceptedAppointementsPatientsByDoctorId(String doctorId) {
		return entityManager
				.createQuery(
						"select p from Patient p join p.appointements pa where pa.doctor.id=:param1 and pa.state=:param2",
						Patient.class)
				.setParameter("param1", doctorId).setParameter("param2", StateAppointement.ACCEPTED).getResultList();
	}

}
