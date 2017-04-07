package Logico;

import java.util.ArrayList;

public class Planner extends Worker {

	private String methodology;
	
	public Planner() {
		// TODO Auto-generated constructor stub
	}

	public Planner(String idNumber, String firstName, String lastName, String address, String sex, String birthday,
			String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant, int daysQuant, String telefono, ArrayList<Contract> contract, String methodology) {
		super(idNumber, firstName, lastName, address, sex, birthday, projetName, anualEvaluation, hourlyPayment, workedHours, projectsQuant, telefono, contract);
		this.methodology = methodology;
	}

	
	public float computeSalary(){
		return super.computeSalary();
	}

	public String getMethodology() {
		return methodology;
	}

	public void setMethodology(String methodology) {
		this.methodology = methodology;
	}

}
