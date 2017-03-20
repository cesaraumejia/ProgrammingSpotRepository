package Logico;

public abstract class Worker {
	protected int idNumber;
	protected String firstName;
	protected String lastName;
	protected String address;
	protected String sex;
	protected int age;
	protected float salary;
	protected String projetName;
	protected String anualEvaluation;
	protected int hourlyPayment;
	protected int workedHours;
	protected int projectsQuant;
	protected boolean available;

	public Worker() {
		// TODO Auto-generated constructor stub
	}

	public Worker(int idNumber, String firstName, String lastName, String address, String sex, int age,
			String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant) {
		super();
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.sex = sex;
		this.age = age;
		this.projetName = projetName;
		this.anualEvaluation = anualEvaluation;
		this.hourlyPayment = hourlyPayment;
		this.workedHours = workedHours;
		this.projectsQuant = projectsQuant;
		this.available=true;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}


	public String getProjetName() {
		return projetName;
	}

	public void setProjetName(String projetName) {
		this.projetName = projetName;
	}

	public String getAnualEvaluation() {
		return anualEvaluation;
	}

	public void setAnualEvaluation(String anualEvaluation) {
		this.anualEvaluation = anualEvaluation;
	}
	
	public int getHourlyPayment() {
		return hourlyPayment;
	}

	public void setHourlyPayment(int hourlyPayment) {
		this.hourlyPayment = hourlyPayment;
	}

	public int getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}

	public int getProjectsQuant() {
		return projectsQuant;
	}

	public void setProjectsQuant(int projectsQuant) {
		this.projectsQuant = projectsQuant;
	}




	public float computeSalary(){
		return salary = hourlyPayment * workedHours;
	}

	public boolean isAvailable() {
	    return available;
	}

	public void setAvailable(boolean available) {
	    this.available = available;
	}
	
	

}
