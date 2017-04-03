package Logico;

public class SoftwareTester extends Worker {

	public SoftwareTester() {
		// TODO Auto-generated constructor stub
	}

	public SoftwareTester(String idNumber, String firstName, String lastName, String address, String sex, String birthday,
		 String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant, String telefono) {
		super(idNumber, firstName, lastName, address, sex, birthday, projetName, anualEvaluation, hourlyPayment, workedHours, projectsQuant, telefono);
		// TODO Auto-generated constructor stub
	}
	
	public float computeSalary(){
		return super.computeSalary();
	}

}
