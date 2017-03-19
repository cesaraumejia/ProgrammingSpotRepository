package Logico;

public class Planner extends Worker {

	private int daysQuant;
	
	public Planner() {
		// TODO Auto-generated constructor stub
	}

	public Planner(int idNumber, String firstName, String lastName, String address, String sex, int age,
			String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant, int daysQuant) {
		super(idNumber, firstName, lastName, address, sex, age, projetName, anualEvaluation, hourlyPayment, workedHours, projectsQuant);
		this.daysQuant = daysQuant;
	}

	public int getDaysQuant() {
		return daysQuant;
	}

	public void setDaysQuant(int daysQuant) {
		this.daysQuant = daysQuant;
	}
	
	public float computeSalary(){
		return super.computeSalary();
	}

}
