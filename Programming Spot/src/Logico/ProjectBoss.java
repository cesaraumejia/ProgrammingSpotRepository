package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectBoss extends Worker implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8233613402460131023L;
	private int experienceYears;
	private int projectsQuantity;
	
	public ProjectBoss() {
		// TODO Auto-generated constructor stub
	}

	public ProjectBoss(String idNumber, String firstName, String lastName, String address, String sex, String birthday,
			String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant, String telefono, ArrayList<Contract> contract, int experienceYears) {
		super(idNumber, firstName, lastName, address, sex, birthday, projetName, anualEvaluation, hourlyPayment, workedHours, projectsQuant, telefono, contract);
		this.experienceYears = experienceYears;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
	
	public float computeSalary(){
		return super.computeSalary();
	}
	


}
