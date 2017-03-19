package Logico;

public class Contract {
	private int initialDate;
	private int finalDate;
	private int contractID;
	private Client client;
	private Project project;
	

	public Contract() {
		// TODO Auto-generated constructor stub
	}


	public Contract(int initialDate, int finalDate, int contractID, Client clientID, Project project) {
		super();
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.contractID = contractID;
		this.client = clientID;
		this.project = project;
	}


	public int getInitialDate() {
		return initialDate;
	}


	public void setInitialDate(int initialDate) {
		this.initialDate = initialDate;
	}


	public int getFinalDate() {
		return finalDate;
	}


	public void setFinalDate(int finalDate) {
		this.finalDate = finalDate;
	}


	public int getContractID() {
		return contractID;
	}


	public void setContractID(int contractID) {
		this.contractID = contractID;
	}


	public Client getClient() {
		return client;
	}


	public void setClientID(Client client) {
		this.client = client;
	}


	public Project getProject() {
		return project;
	}
	

	public float calculatePrice() {
		return project.calculateBasePrice();
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public void setProject(Project project) {
		this.project = project;
	}

}
