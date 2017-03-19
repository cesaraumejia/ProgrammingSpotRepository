package Logico;

public class Designer extends Worker {

	public Designer() {
		// TODO Auto-generated constructor stub
	}

	public Designer(int idNumber, String firstName, String lastName, String address, String sex, int age,
			String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant) {
		super(idNumber, firstName, lastName, address, sex, age, projetName, anualEvaluation, hourlyPayment, workedHours, projectsQuant);
		// TODO Auto-generated constructor stub
	}
	
	public float computeSalary(){
		return super.computeSalary();
	}

}
