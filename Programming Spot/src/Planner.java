
public class Planner extends Worker {

	private int daysQuant;
	
	public Planner() {
		// TODO Auto-generated constructor stub
	}

	public Planner(int idNumber, String firstName, String lastName, String address, String sex, int age, float salary,
			String projetName, String anualEvaluation, int daysQuant) {
		super(idNumber, firstName, lastName, address, sex, age, salary, projetName, anualEvaluation);
		this.daysQuant = daysQuant;
	}

	public int getDaysQuant() {
		return daysQuant;
	}

	public void setDaysQuant(int daysQuant) {
		this.daysQuant = daysQuant;
	}

}
