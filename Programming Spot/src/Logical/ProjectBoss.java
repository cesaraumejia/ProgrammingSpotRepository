package Logical;

public class ProjectBoss extends Worker {
	private int workerQuant;
	private String password;
	

	public ProjectBoss() {
		// TODO Auto-generated constructor stub
	}

	public ProjectBoss(int idNumber, String firstName, String lastName, String address, String sex, int age,
			float salary, String projetName, String anualEvaluation, int workerQuant, String password) {
		super(idNumber, firstName, lastName, address, sex, age, salary, projetName, anualEvaluation);
		this.workerQuant = workerQuant;
		this.password = password;
	}

	public int getWorkerQuant() {
		return workerQuant;
	}

	public void setWorkerQuant(int workerQuant) {
		this.workerQuant = workerQuant;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
