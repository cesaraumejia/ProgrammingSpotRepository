package Logical;
import java.util.ArrayList;

public class Client {
	private int idNumber;
	private String name;
	private ArrayList<Project> projects = new ArrayList<>();
	private String address;
	
	

	public Client() {
		// TODO Auto-generated constructor stub
	}



	public Client(int idNumber, String name, ArrayList<Project> projects, String address) {
		super();
		this.idNumber = idNumber;
		this.name = name;
		this.projects = projects;
		this.address = address;
	}



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
