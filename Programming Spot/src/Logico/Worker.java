package Logico;

import java.util.ArrayList;

public abstract class Worker {
	protected String idNumber;
	protected String firstName;
	protected String lastName;
	protected String address;
	protected String sex;
	protected String birthday;
	protected float salary;
	protected String anualEvaluation;
	protected int hourlyPayment;
	protected int workedHours;
	protected boolean available;
	protected String telefono;
	protected ArrayList<Contract> contract = new ArrayList<>();

	public Worker() {
		// TODO Auto-generated constructor stub
	}

	public Worker(String idNumber, String firstName, String lastName, String address, String sex, String birthday,
			String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant, String telefono, ArrayList<Contract> contract) {
		super();
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.sex = sex;
		this.birthday = birthday;
		this.anualEvaluation = anualEvaluation;
		this.hourlyPayment = hourlyPayment;
		this.workedHours = workedHours;
		this.available=true;
		this.telefono = telefono;
		this.contract = contract;
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

	public ArrayList<Contract> getContract() {
		return contract;
	}

	public void setContract(ArrayList<Contract> contract) {
		this.contract = contract;
	}
	
	

}
