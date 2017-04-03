package Logico;

public abstract class Worker {
	protected String idNumber;
	protected String firstName;
	protected String lastName;
	protected String address;
	protected String sex;
	protected String birthday;
	protected float salary;
	protected String projetName;
	protected String anualEvaluation;
	protected int hourlyPayment;
	protected int workedHours;
	protected int projectsQuant;
	protected boolean available;
	protected String telefono;

	public Worker() {
		// TODO Auto-generated constructor stub
	}

	public Worker(String idNumber, String firstName, String lastName, String address, String sex, String birthday,
			String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant, String telefono) {
		super();
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.sex = sex;
		this.birthday = birthday;
		this.projetName = projetName;
		this.anualEvaluation = anualEvaluation;
		this.hourlyPayment = hourlyPayment;
		this.workedHours = workedHours;
		this.projectsQuant = projectsQuant;
		this.available=true;
		this.telefono = telefono;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
		
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
