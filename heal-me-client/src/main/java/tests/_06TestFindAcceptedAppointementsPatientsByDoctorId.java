package tests;

import java.text.ParseException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Patient;
import services.AppointementServicesRemote;

public class _06TestFindAcceptedAppointementsPatientsByDoctorId {

	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		String jndi = "/heal-me/AppointementServices!services.AppointementServicesRemote";
		AppointementServicesRemote appointementServicesRemote = (AppointementServicesRemote) context.lookup(jndi);

		List<Patient> patients = appointementServicesRemote.findAcceptedAppointementsPatientsByDoctorId("doc01");

		for (Patient patient : patients) {
			System.out.println(patient);
		}

	}

}
