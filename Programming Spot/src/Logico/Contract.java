package Logico;

import java.io.Serializable;

public class Contract implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5256167385752873110L;
	private String initialDate;
	private String finalDate;
	private String contractID;
	private Client client;
	private Project project;  
	private double finalPrice;
	private double lostMoney;
	public static int IDnumber=0;
	private int postpone=0;
	

	public Contract() {
		// TODO Auto-generated constructor stub
	}

	

	public Contract(String initialDate, String finalDate, String contractID, Client client, Project project,double finalPrice) {
		super();
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.contractID = contractID;
		this.client = client;
		this.project = project;
		this.finalPrice=finalPrice;
	}


	public String getInitialDate() {
		return initialDate;
	}


	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}


	public String getFinalDate() {
		return finalDate;
	}


	public void setFinalDate(String finalDate) {
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

	public double getLostMoney() {
		return lostMoney;
	}

	public void setLostMoney(double lostMoney) {
		this.lostMoney = lostMoney;
	}



	public int getPostpone() {
		return postpone;
	}



	public void setPostpone(int postpone) {
		this.postpone = postpone;
	}
	

}
