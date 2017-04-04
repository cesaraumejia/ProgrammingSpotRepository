package Logico;

import java.util.ArrayList;

public class Programmer extends Worker {
	private String programmingLanguage;
	private String programmerType;
	

	public Programmer() {  
		// TODO Auto-generated constructor stub
	}

	public Programmer(String idNumber, String firstName, String lastName, String address, String sex, String birthday,
			String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant, String programmingLanguage, String programmerType, String telefono, ArrayList<Contract> contract) {
		super(idNumber, firstName, lastName, address, sex, birthday, projetName, anualEvaluation, hourlyPayment, workedHours, projectsQuant, telefono, contract);
		this.programmingLanguage = programmingLanguage;
		this.programmerType = programmerType;
	}

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public String getProgrammerType() {
		return programmerType;
	}

	public void setProgrammerType(String programmerType) {
		this.programmerType = programmerType;
	}
	
	public float computeSalary(){
		return super.computeSalary();
	}

}
