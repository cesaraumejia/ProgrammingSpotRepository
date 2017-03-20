package Logico;

public class Contract {
	private int initialDate;
	private int finalDate;
	private String contractID;
	private Client client;
	private Project project;
	private double finalPrice;
	

	public Contract() {
		// TODO Auto-generated constructor stub
	}

	

	public Contract(int initialDate, int finalDate, String contractID, Client clientID, Project project,double finalPrice) {
		super();
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.contractID = contractID;
		this.client = clientID;
		this.project = project;
		this.finalPrice=finalPrice;
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


	public String getContractID() {
		return contractID;
	}


	public void setContractID(String contractID) {
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


	public double getFinalPrice() {
	    return finalPrice;
	}


	public void setFinalPrice(double finalPrice) {
	    this.finalPrice = finalPrice;
	}
	

}
