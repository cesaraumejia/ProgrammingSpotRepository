package Logico;

public class Planner extends Worker {

	private int daysQuant;
	
	public Planner() {
		// TODO Auto-generated constructor stub
	}

	public Planner(String idNumber, String firstName, String lastName, String address, String sex, String birthday,
			String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant, int daysQuant, String telefono) {
		super(idNumber, firstName, lastName, address, sex, birthday, projetName, anualEvaluation, hourlyPayment, workedHours, projectsQuant, telefono);
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
