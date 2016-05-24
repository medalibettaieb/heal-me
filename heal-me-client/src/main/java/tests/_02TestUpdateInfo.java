package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Patient;
import services.UserServicesRemote;

public class _02TestUpdateInfo {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndi = "/heal-me/UserServices!services.UserServicesRemote";
		UserServicesRemote userServicesRemote = (UserServicesRemote) context.lookup(jndi);

		Patient patient = (Patient) userServicesRemote.findUserById("pat02");
		patient.setLastName("mouradi");

		userServicesRemote.deleteUserById("doc02");
		userServicesRemote.updateUser(patient);

	}

}
