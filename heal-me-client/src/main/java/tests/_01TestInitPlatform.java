package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Doctor;
import entities.Patient;
import services.UserServicesRemote;

public class _01TestInitPlatform {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndi = "/heal-me/UserServices!services.UserServicesRemote";
		UserServicesRemote userServicesRemote = (UserServicesRemote) context.lookup(jndi);

		Doctor doctor = new Doctor("doc01", "Ali", "tounsi", "089758", "radiologue");
		Doctor doctor2 = new Doctor("doc02", "Amira", "fattouma", "074536", "pediatre");

		Patient patient = new Patient("pat01", "mohamed", "talbi", "021548", 60);
		Patient patient2 = new Patient("pat02", "najiba", "mohsni", "051241", 45);

		userServicesRemote.addUser(doctor);
		userServicesRemote.addUser(doctor2);
		userServicesRemote.addUser(patient);
		userServicesRemote.addUser(patient2);

	}

}
