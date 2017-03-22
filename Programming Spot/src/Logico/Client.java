package Logico;
import java.util.ArrayList;

public class Client {
	private int idNumber;
	private String name;
	private ArrayList<Project> projects;
	private String address;
	
	

	public Client() {
		this.projects=new ArrayList<>();
	}



	public Client(int idNumber, String name,String address) {
		super();
		this.idNumber = idNumber;
		this.name = name;
		this.address = address;
		this.projects=new ArrayList<>();
	}

	//TODO Deberian los clientes tener contratos o proyectos?
	/*
	private void searchProject(){
	    Contract foundContract=null;
	    for (Contract crt : projects) {
		
	    }
	    
	}*/
	/*
	public void assignContract(Contract contract){
	    
	}*/
	
	
	
	
	
	
	
	
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



	public ArrayList<Project> getProjects() {
		return projects;
	}



	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}
	


}
