package Logico;

import java.util.ArrayList;

public class ProjectBoss extends Worker {
	private int workerQuant;
	private String password;   
	

	public ProjectBoss() {
		// TODO Auto-generated constructor stub
	}

	public ProjectBoss(String idNumber, String firstName, String lastName, String address, String sex, String birthday,
			String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant, int workerQuant, String password, String telefono, ArrayList<Contract> contract) {
		super(idNumber, firstName, lastName, address, sex, birthday, projetName, anualEvaluation, hourlyPayment, workedHours, projectsQuant, telefono, contract);
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
	
	public float computeSalary(){
		return super.computeSalary();
	}
	


}
