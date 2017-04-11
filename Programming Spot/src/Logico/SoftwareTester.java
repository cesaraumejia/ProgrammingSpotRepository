package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class SoftwareTester extends Worker implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1078814206006148061L;
	private String testingSoftware;

	public SoftwareTester() {  
		// TODO Auto-generated constructor stub
	}

	public SoftwareTester(String idNumber, String firstName, String lastName, String address, String sex, String birthday,
		 String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant, String telefono, ArrayList<Contract> contract, String testingSoftware) {
		super(idNumber, firstName, lastName, address, sex, birthday, projetName, anualEvaluation, hourlyPayment, workedHours, projectsQuant, telefono, contract);
		this.testingSoftware = testingSoftware;
	}
	
	public float computeSalary(){
		return super.computeSalary();
	}

	public String getTestingSoftware() {
		return testingSoftware;
	}

	public void setTestingSoftware(String testingSoftware) {
		this.testingSoftware = testingSoftware;
	}

}
