package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.AppointementServicesRemote;

public class _03TestCreateAppointement {

	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		String jndi = "/heal-me/AppointementServices!services.AppointementServicesRemote";
		AppointementServicesRemote appointementServicesRemote = (AppointementServicesRemote) context.lookup(jndi);

		appointementServicesRemote.addAppointement("pat01", "doc01",
				new SimpleDateFormat("dd/MM/yyyy").parse("20/05/2016"));
		
		appointementServicesRemote.addAppointement("pat02", "doc01",
				new SimpleDateFormat("dd/MM/yyyy").parse("29/05/2016"));

	}

}
