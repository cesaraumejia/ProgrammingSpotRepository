
public class Programmer extends Worker {
	private String programmingLanguage;
	private String programmerType;
	

	public Programmer() {
		// TODO Auto-generated constructor stub
	}

	public Programmer(int idNumber, String firstName, String lastName, String address, String sex, int age,
			float salary, String projetName, String anualEvaluation, String programmingLanguage, String programmerType) {
		super(idNumber, firstName, lastName, address, sex, age, salary, projetName, anualEvaluation);
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

}
