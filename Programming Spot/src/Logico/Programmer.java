package Logico;

public class Programmer extends Worker {
	private String programmingLanguage;
	private String programmerType;
	

	public Programmer() {
		// TODO Auto-generated constructor stub
	}

	public Programmer(int idNumber, String firstName, String lastName, String address, String sex, int age,
			String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant, String programmingLanguage, String programmerType) {
		super(idNumber, firstName, lastName, address, sex, age, projetName, anualEvaluation, hourlyPayment, workedHours, projectsQuant);
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
