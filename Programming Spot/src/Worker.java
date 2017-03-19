
public abstract class Worker {
	private int idNumber;
	private String firstName;
	private String lastName;
	private String address;
	private String sex;
	private int age;
	private float salary;
	private String projetName;
	private String anualEvaluation;

	public Worker() {
		// TODO Auto-generated constructor stub
	}

	public Worker(int idNumber, String firstName, String lastName, String address, String sex, int age, float salary,
			String projetName, String anualEvaluation) {
		super();
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.sex = sex;
		this.age = age;
		this.salary = salary;
		this.projetName = projetName;
		this.anualEvaluation = anualEvaluation;
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

	public void setSalary(float salary) {
		this.salary = salary;
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

}
