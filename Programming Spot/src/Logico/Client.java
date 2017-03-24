package Logico;
import java.util.ArrayList;

public class Client {
	private int idNumber;
	private String name;
	private ArrayList<Contract> contracts;
	private String address;
	private int activeProjects;
	

	public Client() {
		this.contracts=new ArrayList<>();
	}



	public Client(int idNumber, String name,String address) {
		super();
		this.idNumber = idNumber;
		this.name = name;
		this.address = address;
		this.contracts=new ArrayList<>();
	}

	//TODO Deberian los clientes tener contratos o proyectos?
	

	
	public void addContract(Contract contract){
	    if(contracts.contains(contract)){
		contracts.add(contract);
	    }
	}
	
	////////////////////////////Setters And Getters////////////////////////////


	public int getIdNumber() {
		return idNumber;
	}



	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public ArrayList<Contract> getContracts() {
		return contracts;
	}


	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getActiveProjects() {
	    return activeProjects;
	}



	public void setActiveProjects(int activeProjects) {
	    this.activeProjects = activeProjects;
	}
	

	

}
