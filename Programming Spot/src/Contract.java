
public class Contract {
	private int initialDate;
	private int finalDate;
	private String contractID;
	private String clientID;
	private Project project;
	private float penalitation;
	

	public Contract() {
		// TODO Auto-generated constructor stub
	}


	public Contract(int initialDate, int finalDate, String contractID, String clientID, Project project,
			float penalitation) {
		super();
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.contractID = contractID;
		this.clientID = clientID;
		this.project = project;
		this.penalitation = penalitation;
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


	public String getClientID() {
		return clientID;
	}


	public void setClientID(String clientID) {
		this.clientID = clientID;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public float getPenalitation() {
		return penalitation;
	}


	public void setPenalitation(float penalitation) {
		this.penalitation = penalitation;
	}

}
