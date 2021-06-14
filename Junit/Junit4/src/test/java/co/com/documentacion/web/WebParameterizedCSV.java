package co.com.documentacion.web;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import co.com.utility.Data;


@RunWith(Parameterized.class)
public class WebParameterizedCSV {

	private static final String filename = "src/test/resources/UserAccounts.csv";

	private String name, email, phone;

	@Test
	public void test() {
		System.out.println(name + " " + email + " " + phone);
	}

	@Parameters
	public static List<String[]> getData() {
		return Data.csv(filename);
	}

	// Ellie Prynne,ep@testemail.com,1234567890,Female,ep1password,Italy,TRUE,FALSE,FALSE
	public WebParameterizedCSV(String name, String email, String phone, String gender, String password, String country,
			String week, String mount, String acept) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

}
