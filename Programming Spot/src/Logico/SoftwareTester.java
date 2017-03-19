package Logico;

public class SoftwareTester extends Worker {

	public SoftwareTester() {
		// TODO Auto-generated constructor stub
	}

	public SoftwareTester(int idNumber, String firstName, String lastName, String address, String sex, int age,
		 String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant) {
		super(idNumber, firstName, lastName, address, sex, age, projetName, anualEvaluation, hourlyPayment, workedHours, projectsQuant);
		// TODO Auto-generated constructor stub
	}
	
	public float computeSalary(){
		return super.computeSalary();
	}

}
